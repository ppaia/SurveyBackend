package com.macys.survey.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.macys.survey.model.OptionResponseNew;
import com.macys.survey.model.SurveyQuizResponseNew;

import java.util.List;

public class SurveyGetResultNew {
    Long id;
    String expName;
    List<SurveyQuizResponseNew> surveyQuiz;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    List<OptionResponseNew> surveyQuizes;


    public SurveyGetResultNew() {
    }


    public SurveyGetResultNew(Long id, String expName, List<SurveyQuizResponseNew> surveyQuiz) {
        this.id = id;
        this.expName = expName;
        this.surveyQuiz = surveyQuiz;
    }

    public List<OptionResponseNew> getSurveyQuizes() {
        return surveyQuizes;
    }

    public void setSurveyQuizes(List<OptionResponseNew> surveyQuizes) {
        this.surveyQuizes = surveyQuizes;
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

    public List<SurveyQuizResponseNew> getSurveyQuiz() {
        return surveyQuiz;
    }

    public void setSurveyQuiz(List<SurveyQuizResponseNew> surveyQuiz) {
        this.surveyQuiz = surveyQuiz;
    }

    @Override
    public String toString() {
        return "SurveyQuizesRequest{" +
                "id=" + id +
                ", expName='" + expName + '\'' +
                ", surveyQuiz=" + surveyQuiz +
                '}';
    }
}
