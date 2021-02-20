package de.blackforestsolutions.dravelopsdatamodel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Getter
@JsonDeserialize(builder = Polygon.PolygonBuilder.class)
public final class Polygon {

    private final List<Point> points;

    private Polygon(PolygonBuilder polygonBuilder) {
        this.points = polygonBuilder.getPoints();
    }

    @Setter
    @Getter
    @Accessors(chain = true)
    @JsonPOJOBuilder(withPrefix = "set")
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class PolygonBuilder {

        private List<Point> points = new LinkedList<>();

        public PolygonBuilder(Point x, Point y, Point z, Point... others) {
            this.points.addAll(Arrays.asList(x, y, z));
            this.points.addAll(Arrays.asList(others));
        }

        public Polygon build() {
            return new Polygon(this);
        }

    }
}
