package com.macys.survey.dao;

import com.macys.survey.model.SurveyCount;
import com.macys.survey.model.SurveyCounter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyCounteDao extends CrudRepository<SurveyCounter,Integer> {
    @Query(value="select new com.macys.survey.model.SurveyCount( SUM(acceptedCount) ,SUM(rejectedCount)) from SurveyCounter ")
    public SurveyCount getSurveyCount();

}
