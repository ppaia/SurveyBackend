package com.macys.survey.model;

import javax.persistence.*;

@Entity
@Table(name="SurveyOption")
public class SurveyOption {

    @Id
    @GeneratedValue
    @Column(name="optionId")
    Long id;

    @ManyToOne
    @JoinColumn(name="surveyQuizId")
    SurveyQuizes surveyQuizes;

    @Column(name="option")
    String option;

    public SurveyOption() {
    }

    public SurveyOption( SurveyQuizes surveyQuizes, String option) {
        this.surveyQuizes = surveyQuizes;
        this.option = option;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SurveyQuizes getSurveyQuizes() {
        return surveyQuizes;
    }

    public void setSurveyQuizes(SurveyQuizes surveyQuizes) {
        this.surveyQuizes = surveyQuizes;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    @Override
    public String toString() {
        return "SurveyOption{" +
                "id=" + id +
                ", surveyQuizes=" + surveyQuizes +
                ", option='" + option + '\'' +
                '}';
    }
}
