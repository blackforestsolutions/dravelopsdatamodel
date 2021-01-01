package de.blackforestsolutions.dravelopsdatamodel.objectmothers;

import de.blackforestsolutions.dravelopsdatamodel.Point;
import de.blackforestsolutions.dravelopsdatamodel.TravelPoint;

import java.time.ZonedDateTime;

public class TravelPointObjectMother {

    public static TravelPoint getTravelPointWithNoEmptyFields() {
        return getTravelPointBuilderWithNoEmptyFields()
                .build();
    }

    public static TravelPoint.TravelPointBuilder getTravelPointBuilderWithNoEmptyFields() {
        return new TravelPoint.TravelPointBuilder()
                .setName("Furtwangen")
                .setPoint(new Point.PointBuilder(48.052590d, 8.207245d).build())
                .setArrivalTime(ZonedDateTime.parse("2020-09-27T10:15:30+02:00[Europe/Berlin]"))
                .setDepartureTime(ZonedDateTime.parse("2020-09-27T10:15:30+02:00[Europe/Berlin]"))
                .setPlatform("1");
    }

    public static TravelPoint getGrosshausbergTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setName("Am Großhausberg 8")
                .setPoint(new Point.PointBuilder(8.209972d, 48.04832d).build())
                .setDepartureTime(ZonedDateTime.parse("2020-09-30T13:08:13+02:00[Europe/Berlin]"))
                .build();
    }

    public static TravelPoint getFurtwangenIlbenstreetTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setName("Furtwangen Ilbenstraße")
                .setPoint(new Point.PointBuilder(8.198995d, 48.047922d).build())
                .setArrivalTime(ZonedDateTime.parse("2020-09-30T13:20:59+02:00[Europe/Berlin]"))
                .setDepartureTime(ZonedDateTime.parse("2020-09-30T13:21+02:00[Europe/Berlin]"))
                .build();
    }

    public static TravelPoint getBleibachSevTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setName("Bleibach SEV")
                .setPoint(new Point.PointBuilder(7.998644d, 48.127233d).build())
                .setArrivalTime(ZonedDateTime.parse("2020-09-30T14:05+02:00[Europe/Berlin]"))
                .setDepartureTime(ZonedDateTime.parse("2020-09-30T14:12+02:00[Europe/Berlin]"))
                .build();
    }

    public static TravelPoint getGuetenbachTownHallTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setName("Gütenbach Rathaus")
                .setPoint(new Point.PointBuilder(8.138826d, 48.044378d).build())
                .setArrivalTime(ZonedDateTime.parse("2020-09-30T13:31+02:00[Europe/Berlin]"))
                .setDepartureTime(ZonedDateTime.parse("2020-09-30T13:31+02:00[Europe/Berlin]"))
                .build();
    }

    public static TravelPoint getSimonswaldTownHallTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setName("Simonswald Rathaus")
                .setPoint(new Point.PointBuilder(8.056936d, 48.100225d).build())
                .setArrivalTime(ZonedDateTime.parse("2020-09-30T13:52+02:00[Europe/Berlin]"))
                .setDepartureTime(ZonedDateTime.parse("2020-09-30T13:52+02:00[Europe/Berlin]"))
                .build();
    }

    public static TravelPoint getWaldkirchKastelberghalleTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setName("Waldkirch Kastelberghalle")
                .setPoint(new Point.PointBuilder(7.952947d, 48.090458d).build())
                .setArrivalTime(ZonedDateTime.parse("2020-09-30T14:29+02:00[Europe/Berlin]"))
                .setDepartureTime(ZonedDateTime.parse("2020-09-30T14:29:01+02:00[Europe/Berlin]"))
                .build();
    }

    public static TravelPoint getKollnauTrainStationTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setName("Kollnau Bf (Bus)")
                .setPoint(new Point.PointBuilder(7.972467d, 48.101665d).build())
                .setArrivalTime(ZonedDateTime.parse("2020-09-30T14:22+02:00[Europe/Berlin]"))
                .setDepartureTime(ZonedDateTime.parse("2020-09-30T14:22+02:00[Europe/Berlin]"))
                .build();
    }

    public static TravelPoint getWaldkirchTownCenterTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setName("Waldkirch Stadtmitte")
                .setPoint(new Point.PointBuilder(7.961104d, 48.093896d).build())
                .setArrivalTime(ZonedDateTime.parse("2020-09-30T14:26+02:00[Europe/Berlin]"))
                .setDepartureTime(ZonedDateTime.parse("2020-09-30T14:26+02:00[Europe/Berlin]"))
                .build();
    }

    public static TravelPoint getSickAgTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setName("Sick AG")
                .setPoint(new Point.PointBuilder(7.950507d, 48.088204d).build())
                .setArrivalTime(ZonedDateTime.parse("2020-09-30T14:34:56+02:00[Europe/Berlin]"))
                .build();
    }

    public static TravelPoint getMannheimHbfTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setName("Mannheim Hbf")
                .setPoint(new Point.PointBuilder(8.464279d, 49.483628d).build())
                .setDepartureTime(ZonedDateTime.parse("2020-10-06T01:20:11+02:00[Europe/Berlin]"))
                .build();
    }

    public static TravelPoint getMannheimUniversityTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setName("Universität")
                .setPlatform("C")
                .setPoint(new Point.PointBuilder(8.463348d, 49.482188d).build())
                .setArrivalTime(ZonedDateTime.parse("2020-10-06T01:24:59+02:00[Europe/Berlin]"))
                .setDepartureTime(ZonedDateTime.parse("2020-10-06T01:25+02:00[Europe/Berlin]"))
                .build();
    }

    public static TravelPoint getBerlinerPlaceTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setName("Berliner Platz")
                .setPlatform("B")
                .setPoint(new Point.PointBuilder(8.45065, 49.48049).build())
                .setArrivalTime(ZonedDateTime.parse("2020-10-06T01:28+02:00[Europe/Berlin]"))
                .setDepartureTime(ZonedDateTime.parse("2020-10-06T01:28:01+02:00[Europe/Berlin]"))
                .build();
    }

    public static TravelPoint getKonradAdenauerBrTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setName("Konrad-Adenauer-Br.")
                .setPlatform("B")
                .setPoint(new Point.PointBuilder(8.458577, 49.482392).build())
                .setArrivalTime(ZonedDateTime.parse("2020-10-06T01:26+02:00[Europe/Berlin]"))
                .setDepartureTime(ZonedDateTime.parse("2020-10-06T01:26+02:00[Europe/Berlin]"))
                .build();
    }

    public static TravelPoint getLudwigsburgCenterTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setName("Ludwigsburg Center")
                .setPoint(new Point.PointBuilder(8.453147, 49.47913).build())
                .setArrivalTime(ZonedDateTime.parse("2020-10-06T01:33:29+02:00[Europe/Berlin]"))
                .build();
    }

    public static TravelPoint getStuttgarterStreetOneTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setName("Stuttgarter Straße 1, Rottweil, Deutschland")
                .setPoint(new Point.PointBuilder(8.674534d, 48.128923d).build())
                .build();
    }

    public static TravelPoint getGermanyTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setName("Deutschland")
                .setPoint(new Point.PointBuilder(9.687096d, 50.970097d).build())
                .build();
    }

    public static TravelPoint getRendsburgCountyTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setName("Kreis Rendsburg-Eckernförde, Deutschland")
                .setPoint(new Point.PointBuilder(9.7748d, 54.264295d).build())
                .build();
    }

    public static TravelPoint getFurtwangenLocalityTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setName("Furtwangen im Schwarzwald, Deutschland")
                .setPoint(new Point.PointBuilder(8.195593d, 48.049034d).build())
                .build();
    }

    public static TravelPoint getAmGrosshaubergTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setName("Am Großhausberg, Furtwangen im Schwarzwald, Deutschland")
                .setPoint(new Point.PointBuilder(8.209198d, 48.048381d).build())
                .build();
    }

    public static TravelPoint getGermanWatchMuseumTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setName("Deutsches Uhrenmuseum Furtwangen, Furtwangen im Schwarzwald, Deutschland")
                .setPoint(new Point.PointBuilder(8.207673d, 48.051086d).build())
                .build();
    }
}
