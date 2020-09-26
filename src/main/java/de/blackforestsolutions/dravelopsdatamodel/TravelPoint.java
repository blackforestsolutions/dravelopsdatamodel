package de.blackforestsolutions.dravelopsdatamodel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.springframework.data.geo.Point;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Slf4j
@JsonDeserialize(builder = TravelPoint.TravelPointBuilder.class)
public final class TravelPoint implements Serializable {

    private static final long serialVersionUID = 6106269076155338045L;

    private static final int HASH_CODE_CONSTANT_SEVENTEEN = 17;

    private static final int HASH_CODE_CONSTANT_THIRTY_ONE = 31;

    private final String name;

    private final Point coordinates;

    private final LocalDateTime arrivalTime;

    private final LocalDateTime departureTime;

    private final String platform;

    private final VertexType vertexType;

    /**
     * Copy constructor for travel point.
     *
     * @param travelPoint you would like to copy
     */
    public TravelPoint(TravelPoint travelPoint) {
        this.name = travelPoint.getName();
        this.coordinates = travelPoint.getCoordinates();
        this.arrivalTime = travelPoint.getArrivalTime();
        this.departureTime = travelPoint.getDepartureTime();
        this.platform = travelPoint.getPlatform();
        this.vertexType = travelPoint.getVertexType();
    }

    private TravelPoint(TravelPointBuilder travelPointBuilder) {
        this.name = travelPointBuilder.getName();
        this.coordinates = travelPointBuilder.getCoordinates();
        this.arrivalTime = travelPointBuilder.getArrivalTime();
        this.departureTime = travelPointBuilder.getDepartureTime();
        this.platform = travelPointBuilder.getPlatform();
        this.vertexType = travelPointBuilder.getVertexType();
    }

    @Override
    public int hashCode() {
        HashCodeBuilder hashCodeBuilder = new HashCodeBuilder(HASH_CODE_CONSTANT_SEVENTEEN, HASH_CODE_CONSTANT_THIRTY_ONE);
        for (Field attributeToCheck : this.getClass().getDeclaredFields()) {
            try {
                if (attributeToCheck.get(this) != null) {
                    hashCodeBuilder.append(attributeToCheck.hashCode());
                }
            } catch (IllegalAccessException e) {
                log.error("Access Error while accessing to Travelpoint", e);
            }
        }
        return hashCodeBuilder.toHashCode();
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
                Objects.equals(coordinates, that.coordinates)
                &&
                Objects.equals(platform, that.platform)
                &&
                Objects.equals(departureTime, that.departureTime)
                &&
                Objects.equals(arrivalTime, that.arrivalTime)
                &&
                Objects.equals(vertexType, that.vertexType);
    }

    /**
     * Checks all first level attributes of an object and tells if there are null values
     *
     * @return if object has null values or not
     */
    public boolean hasNullAttributes() throws IllegalAccessException {
        for (Field attributeToCheck : this.getClass().getDeclaredFields()) {
            if (attributeToCheck.get(this) == null) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if an object string field is empty or not
     *
     * @return if object has empty strings or not
     */
    public boolean hasEmptyString() throws IllegalAccessException {
        for (Field attributeToCheck : this.getClass().getDeclaredFields()) {
            if (attributeToCheck.get(this) != null && attributeToCheck.get(this).getClass().toString().equals(String.class.toString())) {
                String value = (String) attributeToCheck.get(this);
                if (StringUtils.isEmpty(value)) {
                    System.out.println(attributeToCheck.getName() + " is empty in TravelPoint");
                    return true;
                }
            }
        }
        return false;
    }

    @Setter
    @Getter
    @Accessors(chain = true)
    @JsonPOJOBuilder(withPrefix = "set")
    public static class TravelPointBuilder {

        private String name;

        private Point coordinates;

        private LocalDateTime arrivalTime;

        private LocalDateTime departureTime;

        private String platform;

        private VertexType vertexType;

        public TravelPoint build() {
            return new TravelPoint(this);
        }
    }
}
