package de.blackforestsolutions.dravelopsdatamodel;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.geo.Distance;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

@Setter
@Getter
@EqualsAndHashCode
public class ApiToken {

    private String host;
    private String protocol;
    private Integer port = -1;
    private String departure;
    private Point departureCoordinate;
    private String arrival;
    private Point arrivalCoordinate;
    private ZonedDateTime dateTime;
    private Boolean isArrivalDateTime;
    private Locale language;
    private String router;
    private Distance radiusInKilometers;
    private Boolean hasDetails;
    private Boolean hasReferences;
    private String path;
    private Integer maxResults;
    private String apiVersion;
    private Box box;
    private LinkedHashMap<Layer, Boolean> layers = new LinkedHashMap<>();
    private Integer maxPastDaysInCalendar;
    private Integer journeySearchWindowInMinutes;
    private String gtfsProvider;
    private String gtfsUrl;
    private Map<String, String> headers = new HashMap<>();
    private Long retryTimeInMilliseconds;
    private String password;
    private String repository;
    private String filepath;

    public ApiToken() {

    }

    public ApiToken(ApiToken apiToken) {
        this.host = apiToken.getHost();
        this.protocol = apiToken.getProtocol();
        this.port = apiToken.getPort();
        this.departure = apiToken.getDeparture();
        this.departureCoordinate = apiToken.getDepartureCoordinate();
        this.arrival = apiToken.getArrival();
        this.arrivalCoordinate = apiToken.getArrivalCoordinate();
        this.dateTime = apiToken.getDateTime();
        this.isArrivalDateTime = apiToken.getIsArrivalDateTime();
        this.language = apiToken.getLanguage();
        this.router = apiToken.getRouter();
        this.radiusInKilometers = apiToken.getRadiusInKilometers();
        this.hasDetails = apiToken.getHasDetails();
        this.hasReferences = apiToken.getHasReferences();
        this.path = apiToken.getPath();
        this.maxResults = apiToken.getMaxResults();
        this.apiVersion = apiToken.getApiVersion();
        this.box = apiToken.getBox();
        this.layers = apiToken.getLayers();
        this.maxPastDaysInCalendar = apiToken.getMaxPastDaysInCalendar();
        this.journeySearchWindowInMinutes = apiToken.getJourneySearchWindowInMinutes();
        this.gtfsProvider = apiToken.getGtfsProvider();
        this.gtfsUrl = apiToken.getGtfsUrl();
        this.headers = apiToken.getHeaders();
        this.retryTimeInMilliseconds = apiToken.getRetryTimeInMilliseconds();
        this.password = apiToken.getPassword();
        this.repository = apiToken.getRepository();
        this.filepath = apiToken.getFilepath();
    }

    public LinkedHashMap<Layer, Boolean> getLayers() {
        if (layers != null) {
            return (LinkedHashMap<Layer, Boolean>) layers.clone();
        }
        return null;
    }
}