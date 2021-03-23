package de.blackforestsolutions.dravelopsdatamodel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.geo.Distance;

import java.time.ZonedDateTime;
import java.util.*;

@Getter
@JsonDeserialize(builder = ApiToken.ApiTokenBuilder.class)
public class ApiToken {

    private final String host;
    private final String protocol;
    private final Integer port;
    private final String departure;
    private final Point departureCoordinate;
    private final String arrival;
    private final Point arrivalCoordinate;
    private final ZonedDateTime dateTime;
    private final Boolean isArrivalDateTime;
    private final Locale language;
    private final String router;
    private final Distance radiusInKilometers;
    private final Boolean hasDetails;
    private final Boolean hasReferences;
    private final String path;
    private final Integer maxResults;
    private final String apiVersion;
    private final Box box;
    private final List<String> layers;
    private final Integer maxPastDaysInCalendar;
    private final Integer journeySearchWindowInMinutes;
    private final String gtfsProvider;
    private final String gtfsUrl;
    private final Map<String, String> headers;
    private final Long retryTimeInSeconds;

    private ApiToken(ApiTokenBuilder apiTokenBuilder) {
        this.host = apiTokenBuilder.getHost();
        this.protocol = apiTokenBuilder.getProtocol();
        this.port = apiTokenBuilder.getPort();
        this.departure = apiTokenBuilder.getDeparture();
        this.departureCoordinate = apiTokenBuilder.getDepartureCoordinate();
        this.arrival = apiTokenBuilder.getArrival();
        this.arrivalCoordinate = apiTokenBuilder.getArrivalCoordinate();
        this.dateTime = apiTokenBuilder.getDateTime();
        this.isArrivalDateTime = apiTokenBuilder.getIsArrivalDateTime();
        this.language = apiTokenBuilder.getLanguage();
        this.router = apiTokenBuilder.getRouter();
        this.radiusInKilometers = apiTokenBuilder.getRadiusInKilometers();
        this.hasDetails = apiTokenBuilder.getHasDetails();
        this.hasReferences = apiTokenBuilder.getHasReferences();
        this.path = apiTokenBuilder.getPath();
        this.maxResults = apiTokenBuilder.getMaxResults();
        this.apiVersion = apiTokenBuilder.getApiVersion();
        this.box = apiTokenBuilder.getBox();
        this.layers = apiTokenBuilder.getLayers();
        this.maxPastDaysInCalendar = apiTokenBuilder.getMaxPastDaysInCalendar();
        this.journeySearchWindowInMinutes = apiTokenBuilder.getJourneySearchWindowInMinutes();
        this.gtfsProvider = apiTokenBuilder.getGtfsProvider();
        this.gtfsUrl = apiTokenBuilder.getGtfsUrl();
        this.headers = apiTokenBuilder.getHeaders();
        this.retryTimeInSeconds = apiTokenBuilder.getRetryTimeInSeconds();
    }

    @Setter
    @Getter
    @Accessors(chain = true)
    @JsonPOJOBuilder(withPrefix = "set")
    @NoArgsConstructor
    public static class ApiTokenBuilder {

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

        /**
         * This warning indicates a duplicated code fragment.
         * However, since there are three constructors of different types, one solution would be to create a method with a
         * large number of parameters. Since this leads to NumberParameter violation, I leave it with a constructor.
         * three constructors are also more readable than one method with many params and three constructors calling it.
         *
         * @param apiTokenBuilder to copy to {@link ApiTokenBuilder}
         */
        @SuppressWarnings("CPD-START")
        public ApiTokenBuilder(ApiTokenBuilder apiTokenBuilder) {
            this.host = apiTokenBuilder.getHost();
            this.protocol = apiTokenBuilder.getProtocol();
            this.port = apiTokenBuilder.getPort();
            this.departure = apiTokenBuilder.getDeparture();
            this.departureCoordinate = apiTokenBuilder.getDepartureCoordinate();
            this.arrival = apiTokenBuilder.getArrival();
            this.arrivalCoordinate = apiTokenBuilder.getArrivalCoordinate();
            this.dateTime = apiTokenBuilder.getDateTime();
            this.isArrivalDateTime = apiTokenBuilder.getIsArrivalDateTime();
            this.language = apiTokenBuilder.getLanguage();
            this.router = apiTokenBuilder.getRouter();
            this.radiusInKilometers = apiTokenBuilder.getRadiusInKilometers();
            this.hasDetails = apiTokenBuilder.getHasDetails();
            this.hasReferences = apiTokenBuilder.getHasReferences();
            this.path = apiTokenBuilder.getPath();
            this.maxResults = apiTokenBuilder.getMaxResults();
            this.apiVersion = apiTokenBuilder.getApiVersion();
            this.box = apiTokenBuilder.getBox();
            this.layers = apiTokenBuilder.getLayers();
            this.maxPastDaysInCalendar = apiTokenBuilder.getMaxPastDaysInCalendar();
            this.journeySearchWindowInMinutes = apiTokenBuilder.getJourneySearchWindowInMinutes();
            this.gtfsProvider = apiTokenBuilder.getGtfsProvider();
            this.gtfsUrl = apiTokenBuilder.getGtfsUrl();
            this.headers = apiTokenBuilder.getHeaders();
            this.retryTimeInSeconds = apiTokenBuilder.getRetryTimeInSeconds();
        }

        /**
         * This warning indicates a duplicated code fragment.
         * However, since there are three constructors of different types, one solution would be to create a method with a
         * large number of parameters. Since this leads to NumberParameter violation, I leave it with a constructor.
         * three constructors are also more readable than one method with many params and three constructors calling it.
         *
         * @param apiToken to copy to {@link ApiTokenBuilder}
         */
        @SuppressWarnings("CPD-START")
        public ApiTokenBuilder(ApiToken apiToken) {
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

        public ApiToken build() {
            return new ApiToken(this);
        }

    }

}
