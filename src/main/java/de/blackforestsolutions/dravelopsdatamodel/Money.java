package de.blackforestsolutions.dravelopsdatamodel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Currency;

@Getter
@JsonDeserialize(builder = Money.MoneyBuilder.class)
public final class Money implements Serializable {

    // todo serialversion where?

    private final Currency currency;

    private final Double smallestCurrencyValue;

    private final PriceType priceType;

    /**
     * Copy constructor
     *
     * @param money you would like to copy
     */
    public Money(Money money) {
        this.currency = money.getCurrency();
        this.smallestCurrencyValue = money.getSmallestCurrencyValue();
        this.priceType = money.getPriceType();
    }

    private Money(Money.MoneyBuilder moneyBuilder) {
        this.currency = moneyBuilder.getCurrency();
        this.smallestCurrencyValue = moneyBuilder.getSmallestCurrencyValue();
        this.priceType = moneyBuilder.getPriceType();
    }

    @Setter
    @Getter
    @Accessors(chain = true)
    @JsonPOJOBuilder(withPrefix = "set")
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class MoneyBuilder {

        private Currency currency;

        private Double smallestCurrencyValue;

        private PriceType priceType;

        public Money build() {
            return new Money(this);
        }
    }
}
