package com.macys.survey.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="SURVEYCUSTOMERS")
public class SurveyCustomersModel {
	
	@Id
	@GeneratedValue
	@Column(name="surveyId")
	private Long surveyId;

	@ManyToOne
	@JoinColumn(name = "expId")
	SurveyExperience surveyExperience;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="age")
	private String age;
	
	@Column(name="page")
	private String page;

	@Column(name="pincode")
	private String pincode;

	@Column(name="timestamp")
	private Timestamp timestamp;

	private Long count;
	
	public SurveyCustomersModel(String gender, Long count) {
		this.count = count;
		this.gender = gender;
	}
	
	public SurveyCustomersModel(){
	}

	public Long getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(Long surveyId) {
		this.surveyId = surveyId;
	}

	public SurveyExperience getSurveyExperience() {
		return surveyExperience;
	}

	public void setSurveyExperience(SurveyExperience surveyExperience) {
		this.surveyExperience = surveyExperience;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
}
