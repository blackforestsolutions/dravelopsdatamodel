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

import java.io.IOException;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@JsonDeserialize(builder = TravelPoint.TravelPointBuilder.class)
public final class TravelPoint implements Serializable, DataSerializable {

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

    @Override
    public void writeData(ObjectDataOutput out) throws IOException {
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
    }

    @Override
    public void readData(ObjectDataInput in) throws IOException {
        this.name = in.readUTF();
        this.point = in.readObject();
        if (in.readBoolean()) {
            this.arrivalTime = ZonedDateTime.parse(in.readUTF());
        }
        if (in.readBoolean()) {
            this.departureTime = ZonedDateTime.parse(in.readUTF());
        }
        this.platform = in.readUTF();
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
