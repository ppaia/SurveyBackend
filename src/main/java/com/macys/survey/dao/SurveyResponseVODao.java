package com.macys.survey.dao;

import com.macys.survey.model.SurveyResponse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurveyResponseVODao extends CrudRepository<SurveyResponse,Long> {

    @Query(value="select * from survey_response where survey_response.SURVEY_ID in (select SURVEY_ID from surveycustomers where timestamp >= CURRENT DATE - 15 ) ", nativeQuery = true)
    List<SurveyResponse> surveyofLastFifteenDays();
}
