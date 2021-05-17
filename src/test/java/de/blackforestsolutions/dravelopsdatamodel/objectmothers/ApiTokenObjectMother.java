package de.blackforestsolutions.dravelopsdatamodel.objectmothers;

import de.blackforestsolutions.dravelopsdatamodel.ApiToken;
import de.blackforestsolutions.dravelopsdatamodel.Box;
import de.blackforestsolutions.dravelopsdatamodel.GraphQlTab;
import de.blackforestsolutions.dravelopsdatamodel.Point;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.BoxObjectMother.getStationPersistenceBox;

public class ApiTokenObjectMother {

    /**
     * This section of constants represents real data for our services in development mode
     * Please keep them as current as possible.
     */
    private static final String HOST = "localhost";
    private static final String PROTOCOL = "http";
    private static final int STATION_PERSISTENCE_PORT = 8086;
    private static final int ROUTE_PERSISTENCE_PORT = 8088;
    private static final int OTP_FAST_LANE_PORT = 9000;
    private static final int OTP_SLOW_LANE_PORT = 9002;
    private static final int OTP_MAPPER_SERVICE_PORT = 8084;
    private static final int PELIAS_PORT = 4000;
    private static final int BOX_SERVICE_PORT = 8083;
    private static final String OTP_FAST_LANE_ROUTER = "bw-fast";
    private static final String OTP_SLOW_LANE_ROUTER = "bw-slow";
    private static final String JOURNEY_CONTROLLER_PATH = "/journeys/otp";
    private static final String AUTOCOMPLETE_ADDRESSES_CONTROLLER_PATH = "/travelpoints/autocomplete";
    private static final String NEAREST_ADDRESSES_CONTROLLER_PATH = "/travelpoints/nearest";
    private static final String NEAREST_STATIONS_CONTROLLER_PATH = "/travelpoints/nearest";

    /**
     * This section of constants represents fake data for testing purpose. The aim is to make them congruent as much
     * as possible to real use cases.
     */
    private static final int DEFAULT_TEST_PORT = 8000;
    private static final String DEFAULT_TEST_PATH = "/path";
    private static final String DEFAULT_TEST_ROUTER = "bw";
    private static final Locale DEFAULT_TEST_LANGUAGE = new Locale("de");
    private static final Locale DEFAULT_TEST_INCORRECT_LANGUAGE = new Locale("ro");
    private static final ZonedDateTime DEFAULT_TEST_DATE_TIME = ZonedDateTime.parse("2020-09-30T13:00:00+02:00");
    private static final boolean DEFAULT_TEST_IS_ARRIVAL_DATE_TIME = false;
    private static final String DEFAULT_TEST_DEPARTURE_PLACEHOLDER = "Start";
    private static final String DEFAULT_TEST_ARRIVAL_PLACEHOLDER = "Ziel";
    private static final String DEFAULT_TEST_PELIAS_API_VERSION = "v1";
    private static final String DEFAULT_TEST_ARRIVAL = "Sick AG";
    private static final String DEFAULT_TEST_DEPARTURE = "Am Großhausberg 8";
    private static final String DEFAULT_TEST_INCORRECT_DEPARTURE = "Incorrect Autocomplete Text";
    private static final Point DEFAULT_TEST_DEPARTURE_COORDINATE = PointObjectMother.getAmGrosshausbergPoint();
    private static final Point DEFAULT_TEST_ARRIVAL_COORDINATE = PointObjectMother.getSickAgPoint();
    private static final Point DEFAULT_TEST_INCORRECT_COORDINATE = PointObjectMother.getWrongPoint();
    private static final Box DEFAULT_TEST_BOX = BoxObjectMother.getBoxServiceStartBox();
    private static final int DEFAULT_TEST_MAX_PAST_DAYS_IN_CALENDAR = 2;
    private static final int DEFAULT_TEST_JOURNEY_SEARCH_WINDOW = 120;
    private static final int DEFAULT_TEST_PELIAS_REVERSE_RESULTS = 1;
    private static final int DEFAULT_TEST_MAX_RESULTS = 10;
    private static final Map<String, String> DEFAULT_TEST_HEADERS = Map.of("Token", "123");
    private static final Distance DEFAULT_TEST_LONG_RADIUS_IN_KILOMETERS = new Distance(1.0d, Metrics.KILOMETERS);
    private static final Distance DEFAULT_TEST_SHORT_RADIUS_IN_KILOMETERS = new Distance(0.1d, Metrics.KILOMETERS);
    private static final boolean DEFAULT_TEST_OTP_HAS_DETAILS = true;
    private static final boolean DEFAULT_TEST_OTP_HAS_REFERENCES = true;
    private static final List<String> DEFAULT_TEST_PELIAS_LAYERS = ApiTokenObjectMother.getDefaultTestPeliasLayers();
    private static final String DEFAULT_TEST_GTFS_PROVIDER = "sbg";
    private static final String DEFAULT_TEST_GTFS_URL = "http://nvbw.de/fileadmin/user_upload/service/open_data/fahrplandaten_mit_liniennetz/sbg.zip";
    private static final long DEFAULT_TEST_RETRY_TIME_IN_MILLISECONDS = 10L;
    private static final String DEFAULT_TEST_PASSWORD = "thp_y9bY2snmh0Ol2UYCtn7r27AHv759Yg1pvdPU";
    private static final String DEFAULT_TEST_REPOSITORY = "blackforestsolutions/dravelopsdeployment";
    private static final String DEFAULT_TEST_FILE_PATH = "projects/sbg/application-sbg.yml";


    public static ApiToken getApiTokenWithNoEmptyFields() {
        ApiToken apiToken = new ApiToken();
        apiToken.setHost(HOST);
        apiToken.setProtocol(PROTOCOL);
        apiToken.setPort(DEFAULT_TEST_PORT);
        apiToken.setDeparture(DEFAULT_TEST_DEPARTURE);
        apiToken.setDepartureCoordinate(DEFAULT_TEST_DEPARTURE_COORDINATE);
        apiToken.setArrival(DEFAULT_TEST_ARRIVAL);
        apiToken.setArrivalCoordinate(DEFAULT_TEST_ARRIVAL_COORDINATE);
        apiToken.setDateTime(DEFAULT_TEST_DATE_TIME);
        apiToken.setIsArrivalDateTime(DEFAULT_TEST_IS_ARRIVAL_DATE_TIME);
        apiToken.setLanguage(DEFAULT_TEST_LANGUAGE);
        apiToken.setRouter(DEFAULT_TEST_ROUTER);
        apiToken.setRadiusInKilometers(DEFAULT_TEST_LONG_RADIUS_IN_KILOMETERS);
        apiToken.setHasDetails(DEFAULT_TEST_OTP_HAS_DETAILS);
        apiToken.setHasReferences(DEFAULT_TEST_OTP_HAS_REFERENCES);
        apiToken.setPath(DEFAULT_TEST_PATH);
        apiToken.setApiVersion(DEFAULT_TEST_PELIAS_API_VERSION);
        apiToken.setMaxResults(DEFAULT_TEST_PELIAS_REVERSE_RESULTS);
        apiToken.setBox(DEFAULT_TEST_BOX);
        apiToken.setLayers(DEFAULT_TEST_PELIAS_LAYERS);
        apiToken.setMaxPastDaysInCalendar(DEFAULT_TEST_MAX_PAST_DAYS_IN_CALENDAR);
        apiToken.setJourneySearchWindowInMinutes(DEFAULT_TEST_JOURNEY_SEARCH_WINDOW);
        apiToken.setGtfsProvider(DEFAULT_TEST_GTFS_PROVIDER);
        apiToken.setGtfsUrl(DEFAULT_TEST_GTFS_URL);
        apiToken.setHeaders(DEFAULT_TEST_HEADERS);
        apiToken.setRetryTimeInMilliseconds(DEFAULT_TEST_RETRY_TIME_IN_MILLISECONDS);
        apiToken.setRepository(DEFAULT_TEST_REPOSITORY);
        apiToken.setPassword(DEFAULT_TEST_PASSWORD);
        apiToken.setFilepath(DEFAULT_TEST_FILE_PATH);
        return apiToken;
    }

    public static ApiToken getApiTokenWithNoEmptyFieldsBy(Point arrivalCoordinate, Point departureCoordinate, ZonedDateTime dateTime, Locale language) {
        ApiToken apiToken = new ApiToken(getApiTokenWithNoEmptyFields());
        apiToken.setArrivalCoordinate(arrivalCoordinate);
        apiToken.setDepartureCoordinate(departureCoordinate);
        apiToken.setDateTime(dateTime);
        apiToken.setLanguage(language);
        return apiToken;
    }

    // Start
    // Journey Token Request Chain from StargateService to OpenTripPlanner
    public static ApiToken getJourneyUserRequestToken() {
        ApiToken apiToken = new ApiToken();
        apiToken.setIsArrivalDateTime(DEFAULT_TEST_IS_ARRIVAL_DATE_TIME);
        apiToken.setDateTime(DEFAULT_TEST_DATE_TIME);
        apiToken.setDepartureCoordinate(DEFAULT_TEST_DEPARTURE_COORDINATE);
        apiToken.setArrivalCoordinate(DEFAULT_TEST_ARRIVAL_COORDINATE);
        apiToken.setLanguage(DEFAULT_TEST_LANGUAGE);
        return apiToken;
    }

    public static ApiToken getIncorrectJourneyUserRequestToken() {
        ApiToken apiToken = new ApiToken();
        apiToken.setIsArrivalDateTime(DEFAULT_TEST_IS_ARRIVAL_DATE_TIME);
        apiToken.setDateTime(DEFAULT_TEST_DATE_TIME);
        apiToken.setDepartureCoordinate(DEFAULT_TEST_INCORRECT_COORDINATE);
        apiToken.setArrivalCoordinate(DEFAULT_TEST_INCORRECT_COORDINATE);
        apiToken.setLanguage(DEFAULT_TEST_INCORRECT_LANGUAGE);
        return apiToken;
    }

    public static ApiToken getConfiguredRoutePersistenceApiToken() {
        ApiToken apiToken = new ApiToken();
        apiToken.setProtocol(PROTOCOL);
        apiToken.setHost(HOST);
        apiToken.setPort(ROUTE_PERSISTENCE_PORT);
        apiToken.setPath(JOURNEY_CONTROLLER_PATH);
        apiToken.setMaxResults(DEFAULT_TEST_MAX_RESULTS);
        return apiToken;
    }

    public static ApiToken getRoutePersistenceApiToken() {
        ApiToken apiToken = new ApiToken();
        apiToken.setProtocol(PROTOCOL);
        apiToken.setHost(HOST);
        apiToken.setPort(ROUTE_PERSISTENCE_PORT);
        apiToken.setPath(JOURNEY_CONTROLLER_PATH);
        apiToken.setMaxResults(DEFAULT_TEST_MAX_RESULTS);
        apiToken.setIsArrivalDateTime(DEFAULT_TEST_IS_ARRIVAL_DATE_TIME);
        apiToken.setDateTime(DEFAULT_TEST_DATE_TIME);
        apiToken.setDepartureCoordinate(DEFAULT_TEST_DEPARTURE_COORDINATE);
        apiToken.setArrivalCoordinate(DEFAULT_TEST_ARRIVAL_COORDINATE);
        apiToken.setLanguage(DEFAULT_TEST_LANGUAGE);
        return apiToken;
    }

    public static ApiToken getConfiguredJourneyOtpMapperApiToken() {
        ApiToken apiToken = new ApiToken();
        apiToken.setProtocol(PROTOCOL);
        apiToken.setHost(HOST);
        apiToken.setPort(OTP_MAPPER_SERVICE_PORT);
        apiToken.setPath(JOURNEY_CONTROLLER_PATH);
        apiToken.setMaxResults(DEFAULT_TEST_MAX_RESULTS);
        return apiToken;
    }

    public static ApiToken getJourneyOtpMapperApiToken() {
        ApiToken apiToken = new ApiToken();
        apiToken.setProtocol(PROTOCOL);
        apiToken.setHost(HOST);
        apiToken.setPort(OTP_MAPPER_SERVICE_PORT);
        apiToken.setPath(JOURNEY_CONTROLLER_PATH);
        apiToken.setMaxResults(DEFAULT_TEST_MAX_RESULTS);
        apiToken.setIsArrivalDateTime(DEFAULT_TEST_IS_ARRIVAL_DATE_TIME);
        apiToken.setDateTime(DEFAULT_TEST_DATE_TIME);
        apiToken.setDepartureCoordinate(DEFAULT_TEST_DEPARTURE_COORDINATE);
        apiToken.setArrivalCoordinate(DEFAULT_TEST_ARRIVAL_COORDINATE);
        apiToken.setLanguage(DEFAULT_TEST_LANGUAGE);
        return apiToken;
    }

    public static ApiToken getConfiguredPeliasReverseApiToken() {
        ApiToken apiToken = new ApiToken();
        apiToken.setProtocol(PROTOCOL);
        apiToken.setHost(HOST);
        apiToken.setPort(PELIAS_PORT);
        apiToken.setApiVersion(DEFAULT_TEST_PELIAS_API_VERSION);
        apiToken.setMaxResults(DEFAULT_TEST_PELIAS_REVERSE_RESULTS);
        apiToken.setDeparture(DEFAULT_TEST_DEPARTURE_PLACEHOLDER);
        apiToken.setArrival(DEFAULT_TEST_ARRIVAL_PLACEHOLDER);
        apiToken.setLayers(DEFAULT_TEST_PELIAS_LAYERS);
        return apiToken;
    }

    public static ApiToken getPeliasReverseApiToken() {
        ApiToken apiToken = new ApiToken();
        apiToken.setProtocol(PROTOCOL);
        apiToken.setHost(HOST);
        apiToken.setPort(PELIAS_PORT);
        apiToken.setApiVersion(DEFAULT_TEST_PELIAS_API_VERSION);
        apiToken.setMaxResults(DEFAULT_TEST_PELIAS_REVERSE_RESULTS);
        apiToken.setDeparture(DEFAULT_TEST_DEPARTURE_PLACEHOLDER);
        apiToken.setArrival(DEFAULT_TEST_ARRIVAL_PLACEHOLDER);
        apiToken.setLanguage(DEFAULT_TEST_LANGUAGE);
        apiToken.setLayers(DEFAULT_TEST_PELIAS_LAYERS);
        return apiToken;
    }

    // Now here is coming {@link getOpenTripPlannerConfiguredApiToken} {@link getOtpConfiguredFastLaneApiToken}
    // and {@link getOtpConfiguredSlowLaneApiToken} which are used for journey call as well as nearest stations

    public static ApiToken getJourneyOtpFastLaneApiToken() {
        ApiToken apiToken = new ApiToken(getOtpConfiguredFastLaneApiToken());
        apiToken.setLanguage(DEFAULT_TEST_LANGUAGE);
        apiToken.setIsArrivalDateTime(DEFAULT_TEST_IS_ARRIVAL_DATE_TIME);
        apiToken.setDateTime(DEFAULT_TEST_DATE_TIME);
        apiToken.setDeparture(DEFAULT_TEST_DEPARTURE);
        apiToken.setDepartureCoordinate(DEFAULT_TEST_DEPARTURE_COORDINATE);
        apiToken.setArrival(DEFAULT_TEST_ARRIVAL);
        apiToken.setArrivalCoordinate(DEFAULT_TEST_ARRIVAL_COORDINATE);
        return apiToken;
    }

    public static ApiToken getJourneyOtpSlowLaneApiToken() {
        ApiToken apiToken = new ApiToken(getOtpConfiguredSlowLaneApiToken());
        apiToken.setLanguage(DEFAULT_TEST_LANGUAGE);
        apiToken.setIsArrivalDateTime(DEFAULT_TEST_IS_ARRIVAL_DATE_TIME);
        apiToken.setDateTime(DEFAULT_TEST_DATE_TIME);
        apiToken.setDeparture(DEFAULT_TEST_DEPARTURE);
        apiToken.setDepartureCoordinate(DEFAULT_TEST_DEPARTURE_COORDINATE);
        apiToken.setArrival(DEFAULT_TEST_ARRIVAL);
        apiToken.setArrivalCoordinate(DEFAULT_TEST_ARRIVAL_COORDINATE);
        return apiToken;
    }
    // End

    // Start
    // Nearest stations token request chain from stargateService to OpenTripPlanner
    public static ApiToken getNearestStationsUserRequestToken() {
        ApiToken apiToken = new ApiToken();
        apiToken.setArrivalCoordinate(DEFAULT_TEST_DEPARTURE_COORDINATE);
        apiToken.setRadiusInKilometers(DEFAULT_TEST_LONG_RADIUS_IN_KILOMETERS);
        apiToken.setLanguage(DEFAULT_TEST_LANGUAGE);
        return apiToken;
    }

    public static ApiToken getIncorrectNearestStationsUserRequestToken() {
        ApiToken apiToken = new ApiToken();
        apiToken.setArrivalCoordinate(DEFAULT_TEST_INCORRECT_COORDINATE);
        apiToken.setRadiusInKilometers(DEFAULT_TEST_SHORT_RADIUS_IN_KILOMETERS);
        apiToken.setLanguage(DEFAULT_TEST_INCORRECT_LANGUAGE);
        return apiToken;
    }

    public static ApiToken getConfiguredNearestStationsOtpMapperApiToken() {
        ApiToken apiToken = new ApiToken();
        apiToken.setProtocol(PROTOCOL);
        apiToken.setHost(HOST);
        apiToken.setPort(OTP_MAPPER_SERVICE_PORT);
        apiToken.setPath(NEAREST_STATIONS_CONTROLLER_PATH);
        return apiToken;
    }

    public static ApiToken getNearestStationsOtpMapperApiToken() {
        ApiToken apiToken = new ApiToken();
        apiToken.setProtocol(PROTOCOL);
        apiToken.setHost(HOST);
        apiToken.setPort(OTP_MAPPER_SERVICE_PORT);
        apiToken.setPath(NEAREST_STATIONS_CONTROLLER_PATH);
        apiToken.setArrivalCoordinate(DEFAULT_TEST_DEPARTURE_COORDINATE);
        apiToken.setRadiusInKilometers(DEFAULT_TEST_LONG_RADIUS_IN_KILOMETERS);
        apiToken.setLanguage(DEFAULT_TEST_LANGUAGE);
        return apiToken;
    }

    // Now here is coming {@link getOpenTripPlannerConfiguredApiToken} {@link getOtpConfiguredFastLaneApiToken}
    // and {@link getOtpConfiguredSlowLaneApiToken} which are used for journey call as well as nearest stations

    public static ApiToken getNearestStationsOtpFastLaneApiToken() {
        ApiToken apiToken = new ApiToken(getOtpConfiguredFastLaneApiToken());
        apiToken.setArrivalCoordinate(DEFAULT_TEST_DEPARTURE_COORDINATE);
        apiToken.setRadiusInKilometers(DEFAULT_TEST_LONG_RADIUS_IN_KILOMETERS);
        apiToken.setLanguage(DEFAULT_TEST_LANGUAGE);
        return apiToken;
    }

    public static ApiToken getNearestStationsOtpSlowLaneApiToken() {
        ApiToken apiToken = new ApiToken(getOtpConfiguredSlowLaneApiToken());
        apiToken.setArrivalCoordinate(DEFAULT_TEST_DEPARTURE_COORDINATE);
        apiToken.setRadiusInKilometers(DEFAULT_TEST_LONG_RADIUS_IN_KILOMETERS);
        apiToken.setLanguage(DEFAULT_TEST_LANGUAGE);
        return apiToken;
    }

    // Start
    // Both journey call and nearest stations call
    public static ApiToken getOtpConfiguredFastLaneApiToken() {
        ApiToken apiToken = new ApiToken(getOpenTripPlannerConfiguredApiToken());
        apiToken.setPort(OTP_FAST_LANE_PORT);
        apiToken.setRouter(OTP_FAST_LANE_ROUTER);
        return apiToken;
    }

    public static ApiToken getOtpConfiguredSlowLaneApiToken() {
        ApiToken apiToken = new ApiToken(getOpenTripPlannerConfiguredApiToken());
        apiToken.setPort(OTP_SLOW_LANE_PORT);
        apiToken.setRouter(OTP_SLOW_LANE_ROUTER);
        return apiToken;
    }

    private static ApiToken getOpenTripPlannerConfiguredApiToken() {
        ApiToken apiToken = new ApiToken();
        apiToken.setProtocol(PROTOCOL);
        apiToken.setHost(HOST);
        apiToken.setMaxResults(DEFAULT_TEST_MAX_RESULTS);
        return apiToken;
    }
    // End

    // Start
    // Autocomplete Token Request Chain from StargateService to DravelOpsPelias
    public static ApiToken getAutocompleteUserRequestToken() {
        ApiToken apiToken = new ApiToken();
        apiToken.setDeparture(DEFAULT_TEST_DEPARTURE);
        apiToken.setLanguage(DEFAULT_TEST_LANGUAGE);
        return apiToken;
    }

    public static ApiToken getIncorrectAutocompleteUserRequestToken() {
        ApiToken apiToken = new ApiToken();
        apiToken.setDeparture(DEFAULT_TEST_INCORRECT_DEPARTURE);
        apiToken.setLanguage(DEFAULT_TEST_INCORRECT_LANGUAGE);
        return apiToken;
    }

    public static ApiToken getConfiguredAutocompleteBoxServiceApiToken() {
        ApiToken apiToken = new ApiToken();
        apiToken.setProtocol(PROTOCOL);
        apiToken.setHost(HOST);
        apiToken.setPort(BOX_SERVICE_PORT);
        apiToken.setPath(AUTOCOMPLETE_ADDRESSES_CONTROLLER_PATH);
        return apiToken;
    }

    public static ApiToken getAutocompleteBoxServiceApiToken() {
        ApiToken apiToken = new ApiToken();
        apiToken.setProtocol(PROTOCOL);
        apiToken.setHost(HOST);
        apiToken.setPort(BOX_SERVICE_PORT);
        apiToken.setPath(AUTOCOMPLETE_ADDRESSES_CONTROLLER_PATH);
        apiToken.setDeparture(DEFAULT_TEST_DEPARTURE);
        apiToken.setLanguage(DEFAULT_TEST_LANGUAGE);
        return apiToken;
    }

    // Now here is coming {@link getConfiguredPeliasApiToken} which is used for autocomplete call
    // as well as nearest addresses call

    public static ApiToken getPeliasAutocompleteApiToken() {
        ApiToken apiToken = new ApiToken();
        apiToken.setProtocol(PROTOCOL);
        apiToken.setHost(HOST);
        apiToken.setPort(PELIAS_PORT);
        apiToken.setMaxResults(DEFAULT_TEST_MAX_RESULTS);
        apiToken.setLayers(DEFAULT_TEST_PELIAS_LAYERS);
        apiToken.setBox(getStationPersistenceBox());
        apiToken.setApiVersion(DEFAULT_TEST_PELIAS_API_VERSION);
        apiToken.setDeparture(DEFAULT_TEST_DEPARTURE);
        apiToken.setLanguage(DEFAULT_TEST_LANGUAGE);
        return apiToken;
    }
    // End

    // Start
    // Nearest Addresses Token Request Chain from StargateService to DravelOpsPelias
    public static ApiToken getNearestAddressesUserRequestToken() {
        ApiToken apiToken = new ApiToken();
        apiToken.setArrivalCoordinate(DEFAULT_TEST_ARRIVAL_COORDINATE);
        apiToken.setRadiusInKilometers(DEFAULT_TEST_LONG_RADIUS_IN_KILOMETERS);
        apiToken.setLanguage(DEFAULT_TEST_LANGUAGE);
        return apiToken;
    }

    public static ApiToken getIncorrectNearestAddressesUserRequestToken() {
        ApiToken apiToken = new ApiToken();
        apiToken.setArrivalCoordinate(DEFAULT_TEST_INCORRECT_COORDINATE);
        apiToken.setRadiusInKilometers(DEFAULT_TEST_SHORT_RADIUS_IN_KILOMETERS);
        apiToken.setLanguage(DEFAULT_TEST_LANGUAGE);
        return apiToken;
    }

    public static ApiToken getConfiguredNearestAddressesBoxServiceApiToken() {
        ApiToken apiToken = new ApiToken();
        apiToken.setProtocol(PROTOCOL);
        apiToken.setHost(HOST);
        apiToken.setPort(BOX_SERVICE_PORT);
        apiToken.setPath(NEAREST_ADDRESSES_CONTROLLER_PATH);
        return apiToken;
    }

    public static ApiToken getNearestAddressesBoxServiceApiToken() {
        ApiToken apiToken = new ApiToken();
        apiToken.setProtocol(PROTOCOL);
        apiToken.setHost(HOST);
        apiToken.setPort(BOX_SERVICE_PORT);
        apiToken.setPath(NEAREST_ADDRESSES_CONTROLLER_PATH);
        apiToken.setArrivalCoordinate(DEFAULT_TEST_ARRIVAL_COORDINATE);
        apiToken.setRadiusInKilometers(DEFAULT_TEST_LONG_RADIUS_IN_KILOMETERS);
        apiToken.setLanguage(DEFAULT_TEST_LANGUAGE);
        return apiToken;
    }

    // Now here is coming {@link getConfiguredPeliasApiToken} which is used for autocomplete call
    // as well as nearest addresses call

    public static ApiToken getPeliasNearestAddressesApiToken() {
        ApiToken apiToken = new ApiToken();
        apiToken.setProtocol(PROTOCOL);
        apiToken.setHost(HOST);
        apiToken.setPort(PELIAS_PORT);
        apiToken.setMaxResults(DEFAULT_TEST_MAX_RESULTS);
        apiToken.setLayers(DEFAULT_TEST_PELIAS_LAYERS);
        apiToken.setApiVersion(DEFAULT_TEST_PELIAS_API_VERSION);
        apiToken.setArrivalCoordinate(DEFAULT_TEST_ARRIVAL_COORDINATE);
        apiToken.setRadiusInKilometers(DEFAULT_TEST_LONG_RADIUS_IN_KILOMETERS);
        apiToken.setLanguage(DEFAULT_TEST_LANGUAGE);
        return apiToken;
    }
    // End

    // Start
    // Both autocomplete call and nearest addresses call
    public static ApiToken getConfiguredPeliasApiToken() {
        ApiToken apiToken = new ApiToken();
        apiToken.setProtocol(PROTOCOL);
        apiToken.setHost(HOST);
        apiToken.setPort(PELIAS_PORT);
        apiToken.setApiVersion(DEFAULT_TEST_PELIAS_API_VERSION);
        apiToken.setMaxResults(DEFAULT_TEST_MAX_RESULTS);
        apiToken.setLayers(DEFAULT_TEST_PELIAS_LAYERS);
        return apiToken;
    }
    // End

    // HazelcastApiToken
    public static ApiToken getHazelcastApiToken() {
        ApiToken apiToken = new ApiToken();
        apiToken.setMaxPastDaysInCalendar(DEFAULT_TEST_MAX_PAST_DAYS_IN_CALENDAR);
        apiToken.setJourneySearchWindowInMinutes(DEFAULT_TEST_JOURNEY_SEARCH_WINDOW);
        return apiToken;
    }

    // GtfsFileApiToken
    public static ApiToken getSbgGtfsApiToken() {
        ApiToken apiToken = new ApiToken();
        apiToken.setGtfsProvider(DEFAULT_TEST_GTFS_PROVIDER);
        apiToken.setGtfsUrl(DEFAULT_TEST_GTFS_URL);
        apiToken.setHeaders(DEFAULT_TEST_HEADERS);
        return apiToken;
    }

    public static ApiToken getRnvGtfsApiToken() {
        ApiToken apiToken = new ApiToken();
        apiToken.setGtfsProvider("rnv");
        apiToken.setGtfsUrl("https://gtfs-sandbox-dds.rnv-online.de/latest/gtfs.zip");
        return apiToken;
    }

    public static ApiToken getConfiguredTravelPointPersistenceApiToken() {
        ApiToken apiToken = new ApiToken(getConfiguredStationPersistenceApiToken());
        apiToken.setPath("/travelpoints/get");
        return apiToken;
    }

    public static ApiToken getConfiguredPolygonPersistenceApiToken() {
        ApiToken apiToken = new ApiToken(getConfiguredStationPersistenceApiToken());
        apiToken.setPath("/geocoding/get/operatingPolygon");
        return apiToken;
    }

    public static ApiToken getConfiguredBoxPersistenceApiToken() {
        ApiToken apiToken = new ApiToken(getConfiguredStationPersistenceApiToken());
        apiToken.setPath("/geocoding/get/operatingBox");
        apiToken.setRetryTimeInMilliseconds(DEFAULT_TEST_RETRY_TIME_IN_MILLISECONDS);
        return apiToken;
    }

    // Testsoftware
    public static Map<GraphQlTab, ApiToken> getTestSoftwareApiTokens() {
        Map<GraphQlTab, ApiToken> apiTokens = new HashMap<>();

        apiTokens.put(GraphQlTab.JOURNEY_QUERY, getJourneyUserRequestToken());
        apiTokens.put(GraphQlTab.ADDRESS_AUTOCOMPLETION, getAutocompleteUserRequestToken());
        apiTokens.put(GraphQlTab.NEAREST_ADDRESSES, getNearestAddressesUserRequestToken());
        apiTokens.put(GraphQlTab.NEAREST_STATIONS, getNearestStationsUserRequestToken());

        return apiTokens;
    }

    private static ApiToken getConfiguredStationPersistenceApiToken() {
        ApiToken apiToken = new ApiToken();
        apiToken.setProtocol(PROTOCOL);
        apiToken.setHost(HOST);
        apiToken.setPort(STATION_PERSISTENCE_PORT);
        return apiToken;
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
