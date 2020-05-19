package com.macys.survey.model;

import java.util.List;

public class SurveyQuizesRequest {
    Long id;
    String expName;
    List<SurveyQuizListRequest> surveyQuiz;


    public SurveyQuizesRequest() {
    }

    public SurveyQuizesRequest(Long id, String expName, List<SurveyQuizListRequest> surveyQuiz) {
        this.id = id;
        this.expName = expName;
        this.surveyQuiz = surveyQuiz;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExpName() {
        return expName;
    }

    public void setExpName(String expName) {
        this.expName = expName;
    }

    public List<SurveyQuizListRequest> getSurveyQuiz() {
        return surveyQuiz;
    }

    public void setSurveyQuiz(List<SurveyQuizListRequest> surveyQuiz) {
        this.surveyQuiz = surveyQuiz;
    }

    @Override
    public String toString() {
        return "SurveyQuizesRequest{" +
                "id=" + id +
                ", expName='" + expName + '\'' +
                ", surveyQuiz=" + surveyQuiz +
                '}';
    }
}
