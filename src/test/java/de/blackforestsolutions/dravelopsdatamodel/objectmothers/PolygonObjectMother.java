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

    public static Polygon getSbgOperatingArea() {
        return new Polygon(
                getSbgExteriorRing(),
                null,
                new GeometryFactory()
        );
    }

    public static Polygon getHvvOperatingArea() {
        return new Polygon(
                getHvvExteriorRing(),
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
        return new Coordinate[]{
                new Coordinate(0.0d, 0.0d),
                new Coordinate(0.0d, 10.0d),
                new Coordinate(10.0d, 10.0d),
                new Coordinate(10.0d, 0.0d),
                new Coordinate(0.0d, 0.0d)
        };
    }

    private static LinearRing getSbgExteriorRing() {
        return new LinearRing(
                new CoordinateArraySequence(buildSbgPolygonCoordinates()),
                new GeometryFactory()
        );
    }

    private static Coordinate[] buildSbgPolygonCoordinates() {
        return new Coordinate[]{
                new Coordinate(7.699379d, 47.537929d),
                new Coordinate(7.607482d, 47.565715d),
                new Coordinate(7.34954d, 48.073714d),
                new Coordinate(7.349162d, 48.076253d),
                new Coordinate(7.352612d, 48.079932d),
                new Coordinate(7.374396d, 48.091214d),
                new Coordinate(7.722412d, 48.269508d),
                new Coordinate(7.766277d, 48.284717d),
                new Coordinate(8.492754d, 48.371552d),
                new Coordinate(8.850867d, 48.279684d),
                new Coordinate(8.868079d, 48.271439d),
                new Coordinate(9.027188d, 47.775005d),
                new Coordinate(9.01578d, 47.733387d),
                new Coordinate(8.855484d, 47.656017d),
                new Coordinate(8.433312d, 47.568158d),
                new Coordinate(7.699379d, 47.537929d)
        };
    }

    private static LinearRing getHvvExteriorRing() {
        return new LinearRing(
                new CoordinateArraySequence(buildHvvPolygonCoordinates()),
                new GeometryFactory()
        );
    }

    private static Coordinate[] buildHvvPolygonCoordinates() {
        return new Coordinate[]{
                new Coordinate(9.926078590563d, 51.536818622395d),
                new Coordinate(8.813833958308d, 53.083480669832d),
                new Coordinate(8.611938439764d, 53.508599382033d),
                new Coordinate(8.599557252481d, 53.534911948266d),
                new Coordinate(8.310921044198d, 54.906843172932d),
                new Coordinate(9.574676912757d, 54.765199831029d),
                new Coordinate(11.226714204701d, 54.500369899949d),
                new Coordinate(12.131073730255d, 54.078243408456d),
                new Coordinate(12.117897716415d, 53.939184400482d),
                new Coordinate(11.854733497487d, 52.518175065533d),
                new Coordinate(11.788821628861d, 52.393725712042d),
                new Coordinate(11.759540025387d, 52.338463219795d),
                new Coordinate(11.657974729319d, 52.166444610416d),
                new Coordinate(11.626887739718d, 52.130347715987d),
                new Coordinate(9.926078590563d, 51.536818622395d)
        };
    }

}
