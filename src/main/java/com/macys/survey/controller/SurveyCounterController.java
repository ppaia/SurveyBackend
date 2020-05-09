package com.macys.survey.controller;

import com.macys.survey.model.SurveyCounter;
import com.macys.survey.service.SurveyCounterService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value="/rest/chatbot/survey")
public class SurveyCounterController {
    private static final Logger logger = LoggerFactory.getLogger(SurveyCounter.class);

    @Autowired
    SurveyCounterService surveyCounterService;

    public void setSurveyCounterService(SurveyCounterService surveyCounterService) {
        this.surveyCounterService = surveyCounterService;
    }

    /**
     * This method is used to increment the Survey Accept Counter.
     *
     * @return Data void and Http Status
     */


    @PostMapping("/accepted")
    public ResponseEntity updateSurveyAccepted(){
        logger.info("START:: SurveyCounterController :: updateSurveyAccepted");
        surveyCounterService.incrementAcceptedSurvey();
        logger.info("END:: SurveyCounterController :: updateSurveyAccepted");
        return ResponseEntity.ok().build();
    }

    /**
     * This method is used to increment the Survey Reject Counter.
     *
     * @return Data void and Http Status
     */

    @PostMapping("/rejected")
    public ResponseEntity updateSurveyRejected()
    {
        logger.info("START:: SurveyCounterController :: updateSurveyRejected");
        surveyCounterService.incrementRejectedSurvey();
        logger.info("END:: SurveyCounterController :: updateSurveyRejected");
        return ResponseEntity.ok().build();
    }
}
