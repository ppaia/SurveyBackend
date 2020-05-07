package com.macys.survey.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SurveyQuiz")
public class SurveyQuiz {
    @Id
    @Column(name = "quizId",nullable = false)
    private Long id;

    @Column(name = "Page")
    private String page;

    @Column(name = "Question")
    private String question;

    @Column(name = "Option")
    private String option;

    public SurveyQuiz() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public SurveyQuiz(Long id, String page, String question, String option) {
        this.id = id;
        this.page = page;
        this.question = question;
        this.option = option;
    }

    @Override
    public String toString() {
        return "SurveyQuiz{" +
                "id=" + id +
                ", page='" + page + '\'' +
                ", question='" + question + '\'' +
                ", option='" + option + '\'' +
                '}';
    }
}
