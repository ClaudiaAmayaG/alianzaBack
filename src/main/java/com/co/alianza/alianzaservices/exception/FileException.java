package com.co.alianza.alianzaservices.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * Class for exceptions.
 *
 * @author camaya@asesoftware.com
 * @version 1.0.0
 */
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
