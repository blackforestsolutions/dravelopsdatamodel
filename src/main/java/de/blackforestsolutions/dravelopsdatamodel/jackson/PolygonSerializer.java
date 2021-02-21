package de.blackforestsolutions.dravelopsdatamodel.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.Polygon;

import java.io.IOException;

import static de.blackforestsolutions.dravelopsdatamodel.jackson.JacksonConfiguration.*;

public class PolygonSerializer extends JsonSerializer<Polygon> {

    @Override
    public void serialize(Polygon polygon, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeFieldName(COORDINATES_JSON_FIELD);
        jsonGenerator.writeStartArray();

        writePolygonCoordinates(polygon.getExteriorRing(), jsonGenerator);

        jsonGenerator.writeEndArray();
        jsonGenerator.writeEndObject();
    }

    private void writePolygonCoordinates(LineString ring, JsonGenerator jsonGenerator) throws IOException {
        for (int i = 0; i < ring.getNumPoints(); i++) {
            Point point = ring.getPointN(i);
            writeCoordinate(point, jsonGenerator);
        }
    }

    private void writeCoordinate(Point point, JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField(LONGITUDE_JSON_FIELD, point.getX());
        jsonGenerator.writeNumberField(LATITUDE_JSON_FIELD, point.getY());
        jsonGenerator.writeEndObject();
    }
}
