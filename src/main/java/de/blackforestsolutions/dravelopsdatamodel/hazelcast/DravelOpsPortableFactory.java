package de.blackforestsolutions.dravelopsdatamodel.hazelcast;


import com.hazelcast.nio.serialization.Portable;
import com.hazelcast.nio.serialization.PortableFactory;
import de.blackforestsolutions.dravelopsdatamodel.*;
import lombok.SneakyThrows;

public class DravelOpsPortableFactory implements PortableFactory {

    public static final int DRAVEL_OPS_FACTORY_ID = 1;

    public static final int JOURNEY_CLASS_ID = 1;
    public static final int LEG_CLASS_ID = 2;
    public static final int POINT_CLASS_ID = 3;
    public static final int PRICE_CLASS_ID = 4;
    public static final int TRAVEL_POINT_CLASS_ID = 5;
    public static final int TRAVEL_PROVIDER_CLASS_ID = 6;

    @SneakyThrows
    @Override
    public Portable create(int classId) {
        if (JOURNEY_CLASS_ID == classId) {
            return new Journey.JourneyBuilder().build();
        }
        if (LEG_CLASS_ID == classId) {
            return new Leg.LegBuilder().build();
        }
        if (POINT_CLASS_ID == classId) {
            return new Point.PointBuilder().build();
        }
        if (PRICE_CLASS_ID == classId) {
            return new Price.PriceBuilder().build();
        }
        if (TRAVEL_POINT_CLASS_ID == classId) {
            return new TravelPoint.TravelPointBuilder().build();
        }
        if (TRAVEL_PROVIDER_CLASS_ID == classId) {
            return new TravelProvider.TravelProviderBuilder().build();
        }

        throw new IllegalArgumentException(classId + " unsupported classId");
    }
}
