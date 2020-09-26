package de.blackforestsolutions.dravelopsdatamodel;

import java.io.Serializable;
import java.util.List;

public final class Price implements Serializable {

    private final List<Money> prices;

    public Price(List<Money> prices) {
        this.prices = prices;
    }
}
