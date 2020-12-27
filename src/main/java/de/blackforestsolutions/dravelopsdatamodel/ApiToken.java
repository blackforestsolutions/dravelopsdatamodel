package de.blackforestsolutions.dravelopsdatamodel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.geo.Box;
import org.springframework.data.geo.Point;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Locale;

@Getter
@JsonDeserialize(builder = ApiToken.ApiTokenBuilder.class)
public final class ApiToken {

    private final String host;
    private final String protocol;
    private final int port;
    private final String departure;
    private final Point departureCoordinate;
    private final String arrival;
    private final Point arrivalCoordinate;
    private final ZonedDateTime dateTime;
    @Getter(AccessLevel.NONE)
    private final boolean isArrivalDateTime;
    private final Locale language;
    private final String router;
    private final Optimization optimize;
    private final int radius;
    @Getter(AccessLevel.NONE)
    private final boolean hasDetails;
    @Getter(AccessLevel.NONE)
    private final boolean hasReferences;
    private final String path;
    private final Integer maxResults;
    private final String apiVersion;
    private final Box box;
    private final List<String> layers;
    private final int maxPastDaysInCalendar;
    private final int hazelcastTimeRangeInMinutes;

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
        this.optimize = apiTokenBuilder.getOptimize();
        this.radius = apiTokenBuilder.getRadius();
        this.hasDetails = apiTokenBuilder.getHasDetails();
        this.hasReferences = apiTokenBuilder.getHasReferences();
        this.path = apiTokenBuilder.getPath();
        this.maxResults = apiTokenBuilder.getMaxResults();
        this.apiVersion = apiTokenBuilder.getApiVersion();
        this.box = apiTokenBuilder.getBox();
        this.layers = apiTokenBuilder.getLayers();
        this.maxPastDaysInCalendar = apiTokenBuilder.getMaxPastDaysInCalendar();
        this.hazelcastTimeRangeInMinutes = apiTokenBuilder.getHazelcastTimeRangeInMinutes();
    }

    public boolean getIsArrivalDateTime() {
        return this.isArrivalDateTime;
    }

    public boolean getHasDetails() {
        return this.hasDetails;
    }

    public boolean getHasReferences() {
        return this.hasReferences;
    }

    @Setter
    @Getter
    @Accessors(chain = true)
    @JsonPOJOBuilder(withPrefix = "set")
    @NoArgsConstructor
    public static class ApiTokenBuilder {

        private String host;
        private String protocol;
        private int port = -1;
        private String departure;
        private Point departureCoordinate;
        private String arrival;
        private Point arrivalCoordinate;
        private ZonedDateTime dateTime;
        @Setter(AccessLevel.NONE)
        @Getter(AccessLevel.NONE)
        private boolean isArrivalDateTime;
        private Locale language;
        private String router;
        private Optimization optimize;
        private int radius;
        @Setter(AccessLevel.NONE)
        @Getter(AccessLevel.NONE)
        private boolean hasDetails = true;
        @Setter(AccessLevel.NONE)
        @Getter(AccessLevel.NONE)
        private boolean hasReferences = true;
        private String path;
        private Integer maxResults;
        private String apiVersion;
        private Box box;
        private List<String> layers;
        private int maxPastDaysInCalendar;
        private int hazelcastTimeRangeInMinutes;

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
            this.optimize = apiTokenBuilder.getOptimize();
            this.radius = apiTokenBuilder.getRadius();
            this.hasDetails = apiTokenBuilder.getHasDetails();
            this.hasReferences = apiTokenBuilder.getHasReferences();
            this.path = apiTokenBuilder.getPath();
            this.maxResults = apiTokenBuilder.getMaxResults();
            this.apiVersion = apiTokenBuilder.getApiVersion();
            this.box = apiTokenBuilder.getBox();
            this.layers = apiTokenBuilder.getLayers();
            this.maxPastDaysInCalendar = apiTokenBuilder.getMaxPastDaysInCalendar();
            this.hazelcastTimeRangeInMinutes = apiTokenBuilder.getHazelcastTimeRangeInMinutes();
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
            this.optimize = apiToken.getOptimize();
            this.radius = apiToken.getRadius();
            this.hasDetails = apiToken.getHasDetails();
            this.hasReferences = apiToken.getHasReferences();
            this.path = apiToken.getPath();
            this.maxResults = apiToken.getMaxResults();
            this.apiVersion = apiToken.getApiVersion();
            this.box = apiToken.getBox();
            this.layers = apiToken.getLayers();
            this.maxPastDaysInCalendar = apiToken.getMaxPastDaysInCalendar();
            this.hazelcastTimeRangeInMinutes = apiToken.getHazelcastTimeRangeInMinutes();
        }

        public ApiTokenBuilder setIsArrivalDateTime(boolean isArrivalDateTime) {
            this.isArrivalDateTime = isArrivalDateTime;
            return this;
        }

        public boolean getIsArrivalDateTime() {
            return this.isArrivalDateTime;
        }

        public ApiTokenBuilder setHasDetails(boolean hasDetails) {
            this.hasDetails = hasDetails;
            return this;
        }

        public boolean getHasDetails() {
            return this.hasDetails;
        }

        public ApiTokenBuilder setHasReferences(boolean hasReferences) {
            this.hasReferences = hasReferences;
            return this;
        }

        public boolean getHasReferences() {
            return this.hasReferences;
        }

        public ApiToken build() {
            return new ApiToken(this);
        }

    }

}
