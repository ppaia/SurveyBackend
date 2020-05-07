package com.macys.survey.service.impl;

import com.macys.survey.dao.SurveyCounteDao;
import com.macys.survey.model.SurveyCount;
import com.macys.survey.service.SurveyCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveyCountServiceIMPL implements SurveyCountService {
    @Autowired
    SurveyCounteDao surveyCounteDao;

    /**
     * This method is get Survey count.
     *
     * @return Data SurveyCount
     */
    @Override
    public SurveyCount getSurveycount() {
        SurveyCount surveyCount =surveyCounteDao.getSurveyCount();
        return surveyCount;

    }
}
