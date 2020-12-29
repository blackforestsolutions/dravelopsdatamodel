package de.blackforestsolutions.dravelopsdatamodel.objectmothers;

import de.blackforestsolutions.dravelopsdatamodel.Leg;
import de.blackforestsolutions.dravelopsdatamodel.TravelPoint;
import de.blackforestsolutions.dravelopsdatamodel.VehicleType;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;

import java.time.Duration;
import java.util.LinkedList;
import java.util.UUID;

import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.TravelPointObjectMother.*;
import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.TravelProviderObjectMother.*;
import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.UUIDObjectMother.*;
import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.WaypointsObjectMother.getExampleWaypoints;

public class LegObjectMother {

    public static Leg getLegWithNoEmptyFields(UUID id) {
        return getLegBuilderWithNoEmptyFields(id)
                .build();
    }

    public static Leg.LegBuilder getLegBuilderWithNoEmptyFields(UUID id) {
        return new Leg.LegBuilder(id)
                .setDeparture(getTravelPointWithNoEmptyFields())
                .setArrival(getTravelPointWithNoEmptyFields())
                .setDelayInMinutes(Duration.ofSeconds(60L))
                .setDistanceInKilometers(new Distance(5.253d, Metrics.KILOMETERS))
                .setVehicleType(VehicleType.BUS)
                .setWaypoints(getTrack())
                .setTravelProvider(getTravelProviderWithNoEmptyFields())
                .setVehicleNumber("7020")
                .setVehicleName("Furtwangen - Triberg")
                .setIntermediateStops(getIntermediateStops());
    }

    public static Leg getGrosshausbergToFurtwangenIlbenstreetLeg() {
        TravelPoint departure = getGrosshausbergTravelPoint();
        TravelPoint arrival = getFurtwangenIlbenstreetTravelPoint();
        return new Leg.LegBuilder(TEST_UUID_2)
                .setDelayInMinutes(Duration.ZERO)
                .setDistanceInKilometers(new Distance(0.977d, Metrics.KILOMETERS))
                .setVehicleType(VehicleType.WALK)
                .setDeparture(departure)
                .setArrival(arrival)
                .setWaypoints(getExampleWaypoints())
                .build();
    }

    public static Leg getFurtwangenIlbenstreetToBleibachLeg() {
        TravelPoint departure = getFurtwangenIlbenstreetTravelPoint();
        TravelPoint arrival = getBleibachSevTravelPoint();
        return new Leg.LegBuilder(TEST_UUID_3)
                .setDelayInMinutes(Duration.ZERO)
                .setDistanceInKilometers(new Distance(26.394d, Metrics.KILOMETERS))
                .setVehicleType(VehicleType.BUS)
                .setTravelProvider(getSuedbadenTravelProvider())
                .setDeparture(departure)
                .setArrival(arrival)
                .setWaypoints(getExampleWaypoints())
                .setVehicleNumber("272")
                .setVehicleName("Waldkirch Gymnasium - Furtwangen Rößleplatz")
                .setIntermediateStops(getFurtwangenIlbenStreetToBleibachIntermediateStops())
                .build();
    }

    public static Leg getBleibachToWaldkirchKastelberghalleLeg() {
        TravelPoint departure = getBleibachSevTravelPoint();
        TravelPoint arrival = getWaldkirchKastelberghalleTravelPoint();
        return new Leg.LegBuilder(TEST_UUID_4)
                .setDelayInMinutes(Duration.ZERO)
                .setDistanceInKilometers(new Distance(6.784d, Metrics.KILOMETERS))
                .setVehicleType(VehicleType.BUS)
                .setTravelProvider(getSuedbadenTravelProvider())
                .setDeparture(departure)
                .setArrival(arrival)
                .setWaypoints(getExampleWaypoints())
                .setVehicleNumber("201")
                .setVehicleName("Oberprechtal Forellenhof - Emmendingen Bahnhof/ZOB")
                .setIntermediateStops(getBleibachToWaldkirchKastelberghalleIntermediateStops())
                .build();
    }

    public static Leg getWaldkirchKastelberghalleToSickLeg() {
        TravelPoint departure = getWaldkirchKastelberghalleTravelPoint();
        TravelPoint arrival = getSickAgTravelPoint();
        return new Leg.LegBuilder(TEST_UUID_5)
                .setDelayInMinutes(Duration.ZERO)
                .setDistanceInKilometers(new Distance(0.445d, Metrics.KILOMETERS))
                .setVehicleType(VehicleType.WALK)
                .setDeparture(departure)
                .setArrival(arrival)
                .setWaypoints(getExampleWaypoints())
                .build();
    }

    public static Leg getMannheimHbfToMannheimUniversityLeg() {
        TravelPoint departure = getMannheimHbfTravelPoint();
        TravelPoint arrival = getMannheimUniversityTravelPoint();
        return new Leg.LegBuilder(TEST_UUID_2)
                .setDelayInMinutes(Duration.ZERO)
                .setDistanceInKilometers(new Distance(0.320d, Metrics.KILOMETERS))
                .setVehicleType(VehicleType.WALK)
                .setDeparture(departure)
                .setArrival(arrival)
                .setWaypoints(getExampleWaypoints())
                .build();
    }

    public static Leg getMannheimUniversityToMannheimBerlinerPlaceLeg() {
        TravelPoint departure = getMannheimUniversityTravelPoint();
        TravelPoint arrival = getBerlinerPlaceTravelPoint();
        return new Leg.LegBuilder(TEST_UUID_3)
                .setDelayInMinutes(Duration.ZERO)
                .setDistanceInKilometers(new Distance(0.956d, Metrics.KILOMETERS))
                .setVehicleType(VehicleType.TRAM)
                .setTravelProvider(getRnvTravelProvider())
                .setDeparture(departure)
                .setArrival(arrival)
                .setWaypoints(getExampleWaypoints())
                .setVehicleNumber("4")
                .setVehicleName("Bad Dürkheim - LU Oggersheim - LU Hbf - Berliner Platz - MA Hbf - Wasserturm - Paradeplatz - Alte Feuerwache - Schafweide - Universitätsklinikum - Bonafitiuskirche - Ulmenweg - Waldfriedhof")
                .setIntermediateStops(getMannheimUniversityToMannheimBerlinerPlaceIntermediateStop())
                .build();
    }

    public static Leg getBerlinerPlaceToDestinationLeg() {
        TravelPoint departure = getBerlinerPlaceTravelPoint();
        TravelPoint arrival = getLudwigsburgCenterTravelPoint();
        return new Leg.LegBuilder(TEST_UUID_4)
                .setDelayInMinutes(Duration.ZERO)
                .setDistanceInKilometers(new Distance(0.319d, Metrics.KILOMETERS))
                .setVehicleType(VehicleType.WALK)
                .setDeparture(departure)
                .setArrival(arrival)
                .setWaypoints(getExampleWaypoints())
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


    private static LinkedList<TravelPoint> getFurtwangenIlbenStreetToBleibachIntermediateStops() {
        LinkedList<TravelPoint> intermediateStops = new LinkedList<>();
        intermediateStops.add(getGuetenbachTownHallTravelPoint());
        intermediateStops.add(getSimonswaldTownHallTravelPoint());
        return intermediateStops;
    }

    private static LinkedList<TravelPoint> getBleibachToWaldkirchKastelberghalleIntermediateStops() {
        LinkedList<TravelPoint> intermediateStops = new LinkedList<>();
        intermediateStops.add(getKollnauTrainStationTravelPoint());
        intermediateStops.add(getWaldkirchTownCenterTravelPoint());
        return intermediateStops;
    }

    private static LinkedList<TravelPoint> getMannheimUniversityToMannheimBerlinerPlaceIntermediateStop() {
        LinkedList<TravelPoint> intermediateStops = new LinkedList<>();
        intermediateStops.add(getKonradAdenauerBrTravelPoint());
        return intermediateStops;
    }

}
