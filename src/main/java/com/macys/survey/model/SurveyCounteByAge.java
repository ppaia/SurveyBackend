package com.macys.survey.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SURVEYCUSTOMERS")
public class SurveyCounteByAge {
	@Id
	@GeneratedValue
	private Long surveyId;
	private String age;
	private Long count;

	  public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public SurveyCounteByAge(String age, Long count) {
	    this.age = age;
	    this.count = count;
	  }
}
