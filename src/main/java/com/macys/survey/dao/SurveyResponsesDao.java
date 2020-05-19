package com.macys.survey.dao;

import java.util.List;

import com.macys.survey.model.SurveyCustomersModel;
import com.macys.survey.model.SurveyResponses;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyResponsesDao extends CrudRepository<SurveyResponses,Long> {

    public List<SurveyResponses> findBySurveyCustomersModel(SurveyCustomersModel surveyCustomersModel);
}
