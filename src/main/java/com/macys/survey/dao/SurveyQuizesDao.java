package com.macys.survey.dao;

import com.macys.survey.model.SurveyExperience;
import com.macys.survey.model.SurveyQuizes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyQuizesDao extends CrudRepository<SurveyQuizes,Long> {
    public SurveyQuizes findByid(Long surveyExp);
}
