package de.blackforestsolutions.dravelopsdatamodel.objectmothers;

import de.blackforestsolutions.dravelopsdatamodel.Journey;
import de.blackforestsolutions.dravelopsdatamodel.Leg;
import de.blackforestsolutions.dravelopsdatamodel.Price;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.UUID;

import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.LegObjectMother.getLegWithNoEmptyFields;
import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.PriceObjectMother.getPriceWithNoEmptyFields;
import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.UUIDObjectMother.TEST_UUID_1;
import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.UUIDObjectMother.TEST_UUID_2;

public class JourneyObjectMother {

    public static Journey getJourneyWithNoEmptyFields() {
        return new Journey.JourneyBuilder(TEST_UUID_1)
                .setLegs(getLegs())
                .setPrices(getPrices())
                .build();
    }

    private static LinkedHashMap<UUID, Leg> getLegs() {
        LinkedHashMap<UUID, Leg> legs = new LinkedHashMap<>();
        legs.put(TEST_UUID_2 , getLegWithNoEmptyFields());
        return legs;
    }

    private static HashSet<Price> getPrices() {
        HashSet<Price> prices = new HashSet<>();
        prices.add(getPriceWithNoEmptyFields());
        return prices;
    }

}