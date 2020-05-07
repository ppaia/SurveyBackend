package com.macys.survey.exceptionhandler;

import com.macys.survey.exception.ErrorResponse;
import com.macys.survey.exception.SurveyCounterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class SurveyCounterExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(SurveyCounterExceptionHandler.class);

    /**
     * This exception is for SurveyCounter
     *
     * @return error message and HTTP Status
     */
    @ExceptionHandler(SurveyCounterException.class)
    public final ResponseEntity<ErrorResponse> handlerSurveyCounterException(SurveyCounterException ex, WebRequest request)
    {
        logger.info("START :: SurveyCounterExceptionHandler :: handlerSurveyCounterException");
        ErrorResponse errorDetails = new ErrorResponse(new Date(), ex.getMessage(), request.getDescription(false));
        logger.info("END :: SurveyCounterExceptionHandler :: handlerSurveyCounterException");
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

}
