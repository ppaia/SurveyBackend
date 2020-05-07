package com.macys.survey.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SURVEYCUSTOMERS")
public class SurveyCountByGender {

	@Id
	@GeneratedValue
	private Integer surveyId;
	private String gender;
	private Long count;
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	
	public SurveyCountByGender(String gender, Long count) {
		this.gender = gender;
		this.count = count;
	}

}
