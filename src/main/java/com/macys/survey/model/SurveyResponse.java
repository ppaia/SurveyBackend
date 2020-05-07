package com.macys.survey.model;

import javax.persistence.*;

@Entity
public class SurveyResponse {

    @Id
    @GeneratedValue
    Long id;

    @ManyToOne
    @JoinColumn(name = "SURVEY_ID")
    SurveyCustomersModel surveyCustomersModel;

    @ManyToOne
    @JoinColumn(name = "QUIZ_ID")
    SurveyQuiz surveyQuiz;

    String answer;


    public SurveyQuiz getSurveyQuiz() {
        return surveyQuiz;
    }

    public void setSurveyQuiz(SurveyQuiz surveyQuiz) {
        this.surveyQuiz = surveyQuiz;
    }

    public SurveyCustomersModel getSurveyCustomersModel() {
        return surveyCustomersModel;
    }

    public void setSurveyCustomersModel(SurveyCustomersModel surveyCustomersModel) {
        this.surveyCustomersModel = surveyCustomersModel;
    }


    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
