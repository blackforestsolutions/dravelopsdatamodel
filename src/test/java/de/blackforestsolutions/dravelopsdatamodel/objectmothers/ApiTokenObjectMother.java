package de.blackforestsolutions.dravelopsdatamodel.objectmothers;

import de.blackforestsolutions.dravelopsdatamodel.ApiToken;
import de.blackforestsolutions.dravelopsdatamodel.Optimization;
import de.blackforestsolutions.dravelopsdatamodel.Point;
import org.springframework.data.geo.Box;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.BoxObjectMother.getOpenTripPlannerBox;
import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.PointObjectMother.getAmGrosshausbergPoint;
import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.PointObjectMother.getSickAgPoint;

public class ApiTokenObjectMother {

    public static ApiToken.ApiTokenBuilder getApiTokenBuilderWithNoEmptyFields() {
        return new ApiToken.ApiTokenBuilder()
                .setHost("localhost")
                .setProtocol("http")
                .setPort(8080)
                .setDeparture("Furtwangen")
                .setDepartureCoordinate(new Point.PointBuilder(8.0d, 50.0d).build())
                .setArrival("Triberg")
                .setArrivalCoordinate(new Point.PointBuilder(8.0d, 50.0d).build())
                .setDateTime(ZonedDateTime.parse("2020-09-27T10:15:30+02:00"))
                .setIsArrivalDateTime(true)
                .setLanguage(new Locale("de"))
                .setRouter("sbg")
                .setOptimize(Optimization.QUICK)
                .setRadius(3000)
                .setHasDetails(true)
                .setHasReferences(true)
                .setPath("/path")
                .setApiVersion("v1")
                .setMaxResults(1)
                .setBox(new Box(new org.springframework.data.geo.Point(0.0d, 0.0d), new org.springframework.data.geo.Point(0.0d, 0.0d)))
                .setLayers(Collections.singletonList("test"))
                .setMaxPastDaysInCalendar(2)
                .setHazelcastTimeRangeInMinutes(120)
                .setHeaders(Map.of("Token", "123"));
    }

    public static ApiToken getApiTokenWithNoEmptyFields() {
        return new ApiToken.ApiTokenBuilder()
                .setHost("localhost")
                .setProtocol("http")
                .setPort(8080)
                .setDeparture("Furtwangen")
                .setDepartureCoordinate(new Point.PointBuilder(8.0d, 50.0d).build())
                .setArrival("Triberg")
                .setArrivalCoordinate(new Point.PointBuilder(8.0d, 50.0d).build())
                .setDateTime(ZonedDateTime.parse("2020-09-27T10:15:30+02:00"))
                .setIsArrivalDateTime(true)
                .setLanguage(new Locale("de"))
                .setRouter("sbg")
                .setOptimize(Optimization.QUICK)
                .setRadius(3000)
                .setHasDetails(true)
                .setHasReferences(true)
                .setPath("/path")
                .setMaxResults(1)
                .setApiVersion("v1")
                .setBox(new Box(new org.springframework.data.geo.Point(0.0d, 0.0d), new org.springframework.data.geo.Point(0.0d, 0.0d)))
                .setLayers(Collections.singletonList("test"))
                .setMaxPastDaysInCalendar(2)
                .setHazelcastTimeRangeInMinutes(120)
                .setHeaders(Map.of("Token", "123"))
                .build();
    }

    public static ApiToken getApiTokenWithNoEmptyFieldsBy(Point arrivalCoordinate, Point departureCoordinate, ZonedDateTime dateTime, Locale language) {
        return getApiTokenBuilderWithNoEmptyFields()
                .setArrivalCoordinate(arrivalCoordinate)
                .setDepartureCoordinate(departureCoordinate)
                .setDateTime(dateTime)
                .setLanguage(language)
                .build();
    }

    // Start
    // Journey Token Request Chain from StargateService to OpenTripPlanner
    public static ApiToken getJourneyUserRequestToken() {
        return new ApiToken.ApiTokenBuilder()
                .setOptimize(Optimization.QUICK)
                .setIsArrivalDateTime(false)
                .setDateTime(ZonedDateTime.parse("2020-09-30T13:00:00+02:00"))
                .setDepartureCoordinate(getAmGrosshausbergPoint())
                .setArrivalCoordinate(getSickAgPoint())
                .setLanguage(new Locale("de"))
                .build();
    }

    public static ApiToken getConfiguredRoutePersistenceApiToken() {
        return new ApiToken.ApiTokenBuilder()
                .setProtocol("http")
                .setHost("localhost")
                .setPort(8088)
                .setPath("/otp/journeys/get")
                .build();
    }

    public static ApiToken getRoutePersistenceApiToken() {
        return new ApiToken.ApiTokenBuilder()
                .setProtocol("http")
                .setHost("localhost")
                .setPort(8088)
                .setPath("/otp/journeys/get")
                .setIsArrivalDateTime(false)
                .setOptimize(Optimization.QUICK)
                .setDateTime(ZonedDateTime.parse("2020-09-30T13:00:00+02:00"))
                .setDepartureCoordinate(getAmGrosshausbergPoint())
                .setArrivalCoordinate(getSickAgPoint())
                .setLanguage(new Locale("de"))
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
                .setLanguage(new Locale("de"))
                .build();
    }

    public static ApiToken getConfiguredPeliasReverseApiToken() {
        return new ApiToken.ApiTokenBuilder()
                .setProtocol("http")
                .setHost("localhost")
                .setPort(4000)
                .setApiVersion("v1")
                .setMaxResults(1)
                .setDeparture("Start")
                .setArrival("Ziel")
                .build();
    }

    public static ApiToken getPeliasReverseApiToken() {
        return new ApiToken.ApiTokenBuilder()
                .setProtocol("http")
                .setHost("localhost")
                .setPort(4000)
                .setApiVersion("v1")
                .setMaxResults(1)
                .setDeparture("Start")
                .setArrival("Ziel")
                .setLanguage(new Locale("de"))
                .build();
    }

    // Now here is coming {@link getOpenTripPlannerConfiguredApiToken} which is used for DravelopsOtpMapperService
    // as well as DravelOpsPolygonService

    public static ApiToken getOpenTripPlannerApiToken() {
        return new ApiToken.ApiTokenBuilder()
                .setProtocol("http")
                .setHost("localhost")
                .setPort(8089)
                .setRouter("bw")
                .setLanguage(new Locale("de"))
                .setOptimize(Optimization.QUICK)
                .setIsArrivalDateTime(false)
                .setDateTime(ZonedDateTime.parse("2020-09-30T13:00:00+02:00"))
                .setDeparture("Am Großhausberg 8")
                .setDepartureCoordinate(getAmGrosshausbergPoint())
                .setArrival("Sick AG")
                .setArrivalCoordinate(getSickAgPoint())
                .build();
    }
    // End


    // Start
    // TravelPoint Token Request Chain from StargateService to DravelOpsPelias
    public static ApiToken getTravelPointUserRequestToken() {
        return new ApiToken.ApiTokenBuilder()
                .setDeparture("Sick AG")
                .setLanguage(new Locale("de"))
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

    public static ApiToken getPolygonApiToken() {
        return new ApiToken.ApiTokenBuilder()
                .setProtocol("http")
                .setHost("localhost")
                .setPort(8083)
                .setPath("/pelias/travelpoints/get")
                .setDeparture("Sick AG")
                .setLanguage(new Locale("de"))
                .build();
    }

    // Now here is coming {@link getOpenTripPlannerConfiguredApiToken()} which is used for DravelopsOtpMapperService
    // as well as DravelOpsPolygonService

    public static ApiToken getConfiguredPeliasAutocompleteApiToken() {
        return new ApiToken.ApiTokenBuilder()
                .setProtocol("http")
                .setHost("localhost")
                .setPort(4000)
                .setApiVersion("v1")
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
                .build();
    }

    public static ApiToken getPeliasAutocompleteApiToken() {
        return new ApiToken.ApiTokenBuilder()
                .setProtocol("http")
                .setHost("localhost")
                .setPort(4000)
                .setApiVersion("v1")
                .setDeparture("Sick AG")
                .setLanguage(new Locale("de"))
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
                .setBox(getOpenTripPlannerBox())
                .build();
    }
    // End

    // Start
    // Both (Journey and TravelPoint RequestToken)
    public static ApiToken getOpenTripPlannerConfiguredApiToken() {
        return new ApiToken.ApiTokenBuilder()
                .setProtocol("http")
                .setHost("localhost")
                .setPort(8089)
                .setRouter("bw")
                .build();
    }
    // End

    // HazelcastApiToken
    public static ApiToken getHazelcastApiToken() {
        return new ApiToken.ApiTokenBuilder()
                .setMaxPastDaysInCalendar(2)
                .setHazelcastTimeRangeInMinutes(120)
                .build();
    }

    // GtfsFileApiToken
    public static ApiToken getSbgGtfsApiToken() {
        return new ApiToken.ApiTokenBuilder()
                .setProtocol("http")
                .setHost("nvbw.de")
                .setPath("/fileadmin/user_upload/service/open_data/fahrplandaten_mit_liniennetz/sbg.zip")
                .setHeaders(Map.of(
                        "Token", "123"
                ))
                .build();
    }

    public static ApiToken getRnvGtfsApiToken() {
        return new ApiToken.ApiTokenBuilder()
                .setProtocol("https")
                .setHost("gtfs-sandbox-dds.rnv-online.de")
                .setPath("/latest/gtfs.zip")
                .build();
    }

}
