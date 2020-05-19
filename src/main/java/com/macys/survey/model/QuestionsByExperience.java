package com.macys.survey.model;

import java.util.List;

public class QuestionsByExperience {

    String expName;

    List<Question> surveyQuiz;

    public String getExpName() {
        return expName;
    }

    public void setExpName(String expName) {
        this.expName = expName;
    }

    public List<Question> getSurveyQuiz() {
        return surveyQuiz;
    }

    public void setSurveyQuiz(List<Question> surveyQuiz) {
        this.surveyQuiz = surveyQuiz;
    }
}
