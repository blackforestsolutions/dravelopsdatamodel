package de.blackforestsolutions.dravelopsdatamodel.objectmothers;

import de.blackforestsolutions.dravelopsdatamodel.Journey;
import de.blackforestsolutions.dravelopsdatamodel.Leg;
import de.blackforestsolutions.dravelopsdatamodel.Price;
import de.blackforestsolutions.dravelopsdatamodel.PriceType;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Locale;

import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.LegObjectMother.*;
import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.PriceObjectMother.getFurtwangenToWaldkirchPrice;
import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.PriceObjectMother.getPriceWithNoEmptyFields;

@Slf4j
public class JourneyObjectMother {

    public static Journey getJourneyWithEmptyFields() {
        try {
            return new Journey.JourneyBuilder()
                    .build();
        } catch (IOException e) {
            log.error("UUID from Journey could not be generated: ", e);
            return null;
        }
    }

    public static Journey getJourneyWithNoEmptyFields() {
        try {
            return getJourneyBuilderWithNoEmptyFields()
                    .build();
        } catch (IOException e) {
            log.error("UUID from Journey could not be generated: ", e);
            return null;
        }
    }

    public static Journey.JourneyBuilder getJourneyBuilderWithNoEmptyFields() {
        return new Journey.JourneyBuilder()
                .setLanguage(new Locale("de"))
                .setLegs(getLegs())
                .setPrices(getPrices());
    }

    public static Journey getJourneyWithDoubleLegAndPriceKey() {
        try {
            return new Journey.JourneyBuilder()
                    .setLanguage(new Locale("de"))
                    .setLegs(getLegsWithDoubleLeg())
                    .setPrices(getPricesWithDoublePrice())
                    .build();
        } catch (IOException e) {
            log.error("UUID from Journey could not be generated: ", e);
            return null;
        }
    }

    public static Journey getFurtwangenToWaldkirchJourney() {
        try {
            return new Journey.JourneyBuilder()
                    .setLanguage(new Locale("de"))
                    .setLegs(getFurtwangenToWaldkirchLegs())
                    .setPrices(getFurtwangenToWaldkirchPrices())
                    .build();
        } catch (IOException e) {
            log.error("UUID from Journey could not be generated: ", e);
            return null;
        }
    }

    public static Journey getMannheimHbfLudwigsburgCenterJourney() {
        try {
            return new Journey.JourneyBuilder()
                    .setLanguage(new Locale("de"))
                    .setLegs(getMannheimHbfToLudwigsburgCenterLegs())
                    .build();
        } catch (IOException e) {
            log.error("UUID from Journey could not be generated: ", e);
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
