package de.blackforestsolutions.dravelopsdatamodel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.hazelcast.nio.serialization.Portable;
import com.hazelcast.nio.serialization.PortableReader;
import com.hazelcast.nio.serialization.PortableWriter;
import de.blackforestsolutions.dravelopsdatamodel.util.DravelOpsJsonMapper;
import edu.umd.cs.findbugs.annotations.SuppressWarnings;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.Locale;

import static de.blackforestsolutions.dravelopsdatamodel.hazelcast.DravelOpsPortableFactory.DRAVEL_OPS_FACTORY_ID;
import static de.blackforestsolutions.dravelopsdatamodel.hazelcast.DravelOpsPortableFactory.JOURNEY_CLASS_ID;
import static de.blackforestsolutions.dravelopsdatamodel.hazelcast.classdefinition.JourneyClassDefinition.*;

@Getter
@JsonDeserialize(builder = Journey.JourneyBuilder.class)
public final class Journey implements Serializable, Portable {

    private static final long serialVersionUID = 6106269076155338045L;

    private String id;
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

    @JsonIgnore
    @Override
    public int getFactoryId() {
        return DRAVEL_OPS_FACTORY_ID;
    }

    @JsonIgnore
    @Override
    public int getClassId() {
        return JOURNEY_CLASS_ID;
    }

    @Override
    public void writePortable(PortableWriter writer) throws IOException {
        writer.writeUTF(ID_FIELD, this.id);
        if (this.language != null) {
            writer.writeBoolean(HAS_LANGUAGE_FIELD, true);
            writer.writeUTF(LANGUAGE_FIELD, this.language.getLanguage());
        }
        if (this.legs != null) {
            writer.writeBoolean(HAS_LEGS_FIELD, true);
            writer.writePortableArray(LEGS_FIELD, this.legs.toArray(new Portable[this.legs.size()]));
        }
        if (this.prices != null) {
            writer.writeBoolean(HAS_PRICES_FIELD, true);
            writer.writePortableArray(PRICES_FIELD, this.prices.toArray(new Portable[this.prices.size()]));
        }
    }

    @Override
    public void readPortable(PortableReader reader) throws IOException {
        this.id = reader.readUTF(ID_FIELD);
        if (reader.readBoolean(HAS_LANGUAGE_FIELD)) {
            this.language = new Locale(reader.readUTF(LANGUAGE_FIELD));
        }
        if (reader.readBoolean(HAS_LEGS_FIELD)) {
            Portable[] legs = reader.readPortableArray(LEGS_FIELD);
            for (Portable leg : legs) {
                this.legs.add((Leg) leg);
            }
        } else {
            this.legs = null;
        }
        if (reader.readBoolean(HAS_PRICES_FIELD)) {
            Portable[] prices = reader.readPortableArray(PRICES_FIELD);
            for (Portable price : prices) {
                this.prices.add((Price) price);
            }
        } else {
            this.prices = null;
        }
    }

    @Setter
    @Getter
    @Accessors(chain = true)
    @JsonPOJOBuilder(withPrefix = "set")
    public static class JourneyBuilder implements Serializable {

        private static final long serialVersionUID = 2562545155672883922L;

        @JsonIgnore
        private String id;

        private Locale language;

        private LinkedList<Leg> legs = new LinkedList<>();

        private LinkedList<Price> prices = new LinkedList<>();

        public JourneyBuilder() {
        }

        public Journey build() throws IOException {
            this.id = createSha1Id();
            return new Journey(this);
        }

        private String createSha1Id() throws IOException {
            DravelOpsJsonMapper jsonMapper = new DravelOpsJsonMapper();
            return DigestUtils.sha1Hex(jsonMapper.writeValueAsString(this));
        }

    }
}
