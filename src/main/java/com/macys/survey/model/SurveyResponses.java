package com.macys.survey.model;

import javax.persistence.*;

@Entity
@Table(name = "surveyresponses")
public class SurveyResponses {

    @Id
    @GeneratedValue
    @Column(name = "surveyResponseId")
    Long id;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "SURVEY_ID")
    SurveyCustomersModel surveyCustomersModel;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "surveyQuizId")
    SurveyQuizes surveyQuizes;

    @Column(name="answer")
    String answer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SurveyCustomersModel getSurveyCustomersModel() {
        return surveyCustomersModel;
    }

    public void setSurveyCustomersModel(SurveyCustomersModel surveyCustomersModel) {
        this.surveyCustomersModel = surveyCustomersModel;
    }

    public SurveyQuizes getSurveyQuizes() {
        return surveyQuizes;
    }

    public void setSurveyQuizes(SurveyQuizes surveyQuizes) {
        this.surveyQuizes = surveyQuizes;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
