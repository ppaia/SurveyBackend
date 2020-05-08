package com.macys.survey.model;

import java.util.Map;

public class SurveyAnsCountRespSaveBody {
    private String question;

    private Map<String,Long> answers;

    public SurveyAnsCountRespSaveBody(String question, Map<String, Long> answers) {
        this.question = question;
        this.answers = answers;
    }

    public String getQuestion() {

        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Map<String, Long> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<String, Long> answers) {
        this.answers = answers;
    }
}
