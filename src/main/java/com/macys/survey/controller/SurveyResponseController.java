package com.macys.survey.controller;

import com.macys.survey.dao.SurveyResponseDao;
import com.macys.survey.model.SurveyCountByQuestion;
import com.macys.survey.model.SurveyCounter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value="/rest/chatbot")
public class SurveyResponseController {
    private static final Logger logger = LoggerFactory.getLogger(SurveyCounter.class);

    @Autowired
    SurveyResponseDao surveyResponseDao;

    //API to get Survey response for Question Id 9 from table : SURVEYRESPONSE
    @RequestMapping(value="/survey/getSurevyCountByQuestion/{id}", method= RequestMethod.GET)
    @ResponseStatus(value= HttpStatus.OK)
    public Map<String, Long> getSurevyCountByQuestion(@PathVariable long id){
        logger.info("START:: SurveyResponseController :: getSurevyCountByQuestion");
        Map<String, Long> questionMap = new HashMap<String, Long>();
        for(SurveyCountByQuestion question : surveyResponseDao.findCounterDataByQuestion(id))
        {
            questionMap.put(question.getAnswer(), question.getCount());
        }
        logger.info("END:: SurveyResponseController :: getSurevyCountByQuestion");
        return questionMap;
    }


}
