package com.macys.survey.dao;

import com.macys.survey.model.SurveyQuiz;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurveyQuizDao extends CrudRepository<SurveyQuiz, Integer> {
    public List<SurveyQuiz> findByPageIgnoreCase(String page);
}
