package de.blackforestsolutions.dravelopsdatamodel.objectmothers;

import de.blackforestsolutions.dravelopsdatamodel.Price;
import de.blackforestsolutions.dravelopsdatamodel.PriceType;

import java.util.Currency;

public class PriceObjectMother {

    public static Price getPriceWithNoEmptyFields(PriceType priceType) {
        return new Price.PriceBuilder()
                .setPriceType(priceType)
                .setCurrencyCode(Currency.getInstance("EUR"))
                .setSmallestCurrencyValue(100L)
                .build();
    }

}
