package de.blackforestsolutions.dravelopsdatamodel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.net.URL;

@Getter
@Slf4j
@JsonDeserialize(builder = TravelProvider.TravelProviderBuilder.class)
public final class TravelProvider implements Serializable {

    private final String name;

    private final URL url;

    /**
     * Copy constructor
     *
     * @param travelProvider you would like to copy
     */
    public TravelProvider(TravelProvider travelProvider) {
        this.name = travelProvider.getName();
        this.url = travelProvider.getUrl();
    }

    private TravelProvider(TravelProvider.TravelProviderBuilder travelProviderBuilder) {
        this.name = travelProviderBuilder.getName();
        this.url = travelProviderBuilder.getUrl();
    }

    @Setter
    @Getter
    @Accessors(chain = true)
    @JsonPOJOBuilder(withPrefix = "set")
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class TravelProviderBuilder {
        private String name;

        private URL url;

        public TravelProvider build() {
            return new TravelProvider(this);
        }
    }
}
