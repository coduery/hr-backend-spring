package com.coduery.hr.controller.exception;

import java.util.Date;
import java.util.Iterator;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RestApiException {

    private String errorLocation;
    private HttpStatus statusMessage;
    private Integer statusCode;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss z")
    private Date timestamp;
    private String message;
    private String requestUri;
    private Iterator<String> paramNames;
    private String debugMessage;

    private RestApiException() {
        timestamp = new Date();
    }

    public RestApiException(MissingServletRequestParameterException ex, String message, HttpHeaders headers, HttpStatus status, WebRequest request) {
        this();
        if (status.is4xxClientError()) {
            errorLocation = "Client";
        } else if (status.is5xxServerError()) {
            errorLocation = "Server";
        }
        statusMessage = status;
        statusCode = status.value();
        this.message = message;
        requestUri = request.getDescription(false);
        paramNames = request.getParameterNames();
        debugMessage = ex.getLocalizedMessage();
    }

    public String getErrorLocation() {
        return errorLocation;
    }

    public void setErrorLocation(String errorLocation) {
        this.errorLocation = errorLocation;
    }

    public HttpStatus getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(HttpStatus statusMessage) {
        this.statusMessage = statusMessage;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRequestUri() {
        return requestUri;
    }

    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }

    public String getDebugMessage() {
        return debugMessage;
    }

    public void setDebugMessage(String debugMessage) {
        this.debugMessage = debugMessage;
    }

    public Iterator<String> getParamNames() {
        return paramNames;
    }

    public void setParamNames(Iterator<String> paramNames) {
        this.paramNames = paramNames;
    }
}
