package de.blackforestsolutions.dravelopsdatamodel.objectmothers;


import de.blackforestsolutions.dravelopsdatamodel.Point;
import de.blackforestsolutions.dravelopsdatamodel.Polygon;

import java.util.List;

public class PolygonObjectMother {

    public static Polygon getPolygonWithNoEmptyFields() {
        return new Polygon.PolygonBuilder(
                getBasePoints().get(0),
                getBasePoints().get(1),
                getBasePoints().get(2),
                new Point.PointBuilder(15.0d, 15.0d).build(),
                new Point.PointBuilder(20.0d, 20.0d).build(),
                new Point.PointBuilder(25.0d, 25.0d).build()
        ).build();
    }
    public static Polygon getPolygonWithMinPoints() {
        return new Polygon.PolygonBuilder(
                getBasePoints().get(0),
                getBasePoints().get(1),
                getBasePoints().get(2)
        ).build();
    }
    
    private static List<Point> getBasePoints() {
        return List.of(
                new Point.PointBuilder(0.0d, 0.0d).build(),
                new Point.PointBuilder(5.0d, 5.0d).build(),
                new Point.PointBuilder(10.0d, 10.0d).build()   
        );
    }

}
