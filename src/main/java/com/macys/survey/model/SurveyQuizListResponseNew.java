package com.macys.survey.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

public class SurveyQuizListResponseNew {
     @JsonInclude(JsonInclude.Include.NON_NULL)
     Long optionId;
     @JsonInclude(JsonInclude.Include.NON_NULL)
     String option;
     @JsonInclude(JsonInclude.Include.NON_NULL)
     Long surveyQuizId;
     @JsonInclude(JsonInclude.Include.NON_NULL)
     String question;
     @JsonInclude(JsonInclude.Include.NON_NULL)
     List<OptionResponseNew> surveyQuiz;

     public SurveyQuizListResponseNew() {
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

     public List<OptionResponseNew> getSurveyQuiz() {
          return surveyQuiz;
     }

     public void setSurveyQuiz(List<OptionResponseNew> surveyQuiz) {
          this.surveyQuiz = surveyQuiz;
     }
}
