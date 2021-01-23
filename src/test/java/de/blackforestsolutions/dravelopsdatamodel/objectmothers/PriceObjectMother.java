package de.blackforestsolutions.dravelopsdatamodel.objectmothers;

import de.blackforestsolutions.dravelopsdatamodel.Price;
import de.blackforestsolutions.dravelopsdatamodel.PriceType;

import java.util.Currency;

public class PriceObjectMother {

    public static Price getPriceWithNoEmptyFields(PriceType priceType) {
        return getPriceBuilderWithNoEmptyFields()
                .setPriceType(priceType)
                .build();
    }

    public static Price.PriceBuilder getPriceBuilderWithNoEmptyFields() {
        return new Price.PriceBuilder()
                .setPriceType(PriceType.REGULAR)
                .setCurrencyCode(Currency.getInstance("EUR"))
                .setSmallestCurrencyValue(100L);
    }

    public static Price getFurtwangenToWaldkirchPrice() {
        return new Price.PriceBuilder()
                .setPriceType(PriceType.REGULAR)
                .setCurrencyCode(Currency.getInstance("EUR"))
                .setSmallestCurrencyValue(200L)
                .build();
    }

}
