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

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.UUID;

@Getter
@Slf4j
@JsonDeserialize(builder = Journey.JourneyBuilder.class)
public final class Journey implements Serializable {

    private static final long serialVersionUID = 6106269076155338045L;

    private static final int HASH_CODE_CONSTANT_SEVENTEEN = 17;

    private static final int HASH_CODE_CONSTANT_THIRTY_ONE = 31;

    private final UUID id;

    private final LinkedHashMap<UUID, Leg> legs;

    private final Price price;

    /**
     * Copy Constructor
     *
     * @param journey you would like to copy
     */
    public Journey(Journey journey) {
        this.id = UUID.randomUUID();
        this.legs = journey.getLegs();
        this.price = journey.getPrice();
    }

    private Journey(JourneyBuilder journey) {
        this.id = journey.getId();
        this.legs = journey.getLegs();
        this.price = journey.getPrice();
    }

    /**
     * Checks all first level attributes of an object and tells if there are null values
     *
     * @return if object has null values or not
     */
    public boolean hasNullAttributes() throws IllegalAccessException {
        for (Field attributeToCheck : this.getClass().getDeclaredFields()) {
            if (attributeToCheck.get(this) == null) {
                System.out.println(attributeToCheck.getName() + " is null in journey");
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
                    return true;
                }
            }
        }
        return false;
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
                log.error("Access Error while accessing to TravelPoint", e);
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
        Journey journey = (Journey) o;
        return Objects.equals(id, journey.id)
                &&
                Objects.equals(legs, journey.getLegs())
                &&
                Objects.equals(price, journey.getPrice());
    }

    @Setter
    @Getter
    @Accessors(chain = true)
    @JsonPOJOBuilder(withPrefix = "set")
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class JourneyBuilder {

        private UUID id;

        private LinkedHashMap<UUID, Leg> legs;

        private Price price;

        public JourneyBuilder(UUID id) {
            this.id = id;
        }

        public Journey build() {
            return new Journey(this);
        }
    }
}
