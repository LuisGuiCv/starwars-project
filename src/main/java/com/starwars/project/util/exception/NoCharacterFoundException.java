package com.starwars.project.util.exception;

public class NoCharacterFoundException extends Exception{

    public NoCharacterFoundException() {
        super("Hello There!\nThere are no characters with those characteristics");
    }
}
