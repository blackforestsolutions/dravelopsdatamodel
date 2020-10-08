package de.blackforestsolutions.dravelopsdatamodel.objectmothers;

import de.blackforestsolutions.dravelopsdatamodel.TravelProvider;

import java.net.URL;

public class TravelProviderObjectMother {

    public static TravelProvider getTravelProviderWithNoEmptyFields() {
        return new TravelProvider.TravelProviderBuilder()
                .setName("Verkehrsverbund Schwarzwald-Baar")
                .setUrl(getUrl())
                .build();
    }

    private static URL getUrl() {
        try {
            return new URL("https://www.v-s-b.de");
        } catch (Exception ignored) {
            return null;
        }
    }
}
