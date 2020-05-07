package com.macys.survey.model;

public class SurveyCount {
    public Long accepted;
    public Long rejected;

    public SurveyCount(Long accepted, Long rejected) {
        this.accepted = accepted;
        this.rejected = rejected;
    }

    public Long getAccepted() {
        return accepted;
    }

    public void setAccepted(Long accepted) {
        this.accepted = accepted;
    }

    public Long getRejected() {
        return rejected;
    }

    public void setRejected(Long rejected) {
        this.rejected = rejected;
    }

    @Override
    public String toString() {
        return "SurveyCount{" +
                "accepted=" + accepted +
                ", rejected=" + rejected +
                '}';
    }
}
