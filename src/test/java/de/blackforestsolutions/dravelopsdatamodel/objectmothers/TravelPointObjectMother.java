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

    public static TravelPoint getGrosshausbergTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setName("Am Großhausberg 8")
                .setCoordinates(new Point(8.209972d, 48.04832d))
                .setDepartureTime(ZonedDateTime.parse("2020-09-30T13:08:13+02:00"))
                .build();
    }

    public static TravelPoint getFurtwangenIlbenstreetTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setName("Furtwangen Ilbenstraße")
                .setCoordinates(new Point(8.198995d, 48.047922d))
                .setArrivalTime(ZonedDateTime.parse("2020-09-30T13:20:59+02:00"))
                .setDepartureTime(ZonedDateTime.parse("2020-09-30T13:21+02:00"))
                .build();
    }

    public static TravelPoint getBleibachSevTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setName("Bleibach SEV")
                .setCoordinates(new Point(7.998644d, 48.127233d))
                .setArrivalTime(ZonedDateTime.parse("2020-09-30T14:05+02:00"))
                .setDepartureTime(ZonedDateTime.parse("2020-09-30T14:12+02:00"))
                .build();
    }

    public static TravelPoint getGuetenbachTownHallTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setName("Gütenbach Rathaus")
                .setCoordinates(new Point(8.138826d, 48.044378d))
                .setArrivalTime(ZonedDateTime.parse("2020-09-30T13:31+02:00"))
                .setDepartureTime(ZonedDateTime.parse("2020-09-30T13:31+02:00"))
                .build();
    }

    public static TravelPoint getSimonswaldTownHallTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setName("Simonswald Rathaus")
                .setCoordinates(new Point(8.056936d, 48.100225d))
                .setArrivalTime(ZonedDateTime.parse("2020-09-30T13:52+02:00"))
                .setDepartureTime(ZonedDateTime.parse("2020-09-30T13:52+02:00"))
                .build();
    }

    public static TravelPoint getWaldkirchKastelberghalleTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setName("Waldkirch Kastelberghalle")
                .setCoordinates(new Point(7.952947d, 48.090458d))
                .setArrivalTime(ZonedDateTime.parse("2020-09-30T14:29+02:00"))
                .setDepartureTime(ZonedDateTime.parse("2020-09-30T14:29:01+02:00"))
                .build();
    }

    public static TravelPoint getKollnauTrainStationTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setName("Kollnau Bf (Bus)")
                .setCoordinates(new Point(7.972467d, 48.101665d))
                .setArrivalTime(ZonedDateTime.parse("2020-09-30T14:22+02:00"))
                .setDepartureTime(ZonedDateTime.parse("2020-09-30T14:22+02:00"))
                .build();
    }

    public static TravelPoint getWaldkirchTownCenterTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setName("Waldkirch Stadtmitte")
                .setCoordinates(new Point(7.961104d, 48.093896d))
                .setArrivalTime(ZonedDateTime.parse("2020-09-30T14:26+02:00"))
                .setDepartureTime(ZonedDateTime.parse("2020-09-30T14:26+02:00"))
                .build();
    }

    public static TravelPoint getSickAgTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setName("Sick AG")
                .setCoordinates(new Point(7.950507d, 48.088204d))
                .setArrivalTime(ZonedDateTime.parse("2020-09-30T14:34:56+02:00"))
                .build();
    }

    public static TravelPoint getMannheimHbfTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setName("Mannheim Hbf")
                .setCoordinates(new Point(8.464279d, 49.483628d))
                .setDepartureTime(ZonedDateTime.parse("2020-10-06T01:20:11+02:00"))
                .build();
    }

    public static TravelPoint getMannheimUniversityTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setName("Universität")
                .setPlatform("C")
                .setCoordinates(new Point(8.463348d, 49.482188d))
                .setArrivalTime(ZonedDateTime.parse("2020-10-06T01:24:59+02:00"))
                .setDepartureTime(ZonedDateTime.parse("2020-10-06T01:25+02:00"))
                .build();
    }

    public static TravelPoint getBerlinerPlaceTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setName("Berliner Platz")
                .setPlatform("B")
                .setCoordinates(new Point(8.45065, 49.48049))
                .setArrivalTime(ZonedDateTime.parse("2020-10-06T01:28+02:00"))
                .setDepartureTime(ZonedDateTime.parse("2020-10-06T01:28:01+02:00"))
                .build();
    }

    public static TravelPoint getKonradAdenauerBrTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setName("Konrad-Adenauer-Br.")
                .setPlatform("B")
                .setCoordinates(new Point(8.458577, 49.482392))
                .setArrivalTime(ZonedDateTime.parse("2020-10-06T01:26+02:00"))
                .setDepartureTime(ZonedDateTime.parse("2020-10-06T01:26+02:00"))
                .build();
    }

    public static TravelPoint getLudwigsburgCenterTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setName("Ludwigsburg Center")
                .setCoordinates(new Point(8.453147, 49.47913))
                .setArrivalTime(ZonedDateTime.parse("2020-10-06T01:33:29+02:00"))
                .build();
    }
}
