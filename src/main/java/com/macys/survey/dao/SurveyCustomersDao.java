package com.macys.survey.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.macys.survey.model.SurveyCustomersModel;

public interface SurveyCustomersDao extends JpaRepository<SurveyCustomersModel, Long>{

}
