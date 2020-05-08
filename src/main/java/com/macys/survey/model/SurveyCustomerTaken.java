package com.macys.survey.model;

public class SurveyCustomerTaken {
    SurveyQuiz surveyQuiz;
    String answer;

    public SurveyCustomerTaken() {
    }

    public SurveyQuiz getSurveyQuiz() {
        return surveyQuiz;
    }

    public void setSurveyQuiz(SurveyQuiz surveyQuiz) {
        this.surveyQuiz = surveyQuiz;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public SurveyCustomerTaken(SurveyQuiz surveyQuiz, String answer) {
        this.surveyQuiz = surveyQuiz;
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "SurveyCustomerTaken{" +
                "surveyQuiz=" + surveyQuiz +
                ", answer='" + answer + '\'' +
                '}';
    }
}
