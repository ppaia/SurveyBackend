package com.macys.survey.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.macys.survey.model.SurveyCounteByAge;

@Repository
public interface SurveyCounterAge extends CrudRepository<SurveyCounteByAge, Long>{
	@Query(value = "SELECT new com.macys.survey.model.SurveyCounteByAge (s.age, count(1)) FROM SurveyCounteByAge s GROUP BY s.age")
	public List<SurveyCounteByAge> findCounterDataByAge();

}
