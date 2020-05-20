package com.macys.survey.controller;

import com.macys.survey.dao.SurveyExperienceDao;
import com.macys.survey.model.SurveyGetResultNew;
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
    public SurveyGetResultNew  getData(@PathVariable Long expId){

        List<SurveyQuizesResponse> surveyQuiz=new ArrayList<>();


        Map<Long,List<SurveyQuizesResponse>> longListMap=new TreeMap<>();
        List<List<SurveyQuizesResponse>> sr=new ArrayList<>();
        Map<Long, List<SurveyQuizesResponse>> surveyMap = new TreeMap<>();
        SurveyGetResultNew surveyGetResultNew=new SurveyGetResultNew();

        List<SurveyQuizResponseNew> surveyQuizResponseNews=new ArrayList<>();

        List<List<SurveyQuizListResponseNew>> surveyQ=new ArrayList<>();
            if(surveyOptionDao.getData(expId).size()==0){
                throw new SurveyQuizException("NO EXPERIENCE FOUND");
            }
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

            for(Map.Entry<Long,List<SurveyQuizesResponse>> map: surveyMap.entrySet()) {
                surveyQuiz.addAll(map.getValue());
            }




            surveyQuizResponse.setSurveyQuiz(surveyQuiz);

            for(int i=0;i<surveyQuizResponse.getSurveyQuiz().size();i++) {
                if(!longListMap.containsKey(surveyQuizResponse.getSurveyQuiz().get(i).getSurveyQuizId())) {
                    List<SurveyQuizesResponse> sur=new ArrayList<>();
                    sur.add(surveyQuizResponse.getSurveyQuiz().get(i));
                    longListMap.put(surveyQuizResponse.getSurveyQuiz().get(i).getSurveyQuizId(),sur);
                }
                else {
                    List<SurveyQuizesResponse> sur=new ArrayList<>();
                    for(Map.Entry<Long,List<SurveyQuizesResponse>> map: longListMap.entrySet()) {
                        sur=map.getValue();
                    }
                    sur.add(surveyQuizResponse.getSurveyQuiz().get(i));
                    longListMap.put(surveyQuizResponse.getSurveyQuiz().get(i).getSurveyQuizId(),sur);
                }

            }

            for(int i=0;i<surveyQuizResponse.getSurveyQuiz().size();i++) {
                if(!sr.contains(longListMap.get(surveyQuizResponse.getSurveyQuiz().get(i).getSurveyQuizId()))) {
                    sr.add(longListMap.get(surveyQuizResponse.getSurveyQuiz().get(i).getSurveyQuizId()));
                }

            }

            for(int i=0;i<sr.size();i++){
                List<SurveyQuizesResponse> newsurvey=sr.get(i);
                List<SurveyQuizListResponseNew> surveyQuizListResponseNews=new ArrayList<>();
                for(int j=0;j<newsurvey.size();j++) {
                    SurveyQuizListResponseNew surveyQuizListResponseNew=new SurveyQuizListResponseNew();
                    if(newsurvey.get(j).getSurveyQuiz()!=null) {

                    surveyQuizListResponseNew.setOptionId(newsurvey.get(j).getOptionId());
                    surveyQuizListResponseNew.setOption(newsurvey.get(j).getOption());
                        List<OptionResponseNew> optionResponseNews=new ArrayList<>();
                        for (int k = 0; k < newsurvey.get(j).getSurveyQuiz().size(); k++) {
                            surveyQuizListResponseNew.setSurveyQuizId(newsurvey.get(j).getSurveyQuiz().get(k).getSurveyQuizId());
                            surveyQuizListResponseNew.setQuestion(newsurvey.get(j).getSurveyQuiz().get(k).getQuestion());
                            OptionResponseNew opr = new OptionResponseNew();
                            opr.setOptionId(newsurvey.get(j).getSurveyQuiz().get(k).getOptionId());
                            opr.setOption(newsurvey.get(j).getSurveyQuiz().get(k).getOption());
                            optionResponseNews.add(opr);
                            surveyQuizListResponseNew.setSurveyQuiz(optionResponseNews);
                        }
                    }else
                    {
                        List<OptionResponseNew> optionResponseNews=new ArrayList<>();
                        OptionResponseNew opr = new OptionResponseNew();
                        opr.setOptionId(newsurvey.get(j).getOptionId());
                        opr.setOption(newsurvey.get(j).getOption());
                        optionResponseNews.add(opr);
                        surveyQuizListResponseNew.setSurveyQuiz(optionResponseNews);
                    }
                    surveyQuizListResponseNews.add(surveyQuizListResponseNew);
                }
                surveyQ.add(surveyQuizListResponseNews);
            }

            for(int i=0;i<sr.size();i++){

                for(int j=0;j<sr.get(i).size();j++) {
                    if (surveyQ.get(i).get(j).getOptionId() != null) {

                        if (sr.get(i).get(j).getOptionId() == surveyQ.get(i).get(j).getOptionId()) {
                            SurveyQuizResponseNew surveyQuizResponseNew=new SurveyQuizResponseNew();
                            surveyQuizResponseNew.setSurveyQuizId(sr.get(i).get(j).getOptionId());
                            surveyQuizResponseNew.setQuestion(sr.get(i).get(j).getQuestion());
                            surveyQuizResponseNew.setOptions(surveyQ.get(i));
                            surveyQuizResponseNews.add(surveyQuizResponseNew);
                            break;
                        }


                    }
                    else{
                        if (sr.get(i).get(j).getOptionId() == surveyQ.get(i).get(j).getSurveyQuiz().get(0).getOptionId()) {
                            SurveyQuizResponseNew surveyQuizResponseNew=new SurveyQuizResponseNew();
                            surveyQuizResponseNew.setSurveyQuizId(sr.get(i).get(j).getOptionId());
                            surveyQuizResponseNew.setQuestion(sr.get(i).get(j).getQuestion());
                            surveyQuizResponseNew.setOptions(surveyQ.get(i));
                            surveyQuizResponseNews.add(surveyQuizResponseNew);
                            break;
                        }
                    }

                }
            }


            surveyGetResultNew.setId(surveyQuizResponse.getId());
            surveyGetResultNew.setExpName(surveyQuizResponse.getExpName());
            surveyGetResultNew.setSurveyQuiz(surveyQuizResponseNews);


        }
        catch (Exception e){
            e.printStackTrace();
        }



        return surveyGetResultNew;

    }



}
