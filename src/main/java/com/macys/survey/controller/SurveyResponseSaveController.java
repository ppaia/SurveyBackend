package com.macys.survey.controller;

import com.macys.survey.model.SurveyAns;
import com.macys.survey.model.SurveyRespSaveReqBody;
import com.macys.survey.service.SurveyResponseSaveService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/rest/chatbot/survey")
public class SurveyResponseSaveController {

    private static final Logger logger = LoggerFactory.getLogger(SurveyResponseSaveController.class);

    @Autowired
    private SurveyResponseSaveService surveyResponseSaveService;

    /**
     * This method is used to save the Survey response.
     *
     * @return Data void and Http Status
     */
    @PostMapping(value="/save")
    ResponseEntity saveSurveyResponse(@RequestBody SurveyRespSaveReqBody reqBody)
    {
       logger.info("START:: SurveyResponseSaveController :: saveSurveyResponse");
       Long surveyId=reqBody.getSurveyId();
       List<SurveyAns> answers=reqBody.getAnswers();
       surveyResponseSaveService.saveSurveyResponse(surveyId,answers);
       logger.info("START:: SurveyResponseSaveController :: saveSurveyResponse");
       return ResponseEntity.ok().build();
    }
}
