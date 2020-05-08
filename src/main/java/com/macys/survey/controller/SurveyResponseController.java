package com.macys.survey.controller;

import com.macys.survey.dao.SurveyQuizDao;
import com.macys.survey.dao.SurveyResponseDao;
import com.macys.survey.model.*;
import com.macys.survey.service.SurveyResponseSaveService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value="/rest/chatbot")
public class SurveyResponseController {
    private static final Logger logger = LoggerFactory.getLogger(SurveyResponseController.class);

    @Autowired
    SurveyResponseDao surveyResponseDao;

    @Autowired
    private SurveyResponseSaveService surveyResponseSaveService;

    @Autowired
    private SurveyQuizDao surveyQuizDao;

    //API to get Survey response for Question Id from tables : SURVEYRESPONSE AND SURVEYQUIZ
    @RequestMapping(value="/survey/getSurveyCountByQuestion/{id}", method= RequestMethod.GET)
    @ResponseStatus(value= HttpStatus.OK)
    public SurveyAnsCountRespSaveBody getSurveyCountByQuestion(@PathVariable long id){
        logger.info("START:: SurveyResponseController :: getSurveyCountByQuestion");
        Map<String,Long> answerMap = new HashMap<String, Long>();
        for(SurveyCountByQuestion answer : surveyResponseDao.findCounterDataByQuestion(id)) {
            answerMap.put(answer.getAnswer(),answer.getCount());
        }
        SurveyAnsCountRespSaveBody surveyAnsCountRespSaveBody = new SurveyAnsCountRespSaveBody(surveyQuizDao.findByQuizId(id).getQuestion(),answerMap);
        logger.info("END:: SurveyResponseController :: getSurveyCountByQuestion");
        return surveyAnsCountRespSaveBody;
    }
    /**
     * This method is used to save the Survey response.
     *
     * @return Data void and Http Status
     */
    @PostMapping(value="/survey/save")
    ResponseEntity saveSurveyResponse(@RequestBody SurveyRespSaveReqBody reqBody)
    {
        logger.info("START:: SurveyResponseController :: saveSurveyResponse");
        Long surveyId=reqBody.getSurveyId();
        List<SurveyAns> answers=reqBody.getAnswers();
        surveyResponseSaveService.saveSurveyResponse(surveyId,answers);
        logger.info("START:: SurveyResponseController :: saveSurveyResponse");
        return ResponseEntity.ok().build();
    }


}
