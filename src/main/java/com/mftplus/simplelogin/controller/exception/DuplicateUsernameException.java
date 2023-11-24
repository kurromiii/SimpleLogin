package com.mftplus.simplelogin.controller.exception;

public class DuplicateUsernameException extends Exception {
    public DuplicateUsernameException(String massage) {
        super(massage);
    }
}
