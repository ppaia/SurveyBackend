package com.macys.survey.dao;

import com.macys.survey.model.SurveyExperience;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurveyExperienceDao extends CrudRepository<SurveyExperience,Long> {
    public SurveyExperience findByid(Long expId);

    public List<SurveyExperience> findAll();
}
