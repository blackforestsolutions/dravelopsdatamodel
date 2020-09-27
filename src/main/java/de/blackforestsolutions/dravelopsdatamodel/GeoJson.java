package de.blackforestsolutions.dravelopsdatamodel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.geo.Point;

import java.io.Serializable;
import java.util.LinkedList;

@Getter
@JsonDeserialize(builder = GeoJson.GeoJsonBuilder.class)
public final class GeoJson implements Serializable {

    private static final long serialVersionUID = -2529427008797565631L;

    private final String type;

    private final LinkedList<Point> coordinates;

    /**
     * Copy constructor
     *
     * @param geoJson you would like to copy
     */
    public GeoJson(GeoJson geoJson) {
        this.coordinates = geoJson.getCoordinates();
        this.type = geoJson.getType();
    }

    private GeoJson(GeoJson.GeoJsonBuilder geoJsonBuilder) {
        this.coordinates = geoJsonBuilder.getCoordinates();
        this.type = geoJsonBuilder.getType();
    }

    @Getter
    @Setter
    @JsonPOJOBuilder(withPrefix = "set")
    @Accessors(chain = true)
    public static class GeoJsonBuilder {

        private String type;

        private LinkedList<Point> coordinates;

        public GeoJson build() {
            return new GeoJson(this);
        }

    }
}