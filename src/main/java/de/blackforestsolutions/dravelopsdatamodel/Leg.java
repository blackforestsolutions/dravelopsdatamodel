package de.blackforestsolutions.dravelopsdatamodel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.springframework.data.geo.Distance;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.UUID;

@Getter
@Slf4j
@JsonDeserialize(builder = Leg.LegBuilder.class)
public final class Leg implements Serializable {

    private static final long serialVersionUID = 6106269076155338045L;

    private static final int HASH_CODE_CONSTANT_SEVENTEEN = 17;

    private static final int HASH_CODE_CONSTANT_THIRTY_ONE = 31;

    private final UUID id;

    private final TravelPoint departure;

    private final TravelPoint arrival;

    private final LocalDateTime departureTime;

    private final LocalDateTime arrivalTime;

    private final Duration duration;

    private final Duration delay;

    private final Distance distance;

    private final VehicleType vehicleType;

    private final GeoJson track;

    private final WalkStep walkStep;

    private final TravelProvider travelProvider;

    private final String vehicleNumber;

    private final String vehicleName;

    private final LinkedList<TravelPoint> intermediateStops;

    private Leg(LegBuilder legBuilder) {
        this.id = legBuilder.getId();
        this.departure = legBuilder.getDeparture();
        this.arrival = legBuilder.getArrival();
        this.departureTime = legBuilder.getStartTime();
        this.arrivalTime = legBuilder.getArrivalTime();
        this.duration = legBuilder.getDuration();
        this.delay = legBuilder.getDelay();
        this.distance = legBuilder.getDistance();
        this.vehicleType = legBuilder.getVehicleType();
        this.track = legBuilder.getTrack();
        this.walkStep = legBuilder.getWalkStep();
        this.travelProvider = legBuilder.getTravelProvider();
        this.vehicleNumber = legBuilder.getVehicleNumber();
        this.vehicleName = legBuilder.getVehicleName();
        this.intermediateStops = legBuilder.getIntermediateStops();
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
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class LegBuilder {

        private UUID id;

        private TravelPoint departure;

        private TravelPoint arrival;

        private LocalDateTime startTime;

        private LocalDateTime arrivalTime;

        private Duration duration;

        private Duration delay;

        private Distance distance;

        private VehicleType vehicleType;

        private GeoJson track;

        private WalkStep walkStep;

        private TravelProvider travelProvider;

        private String vehicleNumber;

        private String vehicleName;

        private LinkedList<TravelPoint> intermediateStops;

        public Leg build() {
            return new Leg(this);
        }
    }
}
