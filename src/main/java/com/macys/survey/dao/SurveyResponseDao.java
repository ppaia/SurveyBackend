package com.macys.survey.dao;

import com.macys.survey.model.SurveyCountByQuestion;
import com.macys.survey.model.SurveyResponse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurveyResponseDao extends CrudRepository<SurveyResponse,Long> {
    @Query(value = "SELECT new com.macys.survey.model.SurveyCountByQuestion(answer, count(*)) FROM SurveyResponse where QUIZ_ID=?1 GROUP BY answer")
    public List<SurveyCountByQuestion> findCounterDataByQuestion(long id);
}
