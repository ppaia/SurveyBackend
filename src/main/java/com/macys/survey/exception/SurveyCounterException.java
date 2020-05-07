package com.macys.survey.exception;
/**
 *This class is used to throw Exception response
 * in case of any exceptions
 * @param message
 */
public class SurveyCounterException extends RuntimeException {
    public SurveyCounterException(String message)
    {
        super(message);
    }

}
