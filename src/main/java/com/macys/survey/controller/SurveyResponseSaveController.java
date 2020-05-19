package com.macys.survey.controller;

import com.macys.survey.model.SurveyAns;
import com.macys.survey.model.SurveyRespSaveReqBody;
import com.macys.survey.service.SurveyResponseSaveService;
import com.macys.survey.service.SurveyResponsesSaveService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value="/rest/chatbot")
public class SurveyResponseSaveController {

    private static final Logger logger = LoggerFactory.getLogger(SurveyResponseController.class);

    @Autowired
    private SurveyResponsesSaveService surveyResponsesSaveService;


    /**
     * This method is used to save the Survey response.
     *
     * @return Data void and Http Status
     */
    @PostMapping(value="/survey/saveresp")
    ResponseEntity saveSurveyResponse(@RequestBody SurveyRespSaveReqBody reqBody)
    {
        logger.info("START:: SurveyResponseController :: saveSurveyResponse");
        Long surveyId=reqBody.getSurveyId();
        List<SurveyAns> answers=reqBody.getAnswers();
        surveyResponsesSaveService.saveSurveyResponse(surveyId,answers);
        logger.info("END:: SurveyResponseController :: saveSurveyResponse");
        return ResponseEntity.ok().build();
    }

}
