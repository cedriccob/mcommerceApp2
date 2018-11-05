package com.mcommandes.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception lancée lorsqu'on ne trouve pas de commande
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CommandeNotFoundException extends RuntimeException {


    public CommandeNotFoundException(String message) {
        super(message);
    }
}
