package com.macys.survey.exception;
/**
 *This class is used to throw Exception response
 * in case of any exceptions
 * @param message
 */
public class SurveyResponseVOException extends RuntimeException {
    public SurveyResponseVOException(String message)
    {
        super(message);
    }
}
