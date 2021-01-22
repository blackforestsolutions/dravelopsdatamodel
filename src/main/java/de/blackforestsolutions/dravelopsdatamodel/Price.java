package de.blackforestsolutions.dravelopsdatamodel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.DataSerializable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.IOException;
import java.io.Serializable;
import java.util.Currency;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@JsonDeserialize(builder = Price.PriceBuilder.class)
public final class Price implements Serializable, DataSerializable {

    private static final long serialVersionUID = -3355934959094849304L;

    private PriceType priceType;

    private Currency currencyCode;

    private Long smallestCurrencyValue;

    private Price(PriceBuilder priceBuilder) {
        this.currencyCode = priceBuilder.getCurrencyCode();
        this.smallestCurrencyValue = priceBuilder.getSmallestCurrencyValue();
        this.priceType = priceBuilder.getPriceType();
    }

    @Override
    public void writeData(ObjectDataOutput out) throws IOException {
        if (Optional.ofNullable(this.priceType).isPresent()) {
            out.writeBoolean(true);
            out.writeUTF(this.priceType.toString());
        } else {
            out.writeBoolean(false);
        }
        if (Optional.ofNullable(this.currencyCode).isPresent()) {
            out.writeBoolean(true);
            out.writeUTF(this.currencyCode.toString());
        } else {
            out.writeBoolean(false);
        }
        if (Optional.ofNullable(this.smallestCurrencyValue).isPresent()) {
            out.writeBoolean(true);
            out.writeLong(this.smallestCurrencyValue);
        } else {
            out.writeBoolean(false);
        }
    }

    @Override
    public void readData(ObjectDataInput in) throws IOException {
        if (in.readBoolean()) {
            this.priceType = PriceType.valueOf(in.readUTF());
        }
        if (in.readBoolean()) {
            this.currencyCode = Currency.getInstance(in.readUTF());
        }
        if (in.readBoolean()) {
            this.smallestCurrencyValue = in.readLong();
        }
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
