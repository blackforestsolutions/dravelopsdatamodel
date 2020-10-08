package de.blackforestsolutions.dravelopsdatamodel.objectmothers;

import de.blackforestsolutions.dravelopsdatamodel.Leg;
import de.blackforestsolutions.dravelopsdatamodel.TravelPoint;
import de.blackforestsolutions.dravelopsdatamodel.VehicleType;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;

import java.time.Duration;
import java.util.LinkedList;

import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.TravelPointObjectMother.getTravelPointWithNoEmptyFields;
import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.TravelProviderObjectMother.getTravelProviderWithNoEmptyFields;
import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.UUIDObjectMother.TEST_UUID_2;

public class LegObjectMother {

    public static Leg getLegWithNoEmptyFields() {
        return new Leg.LegBuilder(TEST_UUID_2)
                .setDeparture(getTravelPointWithNoEmptyFields())
                .setArrival(getTravelPointWithNoEmptyFields())
                .setDelay(Duration.ofSeconds(60L))
                .setDistanceInKilometers(new Distance(5.253d, Metrics.KILOMETERS))
                .setVehicleType(VehicleType.BUS)
                .setTrack(getTrack())
                .setTravelProvider(getTravelProviderWithNoEmptyFields())
                .setVehicleNumber("7020")
                .setVehicleName("Furtwangen - Triberg")
                .setIntermediateStops(getIntermediateStops())
                .build();
    }

    private static LinkedList<TravelPoint> getIntermediateStops() {
        LinkedList<TravelPoint> intermediateStops = new LinkedList<>();
        intermediateStops.add(getTravelPointWithNoEmptyFields());
        return intermediateStops;
    }

    private static LinkedList<Point> getTrack() {
        LinkedList<Point> points = new LinkedList<>();
        points.add(new Point(0.0d, 0.0d));
        return points;
    }
}
