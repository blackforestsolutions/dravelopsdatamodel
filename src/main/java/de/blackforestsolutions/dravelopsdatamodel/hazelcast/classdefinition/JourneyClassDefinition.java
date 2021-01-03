package de.blackforestsolutions.dravelopsdatamodel.hazelcast.classdefinition;

import com.hazelcast.nio.serialization.ClassDefinition;
import com.hazelcast.nio.serialization.ClassDefinitionBuilder;

import static de.blackforestsolutions.dravelopsdatamodel.hazelcast.DravelOpsPortableFactory.DRAVEL_OPS_FACTORY_ID;
import static de.blackforestsolutions.dravelopsdatamodel.hazelcast.DravelOpsPortableFactory.JOURNEY_CLASS_ID;
import static de.blackforestsolutions.dravelopsdatamodel.hazelcast.classdefinition.LegClassDefinition.buildLegClassDefinition;
import static de.blackforestsolutions.dravelopsdatamodel.hazelcast.classdefinition.PriceClassDefinition.buildPriceClassDefinition;

public class JourneyClassDefinition {

    public static final String ID_FIELD = "id";
    public static final String HAS_LANGUAGE_FIELD = "_has__language";
    public static final String LANGUAGE_FIELD = "language";
    public static final String HAS_LEGS_FIELD = "_has__legs";
    public static final String LEGS_FIELD = "legs";
    public static final String HAS_PRICES_FIELD = "_has__prices";
    public static final String PRICES_FIELD = "prices";

    public static ClassDefinition buildJourneyClassDefinition() {
        return new ClassDefinitionBuilder(DRAVEL_OPS_FACTORY_ID, JOURNEY_CLASS_ID)
                .addUTFField(ID_FIELD)
                .addBooleanField(HAS_LANGUAGE_FIELD)
                .addUTFField(LANGUAGE_FIELD)
                .addBooleanField(HAS_LEGS_FIELD)
                .addPortableArrayField(LEGS_FIELD, buildLegClassDefinition())
                .addBooleanField(HAS_PRICES_FIELD)
                .addPortableArrayField(PRICES_FIELD, buildPriceClassDefinition())
                .build();
    }
}
