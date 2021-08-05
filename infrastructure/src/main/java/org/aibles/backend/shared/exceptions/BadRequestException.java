package org.aibles.backend.shared.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class BadRequestException extends RuntimeException{

    private static final Long serialVersionUID = 1L;

    private String message;
    private final HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

    public BadRequestException(final String message){
        super();
        this.message = message;
    }
}
