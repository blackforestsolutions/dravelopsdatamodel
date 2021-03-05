package de.blackforestsolutions.dravelopsdatamodel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Objects;

@Getter
@JsonDeserialize(builder = Box.BoxBuilder.class)
public final class Box implements Serializable {

    private static final long serialVersionUID = -4958507555911949040L;

    private final Point topLeft;
    private final Point bottomRight;

    private Box(BoxBuilder boxBuilder) {
        this.topLeft = boxBuilder.getTopLeft();
        this.bottomRight = boxBuilder.getBottomRight();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Box that = (Box) o;
        return Objects.equals(topLeft, that.topLeft)
                &&
                Objects.equals(bottomRight, that.bottomRight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topLeft, bottomRight);
    }

    @Setter
    @Getter
    @Accessors(chain = true)
    @JsonPOJOBuilder(withPrefix = "set")
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class BoxBuilder {

        private Point topLeft;
        private Point bottomRight;

        public BoxBuilder(Point topLeft, Point bottomRight) {
            this.topLeft = topLeft;
            this.bottomRight = bottomRight;
        }

        public Box build() {
            return new Box(this);
        }
    }
}
