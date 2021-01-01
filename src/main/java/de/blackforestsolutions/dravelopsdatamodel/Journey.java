package de.blackforestsolutions.dravelopsdatamodel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
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

@Getter
@JsonDeserialize(builder = Journey.JourneyBuilder.class)
public final class Journey implements Serializable {

    private static final long serialVersionUID = 6106269076155338045L;

    private final String id;
    private final Locale language;

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
