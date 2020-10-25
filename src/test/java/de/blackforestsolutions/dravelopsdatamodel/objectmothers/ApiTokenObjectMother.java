package de.blackforestsolutions.dravelopsdatamodel.objectmothers;

import de.blackforestsolutions.dravelopsdatamodel.Optimization;
import de.blackforestsolutions.dravelopsdatamodel.util.ApiToken;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.springframework.data.geo.Box;
import org.springframework.data.geo.Point;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Locale;

import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.PointObjectMother.getAmGrosshausbergPoint;
import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.PointObjectMother.getSickAgPoint;

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
                .setPath("/path")
                .setApiVersion("v1")
                .setMaxResults(1)
                .setBox(new Box(new Point(0.0d, 0.0d), new Point(0.0d, 0.0d)))
                .setLayers(List.of("test"));
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
                .setMaxResults(1)
                .setApiVersion("v1")
                .setBox(new Box(new Point(0.0d, 0.0d), new Point(0.0d, 0.0d)))
                .setLayers(List.of("test"))
                .build();
    }

    public static ApiToken getUserRequestToken() {
        return new ApiToken.ApiTokenBuilder()
                .setOptimize(Optimization.QUICK)
                .setIsArrivalDateTime(false)
                .setDateTime(ZonedDateTime.parse("2020-09-30T13:00:00+02:00"))
                .setDepartureCoordinate(getAmGrosshausbergPoint())
                .setArrivalCoordinate(getSickAgPoint())
                .setLanguage(Locale.forLanguageTag("de"))
                .build();
    }

    public static ApiToken getTravelPointUserRequestToken() {
        return new ApiToken.ApiTokenBuilder()
                .setDeparture("Sick AG")
                .setLanguage(Locale.forLanguageTag("de"))
                .build();
    }

    public static ApiToken getOpenTripPlannerConfiguredApiToken() {
        return new ApiToken.ApiTokenBuilder()
                .setProtocol("http")
                .setHost("localhost")
                .setPort(8089)
                .setRouter("bw")
                .build();
    }

    public static ApiToken getOpenTripPlannerApiToken() {
        return new ApiToken.ApiTokenBuilder()
                .setProtocol("http")
                .setHost("localhost")
                .setPort(8089)
                .setRouter("bw")
                .setLanguage(Locale.forLanguageTag("de"))
                .setOptimize(Optimization.QUICK)
                .setIsArrivalDateTime(false)
                .setDateTime(ZonedDateTime.parse("2020-09-30T13:00:00+02:00"))
                .setDeparture("Am Großhausberg 8")
                .setDepartureCoordinate(getAmGrosshausbergPoint())
                .setArrival("Sick AG")
                .setArrivalCoordinate(getSickAgPoint())
                .build();
    }

    public static ApiToken getConfiguredPeliasApiToken() {
        return new ApiToken.ApiTokenBuilder(getConfiguredPeliasBaseApiToken())
                .setMaxResults(2)
                .setDeparture("Start")
                .setArrival("Ziel")
                .build();
    }

    public static ApiToken getPeliasAutocompleteApiToken() {
        return new ApiToken.ApiTokenBuilder(getConfiguredPeliasAutocompleteApiToken())
                .setDeparture("Sick AG")
                .setLanguage(Locale.forLanguageTag("de"))
                .build();
    }

    public static ApiToken getConfiguredPeliasAutocompleteApiToken() {
        return new ApiToken.ApiTokenBuilder(getConfiguredPeliasBaseApiToken())
                .setMaxResults(10)
                .setLayers(List.of(
                        "venue",
                        "address",
                        "street",
                        "country",
                        "macroregion",
                        "region",
                        "macrocounty",
                        "county",
                        "locality",
                        "localadmin",
                        "borough",
                        "neighbourhood",
                        "coarse",
                        "postalcode"
                ))
                .setBox(new Box(
                        new Point(7.593844d, 47.590746d),
                        new Point(9.798538d, 49.717617d)
                ))
                .build();
    }

    private static ApiToken getConfiguredPeliasBaseApiToken() {
        return new ApiToken.ApiTokenBuilder()
                .setProtocol("http")
                .setHost("localhost")
                .setPort(4000)
                .setApiVersion("v1")
                .build();
    }

    public static ApiToken getConfiguredOtpMapperApiToken() {
        return new ApiToken.ApiTokenBuilder()
                .setProtocol("http")
                .setHost("localhost")
                .setPort(8084)
                .setPath("/otp/journeys/get")
                .build();
    }

    public static ApiToken getConfiguredPolygonApiToken() {
        return new ApiToken.ApiTokenBuilder()
                .setProtocol("http")
                .setHost("localhost")
                .setPort(8083)
                .setPath("/pelias/travelpoints/get")
                .build();
    }

    public static ApiToken getOtpMapperApiToken() {
        return new ApiToken.ApiTokenBuilder()
                .setProtocol("http")
                .setHost("localhost")
                .setPort(8084)
                .setPath("/otp/journeys/get")
                .setOptimize(Optimization.QUICK)
                .setIsArrivalDateTime(false)
                .setDateTime(ZonedDateTime.parse("2020-09-30T13:00:00+02:00"))
                .setDepartureCoordinate(getAmGrosshausbergPoint())
                .setArrivalCoordinate(getSickAgPoint())
                .setLanguage(Locale.forLanguageTag("de"))
                .build();
    }

    public static ApiToken getPolygonApiToken() {
        return new ApiToken.ApiTokenBuilder()
                .setProtocol("http")
                .setHost("localhost")
                .setPort(8083)
                .setPath("/pelias/travelpoints/get")
                .setDeparture("Sick AG")
                .setLanguage(Locale.forLanguageTag("de"))
                .build();
    }
}
