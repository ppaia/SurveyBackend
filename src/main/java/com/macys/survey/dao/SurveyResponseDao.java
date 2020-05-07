package com.macys.survey.dao;

import com.macys.survey.model.SurveyResponse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyResponseDao extends CrudRepository<SurveyResponse,Long> {
}
