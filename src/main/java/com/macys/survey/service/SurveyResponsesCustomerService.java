package com.macys.survey.service;

import com.macys.survey.model.SurveyResponseQuizes;

//import javax.ws.rs.QueryParam;
import java.util.List;

public interface SurveyResponsesCustomerService {

    List<SurveyResponseQuizes> getSurveyGraph(Long surveyId);

}
