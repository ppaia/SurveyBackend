package com.macys.survey.service;

import com.macys.survey.model.SurveyResponseVO;

import java.util.List;

public interface SurveyResponseServiceVO {
    public List<SurveyResponseVO> getLastfifteenDaysSurvey();
}
