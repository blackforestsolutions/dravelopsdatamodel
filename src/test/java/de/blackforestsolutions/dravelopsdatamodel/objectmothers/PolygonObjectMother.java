package de.blackforestsolutions.dravelopsdatamodel.objectmothers;

import org.springframework.data.geo.Point;
import org.springframework.data.geo.Polygon;

public class PolygonObjectMother {

    public static Polygon getPolygon() {
        return new Polygon(
                new Point(5.886104100000001d, 50.979022900000004d),
                new Point(8.661455d, 50.579053d),
                new Point(8.258708d, 50.001111d),
                new Point(8.016066d, 49.961436d),
                new Point(6.651751d, 49.75588d)
        );
    }
}
