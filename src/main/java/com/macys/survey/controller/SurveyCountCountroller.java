package com.macys.survey.controller;

import com.macys.survey.model.SurveyCount;

import com.macys.survey.model.SurveyCounter;
import com.macys.survey.service.impl.SurveyCountServiceIMPL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value="/rest/chatbot/survey")
public class SurveyCountCountroller {
    private static final Logger logger = LoggerFactory.getLogger(SurveyCounter.class);

    @Autowired
    SurveyCountServiceIMPL SurveyCountServiceIMPL;
    /**
     * This method is used to get the count of Survey Count.
     *
     * @return Survey Count
     */

    @GetMapping(value="/SurveyCount")
    public @ResponseBody SurveyCount getSurveyCount(){
        logger.info("INSIDE ::  :: getQuestionFromPaSurveyCountController ");
        return SurveyCountServiceIMPL.getSurveycount();
    }


}
