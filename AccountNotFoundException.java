package com.techelevator.tenmo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( code = HttpStatus.NOT_FOUND, reason = "Account not found.")
<<<<<<< HEAD
public class AccountNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public AccountNotFoundException() {
        super("Account not found.");
    }
=======
public class AccountNotFoundException extends RuntimeException {
        private static final long serialVersionUID = 1L;

        public AccountNotFoundException() {
            super("Account not found.");
        }

>>>>>>> ec27cae196d74b4560858aaa8c8118a54387c26b
}
