package de.blackforestsolutions.dravelopsdatamodel.objectmothers;

import de.blackforestsolutions.dravelopsdatamodel.Journey;
import de.blackforestsolutions.dravelopsdatamodel.Leg;
import de.blackforestsolutions.dravelopsdatamodel.Price;
import de.blackforestsolutions.dravelopsdatamodel.PriceType;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.UUID;

import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.LegObjectMother.getLegWithNoEmptyFields;
import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.PriceObjectMother.getPriceWithNoEmptyFields;
import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.UUIDObjectMother.*;

public class JourneyObjectMother {

    public static Journey getJourneyWithEmptyFields(UUID id) {
        return new Journey.JourneyBuilder(id)
                .build();
    }

    public static Journey getJourneyWithNoEmptyFields() {
        return new Journey.JourneyBuilder(TEST_UUID_1)
                .setLegs(getLegs())
                .setPrices(getPrices())
                .build();
    }

    public static Journey getJourneyWithDoubleLegAndPriceKey() {
        return new Journey.JourneyBuilder(TEST_UUID_1)
                .setLegs(getLegsWithDoubleLeg())
                .setPrices(getPricesWithDoublePrice())
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

    private static LinkedList<Leg> getLegsWithDoubleLeg() {
        LinkedList<Leg> legs = new LinkedList<>();
        legs.add(getLegWithNoEmptyFields(TEST_UUID_2));
        legs.add(getLegWithNoEmptyFields(TEST_UUID_2));
        legs.add(getLegWithNoEmptyFields(TEST_UUID_3));
        return legs;
    }

    private static LinkedList<Price> getPricesWithDoublePrice() {
        LinkedList<Price> prices = new LinkedList<>();
        prices.add(getPriceWithNoEmptyFields(PriceType.REGULAR));
        prices.add(getPriceWithNoEmptyFields(PriceType.REGULAR));
        prices.add(getPriceWithNoEmptyFields(PriceType.SENIOR));
        return prices;
    }

}
