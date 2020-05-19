package com.macys.survey.service.impl;

import com.macys.survey.dao.SurveyExperienceDao;
import com.macys.survey.dao.SurveyOptionDao;
import com.macys.survey.dao.SurveyQuizesDao;
import com.macys.survey.exception.SurveyQuizException;
import com.macys.survey.model.*;
import com.macys.survey.service.SurveyQuizesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class SurveyQuizesServiceIMPL implements SurveyQuizesService {
    @Autowired
    SurveyQuizesDao surveyQuizesDao;

    @Autowired
    SurveyExperienceDao surveyExperienceDao;

    @Autowired
    SurveyOptionDao surveyOptionDao;

    @Override
    public Long addSurveyQuizes(SurveyQuizesRequest surveyQuizesRequest) {
    	Long expId=null;
        if(surveyQuizesRequest.getId()!=null){
            if(surveyExperienceDao.findByid(surveyQuizesRequest.getId())!=null) {
                SurveyExperience surveyExperience = surveyExperienceDao.findByid(surveyQuizesRequest.getId());
                expId=saveSurveyQuiz(surveyQuizesRequest, surveyExperience);
            }
            else
            {
                throw new SurveyQuizException("NO EXPERIENCE ID FOUND FOR "+ surveyQuizesRequest.getId());
            }
        }
        else
        {
            SurveyExperience surveyExperience=new SurveyExperience(surveyQuizesRequest.getExpName());
            surveyExperienceDao.save(surveyExperience);
            expId=saveSurveyQuiz(surveyQuizesRequest,surveyExperience);
        }
        return expId;
    }


    public Long  saveSurveyQuiz(SurveyQuizesRequest surveyQuizesRequest,SurveyExperience surveyExperience){
        for(int i=0;i<surveyQuizesRequest.getSurveyQuiz().size();i++){
            String question= surveyQuizesRequest.getSurveyQuiz().get(i).getQuestion();
            SurveyQuizes surveyQuizes=new SurveyQuizes(surveyExperience,question);
            surveyQuizesDao.save(surveyQuizes);
            for(int j=0;j<surveyQuizesRequest.getSurveyQuiz().get(i).getOption().size();j++){
                String optionName=surveyQuizesRequest.getSurveyQuiz().get(i).getOption().get(j).getOptionName();
                SurveyOption surveyOption=this.newSurveyOption( surveyQuizes, optionName);
                if(surveyQuizesRequest.getSurveyQuiz().get(i).getOption().get(j).getQuestion()!=""||surveyQuizesRequest.getSurveyQuiz().get(i).getOption().get(j).getQuestion()!=null) {
                    String ques = surveyQuizesRequest.getSurveyQuiz().get(i).getOption().get(j).getQuestion();
                    if (ques != null) {
                        SurveyQuizes surveyQuizesinner = new SurveyQuizes(surveyExperience, ques, surveyOption);
                        surveyQuizesDao.save(surveyQuizesinner);
                        for (int k = 0; k < surveyQuizesRequest.getSurveyQuiz().get(i).getOption().get(j).getOption().size(); k++) {
                            String option = surveyQuizesRequest.getSurveyQuiz().get(i).getOption().get(j).getOption().get(k);
                            SurveyOption surveyOpt =this.newSurveyOption(surveyQuizesinner, option);
                        }
                    }
                }
            }
        }
        return surveyExperience.getId();

    }

    public SurveyOption newSurveyOption(SurveyQuizes surveyQuizes, String optionName){
        SurveyOption surveyOption=new SurveyOption(surveyQuizes,optionName);
        surveyOptionDao.save(surveyOption);
        return surveyOption;
    }




}
