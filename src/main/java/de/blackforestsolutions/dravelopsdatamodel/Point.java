package de.blackforestsolutions.dravelopsdatamodel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.hazelcast.nio.serialization.Portable;
import com.hazelcast.nio.serialization.PortableReader;
import com.hazelcast.nio.serialization.PortableWriter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.IOException;
import java.io.Serializable;

import static de.blackforestsolutions.dravelopsdatamodel.hazelcast.DravelOpsPortableFactory.DRAVEL_OPS_FACTORY_ID;
import static de.blackforestsolutions.dravelopsdatamodel.hazelcast.DravelOpsPortableFactory.POINT_CLASS_ID;
import static de.blackforestsolutions.dravelopsdatamodel.hazelcast.classdefinition.PointClassDefinition.X_FIELD;
import static de.blackforestsolutions.dravelopsdatamodel.hazelcast.classdefinition.PointClassDefinition.Y_FIELD;

@Getter
@JsonDeserialize(builder = Point.PointBuilder.class)
public final class Point implements Serializable, Portable {

    private static final long serialVersionUID = 4347461825329195310L;

    private double x;
    private double y;

    private Point(PointBuilder pointBuilder) {
        this.x = pointBuilder.getX();
        this.y = pointBuilder.getY();
    }

    @JsonIgnore
    @Override
    public int getFactoryId() {
        return DRAVEL_OPS_FACTORY_ID;
    }

    @JsonIgnore
    @Override
    public int getClassId() {
        return POINT_CLASS_ID;
    }

    @Override
    public void writePortable(PortableWriter writer) throws IOException {
        writer.writeDouble(X_FIELD, this.x);
        writer.writeDouble(Y_FIELD, this.y);
    }

    @Override
    public void readPortable(PortableReader reader) throws IOException {
        this.x = reader.readDouble(X_FIELD);
        this.y = reader.readDouble(Y_FIELD);
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
