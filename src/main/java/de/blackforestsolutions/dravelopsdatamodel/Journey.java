package de.blackforestsolutions.dravelopsdatamodel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.UUID;

@Getter
@JsonDeserialize(builder = Journey.JourneyBuilder.class)
public final class Journey implements Serializable {

    private static final long serialVersionUID = 6106269076155338045L;

    private final UUID id;

    private final LinkedHashMap<UUID, Leg> legs;

    private final HashSet<Price> prices;

    private Journey(JourneyBuilder journey) {
        this.id = journey.getId();
        this.legs = journey.getLegs();
        this.prices = journey.getPrices();
    }

    public LinkedHashMap<UUID, Leg> getLegs() {
        if (legs != null) {
            return (LinkedHashMap<UUID, Leg>) legs.clone();
        }
        return null;
    }

    public HashSet<Price> getPrices() {
        if (prices != null) {
            return (HashSet<Price>) prices.clone();
        }
        return null;
    }

    @Setter
    @Getter
    @Accessors(chain = true)
    @JsonPOJOBuilder(withPrefix = "set")
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class JourneyBuilder {

        private UUID id;

        private LinkedHashMap<UUID, Leg> legs = new LinkedHashMap<>();

        private HashSet<Price> prices = new HashSet<>();

        public JourneyBuilder(UUID id) {
            this.id = id;
        }

        public Journey build() {
            return new Journey(this);
        }
    }
}
