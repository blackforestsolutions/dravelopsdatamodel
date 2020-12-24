package de.blackforestsolutions.dravelopsdatamodel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.geo.Point;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Locale;

@Getter
@Slf4j
@JsonDeserialize(builder = TravelPoint.TravelPointBuilder.class)
public final class TravelPoint implements Serializable {

    private static final long serialVersionUID = 6106269076155338045L;

    private final String name;

    private final String town;

    private final String country;

    private final Point point;

    private final ZonedDateTime arrivalTime;

    private final ZonedDateTime departureTime;

    private final String platform;

    private TravelPoint(TravelPointBuilder travelPointBuilder) {
        this.name = travelPointBuilder.getName();
        this.town = travelPointBuilder.getTown();
        this.country = travelPointBuilder.getCountry();
        this.point = travelPointBuilder.getPoint();
        this.arrivalTime = travelPointBuilder.getArrivalTime();
        this.departureTime = travelPointBuilder.getDepartureTime();
        this.platform = travelPointBuilder.getPlatform();
    }


    @Setter
    @Getter
    @Accessors(chain = true)
    @JsonPOJOBuilder(withPrefix = "set")
    public static class TravelPointBuilder {

        private String name = "";

        private String town = "";

        private String country = "";

        private Point point;

        private ZonedDateTime arrivalTime;

        private ZonedDateTime departureTime;

        private String platform = "";

        public TravelPoint build() {
            return new TravelPoint(this);
        }
    }
}
