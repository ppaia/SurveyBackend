package com.macys.survey.model;

import java.util.List;

public class SurveyQuizListRequest {
    String question;
    List<SurveyOptionRequest> option;

    public SurveyQuizListRequest() {
    }

    public SurveyQuizListRequest(String question, List<SurveyOptionRequest> option) {
        this.question = question;
        this.option = option;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<SurveyOptionRequest> getOption() {
        return option;
    }

    public void setOption(List<SurveyOptionRequest> option) {
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
