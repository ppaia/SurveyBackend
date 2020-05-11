package com.macys.survey.dao;

import java.util.List;

import com.macys.survey.model.SurveyCustomersModel;
import com.macys.survey.model.SurveyResponse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.macys.survey.model.SampleSurveyGraph;

@Repository
public interface SurveyCustomerGraph extends CrudRepository<SurveyResponse, Integer>{

	public List<SurveyResponse> findBySurveyCustomersModel(SurveyCustomersModel survey);
}
