package de.blackforestsolutions.dravelopsdatamodel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.geo.Distance;

import java.io.Serializable;
import java.time.Duration;
import java.util.LinkedList;


@Getter
@JsonDeserialize(builder = Leg.LegBuilder.class)
public final class Leg implements Serializable {

    private static final long serialVersionUID = 5393486245718564673L;

    private final TravelPoint departure;

    private final TravelPoint arrival;

    private final Duration delayInMinutes;

    private final Distance distanceInKilometers;

    private final VehicleType vehicleType;

    private final LinkedList<Point> waypoints;

    private final TravelProvider travelProvider;

    private final String vehicleNumber;

    private final String vehicleName;

    private final LinkedList<TravelPoint> intermediateStops;

    private Leg(LegBuilder legBuilder) {
        this.departure = legBuilder.getDeparture();
        this.arrival = legBuilder.getArrival();
        this.delayInMinutes = legBuilder.getDelayInMinutes();
        this.distanceInKilometers = legBuilder.getDistanceInKilometers();
        this.vehicleType = legBuilder.getVehicleType();
        this.waypoints = legBuilder.getWaypoints();
        this.travelProvider = legBuilder.getTravelProvider();
        this.vehicleNumber = legBuilder.getVehicleNumber();
        this.vehicleName = legBuilder.getVehicleName();
        this.intermediateStops = legBuilder.getIntermediateStops();
    }

    public LinkedList<Point> getWaypoints() {
        if (waypoints != null) {
            return (LinkedList<Point>) waypoints.clone();
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
    @NoArgsConstructor(access = AccessLevel.PUBLIC)
    public static class LegBuilder {

        private TravelPoint departure;

        private TravelPoint arrival;

        private Duration delayInMinutes;

        private Distance distanceInKilometers;

        private VehicleType vehicleType;

        private LinkedList<Point> waypoints = new LinkedList<>();

        private TravelProvider travelProvider;

        private String vehicleNumber = "";

        private String vehicleName = "";

        private LinkedList<TravelPoint> intermediateStops = new LinkedList<>();

        public Leg build() {
            return new Leg(this);
        }
    }
}
