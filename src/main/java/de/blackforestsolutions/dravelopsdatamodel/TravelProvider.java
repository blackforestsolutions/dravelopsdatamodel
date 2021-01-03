package de.blackforestsolutions.dravelopsdatamodel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.hazelcast.nio.serialization.Portable;
import com.hazelcast.nio.serialization.PortableReader;
import com.hazelcast.nio.serialization.PortableWriter;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;

import static de.blackforestsolutions.dravelopsdatamodel.hazelcast.DravelOpsPortableFactory.DRAVEL_OPS_FACTORY_ID;
import static de.blackforestsolutions.dravelopsdatamodel.hazelcast.DravelOpsPortableFactory.TRAVEL_PROVIDER_CLASS_ID;
import static de.blackforestsolutions.dravelopsdatamodel.hazelcast.classdefinition.TravelProviderClassDefinition.*;

@Getter
@JsonDeserialize(builder = TravelProvider.TravelProviderBuilder.class)
public final class TravelProvider implements Serializable, Portable {

    private static final long serialVersionUID = -8728155372687060904L;

    private String name;

    private URL url;

    private TravelProvider(TravelProvider.TravelProviderBuilder travelProviderBuilder) {
        this.name = travelProviderBuilder.getName();
        this.url = travelProviderBuilder.getUrl();
    }

    @JsonIgnore
    @Override
    public int getFactoryId() {
        return DRAVEL_OPS_FACTORY_ID;
    }

    @JsonIgnore
    @Override
    public int getClassId() {
        return TRAVEL_PROVIDER_CLASS_ID;
    }

    @Override
    public void writePortable(PortableWriter writer) throws IOException {
        writer.writeUTF(NAME_FIELD, this.name);
        if (this.url != null) {
            writer.writeBoolean(HAS_URL_FIELD, true);
            writer.writeUTF(URL_FIELD, this.url.toString());
        }
    }

    @Override
    public void readPortable(PortableReader reader) throws IOException {
        this.name = reader.readUTF(NAME_FIELD);
        if (reader.readBoolean(HAS_URL_FIELD)) {
            this.url = new URL(reader.readUTF(URL_FIELD));
        }
    }

    @Setter
    @Getter
    @Accessors(chain = true)
    @JsonPOJOBuilder(withPrefix = "set")
    public static class TravelProviderBuilder {

        private String name = "";

        private URL url;

        public TravelProvider build() {
            return new TravelProvider(this);
        }
    }
}
