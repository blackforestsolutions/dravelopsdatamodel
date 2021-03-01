package de.blackforestsolutions.dravelopsdatamodel.objectmothers;


import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LinearRing;
import org.locationtech.jts.geom.Polygon;
import org.locationtech.jts.geom.impl.CoordinateArraySequence;

public class PolygonObjectMother {

    public static Polygon getPolygonWithNoEmptyFields() {
        return new Polygon(
                getExteriorRing(),
                null,
                new GeometryFactory()
        );
    }

    private static LinearRing getExteriorRing() {
        return new LinearRing(
                new CoordinateArraySequence(buildPolygonCoordinates()),
                new GeometryFactory()
        );
    }

    private static Coordinate[] buildPolygonCoordinates() {
        return new Coordinate[] {
                new Coordinate(0.0d, 0.0d),
                new Coordinate(0.0d, 10.0d),
                new Coordinate(10.0d, 10.0d),
                new Coordinate(10.0d, 0.0d),
                new Coordinate(0.0d, 0.0d)
        };
    }

}
