package com.macys.survey.exception;

public class CustomerNotFoundException extends RuntimeException {

    Long surveyId;

    public CustomerNotFoundException(Long surveyId) {
        this.surveyId = surveyId;
    }

    public Long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Long surveyId) {
        this.surveyId = surveyId;
    }

    @Override
    public String toString() {
        return "CustomerNotFoundException{" +
                "surveyId='" + surveyId + '\'' +
                '}';
    }

    @Override
    public String getMessage() {
        return "CustomerNotFoundException{" +
                "surveyId='" + surveyId + '\'' +
                '}';
    }
}
