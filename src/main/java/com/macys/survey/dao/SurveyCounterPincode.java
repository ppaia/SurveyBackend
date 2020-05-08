package com.macys.survey.dao;

import com.macys.survey.model.SurveyCountByPincode;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurveyCounterPincode extends CrudRepository<SurveyCountByPincode,Long> {


    @Query(value="select  new com.macys.survey.model.SurveyCountByPincode (substring(pincode,1,2),count(pincode)) from com.macys.survey.model.SurveyCountByPincode group by substring(pincode,1,2)")
     public List<SurveyCountByPincode> findCounterByPincode();
}
