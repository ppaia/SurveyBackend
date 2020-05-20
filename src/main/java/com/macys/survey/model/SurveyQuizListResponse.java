package com.macys.survey.model;

import java.util.List;

public class SurveyQuizListResponse {
    Long id;
    String question;
    List<SurveyOptionResponse> option;

    public SurveyQuizListResponse() {
    }

    public SurveyQuizListResponse(Long id, String question) {
        this.id = id;
        this.question = question;
    }

    public SurveyQuizListResponse(String question, List<SurveyOptionResponse> option) {
        this.question = question;
        this.option = option;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<SurveyOptionResponse> getOption() {
        return option;
    }

    public void setOption(List<SurveyOptionResponse> option) {
        this.option = option;
    }

    @Override
    public String toString() {
        return "SurveyQuizListRequest{" +
                "question='" + question + '\'' +
                ", option=" + option +
                '}';
    }
}
