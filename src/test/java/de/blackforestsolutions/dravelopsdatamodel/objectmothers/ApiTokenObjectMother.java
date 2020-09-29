package de.blackforestsolutions.dravelopsdatamodel.objectmothers;

import de.blackforestsolutions.dravelopsdatamodel.util.ApiToken;
import de.blackforestsolutions.dravelopsdatamodel.Optimization;
import org.springframework.data.geo.Point;

import java.time.ZonedDateTime;
import java.util.Locale;

public class ApiTokenObjectMother {

    public static ApiToken.ApiTokenBuilder getApiTokenBuilderWithNoEmptyFields() {
        return new ApiToken.ApiTokenBuilder()
                .setHost("localhost")
                .setProtocol("http")
                .setPort(8080)
                .setDeparture("Furtwangen")
                .setDepartureCoordinate(new Point(8.0d, 50.0d))
                .setArrival("Triberg")
                .setArrivalCoordinate(new Point(8.0d, 50.0d))
                .setDateTime(ZonedDateTime.parse("2020-09-27T10:15:30+02:00"))
                .setIsArrivalDateTime(true)
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
                .setPort(8080)
                .setDeparture("Furtwangen")
                .setDepartureCoordinate(new Point(8.0d, 50.0d))
                .setArrival("Triberg")
                .setArrivalCoordinate(new Point(8.0d, 50.0d))
                .setDateTime(ZonedDateTime.parse("2020-09-27T10:15:30+02:00"))
                .setIsArrivalDateTime(true)
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
