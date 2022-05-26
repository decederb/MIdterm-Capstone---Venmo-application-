package com.techelevator.tenmo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Transfer type not found.")
public class TransferTypeNotFoundException extends Throwable {
    private static final long serialVersionUID = 1L;
    public TransferTypeNotFoundException(String s) {
        super("Transfer type not found.");
    }
}