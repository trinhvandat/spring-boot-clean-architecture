package org.aibles.backend.student.delivery.impl;

import org.aibles.backend.student.delivery.StudentControllerAdvice;
import org.aibles.backend.student.delivery.responses.SystemResponse;
import org.aibles.backend.shared.constants.CommonConstants;
import org.aibles.backend.shared.exceptions.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StudentControllerAdviceImpl implements StudentControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = BadRequestException.class)
    @Override
    public SystemResponse<String> badRequestExceptionHandler(BadRequestException ex) {
        return SystemResponse.<String>builder()
                .status(CommonConstants.BAD_REQUEST)
                .code(String.valueOf(ex.getHttpStatus().value()))
                .message(ex.getMessage())
                .build();
    }
}
