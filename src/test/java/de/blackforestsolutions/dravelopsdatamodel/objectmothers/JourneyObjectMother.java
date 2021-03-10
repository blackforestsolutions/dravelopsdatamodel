package de.blackforestsolutions.dravelopsdatamodel.objectmothers;

import de.blackforestsolutions.dravelopsdatamodel.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.LinkedList;
import java.util.Locale;

import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.LegObjectMother.*;
import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.PriceObjectMother.getFurtwangenToWaldkirchPrice;
import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.PriceObjectMother.getPriceWithNoEmptyFields;
import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.UUIDObjectMother.*;

@Slf4j
public class JourneyObjectMother {

    private static final Locale DEFAULT_TEST_LANGUAGE = new Locale("de");

    public static Journey getJourneyWithEmptyFields() {
        try {
            return new Journey.JourneyBuilder(TEST_UUID_5)
                    .build();
        } catch (IOException e) {
            log.error("ShaId from Journey could not be generated: ", e);
            return null;
        }
    }

    public static Journey getJourneyWithNoEmptyFields() {
        try {
            return getJourneyBuilderWithNoEmptyFields()
                    .build();
        } catch (IOException e) {
            log.error("ShaId from Journey could not be generated: ", e);
            return null;
        }
    }

    public static Journey.JourneyBuilder getJourneyBuilderWithNoEmptyFields() {
        return new Journey.JourneyBuilder(TEST_UUID_1)
                .setLanguage(DEFAULT_TEST_LANGUAGE)
                .setLegs(getLegs())
                .setPrices(getPrices());
    }

    public static Journey getJourneyWithNoEmptyFieldsByArrivalPoint(Point arrivalPoint) {
        try {
            return getJourneyBuilderWithNoEmptyFields()
                    .setLegs(getLegsByArrivalPoint(arrivalPoint))
                    .build();
        } catch (IOException e) {
            log.error("ShaId from Journey could not be generated: ", e);
            return null;
        }
    }

    public static Journey getJourneyWithNoEmptyFieldsByDeparturePoint(Point departurePoint) {
        try {
            return getJourneyBuilderWithNoEmptyFields()
                    .setLegs(getLegsByDeparturePoint(departurePoint))
                    .build();
        } catch (IOException e) {
            log.error("ShaId from Journey could not be generated: ", e);
            return null;
        }
    }

    public static Journey getJourneyWithNoEmptyFieldsByArrivalTime(ZonedDateTime arrivalTime) {
        try {
            return getJourneyBuilderWithNoEmptyFields()
                    .setLegs(getLegsByArrivalTime(arrivalTime))
                    .build();
        } catch (IOException e) {
            log.error("ShaId from Journey could not be generated: ", e);
            return null;
        }
    }

    public static Journey getJourneyWithNoEmptyFieldsByDepartureTime(ZonedDateTime departureTime) {
        try {
            return getJourneyBuilderWithNoEmptyFields()
                    .setLegs(getLegsByDepartureTime(departureTime))
                    .build();
        } catch (IOException e) {
            log.error("ShaId from Journey could not be generated: ", e);
            return null;
        }
    }

    public static Journey getJourneyWithNoEmptyFieldsByLanguage(Locale language) {
        try {
            return getJourneyBuilderWithNoEmptyFields()
                    .setLanguage(language)
                    .build();
        } catch (IOException e) {
            log.error("ShaId from Journey could not be generated: ", e);
            return null;
        }
    }

    public static Journey getJourneyWithNoEmptyFieldsBy(ApiToken apiToken) {
        try {
            return getJourneyBuilderWithNoEmptyFields()
                    .setLanguage(apiToken.getLanguage())
                    .setLegs(getLegsBy(apiToken))
                    .build();
        } catch (IOException e) {
            log.error("ShaId from Journey could not be generated: ", e);
            return null;
        }
    }

    public static Journey getJourneyWithDoubleLegAndPriceKey() {
        try {
            return new Journey.JourneyBuilder(TEST_UUID_4)
                    .setLanguage(DEFAULT_TEST_LANGUAGE)
                    .setLegs(getLegsWithDoubleLeg())
                    .setPrices(getPricesWithDoublePrice())
                    .build();
        } catch (IOException e) {
            log.error("ShaId from Journey could not be generated: ", e);
            return null;
        }
    }

    public static Journey getFurtwangenToWaldkirchJourney() {
        try {
            return new Journey.JourneyBuilder(TEST_UUID_2)
                    .setLanguage(DEFAULT_TEST_LANGUAGE)
                    .setLegs(getFurtwangenToWaldkirchLegs())
                    .setPrices(getFurtwangenToWaldkirchPrices())
                    .build();
        } catch (IOException e) {
            log.error("ShaId from Journey could not be generated: ", e);
            return null;
        }
    }

    public static Journey getMannheimHbfLudwigsburgCenterJourney() {
        try {
            return new Journey.JourneyBuilder(TEST_UUID_3)
                    .setLanguage(DEFAULT_TEST_LANGUAGE)
                    .setLegs(getMannheimHbfToLudwigsburgCenterLegs())
                    .build();
        } catch (IOException e) {
            log.error("ShaId from Journey could not be generated: ", e);
            return null;
        }
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

    private static LinkedList<Leg> getFurtwangenToWaldkirchLegs() {
        LinkedList<Leg> legs = new LinkedList<>();
        legs.add(getGrosshausbergToFurtwangenIlbenstreetLeg());
        legs.add(getFurtwangenIlbenstreetToBleibachLeg());
        legs.add(getBleibachToWaldkirchKastelberghalleLeg());
        legs.add(getWaldkirchKastelberghalleToSickLeg());
        return legs;
    }

    private static LinkedList<Price> getFurtwangenToWaldkirchPrices() {
        LinkedList<Price> prices = new LinkedList<>();
        prices.add(getFurtwangenToWaldkirchPrice());
        return prices;
    }

    private static LinkedList<Leg> getMannheimHbfToLudwigsburgCenterLegs() {
        LinkedList<Leg> legs = new LinkedList<>();
        legs.add(getMannheimHbfToMannheimUniversityLeg());
        legs.add(getMannheimUniversityToMannheimBerlinerPlaceLeg());
        legs.add(getBerlinerPlaceToDestinationLeg());
        return legs;
    }

}
