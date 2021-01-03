package de.blackforestsolutions.dravelopsdatamodel.hazelcast.classdefinition;

import com.hazelcast.nio.serialization.ClassDefinition;
import com.hazelcast.nio.serialization.ClassDefinitionBuilder;

import static de.blackforestsolutions.dravelopsdatamodel.hazelcast.DravelOpsPortableFactory.DRAVEL_OPS_FACTORY_ID;
import static de.blackforestsolutions.dravelopsdatamodel.hazelcast.DravelOpsPortableFactory.TRAVEL_PROVIDER_CLASS_ID;

public class TravelProviderClassDefinition {

    public static final String NAME_FIELD = "name";
    public static final String URL_FIELD = "url";
    public static final String HAS_URL_FIELD = "_has__url";

    public static ClassDefinition buildTravelProviderClassDefinition() {
        return new ClassDefinitionBuilder(DRAVEL_OPS_FACTORY_ID, TRAVEL_PROVIDER_CLASS_ID)
                .addUTFField(NAME_FIELD)
                .addBooleanField(HAS_URL_FIELD)
                .addUTFField(URL_FIELD)
                .build();
    }
}
