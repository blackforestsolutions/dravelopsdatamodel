package de.blackforestsolutions.dravelopsdatamodel.objectmothers;

import de.blackforestsolutions.dravelopsdatamodel.Journey;
import de.blackforestsolutions.dravelopsdatamodel.Leg;
import de.blackforestsolutions.dravelopsdatamodel.Price;
import de.blackforestsolutions.dravelopsdatamodel.PriceType;

import java.util.LinkedList;
import java.util.Locale;
import java.util.UUID;

import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.LegObjectMother.*;
import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.PriceObjectMother.getFurtwangenToWaldkirchPrice;
import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.PriceObjectMother.getPriceWithNoEmptyFields;
import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.UUIDObjectMother.*;

public class JourneyObjectMother {

    public static Journey getJourneyWithEmptyFields(UUID id) {
        return new Journey.JourneyBuilder(id)
                .build();
    }

    public static Journey getJourneyWithNoEmptyFields() {
        return getJourneyBuilderWithNoEmptyFields()
                .build();
    }

    public static Journey.JourneyBuilder getJourneyBuilderWithNoEmptyFields() {
        return new Journey.JourneyBuilder(TEST_UUID_1)
                .setLanguage(Locale.forLanguageTag("de"))
                .setLegs(getLegs())
                .setPrices(getPrices());
    }

    public static Journey getJourneyWithDoubleLegAndPriceKey() {
        return new Journey.JourneyBuilder(TEST_UUID_1)
                .setLanguage(Locale.forLanguageTag("de"))
                .setLegs(getLegsWithDoubleLeg())
                .setPrices(getPricesWithDoublePrice())
                .build();
    }

    public static Journey getFurtwangenToWaldkirchJourney() {
        return new Journey.JourneyBuilder(TEST_UUID_1)
                .setLanguage(Locale.forLanguageTag("de"))
                .setLegs(getFurtwangenToWaldkirchLegs())
                .setPrices(getFurtwangenToWaldkirchPrices())
                .build();
    }

    public static Journey getMannheimHbfLudwigsburgCenterJourney() {
        return new Journey.JourneyBuilder(TEST_UUID_1)
                .setLanguage(Locale.forLanguageTag("de"))
                .setLegs(getMannheimHbfToLudwigsburgCenterLegs())
                .build();
    }

    private static LinkedList<Leg> getLegs() {
        LinkedList<Leg> legs = new LinkedList<>();
        legs.add(getLegWithNoEmptyFields(TEST_UUID_2));
        return legs;
    }

    private static LinkedList<Price> getPrices() {
        LinkedList<Price> prices = new LinkedList<>();
        prices.add(getPriceWithNoEmptyFields(PriceType.REGULAR));
        return prices;
    }

    public static LinkedList<Leg> getLegsWithDoubleLeg() {
        LinkedList<Leg> legs = new LinkedList<>();
        legs.add(getLegWithNoEmptyFields(TEST_UUID_2));
        legs.add(getLegWithNoEmptyFields(TEST_UUID_2));
        legs.add(getLegWithNoEmptyFields(TEST_UUID_3));
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
