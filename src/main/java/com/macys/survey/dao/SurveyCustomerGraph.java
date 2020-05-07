package com.macys.survey.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.macys.survey.model.SampleSurveyGraph;

@Repository
public interface SurveyCustomerGraph extends CrudRepository<SampleSurveyGraph, Integer>{

	@Query("SELECT new com.macys.survey.model.SampleSurveyGraph (r.survey_id, r.quiz_id, r.answer) FROM SampleSurveyGraph r WHERE r.survey_id=?1")
	public List<SampleSurveyGraph> findInformation(Integer survey_id);
}
