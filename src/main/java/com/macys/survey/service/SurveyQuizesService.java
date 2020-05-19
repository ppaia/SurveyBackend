package com.macys.survey.service;
import com.macys.survey.model.SurveyQuizes;
import com.macys.survey.model.SurveyQuizesRequest;
import com.macys.survey.model.SurveyResponseQuiz;

public interface SurveyQuizesService {
    public Long addSurveyQuizes(SurveyQuizesRequest surveyQuizesRequest);
}
