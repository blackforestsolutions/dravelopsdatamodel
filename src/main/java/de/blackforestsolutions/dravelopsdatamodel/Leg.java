package de.blackforestsolutions.dravelopsdatamodel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.hazelcast.nio.serialization.Portable;
import com.hazelcast.nio.serialization.PortableReader;
import com.hazelcast.nio.serialization.PortableWriter;
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

import static de.blackforestsolutions.dravelopsdatamodel.hazelcast.DravelOpsPortableFactory.DRAVEL_OPS_FACTORY_ID;
import static de.blackforestsolutions.dravelopsdatamodel.hazelcast.DravelOpsPortableFactory.LEG_CLASS_ID;
import static de.blackforestsolutions.dravelopsdatamodel.hazelcast.classdefinition.LegClassDefinition.*;

@Getter
@JsonDeserialize(builder = Leg.LegBuilder.class)
public final class Leg implements Serializable, Portable {

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

    @JsonIgnore
    @Override
    public int getFactoryId() {
        return DRAVEL_OPS_FACTORY_ID;
    }

    @JsonIgnore
    @Override
    public int getClassId() {
        return LEG_CLASS_ID;
    }

    @Override
    public void writePortable(PortableWriter writer) throws IOException {
        writer.writePortable(DEPARTURE_FIELD, this.departure);
        writer.writePortable(ARRIVAL_FIELD, this.arrival);
        if (this.delayInMinutes != null) {
            writer.writeBoolean(HAS_DELAY_IN_MINUTES_FIELD, true);
            writer.writeLong(DELAY_IN_MINUTES_FIELD, this.delayInMinutes.toMinutes());
        }
        if (this.distanceInKilometers != null) {
            writer.writeBoolean(HAS_DISTANCE_IN_KILOMETERS_FIELD, true);
            writer.writeDouble(DISTANCE_IN_KILOMETERS_FIELD, this.distanceInKilometers.getValue());
        }
        if (this.vehicleType != null) {
            writer.writeBoolean(HAS_VEHICLE_TYPE_FIELD, true);
            writer.writeUTF(VEHICLE_TYPE_FIELD, this.vehicleType.toString());
        }
        if (this.waypoints != null) {
            writer.writeBoolean(HAS_WAYPOINTS_FIELD, true);
            writer.writePortableArray(WAYPOINTS_FIELD, this.waypoints.toArray(new Portable[waypoints.size()]));
        }
        writer.writePortable(TRAVEL_PROVIDER_FIELD, this.travelProvider);
        writer.writeUTF(VEHICLE_NUMBER_FIELD, this.vehicleNumber);
        writer.writeUTF(VEHICLE_NAME_FIELD, this.vehicleName);
        if (this.intermediateStops != null) {
            writer.writeBoolean(HAS_INTERMEDIATE_STOPS_FIELD, true);
            writer.writePortableArray(INTERMEDIATE_STOPS_FIELD, this.intermediateStops.toArray(new Portable[intermediateStops.size()]));
        }
    }

    @Override
    public void readPortable(PortableReader reader) throws IOException {
        this.departure = reader.readPortable(DEPARTURE_FIELD);
        this.arrival = reader.readPortable(ARRIVAL_FIELD);
        if (reader.readBoolean(HAS_DELAY_IN_MINUTES_FIELD)) {
            this.delayInMinutes = Duration.ofMinutes(reader.readLong(DELAY_IN_MINUTES_FIELD));
        }
        if (reader.readBoolean(HAS_DISTANCE_IN_KILOMETERS_FIELD)) {
            this.distanceInKilometers = new Distance(reader.readDouble(DISTANCE_IN_KILOMETERS_FIELD), Metrics.KILOMETERS);
        }
        if (reader.readBoolean(HAS_VEHICLE_TYPE_FIELD)) {
            this.vehicleType = VehicleType.valueOf(reader.readUTF(VEHICLE_TYPE_FIELD));
        }
        if (reader.readBoolean(HAS_WAYPOINTS_FIELD)) {
            Portable[] waypoints = reader.readPortableArray(WAYPOINTS_FIELD);
            for (Portable waypoint : waypoints) {
                this.waypoints.add((Point) waypoint);
            }
        } else {
            this.waypoints = null;
        }
        this.travelProvider = reader.readPortable(TRAVEL_PROVIDER_FIELD);
        this.vehicleNumber = reader.readUTF(VEHICLE_NUMBER_FIELD);
        this.vehicleName = reader.readUTF(VEHICLE_NAME_FIELD);
        if (reader.readBoolean(HAS_INTERMEDIATE_STOPS_FIELD)) {
            Portable[] intermediateStops = reader.readPortableArray(INTERMEDIATE_STOPS_FIELD);
            for (Portable intermediateStop : intermediateStops) {
                this.intermediateStops.add((TravelPoint) intermediateStop);
            }
        } else {
            this.intermediateStops = null;
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
