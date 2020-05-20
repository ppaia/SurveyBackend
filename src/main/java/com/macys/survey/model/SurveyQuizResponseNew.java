package com.macys.survey.model;

import java.util.List;

public class SurveyQuizResponseNew {
    Long surveyQuizId;
    String question;
    List<SurveyQuizListResponseNew> options;

    public SurveyQuizResponseNew() {
    }

    public Long getSurveyQuizId() {
        return surveyQuizId;
    }

    public void setSurveyQuizId(Long surveyQuizId) {
        this.surveyQuizId = surveyQuizId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<SurveyQuizListResponseNew> getOptions() {
        return options;
    }

    public void setOptions(List<SurveyQuizListResponseNew> options) {
        this.options = options;
    }
}
