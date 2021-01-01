package de.blackforestsolutions.dravelopsdatamodel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.util.Locale;

@Getter
@JsonDeserialize(builder = Point.PointBuilder.class)
public final class Point implements Serializable {

    private static final long serialVersionUID = 4347461825329195310L;

    private final double x;
    private final double y;

    private Point(PointBuilder pointBuilder) {
        this.x = pointBuilder.getX();
        this.y = pointBuilder.getY();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        } else if (!(obj instanceof Point)) {
            return false;
        } else {
            Point other = (Point) obj;
            if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.x)) {
                return false;
            } else {
                return Double.doubleToLongBits(this.y) == Double.doubleToLongBits(other.y);
            }
        }
    }

    @Setter
    @Getter
    @Accessors(chain = true)
    @JsonPOJOBuilder(withPrefix = "set")
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
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
