package com.macys.survey.model;

import javax.persistence.*;

@Entity
@Table(name="SurveyExperience")
public class SurveyExperience {
    @Id
    @GeneratedValue
    @Column(name="expId")
    Long id;

    @Column(name="expName")
    String expName;

    public SurveyExperience() {
    }

    public SurveyExperience(Long id, String expName) {
        this.id = id;
        this.expName = expName;
    }

    public SurveyExperience(String expName) {
        this.expName = expName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExpName() {
        return expName;
    }

    public void setExpName(String expName) {
        this.expName = expName;
    }

    @Override
    public String toString() {
        return "SurveyExperience{" +
                "id=" + id +
                ", expName='" + expName + '\'' +
                '}';
    }
}
