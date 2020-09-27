package de.blackforestsolutions.dravelopsdatamodel.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeSerializer;
import de.blackforestsolutions.dravelopsdatamodel.deserializer.ZonedDateTimeDeserializer;
import org.springframework.data.geo.GeoModule;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DravelOpsJsonMapper {

    private final ObjectMapper mapper;

    public DravelOpsJsonMapper() {
        this.mapper = new ObjectMapper();
        mapper.registerModule(configureTimeModule());
        mapper.registerModule(new GeoModule());
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    public String map(ApiToken apiToken) throws JsonProcessingException {
        ApiTokenDto apiTokenDto = new ApiTokenDto(apiToken);
        return mapper.writeValueAsString(apiTokenDto);
    }

    public ApiToken mapJsonToApiToken(String apiToken) throws JsonProcessingException {
        ApiTokenDto apiTokenDto = mapper.readValue(apiToken, ApiTokenDto.class);
        return new ApiToken.ApiTokenBuilder(apiTokenDto).build();
    }

    private JavaTimeModule configureTimeModule() {
        JavaTimeModule module = new JavaTimeModule();
        module.addSerializer(new ZonedDateTimeSerializer(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
        module.addDeserializer(ZonedDateTime.class, new ZonedDateTimeDeserializer());
        return module;
    }
}
