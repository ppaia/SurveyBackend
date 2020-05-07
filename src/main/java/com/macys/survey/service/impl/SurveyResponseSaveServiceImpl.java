package com.macys.survey.service.impl;

import com.macys.survey.dao.SurveyCustomersDao;
import com.macys.survey.dao.SurveyQuizDao;
import com.macys.survey.dao.SurveyResponseDao;
import com.macys.survey.exception.CustomerNotFoundException;
import com.macys.survey.exception.QuizNotFoundException;
import com.macys.survey.model.SurveyAns;
import com.macys.survey.model.SurveyCustomersModel;
import com.macys.survey.model.SurveyQuiz;
import com.macys.survey.model.SurveyResponse;
import com.macys.survey.service.SurveyResponseSaveService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurveyResponseSaveServiceImpl implements SurveyResponseSaveService {

    private static final Logger logger = LoggerFactory.getLogger(SurveyResponseSaveServiceImpl.class);

     @Autowired
     SurveyCustomersDao surveyCustomerDao;

     @Autowired
     SurveyQuizDao surveyQuizDao;

     @Autowired
     SurveyResponseDao surveyResponseDao;
    /**
     * This method is used to save the Survey response.
     *
     * @return void
     */
    @Override
    public void saveSurveyResponse(Long surveyId, List<SurveyAns> answers)
    {
      logger.info("START:: SurveyResponseSaveServiceImpl :: saveSurveyResponse");

       Optional<SurveyCustomersModel> optionalSurveyCustomer=surveyCustomerDao.findById(surveyId);
       if(!optionalSurveyCustomer.isPresent())
       {
         throw new CustomerNotFoundException(surveyId);
       }
       SurveyCustomersModel surveyCustomersModel =optionalSurveyCustomer.get();
      answers.stream().forEach(answer->{
          SurveyResponse surveyResponse=new SurveyResponse();

          Optional<SurveyQuiz> optionalSurveyQuiz=surveyQuizDao.findById(answer.getQuizId());
          if(!optionalSurveyQuiz.isPresent())
          {
             throw new QuizNotFoundException(answer.getQuizId());
          }
          SurveyQuiz surveyQuiz=optionalSurveyQuiz.get();
          surveyResponse.setSurveyCustomersModel(surveyCustomersModel);
          surveyResponse.setSurveyQuiz(surveyQuiz);
          surveyResponse.setAnswer(answer.getAnswer());

          surveyResponseDao.save(surveyResponse);
      });
    }
}
