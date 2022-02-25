package de.blackforestsolutions.dravelopsdatamodel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.DataSerializable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.Objects;
import java.util.Optional;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@JsonDeserialize(builder = TravelProvider.TravelProviderBuilder.class)
public final class TravelProvider implements Serializable, DataSerializable {

    private static final long serialVersionUID = -8728155372687060904L;

    private String id;

    private String name;

    private URL url;

    private TravelProvider(TravelProvider.TravelProviderBuilder travelProviderBuilder) {
        this.id = travelProviderBuilder.getId();
        this.name = travelProviderBuilder.getName();
        this.url = travelProviderBuilder.getUrl();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TravelProvider that = (TravelProvider) o;
        return Objects.equals(id, that.id)
                &&
                Objects.equals(name, that.name)
                &&
                Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, url);
    }

    @Override
    public void writeData(ObjectDataOutput out) throws IOException {
        out.writeUTF(this.id);
        out.writeUTF(this.name);
        if (Optional.ofNullable(this.url).isPresent()) {
            out.writeBoolean(true);
            out.writeUTF(this.url.toString());
        } else {
            out.writeBoolean(false);
        }
    }

    @Override
    public void readData(ObjectDataInput in) throws IOException {
        this.id = in.readUTF();
        this.name = in.readUTF();
        if (in.readBoolean()) {
            this.url = new URL(in.readUTF());
        }
    }


    @Setter
    @Getter
    @Accessors(chain = true)
    @JsonPOJOBuilder(withPrefix = "set")
    public static class TravelProviderBuilder {

        private String id = "";

        private String name = "";

        private URL url;

        public TravelProvider build() {
            return new TravelProvider(this);
        }
    }
}
