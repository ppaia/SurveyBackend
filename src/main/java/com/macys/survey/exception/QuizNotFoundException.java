package com.macys.survey.exception;

public class QuizNotFoundException extends  RuntimeException {

    Long quizId;

    public QuizNotFoundException(Long quizId) {
        this.quizId = quizId;
    }

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    @Override
    public String toString() {
        return "QuizNotFoundException{" +
                "quizId=" + quizId +
                '}';
    }

    @Override
    public String getMessage() {
        return "QuizNotFoundException{" +
                "quizId=" + quizId +
                '}';
    }
}
