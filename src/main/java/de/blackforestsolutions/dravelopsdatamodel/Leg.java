package de.blackforestsolutions.dravelopsdatamodel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;

import java.time.Duration;
import java.util.LinkedList;
import java.util.UUID;

@Getter
@Slf4j
@JsonDeserialize(builder = Leg.LegBuilder.class)
public final class Leg {

    private final UUID id;

    private final TravelPoint departure;

    private final TravelPoint arrival;

    private final Duration delay;

    private final Distance distanceInKilometers;

    private final VehicleType vehicleType;

    private final LinkedList<Point> track;

    private final TravelProvider travelProvider;

    private final String vehicleNumber;

    private final String vehicleName;

    private final LinkedList<TravelPoint> intermediateStops;

    private Leg(LegBuilder legBuilder) {
        this.id = legBuilder.getId();
        this.departure = legBuilder.getDeparture();
        this.arrival = legBuilder.getArrival();
        this.delay = legBuilder.getDelay();
        this.distanceInKilometers = legBuilder.getDistanceInKilometers();
        this.vehicleType = legBuilder.getVehicleType();
        this.track = legBuilder.getTrack();
        this.travelProvider = legBuilder.getTravelProvider();
        this.vehicleNumber = legBuilder.getVehicleNumber();
        this.vehicleName = legBuilder.getVehicleName();
        this.intermediateStops = legBuilder.getIntermediateStops();
    }

    public LinkedList<Point> getTrack() {
        if (track != null) {
            return (LinkedList<Point>) track.clone();
        }
        return null;
    }

    public LinkedList<TravelPoint> getIntermediateStops() {
        if (intermediateStops != null) {
            return (LinkedList<TravelPoint>) intermediateStops.clone();
        }
        return null;
    }


    @Setter
    @Getter
    @Accessors(chain = true)
    @JsonPOJOBuilder(withPrefix = "set")
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class LegBuilder {

        private UUID id;

        private TravelPoint departure;

        private TravelPoint arrival;

        private Duration delay;

        private Distance distanceInKilometers;

        private VehicleType vehicleType;

        private LinkedList<Point> track;

        private TravelProvider travelProvider;

        private String vehicleNumber = "";

        private String vehicleName = "";

        private LinkedList<TravelPoint> intermediateStops = new LinkedList<>();

        public LegBuilder(UUID id) {
            this.id = id;
        }

        public Leg build() {
            return new Leg(this);
        }
    }
}
