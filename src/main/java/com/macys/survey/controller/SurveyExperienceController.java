package com.macys.survey.controller;

import com.macys.survey.model.SurveyExperience;
import com.macys.survey.service.SurveyExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value="/rest/chatbot/survey")

public class SurveyExperienceController {
    @Autowired
    SurveyExperienceService surveyExperienceService;

    @GetMapping("/getsurveys")
    public ResponseEntity<List<SurveyExperience>> getAllSurveys(){
        return ResponseEntity.ok().body(surveyExperienceService.getAllExperiences());
    }
}
