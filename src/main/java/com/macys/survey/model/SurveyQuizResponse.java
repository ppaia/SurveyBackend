package com.macys.survey.model;

import java.util.List;

public class SurveyQuizResponse {
    Long id;
    String expName;
    List<SurveyQuizesResponse> surveyQuiz;


    public SurveyQuizResponse() {
    }


    public SurveyQuizResponse(Long id, String expName, List<SurveyQuizesResponse> surveyQuiz) {
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

    public List<SurveyQuizesResponse> getSurveyQuiz() {
        return surveyQuiz;
    }

    public void setSurveyQuiz(List<SurveyQuizesResponse> surveyQuiz) {
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
