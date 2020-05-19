package com.macys.survey.service.impl;

import com.macys.survey.dao.SurveyQuizesDao;
import com.macys.survey.dao.SurveyResponsesDao;
import com.macys.survey.model.SurveyCustomersModel;
import com.macys.survey.model.SurveyResponseQuizes;
import com.macys.survey.model.SurveyResponses;
import com.macys.survey.service.SurveyResponsesCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SurveyResponsesCustomerServiceImpl implements SurveyResponsesCustomerService {

    @Autowired
    SurveyResponsesDao surveyResponsesDao;

    @Autowired
    SurveyQuizesDao surveyQuizesDao;

    @Override
    public List<SurveyResponseQuizes> getSurveyGraph(Long surveyId)
    {
        SurveyCustomersModel surveyCustomersModel=new SurveyCustomersModel();
        surveyCustomersModel.setSurveyId(surveyId);
        List<SurveyResponses> surveyResponsesList=surveyResponsesDao.findBySurveyCustomersModel(surveyCustomersModel);
        System.out.println(surveyResponsesList);
        List<SurveyResponseQuizes>  surveyResponseQuizesList=new ArrayList<>();
        surveyResponsesList.stream().forEach(surveyResponses -> {

            surveyResponseQuizesList.add(new SurveyResponseQuizes(surveyResponses.getSurveyQuizes().getQuestion(),surveyResponses.getAnswer()));

        });
      return surveyResponseQuizesList;
    }
}
