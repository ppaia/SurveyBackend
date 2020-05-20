package com.macys.survey.model;

import java.util.List;

public class SurveyOptionResponse {
    Long id;
    String question;
    List<SurveyOption> option;

    public SurveyOptionResponse() {
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

    public List<SurveyOption> getOption() {
        return option;
    }

    public void setOption(List<SurveyOption> option) {
        this.option = option;
    }
}
