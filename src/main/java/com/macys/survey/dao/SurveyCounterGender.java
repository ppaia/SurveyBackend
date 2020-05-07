package com.macys.survey.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.macys.survey.model.SurveyCountByGender;

@Repository
public interface SurveyCounterGender extends CrudRepository<SurveyCountByGender, Integer>{

	@Query("SELECT new com.macys.survey.model.SurveyCountByGender (s.gender, count(1)) FROM SurveyCountByGender s GROUP BY s.gender")
	public List<SurveyCountByGender> findCounterDataByGender();
}
