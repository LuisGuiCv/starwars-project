package com.starwars.project.util.exception;


public class InvalidLetterException extends Exception {

    public InvalidLetterException() {
        super("Hello There!\nthe letter must be alphabetic and can only be 1");
    }
}
