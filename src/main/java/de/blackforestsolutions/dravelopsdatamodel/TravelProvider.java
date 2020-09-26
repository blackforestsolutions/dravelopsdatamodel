package de.blackforestsolutions.dravelopsdatamodel;

import java.io.Serializable;
import java.net.URL;

public final class TravelProvider implements Serializable {
    private final String name;

    private final URL url;

    public TravelProvider(String name, URL url) {
        this.name = name;
        this.url = url;
    }
}
