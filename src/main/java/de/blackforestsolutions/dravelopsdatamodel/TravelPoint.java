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
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@JsonDeserialize(builder = TravelPoint.TravelPointBuilder.class)
public final class TravelPoint implements Serializable, DataSerializable {

    private static final long serialVersionUID = 6106269076155338045L;

    /**
     * The stopId is not necessarily unique!
     */
    private String stopId;

    private long stopSequence;

    private String name;

    private Point point;

    private ZonedDateTime arrivalTime;

    private ZonedDateTime departureTime;

    private String platform;

    private Distance distanceInKilometers;

    private TravelPoint(TravelPointBuilder travelPointBuilder) {
        this.stopId = travelPointBuilder.getStopId();
        this.stopSequence = travelPointBuilder.getStopSequence();
        this.name = travelPointBuilder.getName();
        this.point = travelPointBuilder.getPoint();
        this.arrivalTime = travelPointBuilder.getArrivalTime();
        this.departureTime = travelPointBuilder.getDepartureTime();
        this.platform = travelPointBuilder.getPlatform();
        this.distanceInKilometers = travelPointBuilder.getDistanceInKilometers();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TravelPoint that = (TravelPoint) o;
        return Objects.equals(name, that.name)
                &&
                Objects.equals(point, that.point)
                &&
                Objects.equals(arrivalTime, that.arrivalTime)
                &&
                Objects.equals(departureTime, that.departureTime)
                &&
                Objects.equals(platform, that.platform)
                &&
                Objects.equals(distanceInKilometers, that.distanceInKilometers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, point, arrivalTime, departureTime, platform, distanceInKilometers);
    }

    @Override
    public void writeData(ObjectDataOutput out) throws IOException {
        out.writeUTF(this.stopId);
        out.writeLong(this.stopSequence);
        out.writeUTF(this.name);
        out.writeObject(this.point);
        if (Optional.ofNullable(this.arrivalTime).isPresent()) {
            out.writeBoolean(true);
            out.writeUTF(this.arrivalTime.toString());
        } else {
            out.writeBoolean(false);
        }
        if (Optional.ofNullable(this.departureTime).isPresent()) {
            out.writeBoolean(true);
            out.writeUTF(this.departureTime.toString());
        } else {
            out.writeBoolean(false);
        }
        out.writeUTF(this.platform);
        if (Optional.ofNullable(this.distanceInKilometers).isPresent()) {
            out.writeBoolean(true);
            out.writeDouble(this.distanceInKilometers.getValue());
        } else {
            out.writeBoolean(false);
        }
    }

    @Override
    public void readData(ObjectDataInput in) throws IOException {
        this.stopId = in.readUTF();
        this.stopSequence = in.readLong();
        this.name = in.readUTF();
        this.point = in.readObject();
        if (in.readBoolean()) {
            this.arrivalTime = ZonedDateTime.parse(in.readUTF());
        }
        if (in.readBoolean()) {
            this.departureTime = ZonedDateTime.parse(in.readUTF());
        }
        this.platform = in.readUTF();
        if (in.readBoolean()) {
            this.distanceInKilometers = new Distance(in.readDouble(), Metrics.KILOMETERS);
        }
    }


    @Setter
    @Getter
    @Accessors(chain = true)
    @JsonPOJOBuilder(withPrefix = "set")
    public static class TravelPointBuilder {

        /**
         * The stopId is not necessarily unique!
         */
        private String stopId = "";

        private long stopSequence = -1L;

        private String name = "";

        private Point point;

        private ZonedDateTime arrivalTime;

        private ZonedDateTime departureTime;

        private String platform = "";

        private Distance distanceInKilometers;

        public TravelPointBuilder() {
        }

        public TravelPointBuilder(TravelPoint travelPoint) {
            this.stopId = travelPoint.getStopId();
            this.stopSequence = travelPoint.getStopSequence();
            this.name = travelPoint.getName();
            this.point = travelPoint.getPoint();
            this.arrivalTime = travelPoint.getArrivalTime();
            this.departureTime = travelPoint.getDepartureTime();
            this.platform = travelPoint.getPlatform();
            this.distanceInKilometers = travelPoint.getDistanceInKilometers();
        }

        public TravelPoint build() {
            return new TravelPoint(this);
        }
    }
}
