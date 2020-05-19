package com.macys.survey.dao;

import com.macys.survey.model.SurveyCountByQuestion;
import com.macys.survey.model.SurveyCustomersModel;
import com.macys.survey.model.SurveyResponses;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurveyResponsesDao extends CrudRepository<SurveyResponses,Long> {

    public List<SurveyResponses> findBySurveyCustomersModel(SurveyCustomersModel surveyCustomersModel);

    @Query(value = "SELECT new com.macys.survey.model.SurveyCountByQuestion(answer, count(*)) FROM SurveyResponses where SURVEY_QUIZ_ID=?1 GROUP BY answer")
    public List<SurveyCountByQuestion> findCounterDataByQuestion(long quizId);
}
