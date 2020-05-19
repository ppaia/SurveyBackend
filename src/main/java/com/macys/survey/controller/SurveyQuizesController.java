package com.macys.survey.controller;

import com.macys.survey.dao.SurveyExperienceDao;
import com.macys.survey.dao.SurveyOptionDao;
import com.macys.survey.dao.SurveyQuizesDao;
import com.macys.survey.exception.SurveyQuizException;
import com.macys.survey.model.*;
import com.macys.survey.service.SurveyQuizesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value="/rest/chatbot/survey")
public class SurveyQuizesController {
    @Autowired
    SurveyQuizesService surveyQuizesService;

    @Autowired
    SurveyExperienceDao surveyExperienceDao;

    @Autowired
    SurveyQuizesDao surveyQuizesDao;

    @Autowired
    SurveyOptionDao surveyOptionDao;

    public void setSurveyQuizesService(SurveyQuizesService surveyQuizesService) {
        this.surveyQuizesService = surveyQuizesService;
    }

    @PostMapping(value="/addQuizes")
    public Long addSurveyQuiz(@RequestBody SurveyQuizesRequest surveyQuizesRequest){
        return surveyQuizesService.addSurveyQuizes(surveyQuizesRequest);

    }


    @RequestMapping(value = "/survey/getSurveyExperience/{expId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public SurveyQuizResponse  getData(@PathVariable Long expId){
        Map<Long, List<SurveyQuizesResponse>> surveyMap = new TreeMap<>();

            List<SurveyQuizesResponse> surveyQuizesResponses = surveyOptionDao.getData(expId);

            SurveyExperience surveyExperience = surveyExperienceDao.findByid(surveyQuizesResponses.get(0).getExpId());
            SurveyQuizResponse surveyQuizResponse = new SurveyQuizResponse();
        try {
            surveyQuizResponse.setId(surveyExperience.getId());
            surveyQuizResponse.setExpName(surveyExperience.getExpName());

            for (int i = 0; i < surveyQuizesResponses.size(); i++) {

                if (!surveyMap.containsKey(surveyQuizesResponses.get(i).getSurveyQuizId()) ) {
                    if(surveyQuizesResponses.get(i).getParent()==null) {
                        List<SurveyQuizesResponse> li = new ArrayList<>();
                        li.add(surveyQuizesResponses.get(i));
                        surveyMap.put(surveyQuizesResponses.get(i).getSurveyQuizId(), li);
                    }else{
                        if(!surveyMap.containsKey(surveyQuizesResponses.get(i).getParent())) {
                            List<SurveyQuizesResponse> li = new ArrayList<>();
                            li.add(surveyQuizesResponses.get(i));
                            surveyMap.put(surveyQuizesResponses.get(i).getParent(), li);
                        }else{
                            List<SurveyQuizesResponse> li = surveyMap.get(surveyQuizesResponses.get(i).getParent());
                            li.add(surveyQuizesResponses.get(i));
                            surveyMap.put(surveyQuizesResponses.get(i).getParent(), li);
                        }

                    }
                }
                else if(surveyQuizesResponses.get(i).getParent()==null) {
                    List<SurveyQuizesResponse> li = surveyMap.get(surveyQuizesResponses.get(i).getSurveyQuizId());
                    li.add(surveyQuizesResponses.get(i));
                    surveyMap.put(surveyQuizesResponses.get(i).getSurveyQuizId(), li);
                }

            }
            List<Long> options=new ArrayList<>();

            for(Map.Entry<Long,List<SurveyQuizesResponse>> map: surveyMap.entrySet()){
                List<SurveyQuizesResponse> surveyQuizes=map.getValue();
                for(SurveyQuizesResponse quizesResponse:surveyQuizes){
                    if(quizesResponse.getParent()==null){
                        List<SurveyQuizesResponse> surveyoptionlist= surveyMap.get(quizesResponse.getOptionId());
                        options.add(quizesResponse.getOptionId());
                        quizesResponse.setSurveyQuiz(surveyoptionlist);

                    }

        }

    }
            surveyMap.keySet().removeAll(options);
            List<SurveyQuizesResponse> surveyQuiz=new ArrayList<>();
            for(Map.Entry<Long,List<SurveyQuizesResponse>> map: surveyMap.entrySet()) {
                surveyQuiz.addAll(map.getValue());
            }
            surveyQuizResponse.setSurveyQuiz(surveyQuiz);
        }
        catch (Exception e){
            e.printStackTrace();
        }



        return surveyQuizResponse;

    }



}
