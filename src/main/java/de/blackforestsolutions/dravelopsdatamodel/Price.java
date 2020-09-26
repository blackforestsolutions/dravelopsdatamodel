package de.blackforestsolutions.dravelopsdatamodel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Getter
@JsonDeserialize(builder = Price.PriceBuilder.class)
public final class Price implements Serializable {

    private static final long serialVersionUID = 6106269076155338045L;

    private final List<Money> prices;

    /**
     * Copy constructor
     *
     * @param price you would like to copy
     */
    public Price(Price price) {
        this.prices = price.getPrices();
    }

    private Price(PriceBuilder priceBuilder) {
        this.prices = priceBuilder.getPrices();
    }

    @Setter
    @Getter
    @Accessors(chain = true)
    @JsonPOJOBuilder(withPrefix = "set")
    public static class PriceBuilder {

        private List<Money> prices;

        public Price build() {
            return new Price(this);
        }
    }
}
