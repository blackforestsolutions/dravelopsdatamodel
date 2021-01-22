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


@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@JsonDeserialize(builder = Point.PointBuilder.class)
public final class Point implements Serializable, DataSerializable {

    private static final long serialVersionUID = 4347461825329195310L;

    private double x;
    private double y;

    private Point(PointBuilder pointBuilder) {
        this.x = pointBuilder.getX();
        this.y = pointBuilder.getY();
    }

    @Override
    public void writeData(ObjectDataOutput out) throws IOException {
        out.writeDouble(this.x);
        out.writeDouble(this.y);
    }

    @Override
    public void readData(ObjectDataInput in) throws IOException {
        this.x = in.readDouble();
        this.y = in.readDouble();
    }


    @Setter
    @Getter
    @Accessors(chain = true)
    @JsonPOJOBuilder(withPrefix = "set")
    @NoArgsConstructor
    public static class PointBuilder {

        private double x;

        private double y;

        public PointBuilder(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public Point build() {
            return new Point(this);
        }

    }

}
