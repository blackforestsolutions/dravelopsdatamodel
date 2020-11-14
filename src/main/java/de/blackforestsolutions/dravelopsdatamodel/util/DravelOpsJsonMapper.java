package de.blackforestsolutions.dravelopsdatamodel.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeSerializer;
import de.blackforestsolutions.dravelopsdatamodel.deserializer.ZonedDateTimeDeserializer;
import org.springframework.data.geo.GeoModule;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DravelOpsJsonMapper extends ObjectMapper {

    private static final long serialVersionUID = 6106269076155338045L;

    public DravelOpsJsonMapper() {
        super.registerModule(configureJavaTimeModule());
        super.registerModule(new GeoModule());
        super.enable(SerializationFeature.INDENT_OUTPUT);
        super.disable(MapperFeature.DEFAULT_VIEW_INCLUSION);
        super.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        super.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    private JavaTimeModule configureJavaTimeModule() {
        JavaTimeModule module = new JavaTimeModule();
        module.addSerializer(new ZonedDateTimeSerializer(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
        module.addDeserializer(ZonedDateTime.class, new ZonedDateTimeDeserializer());
        return module;
    }
}
