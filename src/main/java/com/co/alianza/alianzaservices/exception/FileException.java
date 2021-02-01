package com.co.alianza.alianzaservices.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class FileException extends RuntimeException {

    private final HttpStatus status;
    private final String message;

    public FileException(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }
}
