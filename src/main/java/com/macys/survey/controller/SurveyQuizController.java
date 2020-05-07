package com.macys.survey.controller;

import com.macys.survey.exception.SurveyQuizException;
import com.macys.survey.model.SurveyQuiz;
import com.macys.survey.service.SurveyQuizService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value="/rest/chatbot")
public class SurveyQuizController {
    private static final Logger logger = LoggerFactory.getLogger(SurveyQuiz.class);

    @Autowired
    SurveyQuizService surveyQuizService;

    public void setSurveyQuizService(SurveyQuizService surveyQuizService) {
        this.surveyQuizService = surveyQuizService;
    }

    /**
     * This method get the Survey Question.
     *
     * @param pagename
     * @return Data List<SurveyQuiz> and Http Status
     */

    @GetMapping("/survey/{pagename}/getsurvey")
    public ResponseEntity<List<SurveyQuiz>> getSurveyFromPage(@PathVariable String pagename){
        logger.info("START:: SurveyQuizController :: getSurveyFromPage");
        logger.info("END:: SurveyQuizController :: getSurveyFromPage");
        return new ResponseEntity<List<SurveyQuiz>>(surveyQuizService.getQuestionFromPage(pagename), HttpStatus.OK);

    }
}

