package com.macys.survey.exceptionhandler;

import com.macys.survey.exception.ErrorResponse;
import com.macys.survey.exception.SurveyResponseVOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class SurveyResponseExceptionVOHandler {
    private static final Logger logger = LoggerFactory.getLogger(SurveyResponseExceptionVOHandler.class);

    /**
     * This exception is for SurveyQuiz
     *
     * @return error message and HTTP Status
     */
    @ExceptionHandler(SurveyResponseVOException.class)
    public final ResponseEntity<ErrorResponse> handlerSurveyQuizException(SurveyResponseVOException ex, WebRequest request)
    {
        logger.info("START :: SurveyQuizExceptionHandler :: handlerSurveyQuizException");
        ErrorResponse errorDetails = new ErrorResponse(new Date(), ex.getMessage(), request.getDescription(false));
        logger.info("END :: SurveyCounterExceptionHandler :: handlerSurveyQuizException");
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
