package de.blackforestsolutions.dravelopsdatamodel;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.geo.Distance;

import java.time.ZonedDateTime;
import java.util.*;

@Setter
@Getter
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
    private List<String> layers = new LinkedList<>();
    private Integer maxPastDaysInCalendar;
    private Integer journeySearchWindowInMinutes;
    private String gtfsProvider;
    private String gtfsUrl;
    private Map<String, String> headers = new HashMap<>();
    private Long retryTimeInSeconds;

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
        this.retryTimeInSeconds = apiToken.getRetryTimeInSeconds();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ApiToken that = (ApiToken) o;
        return Objects.equals(host, that.host)
                &&
                Objects.equals(protocol, that.protocol)
                &&
                Objects.equals(port, that.port)
                &&
                Objects.equals(departure, that.departure)
                &&
                Objects.equals(departureCoordinate, that.departureCoordinate)
                &&
                Objects.equals(arrival, that.arrival)
                &&
                Objects.equals(arrivalCoordinate, that.arrivalCoordinate)
                &&
                Objects.equals(dateTime, that.dateTime)
                &&
                Objects.equals(isArrivalDateTime, that.isArrivalDateTime)
                &&
                Objects.equals(language, that.language)
                &&
                Objects.equals(router, that.router)
                &&
                Objects.equals(radiusInKilometers, that.radiusInKilometers)
                &&
                Objects.equals(hasDetails, that.hasDetails)
                &&
                Objects.equals(hasReferences, that.hasReferences)
                &&
                Objects.equals(path, that.path)
                &&
                Objects.equals(maxResults, that.maxResults)
                &&
                Objects.equals(apiVersion, that.apiVersion)
                &&
                Objects.equals(box, that.box)
                &&
                Objects.equals(layers, that.layers)
                &&
                Objects.equals(maxPastDaysInCalendar, that.maxPastDaysInCalendar)
                &&
                Objects.equals(journeySearchWindowInMinutes, that.journeySearchWindowInMinutes)
                &&
                Objects.equals(gtfsProvider, that.gtfsProvider)
                &&
                Objects.equals(gtfsUrl, that.gtfsUrl)
                &&
                Objects.equals(headers, that.headers)
                &&
                Objects.equals(retryTimeInSeconds, that.retryTimeInSeconds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                host,
                protocol,
                port,
                departure,
                departureCoordinate,
                arrival,
                arrivalCoordinate,
                dateTime,
                isArrivalDateTime,
                language,
                router,
                radiusInKilometers,
                hasDetails,
                hasReferences,
                path,
                maxResults,
                apiVersion,
                box,
                layers,
                maxPastDaysInCalendar,
                journeySearchWindowInMinutes,
                gtfsProvider,
                gtfsUrl,
                headers,
                retryTimeInSeconds
        );
    }
}
