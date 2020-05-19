package com.macys.survey.service;

import com.macys.survey.model.SurveyAns;

import java.util.List;

public interface SurveyResponsesSaveService {

    void saveSurveyResponse(Long surveyId, List<SurveyAns> answers);
}
