package de.blackforestsolutions.dravelopsdatamodel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.net.URL;


@Getter
@JsonDeserialize(builder = TravelProvider.TravelProviderBuilder.class)
public final class TravelProvider implements Serializable {

    private static final long serialVersionUID = -8728155372687060904L;

    private final String name;

    private final URL url;

    private TravelProvider(TravelProvider.TravelProviderBuilder travelProviderBuilder) {
        this.name = travelProviderBuilder.getName();
        this.url = travelProviderBuilder.getUrl();
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
