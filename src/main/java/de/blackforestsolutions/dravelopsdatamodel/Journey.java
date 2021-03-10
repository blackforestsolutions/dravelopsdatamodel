package de.blackforestsolutions.dravelopsdatamodel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.DataSerializable;
import edu.umd.cs.findbugs.annotations.SuppressWarnings;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.lang.NonNull;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@JsonDeserialize(builder = Journey.JourneyBuilder.class)
public final class Journey implements Serializable, DataSerializable {

    private static final long serialVersionUID = 6106269076155338045L;

    private UUID id;
    private Locale language;

    /**
     * The mistake indicates a serialization problem with this property.
     * The tests in {@link de.blackforestsolutions.dravelopsdatamodel.util.DravelOpsJsonMapper} prove that the object
     * is serializable and deserializable despite this warning.
     */
    @SuppressWarnings("SE_BAD_FIELD")
    private LinkedList<Leg> legs;

    /**
     * The mistake indicates a serialization problem with this property.
     * The tests in {@link de.blackforestsolutions.dravelopsdatamodel.util.DravelOpsJsonMapper} prove that the object
     * is serializable and deserializable despite this warning.
     */
    @SuppressWarnings("SE_BAD_FIELD")
    private LinkedList<Price> prices;

    private Journey(JourneyBuilder journey) {
        this.id = journey.getId();
        this.legs = journey.getLegs();
        this.prices = journey.getPrices();
        this.language = journey.getLanguage();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Journey that = (Journey) o;
        return Objects.equals(language, that.language)
                &&
                Objects.equals(legs, that.legs)
                &&
                Objects.equals(prices, that.prices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(language, legs, prices);
    }

    @Override
    public void writeData(ObjectDataOutput out) throws IOException {
        if (Optional.ofNullable(this.id).isPresent()) {
            out.writeBoolean(true);
            out.writeUTF(this.id.toString());
        } else {
            out.writeBoolean(false);
        }
        if (Optional.ofNullable(this.language).isPresent()) {
            out.writeBoolean(true);
            out.writeUTF(this.language.toLanguageTag());
        } else {
            out.writeBoolean(false);
        }
        if (Optional.ofNullable(this.legs).isPresent()) {
            out.writeBoolean(true);
            out.writeInt(this.legs.size());
            for (Leg leg : this.legs) {
                out.writeObject(leg);
            }
        } else {
            out.writeBoolean(false);
        }
        if (Optional.ofNullable(this.prices).isPresent()) {
            out.writeBoolean(true);
            out.writeInt(this.prices.size());
            for (Price price : this.prices) {
                out.writeObject(price);
            }
        } else {
            out.writeBoolean(false);
        }
    }

    @Override
    public void readData(ObjectDataInput in) throws IOException {
        if (in.readBoolean()) {
            this.id = UUID.fromString(in.readUTF());
        }
        if (in.readBoolean()) {
            this.language = Locale.forLanguageTag(in.readUTF());
        }
        if (in.readBoolean()) {
            this.legs = new LinkedList<>();
            int legsSize = in.readInt();
            for (int i = 0; i < legsSize; i++) {
                this.legs.add(in.readObject());
            }
        }
        if (in.readBoolean()) {
            this.prices = new LinkedList<>();
            int pricesSize = in.readInt();
            for (int i = 0; i < pricesSize; i++) {
                this.prices.add(in.readObject());
            }
        }
    }

    @Setter
    @Getter
    @Accessors(chain = true)
    @JsonPOJOBuilder(withPrefix = "set")
    public static class JourneyBuilder implements Serializable {

        private static final long serialVersionUID = 2562545155672883922L;

        private UUID id;

        private Locale language;

        private LinkedList<Leg> legs = new LinkedList<>();

        private LinkedList<Price> prices = new LinkedList<>();

        private JourneyBuilder() {
        }

        public JourneyBuilder(@NonNull UUID id) {
            this.id = id;
        }

        public JourneyBuilder setId(@NonNull UUID id) {
            this.id = id;
            return this;
        }

        public Journey build() throws IOException {
            return new Journey(this);
        }

    }
}
