package com.es.seguridadsession.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The type Rest exception handler.
 */
@ControllerAdvice
public class RestExceptionHandler {

    /**
     * Handle resource not found exception error msg for client.
     *
     * @param request the request
     * @param ex      the ex
     * @return the error msg for client
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorMsgForClient handleResourceNotFoundException(HttpServletRequest request, ResourceNotFoundException ex) {
        return new ErrorMsgForClient(ex.getMessage(), request.getRequestURI());
    }

    /**
     * Handle bad request exception error msg for client.
     *
     * @param request the request
     * @param ex      the ex
     * @return the error msg for client
     */
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMsgForClient handleBadRequestException(HttpServletRequest request, BadRequestException ex) {
        return new ErrorMsgForClient(ex.getMessage(), request.getRequestURI());
    }

    /**
     * Handle generic exception error msg for client.
     *
     * @param request the request
     * @param ex      the ex
     * @return the error msg for client
     */
    @ExceptionHandler(GenericException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorMsgForClient handleGenericException(HttpServletRequest request, GenericException ex) {
        return new ErrorMsgForClient(ex.getMessage(), request.getRequestURI());
    }

    /**
     * Handle unauthorized access exception error msg for client.
     *
     * @param request the request
     * @param ex      the ex
     * @return the error msg for client
     */
    @ExceptionHandler(UnauthorizedAccessException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public ErrorMsgForClient handleUnauthorizedAccessException(HttpServletRequest request, UnauthorizedAccessException ex) {
        return new ErrorMsgForClient(ex.getMessage(), request.getRequestURI());
    }

    /**
     * Handle cipher exception error msg for client.
     *
     * @param request the request
     * @param ex      the ex
     * @return the error msg for client
     */
    @ExceptionHandler(CipherException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMsgForClient handleCipherException(HttpServletRequest request, CipherException ex) {
        return new ErrorMsgForClient(ex.getMessage(), request.getRequestURI());
    }

    /**
     * Handle incorrect password exception error msg for client.
     *
     * @param request the request
     * @param ex      the ex
     * @return the error msg for client
     */
    @ExceptionHandler(IncorrectPasswordException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ErrorMsgForClient handleIncorrectPasswordException(HttpServletRequest request, IncorrectPasswordException ex) {
        return new ErrorMsgForClient(ex.getMessage(), request.getRequestURI());
    }

    /**
     * Handle token invalid exception error msg for client.
     *
     * @param request the request
     * @param ex      the ex
     * @return the error msg for client
     */
    @ExceptionHandler(TokenInvalidException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ErrorMsgForClient handleTokenInvalidException(HttpServletRequest request, TokenInvalidException ex) {
        return new ErrorMsgForClient(ex.getMessage(), request.getRequestURI());
    }
}
