package de.blackforestsolutions.dravelopsdatamodel.objectmothers;

import de.blackforestsolutions.dravelopsdatamodel.Box;
import de.blackforestsolutions.dravelopsdatamodel.Point;

public class BoxObjectMother {

    public static Box getBoxWithNoEmptyFields() {
        return new Box.BoxBuilder(
                new Point.PointBuilder(0.0d, 10.0d).build(),
                new Point.PointBuilder(10.d, 0.0d).build()
        ).build();
    }

    public static Box getOpenTripPlannerBox() {
        return new Box.BoxBuilder(
                new Point.PointBuilder(7.593844d, 47.590746d).build(),
                new Point.PointBuilder(9.798538d, 49.717617d).build()
        ).build();
    }

    public static Box getVrsBox() {
        return new Box.BoxBuilder(
                new Point.PointBuilder(5.8629671000000005d, 49.75588d).build(),
                new Point.PointBuilder(8.934161d, 52.290127d).build()
        ).build();
    }

    public static Box getOpenTripPlannerStartBox() {
        return new Box.BoxBuilder(
                new Point.PointBuilder(0.0d, 0.0d).build(),
                new Point.PointBuilder(0.0d, 0.0d).build()
        ).build();
    }
}
