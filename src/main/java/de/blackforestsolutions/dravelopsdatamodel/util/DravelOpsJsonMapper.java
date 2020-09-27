package de.blackforestsolutions.dravelopsdatamodel.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeSerializer;
import de.blackforestsolutions.dravelopsdatamodel.deserializer.ZonedDateTimeDeserializer;
import org.springframework.data.geo.GeoModule;
import reactor.core.publisher.Mono;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DravelOpsJsonMapper {

    private final ObjectMapper mapper;

    public DravelOpsJsonMapper() {
        this.mapper = new ObjectMapper();
        mapper.registerModule(configureJavaTimeModule());
        mapper.registerModule(new GeoModule());
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    public Mono<String> map(ApiToken apiToken) {
        try {
            ApiTokenDto apiTokenDto = new ApiTokenDto(apiToken);
            return Mono.just(mapper.writeValueAsString(apiTokenDto));
        } catch (JsonProcessingException e) {
            return Mono.error(e);
        }
    }

    public Mono<ApiToken> mapJsonToApiToken(String json) {
        try {
            ApiTokenDto apiTokenDto = mapper.readValue(json, ApiTokenDto.class);
            return Mono.just(new ApiToken.ApiTokenBuilder(apiTokenDto).build());
        } catch (JsonProcessingException e) {
            return Mono.error(e);
        }
    }

    private JavaTimeModule configureJavaTimeModule() {
        JavaTimeModule module = new JavaTimeModule();
        module.addSerializer(new ZonedDateTimeSerializer(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
        module.addDeserializer(ZonedDateTime.class, new ZonedDateTimeDeserializer());
        return module;
    }
}
