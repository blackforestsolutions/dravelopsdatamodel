package de.blackforestsolutions.dravelopsdatamodel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Currency;

@Getter
@JsonDeserialize(builder = Price.PriceBuilder.class)
public final class Price {

    private final PriceType priceType;

    private final Currency currency;

    private final Double smallestCurrencyValue;

    private Price(PriceBuilder priceBuilder) {
        this.currency = priceBuilder.getCurrency();
        this.smallestCurrencyValue = priceBuilder.getSmallestCurrencyValue();
        this.priceType = priceBuilder.getPriceType();
    }

    @Setter
    @Getter
    @Accessors(chain = true)
    @JsonPOJOBuilder(withPrefix = "set")
    public static class PriceBuilder {

        private PriceType priceType;

        private Currency currency;

        private Double smallestCurrencyValue;

        public Price build() {
            return new Price(this);
        }
    }
}
