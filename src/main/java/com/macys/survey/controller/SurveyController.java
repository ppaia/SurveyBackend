package com.macys.survey.controller;

import com.macys.survey.dao.SurveyExperienceDao;
import com.macys.survey.dao.SurveyOptionDao;
import com.macys.survey.dao.SurveyQuizesDao;
import com.macys.survey.model.SurveyExperience;
import com.macys.survey.model.SurveyOption;
import com.macys.survey.model.SurveyQuizes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value="/survey/update")
public class SurveyController {

    @Autowired
    SurveyExperienceDao surveyExperienceDao;

    @Autowired
    SurveyQuizesDao surveyQuizesDao;

    @Autowired
    SurveyOptionDao surveyOptionDao;

    @PutMapping(value = "name/{expid}")
    public SurveyExperience updateName(@PathVariable long expid,@RequestBody SurveyExperience surveyExp ){
        SurveyExperience surveyExperience=surveyExperienceDao.findByid(expid);
        surveyExperience.setExpName(surveyExp.getExpName());
        surveyExperienceDao.save(surveyExperience);
        return surveyExperience;
    }
    @PutMapping(value = "question/{surveyQuizId}")
    public SurveyQuizes updateQuestion(@PathVariable long surveyQuizId, @RequestBody SurveyQuizes surveyQuizes){
        SurveyQuizes surveyQuizes1=surveyQuizesDao.findByid(surveyQuizId);
       surveyQuizes1.setQuestion(surveyQuizes.getQuestion());
       surveyQuizesDao.save(surveyQuizes1);
       return surveyQuizes1;

    }
    @PutMapping(value = "option/{optionId}")
    public SurveyOption updateOption(@PathVariable long optionId, @RequestBody SurveyOption surveyOption){
        SurveyOption surveyOption1=surveyOptionDao.findByid(optionId);
        surveyOption1.setOption(surveyOption.getOption());
        surveyOptionDao.save(surveyOption1);
        return surveyOption1;
    }

}
