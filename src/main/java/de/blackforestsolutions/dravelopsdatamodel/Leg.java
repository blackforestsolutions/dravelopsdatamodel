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
import java.time.Duration;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@JsonDeserialize(builder = Leg.LegBuilder.class)
public final class Leg implements Serializable, DataSerializable {

    private static final long serialVersionUID = 5393486245718564673L;

    private TravelPoint departure;

    private TravelPoint arrival;

    private Duration delayInMinutes;

    private Distance distanceInKilometers;

    private VehicleType vehicleType;

    private LinkedList<Point> waypoints;

    private TravelProvider travelProvider;

    private String vehicleNumber;

    private String vehicleName;

    private LinkedList<TravelPoint> intermediateStops;

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
                Objects.equals(delayInMinutes, that.delayInMinutes)
                &&
                Objects.equals(distanceInKilometers, that.distanceInKilometers)
                &&
                Objects.equals(vehicleType, that.vehicleType)
                &&
                Objects.equals(waypoints, that.waypoints)
                &&
                Objects.equals(travelProvider, that.travelProvider)
                &&
                Objects.equals(vehicleNumber, that.vehicleNumber)
                &&
                Objects.equals(vehicleName, that.vehicleName)
                &&
                Objects.equals(intermediateStops, that.intermediateStops);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                departure,
                arrival,
                delayInMinutes,
                distanceInKilometers,
                vehicleType,
                waypoints,
                travelProvider,
                vehicleNumber,
                vehicleName,
                intermediateStops
        );
    }

    @Override
    public void writeData(ObjectDataOutput out) throws IOException {
        out.writeObject(this.departure);
        out.writeObject(this.arrival);
        if (Optional.ofNullable(this.delayInMinutes).isPresent()) {
            out.writeBoolean(true);
            out.writeLong(this.delayInMinutes.toMinutes());
        } else {
            out.writeBoolean(false);
        }
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
            for (TravelPoint intermediateStop : intermediateStops) {
                out.writeObject(intermediateStop);
            }
        } else {
            out.writeBoolean(false);
        }
    }

    @Override
    public void readData(ObjectDataInput in) throws IOException {
        this.departure = in.readObject();
        this.arrival = in.readObject();
        if (in.readBoolean()) {
            this.delayInMinutes = Duration.ofMinutes(in.readLong());
        }
        if (in.readBoolean()) {
            this.distanceInKilometers = new Distance(in.readDouble(), Metrics.KILOMETERS);
        }
        if (in.readBoolean()) {
            this.vehicleType = VehicleType.valueOf(in.readUTF());
        }
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
