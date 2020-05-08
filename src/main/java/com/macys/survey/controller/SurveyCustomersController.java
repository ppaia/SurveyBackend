package com.macys.survey.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.macys.survey.dao.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.macys.survey.dao.SurveyCounterAge;
import com.macys.survey.dao.SurveyCounterGender;
import com.macys.survey.dao.SurveyCustomerGraph;
import com.macys.survey.dao.SurveyCustomersDao;
import com.macys.survey.model.SampleSurveyGraph;
import com.macys.survey.model.SurveyCountByGender;
import com.macys.survey.model.SurveyCountByPincode;
import com.macys.survey.model.SurveyCounteByAge;
import com.macys.survey.model.SurveyCounter;
import com.macys.survey.model.SurveyCustomersModel;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value="/rest/chatbot/")

public class SurveyCustomersController {
	private static final Logger logger = LoggerFactory.getLogger(SurveyCounter.class);
	public String pageType;
	
	@Autowired
	SurveyCustomersDao surveyCustomersDao;
	@Autowired
	SurveyCustomerGraph surveyCustomerGraph;
	@Autowired
	SurveyCounterAge surveyCounterAge;
	@Autowired
	SurveyCounterGender surveyCounterGender;
	@Autowired
	SurveyCounterPincode surveyCounterPincode;

	//API to get all customer details
	@RequestMapping(value="/survey/getSurveyData", method=RequestMethod.GET)
	@ResponseStatus(value=HttpStatus.OK)
	public List<SurveyCustomersModel> getAll(){
		logger.info("START:: SurveyCustomersController :: getSurveyData");
		return surveyCustomersDao.findAll();
	}
	
	//API to get Customer Details through Survey_Id
	@RequestMapping(value="/survey/getSurveyDataById", method=RequestMethod.GET)
	@ResponseStatus(value=HttpStatus.OK)
	public Optional<SurveyCustomersModel> getDetails(@RequestParam(value="id", required =
			true) Long id, SurveyCustomersModel surveyCustomersModel ){
		logger.info("START:: SurveyCustomersController :: getSurveyDataById");
		return surveyCustomersDao.findById(id);
	}
	
	//API to get Survey response from table : SAMPLESURVEYRESPONSE through Customer Query Survey_id
	@RequestMapping(value="/survey/getsurveygraph", method=RequestMethod.GET)
	@ResponseStatus(value=HttpStatus.OK)
	public List<SampleSurveyGraph> getDetailGraph(@RequestParam(value="survey_id", required =
			true) Integer survey_id, SampleSurveyGraph SampleSurveyGraph ){
		logger.info("START:: SurveyCustomersController :: getsurveygraph");
		return surveyCustomerGraph.findInformation(survey_id);
	}
	
	//API to get Survey response for AGE from table : SURVEYCUSTOMERS 
	@RequestMapping(value="/survey/getSurevyCountByAge", method=RequestMethod.GET)
	@ResponseStatus(value=HttpStatus.OK)
	public Map<String, Long> getSurevyCountByAge(){
		logger.info("START:: SurveyCustomersController :: getSurevyCountByAge");
		Map<String, Long> ageMap = new HashMap<String, Long>();
		for(SurveyCounteByAge age : surveyCounterAge.findCounterDataByAge())
		{
			if (age.getAge() != null && !age.getAge().isEmpty()){
				ageMap.put(age.getAge(), age.getCount());
			}
		}
		logger.info("END:: SurveyCustomersController :: getSurevyCountByAge");
		return ageMap; 
	}

	//API to get Survey response for GENDER from table : SURVEYCUSTOMERS 
	@RequestMapping(value="/survey/getSurevyCountByGender", method=RequestMethod.GET)
	@ResponseStatus(value=HttpStatus.OK)
	public Map<String, Long> getSurevyCountByGender(){
		logger.info("START:: SurveyCustomersController :: getSurevyCountByGender");
		Map<String, Long> genderMap = new HashMap<String, Long>();
		for(SurveyCountByGender gender : surveyCounterGender.findCounterDataByGender())
		{
			if (gender.getGender() != null && !gender.getGender().isEmpty()){
				genderMap.put(gender.getGender(), gender.getCount());
			}
		}
		logger.info("END:: SurveyCustomersController :: getSurevyCountByGender");
		return genderMap;
	}

	//API to POST the Customer Details to Table : SURVEYCUSTOMERS
	@RequestMapping(value="/survey/loadsurveydata", method=RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.CREATED)
	public @ResponseBody SurveyCustomersModel persistAllData(@RequestBody final SurveyCustomersModel surveyCustomersModel){
		logger.info("START:: SurveyCustomersController :: loadsurveydata");
		pageType = surveyCustomersModel.getPage();
		Timestamp currentTime=new Timestamp(System.currentTimeMillis());  
		surveyCustomersModel.setTimestamp(currentTime);
		surveyCustomersDao.save(surveyCustomersModel);
		logger.info("END:: SurveyCustomersController :: loadsurveydata");
		return surveyCustomersModel;
		//return surveyCustomersDao.findAll();
	}

	//API to get Survey response on basis of PINCODE from table : SURVEYCUSTOMERS
	@RequestMapping(value="/survey/getSurveyCountByPincode", method=RequestMethod.GET)
	@ResponseStatus(value=HttpStatus.OK)
	public Map<String, Long> getSurveyCountByPincode(){
		logger.info("START:: SurveyCustomersController :: getSurevyCountByGender");
		Map<String, Long> pincodeMap = new HashMap<String, Long>();
		for(SurveyCountByPincode surveyCountByPincode : surveyCounterPincode.findCounterByPincode())
		{
			if (surveyCountByPincode.getPincode() != null && !surveyCountByPincode.getPincode().isEmpty()){
				pincodeMap.put(surveyCountByPincode.getPincode(), surveyCountByPincode.getCount());
			}
		}
		logger.info("END:: SurveyCustomersController :: getSurevyCountByGender");
		return pincodeMap;
	}
}
