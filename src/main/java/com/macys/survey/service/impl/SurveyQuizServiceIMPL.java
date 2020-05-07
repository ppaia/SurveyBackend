package com.macys.survey.service.impl;

import com.macys.survey.dao.SurveyQuizDao;
import com.macys.survey.exception.SurveyQuizException;
import com.macys.survey.model.SurveyQuiz;
import com.macys.survey.service.SurveyQuizService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.List;

@Component
public class SurveyQuizServiceIMPL implements SurveyQuizService {
    private static final Logger logger = LoggerFactory.getLogger(SurveyQuizServiceIMPL.class);

    @Autowired
    SurveyQuizDao surveyQuizDao;

    public void setSurveyQuizDao(SurveyQuizDao surveyQuizDao) {
        this.surveyQuizDao = surveyQuizDao;
    }
    /**
     *
     * This method is get list of Survey quizzes.
     *
     * @param pageName
     * @return Data List<SurveyQuiz>
     */

    @Override
    public List<SurveyQuiz> getQuestionFromPage(String pageName) {
        logger.info("START :: SurveyQuizServiceIMPL :: getQuestionFromPage ");
        if(surveyQuizDao.findByPageIgnoreCase(pageName).size()==0){
            throw new SurveyQuizException("Page Name Not Found");
        }
        List<SurveyQuiz> surveys=surveyQuizDao.findByPageIgnoreCase(pageName);
        logger.info("END :: SurveyQuizServiceIMPL :: getQuestionFromPage ");
        return surveys;
    }
}
