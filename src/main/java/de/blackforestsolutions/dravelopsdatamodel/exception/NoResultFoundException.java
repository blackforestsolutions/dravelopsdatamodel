package de.blackforestsolutions.dravelopsdatamodel.exception;

public class NoResultFoundException extends RuntimeException {

    private static final long serialVersionUID = -2040729626241143822L;

    public NoResultFoundException() {
        super("No result found from API-Call!");
    }

    public NoResultFoundException(String message) {
        super(message);
    }

}
