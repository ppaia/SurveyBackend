package com.macys.survey.model;

import javax.persistence.*;

import com.macys.survey.dao.SurveyCustomersDao;

@Entity
public class SurveyResponse {

    @Id
    @GeneratedValue
    Long id;

    @ManyToOne
    @JoinColumn(name = "SURVEY_ID")
    SurveyCustomersModel surveyCustomer;

    @OneToOne
    @JoinColumn(name = "ID")
    SurveyQuiz surveyQuiz;

    String answer;


    public SurveyQuiz getSurveyQuiz() {
        return surveyQuiz;
    }

    public void setSurveyQuiz(SurveyQuiz surveyQuiz) {
        this.surveyQuiz = surveyQuiz;
    }

    public SurveyCustomersModel getSurveyCustomer() {
        return surveyCustomer;
    }

    public void setSurveyCustomer(SurveyCustomersModel surveyCustomer) {
        this.surveyCustomer = surveyCustomer;
    }


    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
