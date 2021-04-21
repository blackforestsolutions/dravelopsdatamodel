package de.blackforestsolutions.dravelopsdatamodel.objectmothers;

import de.blackforestsolutions.dravelopsdatamodel.Point;

public class PointObjectMother {

    public static Point getAmGrosshausbergPoint() {
        return new Point.PointBuilder(8.209198d, 48.048381d).build();
    }

    public static Point getSickAgPoint() {
        return new Point.PointBuilder(7.891595d, 48.087517d).build();
    }

    public static Point getStuttgarterStreetPoint() {
        return new Point.PointBuilder(8.674534d, 48.128923d).build();
    }

    public static Point getWrongPoint() {
        return new Point.PointBuilder(-10.0d, -10.0d).build();
    }
}
