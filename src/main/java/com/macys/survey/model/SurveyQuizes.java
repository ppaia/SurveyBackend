package com.macys.survey.model;

import javax.persistence.*;
@Entity
@Table(name="surveyquizes")
public class SurveyQuizes {

    @Id
    @GeneratedValue
    @Column(name="surveyQuizId")
    Long id;

    @ManyToOne
    @JoinColumn(name = "expId")
    SurveyExperience surveyExperience;

    @Column(name="question")
    String question;

    @ManyToOne
    @JoinColumn(name="optionId")
    SurveyOption surveyOption;


    public SurveyQuizes() {
    }

    public SurveyQuizes(SurveyExperience surveyExperience, String question) {
        this.surveyExperience = surveyExperience;
        this.question = question;
    }

    public SurveyQuizes(SurveyExperience surveyExperience, String question, SurveyOption surveyOption) {
        this.surveyExperience = surveyExperience;
        this.question = question;
        this.surveyOption = surveyOption;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SurveyExperience getSurveyExperience() {
        return surveyExperience;
    }

    public void setSurveyExperience(SurveyExperience surveyExperience) {
        this.surveyExperience = surveyExperience;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public SurveyOption getSurveyOption() {
        return surveyOption;
    }

    public void setSurveyOption(SurveyOption surveyOption) {
        this.surveyOption = surveyOption;
    }

    @Override
    public String toString() {
        return "SurveyQuizes{" +
                "id=" + id +
                ", surveyExperience=" + surveyExperience +
                ", question='" + question + '\'' +
                ", surveyOption=" + surveyOption +
                '}';
    }
}
