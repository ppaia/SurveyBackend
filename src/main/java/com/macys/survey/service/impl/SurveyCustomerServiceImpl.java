package com.macys.survey.service.impl;

import com.macys.survey.model.SurveyCustomerModelReqBody;
import com.macys.survey.model.SurveyCustomersModel;
import com.macys.survey.model.SurveyExperience;
import com.macys.survey.service.SurveyCustomerService;
import org.springframework.stereotype.Service;

@Service
public class SurveyCustomerServiceImpl implements SurveyCustomerService {

    @Override
    public SurveyCustomersModel saveCustomerDetails(SurveyCustomerModelReqBody surveyCustomerModelReqBody) {
        SurveyCustomersModel surveyCustomersModel = new SurveyCustomersModel();
        SurveyExperience surveyExperience = new SurveyExperience();
        surveyExperience.setId(surveyCustomerModelReqBody.getExpId());
        surveyCustomersModel.setSurveyExperience(surveyExperience);
        surveyCustomersModel.setName(surveyCustomerModelReqBody.getName());
        surveyCustomersModel.setEmail(surveyCustomerModelReqBody.getEmail());
        surveyCustomersModel.setGender(surveyCustomerModelReqBody.getGender());
        surveyCustomersModel.setAge(surveyCustomerModelReqBody.getAge());
        surveyCustomersModel.setPage(surveyCustomerModelReqBody.getPage());
        surveyCustomersModel.setPincode(surveyCustomerModelReqBody.getPincode());
        surveyCustomersModel.setTimestamp(surveyCustomerModelReqBody.getTimestamp());

        return surveyCustomersModel;
    }
}
