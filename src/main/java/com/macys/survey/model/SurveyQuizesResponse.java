package com.macys.survey.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.NamedNativeQuery;
import java.util.List;
import java.util.Map;


public class SurveyQuizesResponse {

    @JsonIgnore
    Long expId;
    @JsonIgnore
    String name;
    Long surveyQuizId;
    String question;
    @JsonIgnore
    Long parent;
    Long optionId;
    String option;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    List<SurveyQuizesResponse> surveyQuiz;

    public SurveyQuizesResponse() {
    }

    public SurveyQuizesResponse(Long optionId) {
        this.optionId = optionId;
    }

    public SurveyQuizesResponse(Long expId, String name, Long surveyQuizId, String question, Long parent, Long optionId, String option) {
        this.expId = expId;
        this.name = name;
        this.surveyQuizId = surveyQuizId;
        this.question = question;
        this.parent = parent;
        this.optionId = optionId;
        this.option = option;
    }


    public Long getExpId() {
        return expId;
    }

    public void setExpId(Long expId) {
        this.expId = expId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSurveyQuizId() {
        return surveyQuizId;
    }

    public void setSurveyQuizId(Long surveyQuizId) {
        this.surveyQuizId = surveyQuizId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

    public Long getOptionId() {
        return optionId;
    }

    public void setOptionId(Long optionId) {
        this.optionId = optionId;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public List<SurveyQuizesResponse> getSurveyQuiz() {
        return surveyQuiz;
    }

    public void setSurveyQuiz(List<SurveyQuizesResponse> surveyQuiz) {
        this.surveyQuiz = surveyQuiz;
    }

    @Override
    public String toString() {
        return "SurveyQuizesResponse{" +
                "expId=" + expId +
                ", name='" + name + '\'' +
                ", surveyQuizId=" + surveyQuizId +
                ", question='" + question + '\'' +
                ", parent=" + parent +
                ", optionId=" + optionId +
                ", option='" + option + '\'' +
                '}';
    }
}
