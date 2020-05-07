package com.macys.survey.exception;
/**
 *This class is used to throw Exception response
 * in case of any exceptions
 * @param message
 */
public class SurveyQuizException extends RuntimeException {
    public SurveyQuizException(String message)
    {
        super(message);
    }
}
