package com.techelevator.tenmo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

<<<<<<< HEAD

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "User not found.")
public class UserNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;
    public UserNotFoundException() {
        super("User not found.");
    }

=======
@ResponseStatus( code = HttpStatus.NOT_FOUND, reason = "User not found.")
public class UserNotFoundException extends RuntimeException {
        private static final long serialVersionUID = 1L;
        public UserNotFoundException() {
            super("User not found.");
        }
>>>>>>> ec27cae196d74b4560858aaa8c8118a54387c26b
}
