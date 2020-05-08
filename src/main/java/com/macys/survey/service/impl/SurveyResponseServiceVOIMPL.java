package com.macys.survey.service.impl;

import com.macys.survey.dao.SurveyResponseVODao;
import com.macys.survey.exception.SurveyResponseVOException;
import com.macys.survey.exceptionhandler.SurveyResponseExceptionVOHandler;
import com.macys.survey.model.*;
import com.macys.survey.service.SurveyResponseServiceVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SurveyResponseServiceVOIMPL implements SurveyResponseServiceVO {

    private static final Logger logger = LoggerFactory.getLogger(SurveyResponseExceptionVOHandler.class);

    @Autowired
    SurveyResponseVODao surveyResponseVODao;

    public void setSurveyResponseVODao(SurveyResponseVODao surveyResponseVODao) {
        this.surveyResponseVODao = surveyResponseVODao;
    }

    /**
     * this method return
     * surveys data
     * of last fifteen days
     * @return List<SurveyResponseVO>
     */


    @Override
    public List<SurveyResponseVO> getLastfifteenDaysSurvey() {
        logger.info("START :: SurveyResponseServiceVOIMPL :: getLastfifteenDaysSurvey ");
        if(surveyResponseVODao.surveyofLastFifteenDays().size()==0) {
        throw new SurveyResponseVOException("NO SURVEYS FOUND");
        }
        List<SurveyResponse> surveyfifteendays= surveyResponseVODao.surveyofLastFifteenDays();
        List<SurveyResponseVO> surveyresponsevo=new ArrayList<>();
        Map<Long, List<SurveyCustomerTaken>> surveys = new HashMap<>();
        Map<Long, SurveyCustomersModel> surveyCustomerMap=new HashMap<>();
        for(SurveyResponse surveyResponse:surveyfifteendays) {

            if(!surveys.containsKey(surveyResponse.getSurveyCustomersModel().getSurveyId())){
                logger.debug("Start :: SurveyResponseServiceVOIMPL :: getLastfifteenDaysSurvey :: loop :: start ");
                SurveyQuiz surveyQuiz=new SurveyQuiz(surveyResponse.getSurveyQuiz().getId(),surveyResponse.getSurveyQuiz().getPage(),surveyResponse.getSurveyQuiz().getQuestion(),surveyResponse.getSurveyQuiz().getOption());
                logger.debug(" SurveyResponseServiceVOIMPL :: getLastfifteenDaysSurvey ::  if :: loop :: start :: ",surveyQuiz);
                SurveyCustomerTaken surveyTaken=new SurveyCustomerTaken(surveyQuiz,surveyResponse.getAnswer());
                List<SurveyCustomerTaken> customerTakens=new ArrayList<>();
                customerTakens.add(surveyTaken);
                logger.debug(" SurveyResponseServiceVOIMPL :: getLastfifteenDaysSurvey ::  if :: loop :: ",customerTakens);
                surveys.put(surveyResponse.getSurveyCustomersModel().getSurveyId(), customerTakens);
                if(!surveyCustomerMap.containsKey(surveyResponse.getSurveyCustomersModel().getSurveyId())) {
                    surveyCustomerMap.put(surveyResponse.getSurveyCustomersModel().getSurveyId(), surveyResponse.getSurveyCustomersModel());
                }
                logger.debug(" SurveyResponseServiceVOIMPL :: getLastfifteenDaysSurvey ::  else :: end ");
            }
            else
            {
                logger.debug(" SurveyResponseServiceVOIMPL :: getLastfifteenDaysSurvey ::  else :: start  ");
                List<SurveyCustomerTaken> customerTakens=surveys.get(surveyResponse.getSurveyCustomersModel().getSurveyId());
                SurveyQuiz surveyQuiz=new SurveyQuiz(surveyResponse.getSurveyQuiz().getId(),surveyResponse.getSurveyQuiz().getPage(),surveyResponse.getSurveyQuiz().getQuestion(),surveyResponse.getSurveyQuiz().getOption());
                SurveyCustomerTaken surveyTaken=new SurveyCustomerTaken(surveyQuiz,surveyResponse.getAnswer());
                customerTakens.add(surveyTaken);
                surveyCustomerMap.put(surveyResponse.getSurveyCustomersModel().getSurveyId(),surveyResponse.getSurveyCustomersModel());
                surveys.put(surveyResponse.getSurveyCustomersModel().getSurveyId(), customerTakens);
                logger.debug(" SurveyResponseServiceVOIMPL :: getLastfifteenDaysSurvey ::  else :: end  ");
            }

        }

        for (Map.Entry<Long, SurveyCustomersModel> entry : surveyCustomerMap.entrySet()) {
            SurveyResponseVO surveyResponseVO=new SurveyResponseVO();
            surveyResponseVO.setSurveyCustomersModel(entry.getValue());
            surveyResponseVO.setSurveyCustomerTakens(surveys.get(entry.getKey()));
            surveyresponsevo.add(surveyResponseVO);
        }
        logger.info("END :: SurveyResponseServiceVOIMPL :: getLastfifteenDaysSurvey ");
        return surveyresponsevo;
    }
}
