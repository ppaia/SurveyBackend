package com.macys.survey.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SURVEYCUSTOMERS")
public class SurveyCountByPincode {

    @Id
    @GeneratedValue
    private Long surveyId;
    private String Pincode;
    private Long count;

    public String getPincode() {
        return Pincode;
    }

    public void setPincode(String pincode) {
        Pincode = pincode;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public SurveyCountByPincode() {
    }

    public SurveyCountByPincode(String pincode, Long count) {
        Pincode = pincode;
        this.count = count;
    }

    @Override
    public String toString() {
        return "SurveyCountByPincode{" +
                "Pincode='" + Pincode + '\'' +
                ", count=" + count +
                '}';
    }
}
