package com.macys.survey.service;

import com.macys.survey.model.SurveyAns;

import java.util.List;

public interface SurveyResponseSaveService {

    void saveSurveyResponse(Long surveyId, List<SurveyAns> answers);

}
