package de.blackforestsolutions.dravelopsdatamodel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.hazelcast.nio.serialization.Portable;
import com.hazelcast.nio.serialization.PortableReader;
import com.hazelcast.nio.serialization.PortableWriter;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.IOException;
import java.io.Serializable;
import java.util.Currency;

import static de.blackforestsolutions.dravelopsdatamodel.hazelcast.DravelOpsPortableFactory.DRAVEL_OPS_FACTORY_ID;
import static de.blackforestsolutions.dravelopsdatamodel.hazelcast.DravelOpsPortableFactory.PRICE_CLASS_ID;
import static de.blackforestsolutions.dravelopsdatamodel.hazelcast.classdefinition.PriceClassDefinition.*;

@Getter
@JsonDeserialize(builder = Price.PriceBuilder.class)
public final class Price implements Serializable, Portable {

    private static final long serialVersionUID = -3355934959094849304L;

    private PriceType priceType;

    private Currency currencyCode;

    private Long smallestCurrencyValue;

    private Price(PriceBuilder priceBuilder) {
        this.currencyCode = priceBuilder.getCurrencyCode();
        this.smallestCurrencyValue = priceBuilder.getSmallestCurrencyValue();
        this.priceType = priceBuilder.getPriceType();
    }

    @JsonIgnore
    @Override
    public int getFactoryId() {
        return DRAVEL_OPS_FACTORY_ID;
    }

    @JsonIgnore
    @Override
    public int getClassId() {
        return PRICE_CLASS_ID;
    }

    @Override
    public void writePortable(PortableWriter writer) throws IOException {
        if (this.priceType != null) {
            writer.writeBoolean(HAS_PRICE_TYPE_FIELD, true);
            writer.writeUTF(PRICE_TYPE_FIELD, this.priceType.toString());
        }
        if (this.currencyCode != null) {
            writer.writeBoolean(HAS_CURRENCY_CODE_FIELD, true);
            writer.writeUTF(CURRENCY_CODE_FIELD, this.currencyCode.toString());
        }
        if (this.smallestCurrencyValue != null) {
            writer.writeBoolean(HAS_SMALLEST_CURRENCY_VALUE_FIELD, true);
            writer.writeLong(SMALLEST_CURRENCY_VALUE_FIELD, this.smallestCurrencyValue);
        }
    }

    @Override
    public void readPortable(PortableReader reader) throws IOException {
        if (reader.readBoolean(HAS_PRICE_TYPE_FIELD)) {
            this.priceType = PriceType.valueOf(reader.readUTF(PRICE_TYPE_FIELD));
        }
        if (reader.readBoolean(HAS_CURRENCY_CODE_FIELD)) {
            this.currencyCode = Currency.getInstance(reader.readUTF(CURRENCY_CODE_FIELD));
        }
        if (reader.readBoolean(HAS_SMALLEST_CURRENCY_VALUE_FIELD)) {
            this.smallestCurrencyValue = reader.readLong(SMALLEST_CURRENCY_VALUE_FIELD);
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
