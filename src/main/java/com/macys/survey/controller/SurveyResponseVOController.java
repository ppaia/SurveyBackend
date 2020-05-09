package com.macys.survey.controller;

import com.macys.survey.model.SurveyResponse;
import com.macys.survey.model.SurveyResponseVO;
import com.macys.survey.service.SurveyResponseServiceVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This controller send the surveytaken in
 * last 15 days
 *
 */

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value="/rest/chatbot")
public class SurveyResponseVOController {
    private static final Logger logger = LoggerFactory.getLogger(SurveyResponse.class);

    @Autowired
    SurveyResponseServiceVO surveyResponseServiceVO;

    @GetMapping(value="/survey/lastsurveys")
    public ResponseEntity<List<SurveyResponseVO>> fiffteendaysurveys(){
        logger.info("START :: SurveyResponseVOController :: fiffteendaysurveys ");
        logger.info("END :: SurveyResponseVOController :: fiffteendaysurveys ");
        return new ResponseEntity<List<SurveyResponseVO>>(surveyResponseServiceVO.getLastfifteenDaysSurvey(), HttpStatus.OK);
    }
}
