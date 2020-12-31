package de.blackforestsolutions.dravelopsdatamodel.exception;

public class NoExternalResultFoundException extends Exception {

    private static final long serialVersionUID = -8010124460949083209L;

    public NoExternalResultFoundException() {
        super("Logical error triggered by API");
    }
}
