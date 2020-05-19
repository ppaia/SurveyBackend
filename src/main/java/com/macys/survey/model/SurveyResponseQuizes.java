package com.macys.survey.model;

public class SurveyResponseQuizes {

    String question;

    String answer;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public SurveyResponseQuizes(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }
}
