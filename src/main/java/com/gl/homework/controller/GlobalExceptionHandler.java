package com.gl.homework.controller;

import com.gl.homework.exception.UserNotFoundException;
import com.gl.homework.wire.UserNotFoundResponse;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseBody
    UserNotFoundResponse entityNotFoundException(@NonNull HttpServletRequest request,
                                                 @NonNull UserNotFoundException ex) {
        return UserNotFoundResponse.builder()
                .url(request.getRequestURI())
                .message(ex.getLocalizedMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    UserNotFoundResponse exceptionHandler(@NonNull HttpServletRequest request, ConstraintViolationException e) {
        return UserNotFoundResponse.builder().
                url(request.getRequestURI())
                .message(e.getMessage())
                .build();
    }

}