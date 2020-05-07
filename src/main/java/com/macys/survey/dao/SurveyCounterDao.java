package com.macys.survey.dao;

import com.macys.survey.model.SurveyCounter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.sql.Date;

@Repository
public interface SurveyCounterDao extends CrudRepository<SurveyCounter, Date> {
    public SurveyCounter findBySurveyDate(Date surveyDate);
}
