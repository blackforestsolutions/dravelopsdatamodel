package de.blackforestsolutions.dravelopsdatamodel.objectmothers;

import de.blackforestsolutions.dravelopsdatamodel.TravelProvider;
import lombok.extern.slf4j.Slf4j;

import java.net.URL;

@Slf4j
public class TravelProviderObjectMother {

    public static TravelProvider getTravelProviderWithNoEmptyFields() {
        return getTravelProviderBuilderWithNoEmptyFields()
                .build();
    }

    public static TravelProvider.TravelProviderBuilder getTravelProviderBuilderWithNoEmptyFields() {
        return new TravelProvider.TravelProviderBuilder()
                .setId("sbg")
                .setName("Verkehrsverbund Schwarzwald-Baar")
                .setUrl(getUrl());
    }

    public static TravelProvider getSuedbadenTravelProvider() {
        return new TravelProvider.TravelProviderBuilder()
                .setId("sbg")
                .setName("Sonstige")
                .setUrl(getSuedbadenUrl())
                .build();
    }

    public static TravelProvider getRnvTravelProvider() {
        return new TravelProvider.TravelProviderBuilder()
                .setId("rnv")
                .setName("Rhein-Neckar-Verkehr GmbH (rnv)")
                .setUrl(getRnvUrl())
                .build();
    }

    private static URL getUrl() {
        try {
            return new URL("https://www.v-s-b.de");
        } catch (Exception ignored) {
            return null;
        }
    }


    private static URL getSuedbadenUrl() {
        try {
            return new URL("https://www.suedbadenbus.de/suedbadenbus/view/index.shtml");
        } catch (Exception e) {
            log.error("URL from TravelProvider was not possible to parse due to: ", e);
            return null;
        }
    }

    private static URL getRnvUrl() {
        try {
            return new URL("http://www.rnv-online.de");
        } catch (Exception e) {
            log.error("URL from TravelProvider was not possible to parse due to: ", e);
            return null;
        }
    }
}
