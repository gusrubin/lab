package com.gusrubin.lab.cleanlog.application.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;

/**
 * @author Gustavo Rubin
 *
 */

@RestControllerAdvice
public class RestExceptionHandler {

    /**
     * Handle content type validation exceptions when handling REST requests.
     *
     * @param ex the {@link HttpMediaTypeNotSupportedException}
     * @return a Map with error messages with 415 HTTP status
     */
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public Map<String, String> handleIllegalArgumentException(HttpMediaTypeNotSupportedException ex) {
	Map<String, String> errors = new HashMap<>();
	String errorMessage = ex.getMessage() + ". Check version of 'Content-Type' header";
	errors.put("error", errorMessage);
	return errors;
    }

    /**
     * Handle accept media type validation exceptions when handling REST requests.
     *
     * @param ex the {@link HttpMediaTypeNotAcceptableException}
     * @return a Map with error messages with 406 HTTP status
     */
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public Map<String, String> handleIllegalArgumentException(HttpMediaTypeNotAcceptableException ex) {
	Map<String, String> errors = new HashMap<>();
	String errorMessage = ex.getMessage() + ". Check media type version in 'Accept' header";
	errors.put("error", errorMessage);
	return errors;
    }

    /**
     * Handle constraint validation of IllegalArgumentException,
     * IllegalStateException and HttpMessageNotReadableException exceptions.
     *
     * @param ex the {@link Exception}
     * @return a Map with error messages with 400 HTTP status
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ IllegalArgumentException.class, IllegalStateException.class,
	    HttpMessageNotReadableException.class })
    public Map<String, String> handleIllegalStateException(Exception ex) {
	Map<String, String> errors = new HashMap<>();
	String errorMessage = ex.getMessage();
	errors.put("error", errorMessage);
	return errors;
    }

    /**
     * Handle any other exceptions during the runtime process.
     *
     * @param ex the {@link Exception}
     * @return a Map with error messages with 500 HTTP status
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Map<String, String> handleAnyOtherException(Exception ex) {
	Map<String, String> errors = new HashMap<>();
	String errorMessage = ex.getMessage();
	errors.put("error", errorMessage);
	return errors;
    }

}
