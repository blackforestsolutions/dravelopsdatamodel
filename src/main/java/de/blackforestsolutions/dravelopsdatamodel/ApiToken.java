package de.blackforestsolutions.dravelopsdatamodel;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.ZonedDateTime;
import java.util.Locale;

@Getter
public final class ApiToken {

    private final String host;
    private final String protocol;
    private final int port;
    private final String departure;
    private final String arrival;
    private final ZonedDateTime departureDate;
    private final ZonedDateTime arrivalDate;
    @Getter(AccessLevel.NONE)
    private final boolean isDeparture;
    private final Locale language;
    private final String router;
    private final Optimization optimize;
    private final int radius;
    @Getter(AccessLevel.NONE)
    private final boolean hasDetails;
    @Getter(AccessLevel.NONE)
    private final boolean hasReferences;

    private ApiToken(ApiTokenBuilder apiTokenBuilder) {
        this.host = apiTokenBuilder.getHost();
        this.protocol = apiTokenBuilder.getProtocol();
        this.port = apiTokenBuilder.getPort();
        this.departure = apiTokenBuilder.getDeparture();
        this.arrival = apiTokenBuilder.getArrival();
        this.departureDate = apiTokenBuilder.getDepartureDate();
        this.arrivalDate = apiTokenBuilder.getArrivalDate();
        this.isDeparture = apiTokenBuilder.getIsDeparture();
        this.language = apiTokenBuilder.getLanguage();
        this.router = apiTokenBuilder.getRouter();
        this.optimize = apiTokenBuilder.getOptimize();
        this.radius = apiTokenBuilder.getRadius();
        this.hasDetails = apiTokenBuilder.getHasDetails();
        this.hasReferences = apiTokenBuilder.getHasReferences();
    }

    public boolean getIsDeparture() {
        return this.isDeparture;
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
    @NoArgsConstructor
    public static class ApiTokenBuilder {

        private String host;
        private String protocol;
        private int port = -1;
        private String departure;
        private String arrival;
        private ZonedDateTime departureDate;
        private ZonedDateTime arrivalDate;
        @Setter(AccessLevel.NONE)
        @Getter(AccessLevel.NONE)
        private boolean isDeparture;
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

        @SuppressWarnings("CPD-START")
        public ApiTokenBuilder(ApiToken apiToken) {
            this.host = apiToken.getHost();
            this.protocol = apiToken.getProtocol();
            this.port = apiToken.getPort();
            this.departure = apiToken.getDeparture();
            this.arrival = apiToken.getArrival();
            this.departureDate = apiToken.getDepartureDate();
            this.arrivalDate = apiToken.getArrivalDate();
            this.isDeparture = apiToken.getIsDeparture();
            this.language = apiToken.getLanguage();
            this.router = apiToken.getRouter();
            this.optimize = apiToken.getOptimize();
            this.radius = apiToken.getRadius();
            this.hasDetails = apiToken.getHasDetails();
            this.hasReferences = apiToken.getHasReferences();
        }

        @SuppressWarnings("CPD-START")
        ApiTokenBuilder(ApiTokenDto apiTokenDto) {
            this.host = apiTokenDto.getHost();
            this.protocol = apiTokenDto.getProtocol();
            this.port = apiTokenDto.getPort();
            this.departure = apiTokenDto.getDeparture();
            this.arrival = apiTokenDto.getArrival();
            this.departureDate = apiTokenDto.getDepartureDate();
            this.arrivalDate = apiTokenDto.getArrivalDate();
            this.isDeparture = apiTokenDto.getIsDeparture();
            this.language = apiTokenDto.getLanguage();
            this.router = apiTokenDto.getRouter();
            this.optimize = apiTokenDto.getOptimize();
            this.radius = apiTokenDto.getRadius();
            this.hasDetails = apiTokenDto.getHasDetails();
            this.hasReferences = apiTokenDto.getHasReferences();
        }

        public ApiTokenBuilder setIsDeparture(boolean isDeparture) {
            this.isDeparture = isDeparture;
            return this;
        }

        public boolean getIsDeparture() {
            return this.isDeparture;
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
