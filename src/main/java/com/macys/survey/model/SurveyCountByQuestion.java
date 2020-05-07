package com.macys.survey.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class SurveyCountByQuestion implements Serializable {

    @JsonIgnore
    private Long quizId;

    private String answer;

    private Long count;

    public SurveyCountByQuestion(Long quizId, String answer, Long count) {
        this.quizId = quizId;
        this.answer = answer;
        this.count = count;
    }

    public SurveyCountByQuestion(String answer, Long count) {
        this.answer = answer;
        this.count = count;
    }

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }


}
