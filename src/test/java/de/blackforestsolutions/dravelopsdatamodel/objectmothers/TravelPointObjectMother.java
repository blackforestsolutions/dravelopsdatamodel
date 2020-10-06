package de.blackforestsolutions.dravelopsdatamodel.objectmothers;

import de.blackforestsolutions.dravelopsdatamodel.TravelPoint;
import org.springframework.data.geo.Point;

import java.time.ZonedDateTime;

public class TravelPointObjectMother {

    public static TravelPoint getTravelPointWithNoEmptyFields() {
        return new TravelPoint.TravelPointBuilder()
                .setName("Furtwangen")
                .setCoordinates(new Point(48.052590d, 8.207245d))
                .setArrivalTime(ZonedDateTime.parse("2020-09-27T10:15:30+02:00"))
                .setDepartureTime(ZonedDateTime.parse("2020-09-27T10:15:30+02:00"))
                .setPlatform("1")
                .build();
    }
}
