package de.blackforestsolutions.dravelopsdatamodel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import edu.umd.cs.findbugs.annotations.SuppressWarnings;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Getter
@JsonDeserialize(builder = Journey.JourneyBuilder.class)
public final class Journey implements Serializable {

    private static final long serialVersionUID = 6106269076155338045L;

    private final UUID id;


    /**
     * The mistake indicates a serialization problem with this property.
     * The tests in {@link de.blackforestsolutions.dravelopsdatamodel.util.DravelOpsJsonMapper} prove that the object
     * is serializable and deserializable despite this warning.
     */
    @SuppressWarnings("SE_BAD_FIELD")
    private final LinkedList<Leg> legs;

    /**
     * The mistake indicates a serialization problem with this property.
     * The tests in {@link de.blackforestsolutions.dravelopsdatamodel.util.DravelOpsJsonMapper} prove that the object
     * is serializable and deserializable despite this warning.
     */
    @SuppressWarnings("SE_BAD_FIELD")
    private final LinkedList<Price> prices;

    private Journey(JourneyBuilder journey) {
        this.id = journey.getId();
        this.legs = journey.getLegs();
        this.prices = journey.getPrices();
    }

    public LinkedList<Leg> getLegs() {
        if (legs != null) {
            return (LinkedList<Leg>) legs.clone();
        }
        return null;
    }

    public LinkedList<Price> getPrices() {
        if (prices != null) {
            return (LinkedList<Price>) prices.clone();
        }
        return null;
    }

    @Getter
    @Accessors(chain = true)
    @JsonPOJOBuilder(withPrefix = "set")
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class JourneyBuilder {

        @Setter
        private UUID id;

        private LinkedList<Leg> legs = new LinkedList<>();

        private LinkedList<Price> prices = new LinkedList<>();

        public JourneyBuilder(UUID id) {
            this.id = id;
        }

        public JourneyBuilder setLegs(LinkedList<Leg> legs) {
            this.legs = legs
                    .stream()
                    .filter(distinctByKey(Leg::getId))
                    .collect(Collectors.toCollection(LinkedList::new));

            return this;
        }

        public JourneyBuilder setPrices(LinkedList<Price> prices) {
            this.prices = prices
                    .stream()
                    .filter(distinctByKey(Price::getPriceType))
                    .collect(Collectors.toCollection(LinkedList::new));

            return this;
        }

        public Journey build() {
            return new Journey(this);
        }

        private <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
            Map<Object, Boolean> seen = new ConcurrentHashMap<>();
            return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
        }
    }
}
