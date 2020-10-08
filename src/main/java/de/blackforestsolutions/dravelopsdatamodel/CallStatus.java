package de.blackforestsolutions.dravelopsdatamodel;

import lombok.Getter;
import org.springframework.lang.NonNull;

@Getter
public final class CallStatus<T> {

    private final T calledObject;

    private final Status status;

    private final Throwable throwable;

    public CallStatus(T calledObject, @NonNull Status status, Throwable throwable) {
        this.calledObject = calledObject;
        this.status = status;
        this.throwable = throwable;
    }
}
