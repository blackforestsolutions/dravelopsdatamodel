package de.blackforestsolutions.dravelopsdatamodel.objectmothers;

import de.blackforestsolutions.dravelopsdatamodel.ApiToken;
import de.blackforestsolutions.dravelopsdatamodel.Optimization;

import java.time.ZonedDateTime;
import java.util.Locale;

public class ApiTokenObjectMother {

    public static ApiToken.ApiTokenBuilder getApiTokenBuilderWithNoEmptyFields() {
        return new ApiToken.ApiTokenBuilder()
                .setHost("localhost")
                .setProtocol("http")
                .setDeparture("Furtwangen")
                .setArrival("Triberg")
                .setDepartureDate(ZonedDateTime.parse("2020-09-27T10:15:30+02:00"))
                .setArrivalDate(ZonedDateTime.parse("2020-09-27T10:15:30+02:00"))
                .setIsDeparture(true)
                .setLanguage(Locale.GERMAN)
                .setRouter("sbg")
                .setOptimize(Optimization.QUICK)
                .setRadius(3000)
                .setHasDetails(true)
                .setHasReferences(true)
                .setPath("/path");
    }

    public static ApiToken getApiTokenWithNoEmptyFields() {
        return new ApiToken.ApiTokenBuilder()
                .setHost("localhost")
                .setProtocol("http")
                .setDeparture("Furtwangen")
                .setArrival("Triberg")
                .setDepartureDate(ZonedDateTime.parse("2020-09-27T10:15:30+02:00"))
                .setArrivalDate(ZonedDateTime.parse("2020-09-27T10:15:30+02:00"))
                .setIsDeparture(true)
                .setLanguage(Locale.GERMAN)
                .setRouter("sbg")
                .setOptimize(Optimization.QUICK)
                .setRadius(3000)
                .setHasDetails(true)
                .setHasReferences(true)
                .setPath("/path")
                .build();
    }
}
