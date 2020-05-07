package com.macys.survey.service.impl;

import com.macys.survey.dao.SurveyCounterDao;
import com.macys.survey.exception.SurveyCounterException;
import com.macys.survey.model.SurveyCounter;
import com.macys.survey.service.SurveyCounterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;
import java.util.Calendar;
import java.util.Date;

@Component
public class SurveyCounterServiceIMPL implements SurveyCounterService {
    private static final Logger logger = LoggerFactory.getLogger(SurveyCounterServiceIMPL.class);
    @Autowired
    SurveyCounterDao surveyCounterDao;

    public void setSurveyCounterDao(SurveyCounterDao surveyCounterDao) {
        this.surveyCounterDao = surveyCounterDao;
    }

    /**
     * This method is used to increment survey accepted .
     *
     * @return Data void
     */


    @Override
    public void incrementAcceptedSurvey() {
        StopWatch stopWatch=new StopWatch();
        stopWatch.start();
        logger.info("START :: SurveyCounterServiceIMPL :: incrementAcceptedSurvey ");
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        if(date==null){
            throw new SurveyCounterException("Date Not Found");
        }
        try{
            if(surveyCounterDao.findBySurveyDate(date)!=null){
                SurveyCounter surveyCounter = surveyCounterDao.findBySurveyDate(date);
                logger.debug("START :: incrementAcceptedSurvey  :: "+surveyCounter.getAcceptedCount());
                surveyCounter.setAcceptedCount(surveyCounter.getAcceptedCount()+1);
                logger.debug("END :: incrementAcceptedSurvey "+surveyCounter.getAcceptedCount());
                surveyCounterDao.save(surveyCounter);
            }
            else
            {
                SurveyCounter surveyCounter=new SurveyCounter(1L,0L,date);
                surveyCounterDao.save(surveyCounter);
            }
        }
        catch(Exception e){
            logger.error("ERROR :: SQL exception occurred at incrementAcceptedSurvey :: "+new Date(),e);
        }
        stopWatch.stop();
        logger.info("END :: SurveyCounterServiceIMPL  ::  incrementAcceptedSurvey "+stopWatch.getTotalTimeMillis());
    }

    /**
     * This method is used to increment survey rejected .
     *
     * @return Data void
     */

    @Override
    public void incrementRejectedSurvey() {
        StopWatch stopWatch=new StopWatch();
        stopWatch.start();
        logger.info("START :: SurveyCounterServiceIMPL :: incrementRejectedSurvey ");

        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        if(date==null){
            throw new SurveyCounterException("Date Not Found");
        }

        try{
            if(surveyCounterDao.findBySurveyDate(date)!=null){
                SurveyCounter surveyCounter = surveyCounterDao.findBySurveyDate(date);
                logger.debug("START :: incrementRejectedSurvey  :: "+surveyCounter.getRejectedCount());
                surveyCounter.setRejectedCount(surveyCounter.getRejectedCount()+1);
                logger.debug("END :: incrementRejectedSurvey  :: "+surveyCounter.getRejectedCount());
                surveyCounterDao.save(surveyCounter);
            }
            else
            {
                SurveyCounter surveyCounter=new SurveyCounter(0l,1L,date);
                surveyCounterDao.save(surveyCounter);
            }
        }
        catch(Exception e){
            logger.error("ERROR :: SQL exception occurred at incrementRejectedSurvey :: "+new Date(),e);
        }
        stopWatch.stop();
        logger.info("END :: SurveyCounterServiceIMPL ::  incrementRejectedSurvey "+stopWatch.getTotalTimeMillis());

}


}
