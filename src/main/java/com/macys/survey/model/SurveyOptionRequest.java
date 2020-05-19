package com.macys.survey.model;

import java.util.List;
import java.util.Map;

public class SurveyOptionRequest {
    String optionName;
    String question;
    List<String> option;

    public SurveyOptionRequest() {
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getOption() {
        return option;
    }

    public void setOption(List<String> option) {
        this.option = option;
    }
}
