package com.macys.survey.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.sql.Date;

@Entity
@Table(name = "Surveycounter")
public class SurveyCounter {
    @Column(name = "Acceptedcount",nullable = false)
    private Long acceptedCount;

    @Column(name = "Rejectedcount",nullable = false)
    private Long rejectedCount;

    public SurveyCounter(Long acceptedCount, Long rejectedCount, Date surveyDate) {
		super();
		this.acceptedCount = acceptedCount;
		this.rejectedCount = rejectedCount;
		this.surveyDate = surveyDate;
	}

	public SurveyCounter() {
		super();
	}

	@Id
    @Column(name = "Surveydate")
    private Date surveyDate;

    public Long getAcceptedCount() {
        return acceptedCount;
    }

    public void setAcceptedCount(Long acceptedCount) {
        this.acceptedCount = acceptedCount;
    }

    public Long getRejectedCount() {
        return rejectedCount;
    }

    public void setRejectedCount(Long rejectedCount) {
        this.rejectedCount = rejectedCount;
    }

    public Date getSurveyDate() {
        return surveyDate;
    }

    public void setSurveyDate(Date surveyDate) {
        this.surveyDate = surveyDate;
    }
}
