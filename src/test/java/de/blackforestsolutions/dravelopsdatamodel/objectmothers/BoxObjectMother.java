package de.blackforestsolutions.dravelopsdatamodel.objectmothers;

import de.blackforestsolutions.dravelopsdatamodel.Box;
import de.blackforestsolutions.dravelopsdatamodel.Point;

public class BoxObjectMother {

    private static final double MIN_WGS_84_LONGITUDE = -180.0d;
    private static final double MAX_WGS_84_LONGITUDE = 180.0d;
    private static final double MIN_WGS_84_LATITUDE = -90.0d;
    private static final double MAX_WGS_84_LATITUDE = 90.0d;

    public static Box getBoxWithNoEmptyFields() {
        return new Box.BoxBuilder(
                new Point.PointBuilder(0.0d, 10.0d).build(),
                new Point.PointBuilder(10.d, 0.0d).build()
        ).build();
    }

    public static Box getStationPersistenceBox() {
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

    public static Box getBoxServiceStartBox() {
        return new Box.BoxBuilder(
                new Point.PointBuilder(MIN_WGS_84_LONGITUDE, MAX_WGS_84_LATITUDE).build(),
                new Point.PointBuilder(MAX_WGS_84_LONGITUDE, MIN_WGS_84_LATITUDE).build()
        ).build();
    }
}
