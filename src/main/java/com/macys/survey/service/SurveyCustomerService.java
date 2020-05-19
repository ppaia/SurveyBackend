package com.macys.survey.service;

import com.macys.survey.model.SurveyCustomerModelReqBody;
import com.macys.survey.model.SurveyCustomersModel;

public interface SurveyCustomerService {
    public SurveyCustomersModel saveCustomerDetails(SurveyCustomerModelReqBody surveyCustomerModelReqBody);

}
