package de.blackforestsolutions.dravelopsdatamodel.hazelcast.classdefinition;

import com.hazelcast.nio.serialization.ClassDefinition;
import com.hazelcast.nio.serialization.ClassDefinitionBuilder;

import static de.blackforestsolutions.dravelopsdatamodel.hazelcast.DravelOpsPortableFactory.DRAVEL_OPS_FACTORY_ID;
import static de.blackforestsolutions.dravelopsdatamodel.hazelcast.DravelOpsPortableFactory.PRICE_CLASS_ID;

public class PriceClassDefinition {

    public static final String HAS_PRICE_TYPE_FIELD = "_has__priceType";
    public static final String PRICE_TYPE_FIELD = "priceType";
    public static final String HAS_CURRENCY_CODE_FIELD = "_has__currencyCode";
    public static final String CURRENCY_CODE_FIELD = "currencyCode";
    public static final String HAS_SMALLEST_CURRENCY_VALUE_FIELD = "_has__smallestCurrencyValue";
    public static final String SMALLEST_CURRENCY_VALUE_FIELD = "smallestCurrencyValue";

    public static ClassDefinition buildPriceClassDefinition() {
        return new ClassDefinitionBuilder(DRAVEL_OPS_FACTORY_ID, PRICE_CLASS_ID)
                .addBooleanField(HAS_PRICE_TYPE_FIELD)
                .addUTFField(PRICE_TYPE_FIELD)
                .addBooleanField(HAS_CURRENCY_CODE_FIELD)
                .addUTFField(CURRENCY_CODE_FIELD)
                .addBooleanField(HAS_SMALLEST_CURRENCY_VALUE_FIELD)
                .addLongField(SMALLEST_CURRENCY_VALUE_FIELD)
                .build();
    }
}
