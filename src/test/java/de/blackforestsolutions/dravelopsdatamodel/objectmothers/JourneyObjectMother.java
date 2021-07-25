package de.blackforestsolutions.dravelopsdatamodel.objectmothers;

import de.blackforestsolutions.dravelopsdatamodel.*;
import lombok.extern.slf4j.Slf4j;

import java.time.ZonedDateTime;
import java.util.LinkedList;
import java.util.Locale;
import java.util.UUID;

import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.LegObjectMother.*;
import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.PriceObjectMother.getFurtwangenToWaldkirchPrice;
import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.PriceObjectMother.getPriceWithNoEmptyFields;
import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.UUIDObjectMother.*;
import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.WaypointsObjectMother.getExampleWaypoints;

@Slf4j
public class JourneyObjectMother {

    private static final Locale DEFAULT_TEST_LANGUAGE = new Locale("de");

    public static Journey getJourneyWithEmptyFields() {
        return new Journey.JourneyBuilder(TEST_UUID_5)
                .build();
    }

    public static Journey getJourneyWithNoEmptyFields() {
        return getJourneyBuilderWithNoEmptyFields()
                .build();
    }

    public static Journey.JourneyBuilder getJourneyBuilderWithNoEmptyFields() {
        return new Journey.JourneyBuilder(TEST_UUID_1)
                .setLanguage(DEFAULT_TEST_LANGUAGE)
                .setLegs(getLegs())
                .setPrices(getPrices());
    }

    public static Journey getJourneyWithNoEmptyFieldsById(UUID id) {
        return getJourneyBuilderWithNoEmptyFields()
                .setId(id)
                .build();
    }

    public static Journey getJourneyWithNoEmptyFieldsByVehicleType(VehicleType vehicleType) {
        return getJourneyBuilderWithNoEmptyFields()
                .setLegs(getLegsByVehicleType(vehicleType))
                .build();
    }

    public static Journey getJourneyWithNoEmptyFieldsByArrivalPoint(Point arrivalPoint, UUID id) {
        return getJourneyBuilderWithNoEmptyFields()
                .setId(id)
                .setLegs(getLegsByArrivalPoint(arrivalPoint))
                .build();
    }

    public static Journey getJourneyWithNoEmptyFieldsByDeparturePoint(Point departurePoint, UUID id) {
        return getJourneyBuilderWithNoEmptyFields()
                .setId(id)
                .setLegs(getLegsByDeparturePoint(departurePoint))
                .build();
    }

    public static Journey getJourneyWithNoEmptyFieldsByArrivalTime(ZonedDateTime arrivalTime, UUID id) {
        return getJourneyBuilderWithNoEmptyFields()
                .setId(id)
                .setLegs(getLegsByArrivalTime(arrivalTime))
                .build();
    }

    public static Journey getJourneyWithNoEmptyFieldsByDepartureTime(ZonedDateTime departureTime, UUID id) {
        return getJourneyBuilderWithNoEmptyFields()
                .setId(id)
                .setLegs(getLegsByDepartureTime(departureTime))
                .build();
    }

    public static Journey getJourneyWithNoEmptyFieldsByLanguage(Locale language, UUID id) {
        return getJourneyBuilderWithNoEmptyFields()
                .setId(id)
                .setLanguage(language)
                .build();
    }

    public static Journey getJourneyWithNoEmptyFieldsBy(ApiToken apiToken, UUID id) {
        return getJourneyBuilderWithNoEmptyFields()
                .setId(id)
                .setLanguage(apiToken.getLanguage())
                .setLegs(getLegsBy(apiToken))
                .build();
    }

    public static Journey getJourneyWithDoubleLegAndPriceKey() {
        return new Journey.JourneyBuilder(TEST_UUID_4)
                .setLanguage(DEFAULT_TEST_LANGUAGE)
                .setLegs(getLegsWithDoubleLeg())
                .setPrices(getPricesWithDoublePrice())
                .build();
    }

    public static Journey getFurtwangenToWaldkirchJourney() {
        return new Journey.JourneyBuilder(TEST_UUID_2)
                .setLanguage(DEFAULT_TEST_LANGUAGE)
                .setLegs(getFurtwangenToWaldkirchLegs(new LinkedList<>()))
                .setPrices(getFurtwangenToWaldkirchPrices())
                .build();
    }

    public static Journey getFurtwangenToWaldkirchWaypointsJourney() {
        LinkedList<Point> mockedWaypoints = getExampleWaypoints();
        return new Journey.JourneyBuilder(getFurtwangenToWaldkirchJourney())
                .setLegs(getFurtwangenToWaldkirchLegs(mockedWaypoints))
                .build();
    }

    public static Journey getMannheimHbfLudwigsburgCenterJourney() {
        return new Journey.JourneyBuilder(TEST_UUID_3)
                .setLanguage(DEFAULT_TEST_LANGUAGE)
                .setLegs(getMannheimHbfToLudwigsburgCenterLegs(new LinkedList<>()))
                .build();
    }

    public static Journey getMannheimHbfLudwigsburgCenterWaypointsJourney() {
        LinkedList<Point> mockedWaypoints = getExampleWaypoints();
        return new Journey.JourneyBuilder(getMannheimHbfLudwigsburgCenterJourney())
                .setLegs(getMannheimHbfToLudwigsburgCenterLegs(mockedWaypoints))
                .build();
    }

    private static LinkedList<Leg> getLegs() {
        LinkedList<Leg> legs = new LinkedList<>();
        legs.add(getLegWithNoEmptyFields());
        return legs;
    }

    private static LinkedList<Price> getPrices() {
        LinkedList<Price> prices = new LinkedList<>();
        prices.add(getPriceWithNoEmptyFields(PriceType.REGULAR));
        return prices;
    }

    private static LinkedList<Leg> getLegsByVehicleType(VehicleType vehicleType) {
        LinkedList<Leg> legs = new LinkedList<>();
        legs.add(getLegWithNoEmptyFieldsByVehicleType(vehicleType));
        return legs;
    }

    private static LinkedList<Leg> getLegsByArrivalPoint(Point arrivalPoint) {
        LinkedList<Leg> legs = new LinkedList<>();
        legs.add(getLegWithNoEmptyFieldsByArrivalPoint(arrivalPoint));
        return legs;
    }

    private static LinkedList<Leg> getLegsByDeparturePoint(Point departurePoint) {
        LinkedList<Leg> legs = new LinkedList<>();
        legs.add(getLegWithNoEmptyFieldsByDeparturePoint(departurePoint));
        return legs;
    }

    private static LinkedList<Leg> getLegsByArrivalTime(ZonedDateTime arrivalTime) {
        LinkedList<Leg> legs = new LinkedList<>();
        legs.add(getLegWithNoEmptyFieldsByArrivalTime(arrivalTime));
        return legs;
    }

    private static LinkedList<Leg> getLegsByDepartureTime(ZonedDateTime departureTime) {
        LinkedList<Leg> legs = new LinkedList<>();
        legs.add(getLegWithNoEmptyFieldsByDepartureTime(departureTime));
        return legs;
    }

    private static LinkedList<Leg> getLegsBy(ApiToken apiToken) {
        LinkedList<Leg> legs = new LinkedList<>();
        legs.add(getLegWithNoEmptyFieldsBy(apiToken));
        return legs;
    }

    public static LinkedList<Leg> getLegsWithDoubleLeg() {
        LinkedList<Leg> legs = new LinkedList<>();
        legs.add(getLegWithNoEmptyFields());
        legs.add(getLegWithNoEmptyFields());
        legs.add(getLegWithNoEmptyFields());
        return legs;
    }

    private static LinkedList<Price> getPricesWithDoublePrice() {
        LinkedList<Price> prices = new LinkedList<>();
        prices.add(getPriceWithNoEmptyFields(PriceType.SENIOR));
        prices.add(getPriceWithNoEmptyFields(PriceType.REGULAR));
        prices.add(getPriceWithNoEmptyFields(PriceType.REGULAR));
        return prices;
    }

    private static LinkedList<Leg> getFurtwangenToWaldkirchLegs(LinkedList<Point> mockedWaypoints) {
        LinkedList<Leg> legs = new LinkedList<>();
        legs.add(getGrosshausbergToFurtwangenIlbenstreetLeg(mockedWaypoints));
        legs.add(getFurtwangenIlbenstreetToBleibachLeg(mockedWaypoints));
        legs.add(getBleibachToWaldkirchKastelberghalleLeg(mockedWaypoints));
        legs.add(getWaldkirchKastelberghalleToSickLeg(mockedWaypoints));
        return legs;
    }

    private static LinkedList<Price> getFurtwangenToWaldkirchPrices() {
        LinkedList<Price> prices = new LinkedList<>();
        prices.add(getFurtwangenToWaldkirchPrice());
        return prices;
    }

    private static LinkedList<Leg> getMannheimHbfToLudwigsburgCenterLegs(LinkedList<Point> mockedWaypoints) {
        LinkedList<Leg> legs = new LinkedList<>();
        legs.add(getMannheimHbfToMannheimUniversityLeg(mockedWaypoints));
        legs.add(getMannheimUniversityToMannheimBerlinerPlaceLeg(mockedWaypoints));
        legs.add(getBerlinerPlaceToDestinationLeg(mockedWaypoints));
        return legs;
    }

}
