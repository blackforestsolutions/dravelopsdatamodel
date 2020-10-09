package de.blackforestsolutions.dravelopsdatamodel.objectmothers;

import de.blackforestsolutions.dravelopsdatamodel.Journey;
import de.blackforestsolutions.dravelopsdatamodel.Leg;
import de.blackforestsolutions.dravelopsdatamodel.Price;

import java.util.LinkedList;
import java.util.UUID;

import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.LegObjectMother.getLegWithNoEmptyFields;
import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.PriceObjectMother.getPriceWithNoEmptyFields;
import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.UUIDObjectMother.TEST_UUID_1;

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

    private static LinkedList<Leg> getLegs() {
        LinkedList<Leg> legs = new LinkedList<>();
        legs.add(getLegWithNoEmptyFields());
        return legs;
    }

    private static LinkedList<Price> getPrices() {
        LinkedList<Price> prices = new LinkedList<>();
        prices.add(getPriceWithNoEmptyFields());
        return prices;
    }

}
