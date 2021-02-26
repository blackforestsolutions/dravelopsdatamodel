package de.blackforestsolutions.dravelopsdatamodel.objectmothers;

import de.blackforestsolutions.dravelopsdatamodel.ApiToken;
import de.blackforestsolutions.dravelopsdatamodel.Box;
import de.blackforestsolutions.dravelopsdatamodel.Optimization;
import de.blackforestsolutions.dravelopsdatamodel.Point;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.BoxObjectMother.getOpenTripPlannerBox;

public class ApiTokenObjectMother {

    /**
     * This section of constants represents real data for our services in development mode
     * Please keep them as current as possible.
     */
    private static final String HOST = "localhost";
    private static final String PROTOCOL = "http";
    private static final int STATION_PERSISTENCE_PORT = 8086;
    private static final int ROUTE_PERSISTENCE_PORT = 8088;
    private static final int OTP_PORT = 8080;
    private static final int OTP_MAPPER_SERVICE_PORT = 8084;
    private static final int PELIAS_PORT = 4000;
    private static final int POLYGON_SERVICE_PORT = 8083;
    private static final String ROUTE_PERSISTENCE_JOURNEY_CONTROLLER_PATH = "/otp/journeys/get";
    private static final String PELIAS_TRAVEL_POINT_CONTROLLER = "/pelias/travelpoints/get";

    /**
     * This section of constants represents fake data for testing purpose. The aim is to make them congruent as much
     * as possible to real use cases.
     */
    private static final int DEFAULT_TEST_PORT = 8000;
    private static final String DEFAULT_TEST_PATH = "/path";
    private static final String DEFAULT_TEST_ROUTER = "bw";
    private static final Locale DEFAULT_TEST_LANGUAGE = new Locale("de");
    private static final ZonedDateTime DEFAULT_TEST_DATE_TIME = ZonedDateTime.parse("2020-09-30T13:00:00+02:00");
    private static final boolean DEFAULT_TEST_IS_ARRIVAL_DATE_TIME = false;
    private static final String DEFAULT_TEST_DEPARTURE_PLACEHOLDER = "Start";
    private static final String DEFAULT_TEST_ARRIVAL_PLACEHOLDER = "Ziel";
    private static final String DEFAULT_TEST_PELIAS_API_VERSION = "v1";
    private static final String DEFAULT_TEST_ARRIVAL = "Sick AG";
    private static final String DEFAULT_TEST_DEPARTURE = "Am Großhausberg 8";
    private static final Point DEFAULT_TEST_DEPARTURE_COORDINATE = PointObjectMother.getAmGrosshausbergPoint();
    private static final Point DEFAULT_TEST_ARRIVAL_COORDINATE = PointObjectMother.getSickAgPoint();
    private static final Box DEFAULT_TEST_BOX = BoxObjectMother.getOpenTripPlannerStartBox();
    private static final int DEFAULT_TEST_MAX_PAST_DAYS_IN_CALENDAR = 2;
    private static final int DEFAULT_TEST_HAZELCAST_TIME_SEARCH_RANGE = 120;
    private static final int DEFAULT_TEST_PELIAS_REVERSE_RESULTS = 1;
    private static final int DEFAULT_TEST_PELIAS_RESULTS = 10;
    private static final Map<String, String> DEFAULT_TEST_HEADERS = Map.of("Token", "123");
    private static final int DEFAULT_TEST_RADIUS = 3000;
    private static final boolean DEFAULT_TEST_OTP_HAS_DETAILS = true;
    private static final boolean DEFAULT_TEST_OTP_HAS_REFERENCES = true;
    private static final List<String> DEFAULT_TEST_PELIAS_LAYERS = ApiTokenObjectMother.getDefaultTestPeliasLayers();
    private static final Optimization DEFAULT_TEST_OPTIMIZATION = Optimization.QUICK;
    private static final String DEFAULT_TEST_GTFS_URL = "http://nvbw.de/fileadmin/user_upload/service/open_data/fahrplandaten_mit_liniennetz/sbg.zip";


    public static ApiToken.ApiTokenBuilder getApiTokenBuilderWithNoEmptyFields() {
        return new ApiToken.ApiTokenBuilder()
                .setHost(HOST)
                .setProtocol(PROTOCOL)
                .setPort(DEFAULT_TEST_PORT)
                .setDeparture(DEFAULT_TEST_DEPARTURE)
                .setDepartureCoordinate(DEFAULT_TEST_DEPARTURE_COORDINATE)
                .setArrival(DEFAULT_TEST_ARRIVAL)
                .setArrivalCoordinate(DEFAULT_TEST_ARRIVAL_COORDINATE)
                .setDateTime(DEFAULT_TEST_DATE_TIME)
                .setIsArrivalDateTime(DEFAULT_TEST_IS_ARRIVAL_DATE_TIME)
                .setLanguage(DEFAULT_TEST_LANGUAGE)
                .setRouter(DEFAULT_TEST_ROUTER)
                .setOptimize(DEFAULT_TEST_OPTIMIZATION)
                .setRadius(DEFAULT_TEST_RADIUS)
                .setHasDetails(DEFAULT_TEST_OTP_HAS_DETAILS)
                .setHasReferences(DEFAULT_TEST_OTP_HAS_REFERENCES)
                .setPath(DEFAULT_TEST_PATH)
                .setApiVersion(DEFAULT_TEST_PELIAS_API_VERSION)
                .setMaxResults(DEFAULT_TEST_PELIAS_REVERSE_RESULTS)
                .setBox(DEFAULT_TEST_BOX)
                .setLayers(DEFAULT_TEST_PELIAS_LAYERS)
                .setMaxPastDaysInCalendar(DEFAULT_TEST_MAX_PAST_DAYS_IN_CALENDAR)
                .setHazelcastTimeRangeInMinutes(DEFAULT_TEST_HAZELCAST_TIME_SEARCH_RANGE)
                .setGtfsUrl(DEFAULT_TEST_GTFS_URL)
                .setHeaders(DEFAULT_TEST_HEADERS);
    }

    public static ApiToken getApiTokenWithNoEmptyFields() {
        return new ApiToken.ApiTokenBuilder()
                .setHost(HOST)
                .setProtocol(PROTOCOL)
                .setPort(DEFAULT_TEST_PORT)
                .setDeparture(DEFAULT_TEST_DEPARTURE)
                .setDepartureCoordinate(DEFAULT_TEST_DEPARTURE_COORDINATE)
                .setArrival(DEFAULT_TEST_ARRIVAL)
                .setArrivalCoordinate(DEFAULT_TEST_ARRIVAL_COORDINATE)
                .setDateTime(DEFAULT_TEST_DATE_TIME)
                .setIsArrivalDateTime(DEFAULT_TEST_IS_ARRIVAL_DATE_TIME)
                .setLanguage(DEFAULT_TEST_LANGUAGE)
                .setRouter(DEFAULT_TEST_ROUTER)
                .setOptimize(DEFAULT_TEST_OPTIMIZATION)
                .setRadius(DEFAULT_TEST_RADIUS)
                .setHasDetails(DEFAULT_TEST_OTP_HAS_DETAILS)
                .setHasReferences(DEFAULT_TEST_OTP_HAS_REFERENCES)
                .setPath(DEFAULT_TEST_PATH)
                .setMaxResults(DEFAULT_TEST_PELIAS_REVERSE_RESULTS)
                .setApiVersion(DEFAULT_TEST_PELIAS_API_VERSION)
                .setBox(DEFAULT_TEST_BOX)
                .setLayers(DEFAULT_TEST_PELIAS_LAYERS)
                .setMaxPastDaysInCalendar(DEFAULT_TEST_MAX_PAST_DAYS_IN_CALENDAR)
                .setHazelcastTimeRangeInMinutes(DEFAULT_TEST_HAZELCAST_TIME_SEARCH_RANGE)
                .setGtfsUrl(DEFAULT_TEST_GTFS_URL)
                .setHeaders(DEFAULT_TEST_HEADERS)
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
                .setOptimize(DEFAULT_TEST_OPTIMIZATION)
                .setIsArrivalDateTime(DEFAULT_TEST_IS_ARRIVAL_DATE_TIME)
                .setDateTime(DEFAULT_TEST_DATE_TIME)
                .setDepartureCoordinate(DEFAULT_TEST_DEPARTURE_COORDINATE)
                .setArrivalCoordinate(DEFAULT_TEST_ARRIVAL_COORDINATE)
                .setLanguage(DEFAULT_TEST_LANGUAGE)
                .build();
    }

    public static ApiToken getConfiguredRoutePersistenceApiToken() {
        return new ApiToken.ApiTokenBuilder()
                .setProtocol(PROTOCOL)
                .setHost(HOST)
                .setPort(ROUTE_PERSISTENCE_PORT)
                .setPath(ROUTE_PERSISTENCE_JOURNEY_CONTROLLER_PATH)
                .build();
    }

    public static ApiToken getRoutePersistenceApiToken() {
        return new ApiToken.ApiTokenBuilder()
                .setProtocol(PROTOCOL)
                .setHost(HOST)
                .setPort(ROUTE_PERSISTENCE_PORT)
                .setPath(ROUTE_PERSISTENCE_JOURNEY_CONTROLLER_PATH)
                .setIsArrivalDateTime(DEFAULT_TEST_IS_ARRIVAL_DATE_TIME)
                .setOptimize(DEFAULT_TEST_OPTIMIZATION)
                .setDateTime(DEFAULT_TEST_DATE_TIME)
                .setDepartureCoordinate(DEFAULT_TEST_DEPARTURE_COORDINATE)
                .setArrivalCoordinate(DEFAULT_TEST_ARRIVAL_COORDINATE)
                .setLanguage(DEFAULT_TEST_LANGUAGE)
                .build();
    }

    public static ApiToken getConfiguredOtpMapperApiToken() {
        return new ApiToken.ApiTokenBuilder()
                .setProtocol(PROTOCOL)
                .setHost(HOST)
                .setPort(OTP_MAPPER_SERVICE_PORT)
                .setPath(ROUTE_PERSISTENCE_JOURNEY_CONTROLLER_PATH)
                .build();
    }

    public static ApiToken getOtpMapperApiToken() {
        return new ApiToken.ApiTokenBuilder()
                .setProtocol(PROTOCOL)
                .setHost(HOST)
                .setPort(OTP_MAPPER_SERVICE_PORT)
                .setPath(ROUTE_PERSISTENCE_JOURNEY_CONTROLLER_PATH)
                .setOptimize(DEFAULT_TEST_OPTIMIZATION)
                .setIsArrivalDateTime(DEFAULT_TEST_IS_ARRIVAL_DATE_TIME)
                .setDateTime(DEFAULT_TEST_DATE_TIME)
                .setDepartureCoordinate(DEFAULT_TEST_DEPARTURE_COORDINATE)
                .setArrivalCoordinate(DEFAULT_TEST_ARRIVAL_COORDINATE)
                .setLanguage(DEFAULT_TEST_LANGUAGE)
                .build();
    }

    public static ApiToken getConfiguredPeliasReverseApiToken() {
        return new ApiToken.ApiTokenBuilder()
                .setProtocol(PROTOCOL)
                .setHost(HOST)
                .setPort(PELIAS_PORT)
                .setApiVersion(DEFAULT_TEST_PELIAS_API_VERSION)
                .setMaxResults(DEFAULT_TEST_PELIAS_REVERSE_RESULTS)
                .setDeparture(DEFAULT_TEST_DEPARTURE_PLACEHOLDER)
                .setArrival(DEFAULT_TEST_ARRIVAL_PLACEHOLDER)
                .build();
    }

    public static ApiToken getPeliasReverseApiToken() {
        return new ApiToken.ApiTokenBuilder()
                .setProtocol(PROTOCOL)
                .setHost(HOST)
                .setPort(PELIAS_PORT)
                .setApiVersion(DEFAULT_TEST_PELIAS_API_VERSION)
                .setMaxResults(DEFAULT_TEST_PELIAS_REVERSE_RESULTS)
                .setDeparture(DEFAULT_TEST_DEPARTURE_PLACEHOLDER)
                .setArrival(DEFAULT_TEST_ARRIVAL_PLACEHOLDER)
                .setLanguage(DEFAULT_TEST_LANGUAGE)
                .build();
    }

    // Now here is coming {@link getOpenTripPlannerConfiguredApiToken} which is used for DravelopsOtpMapperService
    // as well as DravelOpsPolygonService

    public static ApiToken getOpenTripPlannerApiToken() {
        return new ApiToken.ApiTokenBuilder()
                .setProtocol(PROTOCOL)
                .setHost(HOST)
                .setPort(OTP_PORT)
                .setRouter(DEFAULT_TEST_ROUTER)
                .setLanguage(DEFAULT_TEST_LANGUAGE)
                .setOptimize(DEFAULT_TEST_OPTIMIZATION)
                .setIsArrivalDateTime(DEFAULT_TEST_IS_ARRIVAL_DATE_TIME)
                .setDateTime(DEFAULT_TEST_DATE_TIME)
                .setDeparture(DEFAULT_TEST_DEPARTURE)
                .setDepartureCoordinate(DEFAULT_TEST_DEPARTURE_COORDINATE)
                .setArrival(DEFAULT_TEST_ARRIVAL)
                .setArrivalCoordinate(DEFAULT_TEST_ARRIVAL_COORDINATE)
                .build();
    }
    // End


    // Start
    // TravelPoint Token Request Chain from StargateService to DravelOpsPelias
    public static ApiToken getTravelPointUserRequestToken() {
        return new ApiToken.ApiTokenBuilder()
                .setDeparture(DEFAULT_TEST_DEPARTURE)
                .setLanguage(DEFAULT_TEST_LANGUAGE)
                .build();
    }

    public static ApiToken getConfiguredPolygonApiToken() {
        return new ApiToken.ApiTokenBuilder()
                .setProtocol(PROTOCOL)
                .setHost(HOST)
                .setPort(POLYGON_SERVICE_PORT)
                .setPath(PELIAS_TRAVEL_POINT_CONTROLLER)
                .build();
    }

    public static ApiToken getPolygonApiToken() {
        return new ApiToken.ApiTokenBuilder()
                .setProtocol(PROTOCOL)
                .setHost(HOST)
                .setPort(POLYGON_SERVICE_PORT)
                .setPath(PELIAS_TRAVEL_POINT_CONTROLLER)
                .setDeparture(DEFAULT_TEST_DEPARTURE)
                .setLanguage(DEFAULT_TEST_LANGUAGE)
                .build();
    }

    // Now here is coming {@link getOpenTripPlannerConfiguredApiToken()} which is used for DravelopsOtpMapperService
    // as well as DravelOpsPolygonService

    public static ApiToken getConfiguredPeliasAutocompleteApiToken() {
        return new ApiToken.ApiTokenBuilder()
                .setProtocol(PROTOCOL)
                .setHost(HOST)
                .setPort(PELIAS_PORT)
                .setApiVersion(DEFAULT_TEST_PELIAS_API_VERSION)
                .setMaxResults(DEFAULT_TEST_PELIAS_RESULTS)
                .setLayers(DEFAULT_TEST_PELIAS_LAYERS)
                .build();
    }

    public static ApiToken getPeliasAutocompleteApiToken() {
        return new ApiToken.ApiTokenBuilder()
                .setProtocol(PROTOCOL)
                .setHost(HOST)
                .setPort(PELIAS_PORT)
                .setApiVersion(DEFAULT_TEST_PELIAS_API_VERSION)
                .setDeparture(DEFAULT_TEST_DEPARTURE)
                .setLanguage(DEFAULT_TEST_LANGUAGE)
                .setMaxResults(DEFAULT_TEST_PELIAS_RESULTS)
                .setLayers(DEFAULT_TEST_PELIAS_LAYERS)
                .setBox(getOpenTripPlannerBox())
                .build();
    }
    // End

    // Start
    // Both (Journey and TravelPoint RequestToken)
    public static ApiToken getOpenTripPlannerConfiguredApiToken() {
        return new ApiToken.ApiTokenBuilder()
                .setProtocol(PROTOCOL)
                .setHost(HOST)
                .setPort(OTP_PORT)
                .setRouter(DEFAULT_TEST_ROUTER)
                .build();
    }
    // End

    // HazelcastApiToken
    public static ApiToken getHazelcastApiToken() {
        return new ApiToken.ApiTokenBuilder()
                .setMaxPastDaysInCalendar(DEFAULT_TEST_MAX_PAST_DAYS_IN_CALENDAR)
                .setHazelcastTimeRangeInMinutes(DEFAULT_TEST_HAZELCAST_TIME_SEARCH_RANGE)
                .build();
    }

    // GtfsFileApiToken
    public static ApiToken getSbgGtfsApiToken() {
        return new ApiToken.ApiTokenBuilder()
                .setGtfsUrl(DEFAULT_TEST_GTFS_URL)
                .setHeaders(DEFAULT_TEST_HEADERS)
                .build();
    }

    public static ApiToken getRnvGtfsApiToken() {
        return new ApiToken.ApiTokenBuilder()
                .setGtfsUrl("https://gtfs-sandbox-dds.rnv-online.de/latest/gtfs.zip")
                .build();
    }

    public static ApiToken getConfiguredTravelPointPersistenceApiToken() {
        return getConfiguredStationPersistenceApiToken()
                .setPath("/travelpoints/get")
                .build();
    }

    public static ApiToken getConfiguredPolygonPersistenceApiToken() {
        return getConfiguredStationPersistenceApiToken()
                .setPath("/geocoding/get/operatingPolygon")
                .build();
    }

    public static ApiToken getConfiguredBoxPersistenceApiToken() {
        return getConfiguredStationPersistenceApiToken()
                .setPath("/geocoding/get/operatingBox")
                .build();
    }

    private static ApiToken.ApiTokenBuilder getConfiguredStationPersistenceApiToken() {
        return new ApiToken.ApiTokenBuilder()
                .setProtocol(PROTOCOL)
                .setHost(HOST)
                .setPort(STATION_PERSISTENCE_PORT);
    }

    private static List<String> getDefaultTestPeliasLayers() {
        return List.of(
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
        );
    }

}
