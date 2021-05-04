package de.blackforestsolutions.dravelopsdatamodel;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
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
