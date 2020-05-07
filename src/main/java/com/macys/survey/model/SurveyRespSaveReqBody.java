package com.macys.survey.model;

import java.util.List;

public class SurveyRespSaveReqBody {

    Long surveyId;

    List<SurveyAns> answers;

    public Long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Long surveyId) {
        this.surveyId = surveyId;
    }

    public List<SurveyAns> getAnswers() {
        return answers;
    }

    public void setAnswers(List<SurveyAns> answers) {
        this.answers = answers;
    }

}
