package com.macys.survey.service;

import com.macys.survey.model.SurveyQuiz;

import java.util.List;

public interface SurveyQuizService {
    public List<SurveyQuiz> getQuestionFromPage(String pageName);
}
