package com.macys.survey.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SAMPLESURVEYRESPONSE")
public class SampleSurveyGraph {
	
	@Id
	@Column(name="ID")
	private Integer id;
	
	@Column(name="SURVEY_ID")
	private Integer survey_id;
	
	public SampleSurveyGraph() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSurvey_id() {
		return survey_id;
	}

	public void setSurvey_id(Integer survey_id) {
		this.survey_id = survey_id;
	}

	public Integer getQuiz_id() {
		return quiz_id;
	}

	public void setQuiz_id(Integer quiz_id) {
		this.quiz_id = quiz_id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Column(name="QUIZID")
	private Integer quiz_id;
	
	@Column(name="ANSWER")
	private String answer;

	public SampleSurveyGraph(Integer survey_id, Integer quiz_id, String answer) {
		this.survey_id = survey_id;
		this.quiz_id = quiz_id;
		this.answer = answer;
	}
	
	
}
