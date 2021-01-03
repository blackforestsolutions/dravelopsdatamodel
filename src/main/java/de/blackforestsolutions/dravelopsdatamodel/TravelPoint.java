package de.blackforestsolutions.dravelopsdatamodel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.hazelcast.nio.serialization.Portable;
import com.hazelcast.nio.serialization.PortableReader;
import com.hazelcast.nio.serialization.PortableWriter;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.IOException;
import java.io.Serializable;
import java.time.ZonedDateTime;

import static de.blackforestsolutions.dravelopsdatamodel.hazelcast.DravelOpsPortableFactory.DRAVEL_OPS_FACTORY_ID;
import static de.blackforestsolutions.dravelopsdatamodel.hazelcast.DravelOpsPortableFactory.TRAVEL_POINT_CLASS_ID;
import static de.blackforestsolutions.dravelopsdatamodel.hazelcast.classdefinition.TravelPointClassDefinition.*;

@Getter
@JsonDeserialize(builder = TravelPoint.TravelPointBuilder.class)
public final class TravelPoint implements Serializable, Portable {

    private static final long serialVersionUID = 6106269076155338045L;

    private String name;

    private Point point;

    private ZonedDateTime arrivalTime;

    private ZonedDateTime departureTime;

    private String platform;

    private TravelPoint(TravelPointBuilder travelPointBuilder) {
        this.name = travelPointBuilder.getName();
        this.point = travelPointBuilder.getPoint();
        this.arrivalTime = travelPointBuilder.getArrivalTime();
        this.departureTime = travelPointBuilder.getDepartureTime();
        this.platform = travelPointBuilder.getPlatform();
    }

    @JsonIgnore
    @Override
    public int getFactoryId() {
        return DRAVEL_OPS_FACTORY_ID;
    }

    @JsonIgnore
    @Override
    public int getClassId() {
        return TRAVEL_POINT_CLASS_ID;
    }

    @Override
    public void writePortable(PortableWriter writer) throws IOException {
        writer.writeUTF(NAME_FIELD, this.name);
        writer.writePortable(POINT_FIELD, this.point);
        if (this.arrivalTime != null) {
            writer.writeBoolean(HAS_ARRIVAL_TIME_FIELD, true);
            writer.writeUTF(ARRIVAL_TIME_FIELD, this.arrivalTime.toString());
        }
        if (this.departureTime != null) {
            writer.writeBoolean(HAS_DEPARTURE_TIME_FIELD, true);
            writer.writeUTF(DEPARTURE_TIME_FIELD, this.departureTime.toString());
        }
        writer.writeUTF(PLATFORM_FIELD, this.platform);
    }

    @Override
    public void readPortable(PortableReader reader) throws IOException {
        this.name = reader.readUTF(NAME_FIELD);
        this.point = reader.readPortable(POINT_FIELD);
        if (reader.readBoolean(HAS_ARRIVAL_TIME_FIELD)) {
            this.arrivalTime = ZonedDateTime.parse(reader.readUTF(ARRIVAL_TIME_FIELD));
        }
        if (reader.readBoolean(HAS_DEPARTURE_TIME_FIELD)) {
            this.departureTime = ZonedDateTime.parse(reader.readUTF(DEPARTURE_TIME_FIELD));
        }
        this.platform = reader.readUTF(PLATFORM_FIELD);
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
