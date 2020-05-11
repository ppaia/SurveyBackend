package com.macys.survey.model;

public class SurveyResponseQuiz {

    String questions;
    String answers;

    public SurveyResponseQuiz() {
    }

    public SurveyResponseQuiz(String questions, String answers) {
        this.questions = questions;
        this.answers = answers;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }
}
