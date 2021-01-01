package de.blackforestsolutions.dravelopsdatamodel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Getter
@JsonDeserialize(builder = TravelPoint.TravelPointBuilder.class)
public final class TravelPoint implements Serializable {

    private static final long serialVersionUID = 6106269076155338045L;

    private final String name;

    private final Point point;

    private final ZonedDateTime arrivalTime;

    private final ZonedDateTime departureTime;

    private final String platform;

    private TravelPoint(TravelPointBuilder travelPointBuilder) {
        this.name = travelPointBuilder.getName();
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

        private Point point;

        private ZonedDateTime arrivalTime;

        private ZonedDateTime departureTime;

        private String platform = "";

        public TravelPoint build() {
            return new TravelPoint(this);
        }
    }
}
