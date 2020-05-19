package com.macys.survey.service.impl;

import com.macys.survey.dao.SurveyCustomersDao;
import com.macys.survey.dao.SurveyQuizesDao;
import com.macys.survey.dao.SurveyResponsesDao;
import com.macys.survey.exception.CustomerNotFoundException;
import com.macys.survey.exception.QuizNotFoundException;
import com.macys.survey.model.*;
import com.macys.survey.service.SurveyResponsesSaveService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurveyResponsesSaveServiceImpl implements SurveyResponsesSaveService {

    private static final Logger logger = LoggerFactory.getLogger(SurveyResponsesSaveServiceImpl.class);

    @Autowired
    SurveyCustomersDao surveyCustomerDao;

    @Autowired
    SurveyResponsesDao surveyResponsesDao;

    @Autowired
    SurveyQuizesDao surveyQuizesDao;


    /**
     * This method is used to save the Survey response.
     *
     * @return void
     */
    @Override
    public void saveSurveyResponse(Long surveyId, List<SurveyAns> answers)
    {
        logger.info("START:: SurveyResponsesSaveServiceImpl :: saveSurveyResponse");

        Optional<SurveyCustomersModel> optionalSurveyCustomer=surveyCustomerDao.findById(surveyId);
        if(!optionalSurveyCustomer.isPresent())
        {
            throw new CustomerNotFoundException(surveyId);
        }
        SurveyCustomersModel surveyCustomersModel =optionalSurveyCustomer.get();
        answers.stream().forEach(answer->{
            SurveyResponses surveyResponses=new SurveyResponses();

            Optional<SurveyQuizes> optionalSurveyQuiz=surveyQuizesDao.findById(answer.getQuizId());
            if(!optionalSurveyQuiz.isPresent())
            {
                throw new QuizNotFoundException(answer.getQuizId());
            }
            SurveyQuizes surveyQuizes=optionalSurveyQuiz.get();
            surveyResponses.setSurveyCustomersModel(surveyCustomersModel);
            surveyResponses.setSurveyQuizes(surveyQuizes);
            surveyResponses.setAnswer(answer.getAnswer());

            surveyResponsesDao.save(surveyResponses);
        });
    }
}
