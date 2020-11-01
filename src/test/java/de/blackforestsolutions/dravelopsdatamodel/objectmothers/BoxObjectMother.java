package de.blackforestsolutions.dravelopsdatamodel.objectmothers;

import org.springframework.data.geo.Box;
import org.springframework.data.geo.Point;

public class BoxObjectMother {

    public static Box getOpenTripPlannerBox() {
        return new Box(
                new Point(7.593844d, 47.590746d),
                new Point(9.798538d, 49.717617d)
        );
    }

    public static Box getVrsBox() {
        return new Box(
                new Point(5.8629671000000005d, 49.75588d),
                new Point(8.934161d, 52.290127d)
        );
    }

    public static Box getOpenTripPlannerStartBox() {
        return new Box(
                new Point(0d, 0d),
                new Point(0d, 0d)
        );
    }
}
