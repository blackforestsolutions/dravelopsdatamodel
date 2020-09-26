package de.blackforestsolutions.dravelopsdatamodel;

import java.io.Serializable;
import java.util.Currency;

public final class Money implements Serializable {
    private final Currency currency;

    private final Double smallestCurrencyValue;

    private final PriceType priceType;

    public Money(Currency currency, Double smallestCurrencyValue, PriceType priceType) {
        this.currency = currency;
        this.smallestCurrencyValue = smallestCurrencyValue;
        this.priceType = priceType;
    }
}
