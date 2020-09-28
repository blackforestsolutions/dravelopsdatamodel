package de.blackforestsolutions.dravelopsdatamodel.objectmothers;

import de.blackforestsolutions.dravelopsdatamodel.TravelPoint;
import org.springframework.data.geo.Point;

import java.time.LocalDateTime;

public class TravelPointObjectMother {

    public static TravelPoint getTravelPointWithNoEmptyFields() {
        return new TravelPoint.TravelPointBuilder()
                .setName("Furtwangen")
                .setCoordinates(new Point(48.052590d, 8.207245d))
                .setArrivalTime(LocalDateTime.parse("2020-09-27T10:15:30"))
                .setDepartureTime(LocalDateTime.parse("2020-09-27T10:15:30"))
                .setPlatform("1")
                .build();
    }
}
