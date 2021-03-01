package de.blackforestsolutions.dravelopsdatamodel.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.locationtech.jts.algorithm.ConvexHull;
import org.locationtech.jts.geom.*;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static de.blackforestsolutions.dravelopsdatamodel.jackson.JacksonConfiguration.*;

public class PolygonDeserializer extends JsonDeserializer<Polygon> {

    private static final GeometryFactory GEOMETRY_FACTORY = new GeometryFactory();

    @Override
    public Polygon deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        Iterator<JsonNode> points = node.get(COORDINATES_JSON_FIELD).elements();
        Geometry[] geometries = extractPointsFrom(points);
        GeometryCollection geometryCollection = new GeometryCollection(geometries, GEOMETRY_FACTORY);

        return (Polygon) new ConvexHull(geometryCollection).getConvexHull();
    }

    private Geometry[] extractPointsFrom(Iterator<JsonNode> coordinates) {
        List<Geometry> points = new LinkedList<>();
        while (coordinates.hasNext()) {
            JsonNode jsonCoordinate = coordinates.next();
            double x = jsonCoordinate.get(LONGITUDE_JSON_FIELD).asDouble();
            double y = jsonCoordinate.get(LATITUDE_JSON_FIELD).asDouble();
            points.add(convertToPoint(x, y));
        }
        return points.toArray(new Geometry[0]);
    }

    private Point convertToPoint(double x, double y) {
        Coordinate coordinate = new Coordinate(x, y);
        return GEOMETRY_FACTORY.createPoint(coordinate);
    }
}
