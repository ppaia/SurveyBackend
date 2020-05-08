package com.macys.survey.model;

import java.util.List;

public class SurveyResponseVO {
   private SurveyCustomersModel surveyCustomersModel;

   List<SurveyCustomerTaken> surveyCustomerTakens;

    public SurveyCustomersModel getSurveyCustomersModel() {
        return surveyCustomersModel;
    }

    public void setSurveyCustomersModel(SurveyCustomersModel surveyCustomersModel) {
        this.surveyCustomersModel = surveyCustomersModel;
    }

    public List<SurveyCustomerTaken> getSurveyCustomerTakens() {
        return surveyCustomerTakens;
    }

    public void setSurveyCustomerTakens(List<SurveyCustomerTaken> surveyCustomerTakens) {
        this.surveyCustomerTakens = surveyCustomerTakens;
    }
}
