package de.blackforestsolutions.dravelopsdatamodel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.DataSerializable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;

import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@JsonDeserialize(builder = Leg.LegBuilder.class)
public final class Leg implements Serializable, DataSerializable {

    private static final long serialVersionUID = 5393486245718564673L;

    /**
     * tripId = id from TravelProvider + tripId
     */
    private String tripId;

    private TravelPoint departure;

    private TravelPoint arrival;

    private Distance distanceInKilometers;

    private VehicleType vehicleType;

    private String polyline;

    private LinkedList<Point> waypoints;

    private TravelProvider travelProvider;

    private String vehicleNumber;

    private String vehicleName;

    private LinkedList<TravelPoint> intermediateStops;

    private LinkedList<WalkStep> walkSteps;

    private Leg(LegBuilder legBuilder) {
        this.tripId = legBuilder.getTripId();
        this.departure = legBuilder.getDeparture();
        this.arrival = legBuilder.getArrival();
        this.distanceInKilometers = legBuilder.getDistanceInKilometers();
        this.vehicleType = legBuilder.getVehicleType();
        this.polyline = legBuilder.getPolyline();
        this.waypoints = legBuilder.getWaypoints();
        this.travelProvider = legBuilder.getTravelProvider();
        this.vehicleNumber = legBuilder.getVehicleNumber();
        this.vehicleName = legBuilder.getVehicleName();
        this.intermediateStops = legBuilder.getIntermediateStops();
        this.walkSteps = legBuilder.getWalkSteps();
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

    public LinkedList<WalkStep> getWalkSteps() {
        if (walkSteps != null) {
            return (LinkedList<WalkStep>) walkSteps.clone();
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Leg that = (Leg) o;
        return Objects.equals(departure, that.departure)
                &&
                Objects.equals(arrival, that.arrival)
                &&
                Objects.equals(distanceInKilometers, that.distanceInKilometers)
                &&
                Objects.equals(vehicleType, that.vehicleType)
                &&
                Objects.equals(polyline, that.polyline)
                &&
                Objects.equals(waypoints, that.waypoints)
                &&
                Objects.equals(travelProvider, that.travelProvider)
                &&
                Objects.equals(vehicleNumber, that.vehicleNumber)
                &&
                Objects.equals(vehicleName, that.vehicleName)
                &&
                Objects.equals(intermediateStops, that.intermediateStops)
                &&
                Objects.equals(walkSteps, that.walkSteps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                departure,
                arrival,
                distanceInKilometers,
                vehicleType,
                polyline,
                waypoints,
                travelProvider,
                vehicleNumber,
                vehicleName,
                intermediateStops,
                walkSteps
        );
    }

    @Override
    public void writeData(ObjectDataOutput out) throws IOException {
        out.writeUTF(this.tripId);
        out.writeObject(this.departure);
        out.writeObject(this.arrival);
        if (Optional.ofNullable(this.distanceInKilometers).isPresent()) {
            out.writeBoolean(true);
            out.writeDouble(this.distanceInKilometers.getValue());
        } else {
            out.writeBoolean(false);
        }
        if (Optional.ofNullable(this.vehicleType).isPresent()) {
            out.writeBoolean(true);
            out.writeUTF(this.vehicleType.toString());
        } else {
            out.writeBoolean(false);
        }
        out.writeUTF(this.polyline);
        if (Optional.ofNullable(this.waypoints).isPresent()) {
            out.writeBoolean(true);
            out.writeInt(this.waypoints.size());
            for (Point waypoint : this.waypoints) {
                out.writeObject(waypoint);
            }
        } else {
            out.writeBoolean(false);
        }
        out.writeObject(this.travelProvider);
        out.writeUTF(this.vehicleNumber);
        out.writeUTF(this.vehicleName);
        if (Optional.ofNullable(this.intermediateStops).isPresent()) {
            out.writeBoolean(true);
            out.writeInt(this.intermediateStops.size());
            for (TravelPoint intermediateStop : this.intermediateStops) {
                out.writeObject(intermediateStop);
            }
        } else {
            out.writeBoolean(false);
        }
        if (Optional.ofNullable(this.walkSteps).isPresent()) {
            out.writeBoolean(true);
            out.writeInt(this.walkSteps.size());
            for (WalkStep walkStep : this.walkSteps) {
                out.writeObject(walkStep);
            }
        } else {
            out.writeBoolean(false);
        }
    }

    @Override
    public void readData(ObjectDataInput in) throws IOException {
        this.tripId = in.readUTF();
        this.departure = in.readObject();
        this.arrival = in.readObject();
        if (in.readBoolean()) {
            this.distanceInKilometers = new Distance(in.readDouble(), Metrics.KILOMETERS);
        }
        if (in.readBoolean()) {
            this.vehicleType = VehicleType.valueOf(in.readUTF());
        }
        this.polyline = in.readUTF();
        if (in.readBoolean()) {
            this.waypoints = new LinkedList<>();
            int waypointsSize = in.readInt();
            for (int i = 0; i < waypointsSize; i++) {
                this.waypoints.add(in.readObject());
            }
        }
        this.travelProvider = in.readObject();
        this.vehicleNumber = in.readUTF();
        this.vehicleName = in.readUTF();
        if (in.readBoolean()) {
            this.intermediateStops = new LinkedList<>();
            int intermediateStopsSize = in.readInt();
            for (int i = 0; i < intermediateStopsSize; i++) {
                this.intermediateStops.add(in.readObject());
            }
        }
        if (in.readBoolean()) {
            this.walkSteps = new LinkedList<>();
            int stepsSize = in.readInt();
            for (int i = 0; i < stepsSize; i++) {
                this.walkSteps.add(in.readObject());
            }
        }
    }


    @Setter
    @Getter
    @Accessors(chain = true)
    @JsonPOJOBuilder(withPrefix = "set")
    @NoArgsConstructor(access = AccessLevel.PUBLIC)
    public static class LegBuilder {

        /**
         * tripId = id from TravelProvider + tripId
         */
        private String tripId = "";

        private TravelPoint departure;

        private TravelPoint arrival;

        private Distance distanceInKilometers;

        private VehicleType vehicleType;

        private String polyline;

        private LinkedList<Point> waypoints = new LinkedList<>();

        private TravelProvider travelProvider;

        private String vehicleNumber = "";

        private String vehicleName = "";

        private LinkedList<TravelPoint> intermediateStops = new LinkedList<>();

        private LinkedList<WalkStep> walkSteps = new LinkedList<>();

        public LegBuilder(Leg leg) {
            this.tripId = leg.getTripId();
            this.departure = leg.getDeparture();
            this.arrival = leg.getArrival();
            this.distanceInKilometers = leg.getDistanceInKilometers();
            this.vehicleType = leg.getVehicleType();
            this.polyline = leg.getPolyline();
            this.waypoints = leg.getWaypoints();
            this.travelProvider = leg.getTravelProvider();
            this.vehicleNumber = leg.getVehicleNumber();
            this.vehicleName = leg.getVehicleName();
            this.intermediateStops = leg.getIntermediateStops();
            this.walkSteps = leg.getWalkSteps();
        }

        public Leg build() {
            return new Leg(this);
        }
    }
}
