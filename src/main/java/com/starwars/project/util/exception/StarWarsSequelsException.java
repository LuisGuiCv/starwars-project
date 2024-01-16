package com.starwars.project.util.exception;

/**
 * this custom exception will be used when the end user enters a movieId that makes reference to a non canon Star Wars movie.
 * @author Luis Guillermo Cruz Vargas
 * @version 1.0
 * @since 01/15/2024
 */
public class StarWarsSequelsException extends Exception {
    /**
     * this method will create the messae than the end user will see when enter a movieId that makes reference to a non canon Star Wars movie.
     * @author Luis Guillermo Cruz Vargas
     * @version 1.0
     * @since 01/15/2024
     */
    public StarWarsSequelsException() {
        super("Hello There!\nStar Wars Episodes VII,VIII and IX are not canon");
    }
}
