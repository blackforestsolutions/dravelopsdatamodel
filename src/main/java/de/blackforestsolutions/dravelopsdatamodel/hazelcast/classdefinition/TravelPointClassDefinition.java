package de.blackforestsolutions.dravelopsdatamodel.hazelcast.classdefinition;

import com.hazelcast.nio.serialization.ClassDefinition;
import com.hazelcast.nio.serialization.ClassDefinitionBuilder;

import static de.blackforestsolutions.dravelopsdatamodel.hazelcast.DravelOpsPortableFactory.DRAVEL_OPS_FACTORY_ID;
import static de.blackforestsolutions.dravelopsdatamodel.hazelcast.DravelOpsPortableFactory.TRAVEL_POINT_CLASS_ID;
import static de.blackforestsolutions.dravelopsdatamodel.hazelcast.classdefinition.PointClassDefinition.buildPointClassDefinition;

public class TravelPointClassDefinition {

    public static final String NAME_FIELD = "name";
    public static final String POINT_FIELD = "point";
    public static final String HAS_ARRIVAL_TIME_FIELD = "_has__arrivalTime";
    public static final String ARRIVAL_TIME_FIELD = "arrivalTime";
    public static final String HAS_DEPARTURE_TIME_FIELD = "_has__departureTime";
    public static final String DEPARTURE_TIME_FIELD = "departureTime";
    public static final String PLATFORM_FIELD = "platform";

    public static ClassDefinition buildTravelPointClassDefinition() {
        return new ClassDefinitionBuilder(DRAVEL_OPS_FACTORY_ID, TRAVEL_POINT_CLASS_ID)
                .addUTFField(NAME_FIELD)
                .addPortableField(POINT_FIELD, buildPointClassDefinition())
                .addBooleanField(HAS_ARRIVAL_TIME_FIELD)
                .addUTFField(ARRIVAL_TIME_FIELD)
                .addBooleanField(HAS_DEPARTURE_TIME_FIELD)
                .addUTFField(DEPARTURE_TIME_FIELD)
                .addUTFField(PLATFORM_FIELD)
                .build();
    }
}
