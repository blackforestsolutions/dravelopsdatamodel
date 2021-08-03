package de.blackforestsolutions.dravelopsdatamodel.objectmothers;

import de.blackforestsolutions.dravelopsdatamodel.*;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.LinkedList;

import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.TravelPointObjectMother.*;
import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.TravelProviderObjectMother.*;
import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.WalkStepObjectMother.*;

public class LegObjectMother {

    private static final Metrics DEFAULT_TEST_DISTANCE_METRIC = Metrics.KILOMETERS;

    public static Leg getLegWithNoEmptyFields() {
        return getLegBuilderWithNoEmptyFields()
                .build();
    }

    public static Leg.LegBuilder getLegBuilderWithNoEmptyFields() {
        return new Leg.LegBuilder()
                .setDeparture(getTravelPointWithNoEmptyFields())
                .setArrival(getTravelPointWithNoEmptyFields())
                .setDelayInMinutes(Duration.ofSeconds(60L))
                .setDistanceInKilometers(new Distance(5.253d, DEFAULT_TEST_DISTANCE_METRIC))
                .setVehicleType(VehicleType.BUS)
                .setPolyline("mtodHyhpo@")
                .setWaypoints(getTrack())
                .setTravelProvider(getTravelProviderWithNoEmptyFields())
                .setVehicleNumber("7020")
                .setVehicleName("Furtwangen - Triberg")
                .setIntermediateStops(getIntermediateStops())
                .setWalkSteps(getWalkSteps());
    }

    public static Leg getLegWithNoEmptyFieldsByVehicleType(VehicleType vehicleType) {
        return getLegBuilderWithNoEmptyFields()
                .setVehicleType(vehicleType)
                .build();
    }

    public static Leg getLegWithNoEmptyFieldsByArrivalPoint(Point arrivalPoint) {
        return getLegBuilderWithNoEmptyFields()
                .setArrival(getTravelPointWithNoEmptyFieldsByArrivalTime(arrivalPoint))
                .build();
    }

    public static Leg getLegWithNoEmptyFieldsByDeparturePoint(Point departurePoint) {
        return getLegBuilderWithNoEmptyFields()
                .setDeparture(getTravelPointWithNoEmptyFieldsByArrivalTime(departurePoint))
                .build();
    }

    public static Leg getLegWithNoEmptyFieldsByArrivalTime(ZonedDateTime arrivalTime) {
        return getLegBuilderWithNoEmptyFields()
                .setArrival(getTravelPointWithNoEmptyFieldsByArrivalTime(arrivalTime))
                .build();
    }

    public static Leg getLegWithNoEmptyFieldsByDepartureTime(ZonedDateTime departureTime) {
        return getLegBuilderWithNoEmptyFields()
                .setDeparture(getTravelPointWithNoEmptyFieldsByDepartureTime(departureTime))
                .build();
    }

    public static Leg getLegWithNoEmptyFieldsBy(ApiToken apiToken) {
        return getLegBuilderWithNoEmptyFields()
                .setDeparture(getDepartureTravelPointWithNoEmptyFieldsBy(apiToken))
                .setArrival(getArrivalTravelPointWithNoEmptyFieldsBy(apiToken))
                .build();
    }

    public static Leg getGrosshausbergToFurtwangenIlbenstreetLeg(LinkedList<Point> waypoints) {
        TravelPoint departure = getGrosshausbergTravelPoint();
        TravelPoint arrival = getFurtwangenIlbenstreetTravelPoint();
        return new Leg.LegBuilder()
                .setDelayInMinutes(Duration.ZERO)
                .setDistanceInKilometers(new Distance(0.977d, DEFAULT_TEST_DISTANCE_METRIC))
                .setVehicleType(VehicleType.WALK)
                .setDeparture(departure)
                .setArrival(arrival)
                .setPolyline("mtodHyhpo@@HVbDPVHlABAl@QRIDN|@Sd@Gx@Ob@EDp@FfAD~@@JDd@Fd@@JPt@v@{@LM")
                .setWaypoints(waypoints)
                .setWalkSteps(getGrosshausbergToFurtwangenIlbenstreetWalkSteps(waypoints))
                .build();
    }

    public static Leg getFurtwangenIlbenstreetToBleibachLeg(LinkedList<Point> waypoints) {
        TravelPoint departure = getFurtwangenIlbenstreetTravelPoint();
        TravelPoint arrival = getBleibachSevTravelPoint();
        return new Leg.LegBuilder()
                .setDelayInMinutes(Duration.ZERO)
                .setDistanceInKilometers(new Distance(26.394d, DEFAULT_TEST_DISTANCE_METRIC))
                .setVehicleType(VehicleType.BUS)
                .setTravelProvider(getSuedbadenTravelProvider())
                .setDeparture(departure)
                .setArrival(arrival)
                .setPolyline("mtodHyhpo@@HVbDPVHlABAl@QRIDN|@Sd@Gx@Ob@EDp@FfAD~@@JDd@Fd@@JPt@v@{@LM")
                .setWaypoints(waypoints)
                .setVehicleNumber("272")
                .setVehicleName("Waldkirch Gymnasium - Furtwangen Rößleplatz")
                .setIntermediateStops(getFurtwangenIlbenStreetToBleibachIntermediateStops())
                .build();
    }

    public static Leg getBleibachToWaldkirchKastelberghalleLeg(LinkedList<Point> waypoints) {
        TravelPoint departure = getBleibachSevTravelPoint();
        TravelPoint arrival = getWaldkirchKastelberghalleTravelPoint();
        return new Leg.LegBuilder()
                .setDelayInMinutes(Duration.ZERO)
                .setDistanceInKilometers(new Distance(6.784d, DEFAULT_TEST_DISTANCE_METRIC))
                .setVehicleType(VehicleType.BUS)
                .setTravelProvider(getSuedbadenTravelProvider())
                .setDeparture(departure)
                .setArrival(arrival)
                .setPolyline("mtodHyhpo@@HVbDPVHlABAl@QRIDN|@Sd@Gx@Ob@EDp@FfAD~@@JDd@Fd@@JPt@v@{@LM")
                .setWaypoints(waypoints)
                .setVehicleNumber("201")
                .setVehicleName("Oberprechtal Forellenhof - Emmendingen Bahnhof/ZOB")
                .setIntermediateStops(getBleibachToWaldkirchKastelberghalleIntermediateStops())
                .build();
    }

    public static Leg getWaldkirchKastelberghalleToSickLeg(LinkedList<Point> waypoints) {
        TravelPoint departure = getWaldkirchKastelberghalleTravelPoint();
        TravelPoint arrival = getSickAgTravelPoint();
        return new Leg.LegBuilder()
                .setDelayInMinutes(Duration.ZERO)
                .setDistanceInKilometers(new Distance(0.445d, DEFAULT_TEST_DISTANCE_METRIC))
                .setVehicleType(VehicleType.WALK)
                .setDeparture(departure)
                .setArrival(arrival)
                .setPolyline("mtodHyhpo@@HVbDPVHlABAl@QRIDN|@Sd@Gx@Ob@EDp@FfAD~@@JDd@Fd@@JPt@v@{@LM")
                .setWaypoints(waypoints)
                .setWalkSteps(getWaldkirchKastelberghalleToSickWalkSteps(waypoints))
                .build();
    }

    public static Leg getMannheimHbfToMannheimUniversityLeg(LinkedList<Point> waypoints) {
        TravelPoint departure = getMannheimHbfTravelPoint();
        TravelPoint arrival = getMannheimUniversityTravelPoint();
        return new Leg.LegBuilder()
                .setDelayInMinutes(Duration.ZERO)
                .setDistanceInKilometers(new Distance(0.320d, DEFAULT_TEST_DISTANCE_METRIC))
                .setVehicleType(VehicleType.WALK)
                .setDeparture(departure)
                .setArrival(arrival)
                .setPolyline("cw_mHgdtr@h@mBFFZVD?BIVs@Pm@Le@BDLR`@l@X\\NLNPDJDJ@D@DBJ@J?H@L?JAL?HJBCDALB?@@Ir@Gb@CV")
                .setWaypoints(waypoints)
                .setWalkSteps(getMannheimHbfToMannheimUniversityWalkSteps(waypoints))
                .build();
    }

    public static Leg getMannheimUniversityToMannheimBerlinerPlaceLeg(LinkedList<Point> waypoints) {
        TravelPoint departure = getMannheimUniversityTravelPoint();
        TravelPoint arrival = getBerlinerPlaceTravelPoint();
        return new Leg.LegBuilder()
                .setDelayInMinutes(Duration.ZERO)
                .setDistanceInKilometers(new Distance(0.956d, DEFAULT_TEST_DISTANCE_METRIC))
                .setVehicleType(VehicleType.TRAM)
                .setTravelProvider(getRnvTravelProvider())
                .setDeparture(departure)
                .setArrival(arrival)
                .setPolyline("sn_mH{~sr@i@x\\zJnp@")
                .setWaypoints(waypoints)
                .setVehicleNumber("4")
                .setVehicleName("Bad Dürkheim - LU Oggersheim - LU Hbf - Berliner Platz - MA Hbf - Wasserturm - Paradeplatz - Alte Feuerwache - Schafweide - Universitätsklinikum - Bonafitiuskirche - Ulmenweg - Waldfriedhof")
                .setIntermediateStops(getMannheimUniversityToMannheimBerlinerPlaceIntermediateStop())
                .build();
    }

    public static Leg getBerlinerPlaceToDestinationLeg(LinkedList<Point> waypoints) {
        TravelPoint departure = getBerlinerPlaceTravelPoint();
        TravelPoint arrival = getLudwigsburgCenterTravelPoint();
        return new Leg.LegBuilder()
                .setDelayInMinutes(Duration.ZERO)
                .setDistanceInKilometers(new Distance(0.319d, DEFAULT_TEST_DISTANCE_METRIC))
                .setVehicleType(VehicleType.WALK)
                .setDeparture(departure)
                .setArrival(arrival)
                .setPolyline("ad_mHsoqr@E@?AG@AICKGBCSBCPOAE^UJEDCJK@BFIFMDMDO@O@M@QAWCUGa@Is@BGrAAfA{A@A@CNS?C@?BER[@F")
                .setWaypoints(waypoints)
                .build();

    }

    private static LinkedList<TravelPoint> getIntermediateStops() {
        LinkedList<TravelPoint> intermediateStops = new LinkedList<>();
        intermediateStops.add(getTravelPointWithNoEmptyFields());
        return intermediateStops;
    }

    private static LinkedList<Point> getTrack() {
        LinkedList<Point> points = new LinkedList<>();
        points.add(new Point.PointBuilder(0.0d, 0.0d).build());
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

    private static LinkedList<WalkStep> getWalkSteps() {
        LinkedList<WalkStep> walkSteps = new LinkedList<>();
        walkSteps.add(getWalkStepWithNoEmptyFields());
        return walkSteps;
    }

    private static LinkedList<WalkStep> getGrosshausbergToFurtwangenIlbenstreetWalkSteps(LinkedList<Point> waypoints) {
        LinkedList<WalkStep> walkSteps = new LinkedList<>();
        walkSteps.add(getAmGrosshausbergStreetWalkStep());
        walkSteps.add(getAmGrosshausbergStreetToMartinSchmittStreetWalkStep());
        walkSteps.add(getMartinSchmittStreetWalkStep());
        walkSteps.add(getWeibertMahlerStreetWalkStep());
        walkSteps.add(getBregstreetWalkStep(waypoints));
        return walkSteps;
    }

    private static LinkedList<WalkStep> getWaldkirchKastelberghalleToSickWalkSteps(LinkedList<Point> waypoints) {
        LinkedList<WalkStep> walkSteps = new LinkedList<>();
        walkSteps.add(getFreiburgerStreetWalkStep());
        walkSteps.add(getFreiburgerStreetToUnterfelderPathWalkStep());
        walkSteps.add(getUnterfelderPathWalkStep());
        walkSteps.add(getHansjakobStreetWalkStep());
        walkSteps.add(getErwinSickStreetWalkStep(waypoints));
        return walkSteps;
    }

    private static LinkedList<WalkStep> getMannheimHbfToMannheimUniversityWalkSteps(LinkedList<Point> waypoints) {
        LinkedList<WalkStep> walkSteps = new LinkedList<>();
        walkSteps.add(getCarlTheodorPlaceWalkStep());
        walkSteps.add(getCarlTheodorPlaceToOttoSelzStreetFootpathWalkStep());
        walkSteps.add(getCarlTheodorPlaceToOttoSelzStreetPathWalkStep());
        walkSteps.add(getOttoSelzStreetWalkStep());
        walkSteps.add(getOttoSelzStreetToPlatformThreeWalkStep());
        walkSteps.add(getPlatformThreeWalkStep(waypoints));
        return walkSteps;
    }

    private static LinkedList<WalkStep> getBerlinerPlaceToDestinationWalkSteps(LinkedList<Point> waypoints) {
        LinkedList<WalkStep> walkSteps = new LinkedList<>();
        walkSteps.add(getPlatformWalkStep());
        walkSteps.add(getPlatformToLudwigStreetWalkStep());
        walkSteps.add(getLudwigStreetWalkStep());
        walkSteps.add(getBerlinerPlaceWalkStep());
        walkSteps.add(getHenyRoosPassageWalkStep());
        walkSteps.add(getHenyRoosPassageToDestinationFootpathWalkStep());
        walkSteps.add(getHenyRoosPassageToDestinationPathWalkStep(waypoints));
        return walkSteps;
    }

}
