package de.blackforestsolutions.dravelopsdatamodel.objectmothers;

import org.springframework.data.geo.Point;

public class PointObjectMother {

    public static Point getAmGrosshausbergPoint() {
        return new Point(8.209198d, 48.048381d);
    }

    public static Point getSickAgPoint() {
        return new Point(7.891595d, 48.087517d);
    }

    public static Point getStuttgarterStreetPoint() {
        return new Point(8.674534d, 48.128923d);
    }
}
