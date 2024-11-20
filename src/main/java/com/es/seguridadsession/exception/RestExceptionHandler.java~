package com.es.seguridadsession.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorMsgForClient handleResourceNotFoundException(HttpServletRequest request, ResourceNotFoundException ex) {
        return new ErrorMsgForClient(ex.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMsgForClient handleBadRequestException(HttpServletRequest request, BadRequestException ex) {
        return new ErrorMsgForClient(ex.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler(GenericException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorMsgForClient handleGenericException(HttpServletRequest request, GenericException ex) {
        return new ErrorMsgForClient(ex.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler(UnauthorizedAccessException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public ErrorMsgForClient handleUnauthorizedAccessException(HttpServletRequest request, UnauthorizedAccessException ex) {
        return new ErrorMsgForClient(ex.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler(CipherException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMsgForClient handleCipherException(HttpServletRequest request, CipherException ex) {
        return new ErrorMsgForClient(ex.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler(IncorrectPasswordException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ErrorMsgForClient handleIncorrectPasswordException(HttpServletRequest request, IncorrectPasswordException ex) {
        return new ErrorMsgForClient(ex.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler(TokenInvalidException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ErrorMsgForClient handleTokenInvalidException(HttpServletRequest request, TokenInvalidException ex) {
        return new ErrorMsgForClient(ex.getMessage(), request.getRequestURI());
    }
}
