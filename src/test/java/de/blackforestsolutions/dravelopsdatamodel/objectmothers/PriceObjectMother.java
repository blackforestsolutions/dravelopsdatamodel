package de.blackforestsolutions.dravelopsdatamodel.objectmothers;

import de.blackforestsolutions.dravelopsdatamodel.Price;
import de.blackforestsolutions.dravelopsdatamodel.PriceType;

import java.util.Currency;

public class PriceObjectMother {

    private static final Currency DEFAULT_TEST_CURRENCY_CODE = Currency.getInstance("EUR");
    private static final PriceType DEFAULT_TEST_PRICE_TYPE = PriceType.REGULAR;

    public static Price getPriceWithNoEmptyFields(PriceType priceType) {
        return getPriceBuilderWithNoEmptyFields()
                .setPriceType(priceType)
                .build();
    }

    public static Price.PriceBuilder getPriceBuilderWithNoEmptyFields() {
        return new Price.PriceBuilder()
                .setPriceType(DEFAULT_TEST_PRICE_TYPE)
                .setCurrencyCode(DEFAULT_TEST_CURRENCY_CODE)
                .setSmallestCurrencyValue(100L);
    }

    public static Price getFurtwangenToWaldkirchPrice() {
        return new Price.PriceBuilder()
                .setPriceType(DEFAULT_TEST_PRICE_TYPE)
                .setCurrencyCode(DEFAULT_TEST_CURRENCY_CODE)
                .setSmallestCurrencyValue(200L)
                .build();
    }

}
