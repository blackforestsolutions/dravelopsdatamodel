package de.blackforestsolutions.dravelopsdatamodel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Currency;

@Getter
@JsonDeserialize(builder = Price.PriceBuilder.class)
public final class Price implements Serializable {

    private static final long serialVersionUID = -3355934959094849304L;
    private final PriceType priceType;

    private final Currency currencyCode;

    private final Long smallestCurrencyValue;

    private Price(PriceBuilder priceBuilder) {
        this.currencyCode = priceBuilder.getCurrencyCode();
        this.smallestCurrencyValue = priceBuilder.getSmallestCurrencyValue();
        this.priceType = priceBuilder.getPriceType();
    }

    @Setter
    @Getter
    @Accessors(chain = true)
    @JsonPOJOBuilder(withPrefix = "set")
    public static class PriceBuilder {

        private PriceType priceType;

        private Currency currencyCode;

        private Long smallestCurrencyValue;

        public Price build() {
            return new Price(this);
        }
    }
}
