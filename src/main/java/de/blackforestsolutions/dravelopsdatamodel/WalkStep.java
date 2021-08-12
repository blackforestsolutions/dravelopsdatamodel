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
import java.util.Objects;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@JsonDeserialize(builder = WalkStep.WalkStepBuilder.class)
public final class WalkStep implements Serializable, DataSerializable {

    private static final long serialVersionUID = -1395475073627476361L;

    private String streetName;

    private Distance distanceInKilometers;

    private Point startPoint;

    private Point endPoint;

    private WalkingDirection walkingDirection;

    private CompassDirection compassDirection;

    private boolean isStreetNameGenerated;

    private boolean isOriginPoint;

    private boolean isDestinationPoint;

    private String circleExit;

    private WalkStep(WalkStepBuilder walkStepBuilder) {
        this.streetName = walkStepBuilder.getStreetName();
        this.distanceInKilometers = walkStepBuilder.getDistanceInKilometers();
        this.startPoint = walkStepBuilder.getStartPoint();
        this.endPoint = walkStepBuilder.getEndPoint();
        this.walkingDirection = walkStepBuilder.getWalkingDirection();
        this.compassDirection = walkStepBuilder.getCompassDirection();
        this.isStreetNameGenerated = walkStepBuilder.isStreetNameGenerated();
        this.isOriginPoint = walkStepBuilder.isOriginPoint();
        this.isDestinationPoint = walkStepBuilder.isDestinationPoint();
        this.circleExit = walkStepBuilder.getCircleExit();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        WalkStep that = (WalkStep) o;
        return Objects.equals(streetName, that.streetName)
                &&
                Objects.equals(distanceInKilometers, that.distanceInKilometers)
                &&
                Objects.equals(startPoint, that.startPoint)
                &&
                Objects.equals(endPoint, that.endPoint)
                &&
                Objects.equals(walkingDirection, that.walkingDirection)
                &&
                Objects.equals(compassDirection, that.compassDirection)
                &&
                Objects.equals(isStreetNameGenerated, that.isStreetNameGenerated)
                &&
                Objects.equals(isOriginPoint, that.isOriginPoint)
                &&
                Objects.equals(isDestinationPoint, that.isDestinationPoint)
                &&
                Objects.equals(circleExit, that.circleExit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                streetName,
                distanceInKilometers,
                startPoint,
                endPoint,
                walkingDirection,
                compassDirection,
                isStreetNameGenerated,
                isOriginPoint,
                isDestinationPoint,
                circleExit
        );
    }

    @Override
    public void writeData(ObjectDataOutput out) throws IOException {
        out.writeUTF(this.streetName);
        if (Optional.ofNullable(this.distanceInKilometers).isPresent()) {
            out.writeBoolean(true);
            out.writeDouble(this.distanceInKilometers.getValue());
        } else {
            out.writeBoolean(false);
        }
        out.writeObject(this.startPoint);
        out.writeObject(this.endPoint);
        if (Optional.ofNullable(this.walkingDirection).isPresent()) {
            out.writeBoolean(true);
            out.writeUTF(this.walkingDirection.toString());
        } else {
            out.writeBoolean(false);
        }
        if (Optional.ofNullable(this.compassDirection).isPresent()) {
            out.writeBoolean(true);
            out.writeUTF(this.compassDirection.toString());
        } else {
            out.writeBoolean(false);
        }
        out.writeBoolean(this.isStreetNameGenerated);
        out.writeBoolean(this.isOriginPoint);
        out.writeBoolean(this.isDestinationPoint);
        out.writeUTF(this.circleExit);
    }

    @Override
    public void readData(ObjectDataInput in) throws IOException {
        this.streetName = in.readUTF();
        if (in.readBoolean()) {
            this.distanceInKilometers = new Distance(in.readDouble(), Metrics.KILOMETERS);
        }
        this.startPoint = in.readObject();
        this.endPoint = in.readObject();
        if (in.readBoolean()) {
            this.walkingDirection = WalkingDirection.valueOf(in.readUTF());
        }
        if (in.readBoolean()) {
            this.compassDirection = CompassDirection.valueOf(in.readUTF());
        }
        this.isStreetNameGenerated = in.readBoolean();
        this.isOriginPoint = in.readBoolean();
        this.isDestinationPoint = in.readBoolean();
        this.circleExit = in.readUTF();
    }

    @Setter
    @Getter
    @Accessors(chain = true)
    @JsonPOJOBuilder(withPrefix = "set")
    @NoArgsConstructor(access = AccessLevel.PUBLIC)
    public static class WalkStepBuilder {

        private String streetName = "";

        private Distance distanceInKilometers;

        private WalkingDirection walkingDirection;

        private CompassDirection compassDirection;

        private Point startPoint;

        private Point endPoint;

        private boolean isStreetNameGenerated;

        private boolean isOriginPoint;

        private boolean isDestinationPoint;

        private String circleExit = "";

        public WalkStepBuilder(WalkStep walkStep) {
            this.streetName = walkStep.getStreetName();
            this.distanceInKilometers = walkStep.getDistanceInKilometers();
            this.walkingDirection = walkStep.getWalkingDirection();
            this.compassDirection = walkStep.getCompassDirection();
            this.startPoint = walkStep.getStartPoint();
            this.endPoint = walkStep.getEndPoint();
            this.isStreetNameGenerated = walkStep.isStreetNameGenerated();
            this.isOriginPoint = walkStep.isOriginPoint();
            this.isDestinationPoint = walkStep.isDestinationPoint();
            this.circleExit = walkStep.getCircleExit();
        }

        public WalkStep build() {
            return new WalkStep(this);
        }
    }
}
