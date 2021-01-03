package de.blackforestsolutions.dravelopsdatamodel.hazelcast.classdefinition;

import com.hazelcast.nio.serialization.ClassDefinition;
import com.hazelcast.nio.serialization.ClassDefinitionBuilder;

import static de.blackforestsolutions.dravelopsdatamodel.hazelcast.DravelOpsPortableFactory.*;
import static de.blackforestsolutions.dravelopsdatamodel.hazelcast.classdefinition.PointClassDefinition.buildPointClassDefinition;
import static de.blackforestsolutions.dravelopsdatamodel.hazelcast.classdefinition.TravelPointClassDefinition.buildTravelPointClassDefinition;
import static de.blackforestsolutions.dravelopsdatamodel.hazelcast.classdefinition.TravelProviderClassDefinition.buildTravelProviderClassDefinition;

public class LegClassDefinition {

    public static final String DEPARTURE_FIELD = "departure";
    public static final String ARRIVAL_FIELD = "arrival";
    public static final String HAS_DELAY_IN_MINUTES_FIELD = "_has__delayInMinutes";
    public static final String DELAY_IN_MINUTES_FIELD = "delayInMinutes";
    public static final String HAS_DISTANCE_IN_KILOMETERS_FIELD = "_has__distanceInKilometers";
    public static final String DISTANCE_IN_KILOMETERS_FIELD = "distanceInKilometers";
    public static final String HAS_VEHICLE_TYPE_FIELD = "_has__vehicleType";
    public static final String VEHICLE_TYPE_FIELD = "vehicleType";
    public static final String HAS_WAYPOINTS_FIELD = "_has__waypoints";
    public static final String WAYPOINTS_FIELD = "waypoints";
    public static final String TRAVEL_PROVIDER_FIELD = "travelProvider";
    public static final String VEHICLE_NUMBER_FIELD = "vehicleNumber";
    public static final String VEHICLE_NAME_FIELD = "vehicleName";
    public static final String HAS_INTERMEDIATE_STOPS_FIELD = "_has__intermediateStops";
    public static final String INTERMEDIATE_STOPS_FIELD = "intermediateStops";

    public static ClassDefinition buildLegClassDefinition() {
        return new ClassDefinitionBuilder(DRAVEL_OPS_FACTORY_ID, LEG_CLASS_ID)
                .addPortableField(DEPARTURE_FIELD, buildTravelPointClassDefinition())
                .addPortableField(ARRIVAL_FIELD, buildTravelPointClassDefinition())
                .addBooleanField(HAS_DELAY_IN_MINUTES_FIELD)
                .addLongField(DELAY_IN_MINUTES_FIELD)
                .addBooleanField(HAS_DISTANCE_IN_KILOMETERS_FIELD)
                .addDoubleField(DISTANCE_IN_KILOMETERS_FIELD)
                .addBooleanField(HAS_VEHICLE_TYPE_FIELD)
                .addUTFField(VEHICLE_TYPE_FIELD)
                .addBooleanField(HAS_WAYPOINTS_FIELD)
                .addPortableArrayField(WAYPOINTS_FIELD, buildPointClassDefinition())
                .addPortableField(TRAVEL_PROVIDER_FIELD, buildTravelProviderClassDefinition())
                .addUTFField(VEHICLE_NUMBER_FIELD)
                .addUTFField(VEHICLE_NAME_FIELD)
                .addBooleanField(HAS_INTERMEDIATE_STOPS_FIELD)
                .addPortableArrayField(INTERMEDIATE_STOPS_FIELD, buildTravelPointClassDefinition())
                .build();
    }
}
