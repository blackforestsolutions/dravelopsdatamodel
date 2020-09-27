package de.blackforestsolutions.dravelopsdatamodel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.Locale;

@Setter(AccessLevel.PACKAGE)
@Getter(AccessLevel.PACKAGE)
final class ApiTokenDto {

    @JsonProperty("host")
    private String host;
    @JsonProperty("protocol")
    private String protocol;
    @JsonProperty("port")
    private int port;
    @JsonProperty("departure")
    private String departure;
    @JsonProperty("arrival")
    private String arrival;
    @JsonProperty("departureDate")
    private ZonedDateTime departureDate;
    @JsonProperty("arrivalDate")
    private ZonedDateTime arrivalDate;
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    @JsonProperty("isDeparture")
    private boolean isDeparture;
    @JsonProperty("language")
    private Locale language;
    @JsonProperty("router")
    private String router;
    @JsonProperty("optimize")
    private Optimization optimize;
    @JsonProperty("radius")
    private int radius;
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    @JsonProperty("hasDetails")
    private boolean hasDetails;
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    @JsonProperty("hasReferences")
    private boolean hasReferences;
    @JsonProperty("path")
    private String path;

    ApiTokenDto() {

    }

    ApiTokenDto(ApiToken apiToken) {
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
        this.path = apiToken.getPath();
    }

    void setIsDeparture(boolean isDeparture) {
        this.isDeparture = isDeparture;
    }

    boolean getIsDeparture() {
        return this.isDeparture;
    }

    void setHasDetails(boolean hasDetails) {
        this.hasDetails = hasDetails;
    }

    boolean getHasDetails() {
        return this.hasDetails;
    }

    void setHasReferences(boolean hasReferences) {
        this.hasReferences = hasReferences;
    }

    boolean getHasReferences() {
        return this.hasReferences;
    }


}
