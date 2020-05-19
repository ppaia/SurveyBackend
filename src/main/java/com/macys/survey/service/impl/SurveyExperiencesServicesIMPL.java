package com.macys.survey.service.impl;

import com.macys.survey.dao.SurveyExperienceDao;
import com.macys.survey.exception.SurveyExperienceException;
import com.macys.survey.model.SurveyExperience;
import com.macys.survey.service.SurveyExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SurveyExperiencesServicesIMPL implements SurveyExperienceService {
    @Autowired
    SurveyExperienceDao surveyExperienceDao;

    @Override
    public List<SurveyExperience> getAllExperiences() {
        if(surveyExperienceDao.findAll().size()==0){
            throw new SurveyExperienceException("NO EXPERIENCE FOUND");
        }
        else {
            return surveyExperienceDao.findAll();
        }
    }
}
