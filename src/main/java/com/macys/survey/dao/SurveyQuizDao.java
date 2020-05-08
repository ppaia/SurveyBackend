package com.macys.survey.dao;

import com.macys.survey.model.SurveyQuiz;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurveyQuizDao extends CrudRepository<SurveyQuiz, Long> {
    public List<SurveyQuiz> findByPageIgnoreCase(String page);

    @Query("SELECT q FROM SurveyQuiz q WHERE q.id =?1")
    public SurveyQuiz findByQuizId(Long id);
}
