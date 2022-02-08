package de.blackforestsolutions.dravelopsdatamodel.objectmothers;

import de.blackforestsolutions.dravelopsdatamodel.ApiToken;
import de.blackforestsolutions.dravelopsdatamodel.Point;
import de.blackforestsolutions.dravelopsdatamodel.TravelPoint;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;

import java.time.Duration;
import java.time.ZonedDateTime;

public class TravelPointObjectMother {

    public static TravelPoint getTravelPointWithNoEmptyFields() {
        return getTravelPointBuilderWithNoEmptyFields()
                .build();
    }

    public static TravelPoint.TravelPointBuilder getTravelPointBuilderWithNoEmptyFields() {
        return new TravelPoint.TravelPointBuilder()
                .setStopId("1:de:08326:123")
                .setStopSequence(6)
                .setName("Furtwangen")
                .setPoint(new Point.PointBuilder(48.052590d, 8.207245d).build())
                .setArrivalTime(ZonedDateTime.parse("2020-09-27T10:15:30+02:00[Europe/Berlin]"))
                .setArrivalDelayInSeconds(Duration.ofSeconds(60L))
                .setDepartureTime(ZonedDateTime.parse("2020-09-27T10:15:30+02:00[Europe/Berlin]"))
                .setDepartureDelayInSeconds(Duration.ofSeconds(60L))
                .setPlatform("1")
                .setDistanceInKilometers(new Distance(0.5d, Metrics.KILOMETERS));
    }

    public static TravelPoint getTravelPointWithNoEmptyFieldsByArrivalTime(Point point) {
        return getTravelPointBuilderWithNoEmptyFields()
                .setPoint(point)
                .build();
    }

    public static TravelPoint getTravelPointWithNoEmptyFieldsByArrivalTime(ZonedDateTime arrivalTime) {
        return getTravelPointBuilderWithNoEmptyFields()
                .setArrivalTime(arrivalTime)
                .build();
    }

    public static TravelPoint getTravelPointWithNoEmptyFieldsByDepartureTime(ZonedDateTime departureTime) {
        return getTravelPointBuilderWithNoEmptyFields()
                .setDepartureTime(departureTime)
                .build();
    }

    public static TravelPoint getDepartureTravelPointWithNoEmptyFieldsBy(ApiToken apiToken) {
        return getTravelPointBuilderWithNoEmptyFields()
                .setPoint(apiToken.getDepartureCoordinate())
                .setDepartureTime(apiToken.getDateTime())
                .build();
    }

    public static TravelPoint getArrivalTravelPointWithNoEmptyFieldsBy(ApiToken apiToken) {
        return getTravelPointBuilderWithNoEmptyFields()
                .setPoint(apiToken.getArrivalCoordinate())
                .setArrivalTime(apiToken.getDateTime())
                .build();
    }

    public static TravelPoint getTravelPointWithNoEmptyFieldsBy(Point point) {
        return getTravelPointBuilderWithNoEmptyFields()
                .setPoint(point)
                .build();
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
                .setStopId("1:de:08326:490")
                .setStopSequence(6)
                .setName("Furtwangen Ilbenstraße")
                .setPoint(new Point.PointBuilder(8.198995d, 48.047922d).build())
                .setArrivalTime(ZonedDateTime.parse("2020-09-30T13:20:59+02:00[Europe/Berlin]"))
                .setDepartureTime(ZonedDateTime.parse("2020-09-30T13:21+02:00[Europe/Berlin]"))
                .build();
    }

    public static TravelPoint getBleibachSevTravelPoint(int stopSequence) {
        return new TravelPoint.TravelPointBuilder()
                .setStopId("1:de:08316:11560:1")
                .setStopSequence(stopSequence)
                .setName("Bleibach SEV")
                .setPoint(new Point.PointBuilder(7.998644d, 48.127233d).build())
                .setArrivalTime(ZonedDateTime.parse("2020-09-30T14:05+02:00[Europe/Berlin]"))
                .setDepartureTime(ZonedDateTime.parse("2020-09-30T14:12+02:00[Europe/Berlin]"))
                .build();
    }

    public static TravelPoint getGuetenbachTownHallTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setStopId("1:de:08326:482")
                .setStopSequence(15)
                .setName("Gütenbach Rathaus")
                .setPoint(new Point.PointBuilder(8.138826d, 48.044378d).build())
                .setArrivalTime(ZonedDateTime.parse("2020-09-30T13:31+02:00[Europe/Berlin]"))
                .setDepartureTime(ZonedDateTime.parse("2020-09-30T13:31+02:00[Europe/Berlin]"))
                .build();
    }

    public static TravelPoint getSimonswaldTownHallTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setStopId("1:de:08316:462")
                .setStopSequence(28)
                .setName("Simonswald Rathaus")
                .setPoint(new Point.PointBuilder(8.056936d, 48.100225d).build())
                .setArrivalTime(ZonedDateTime.parse("2020-09-30T13:52+02:00[Europe/Berlin]"))
                .setDepartureTime(ZonedDateTime.parse("2020-09-30T13:52+02:00[Europe/Berlin]"))
                .build();
    }

    public static TravelPoint getWaldkirchKastelberghalleTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setStopId("1:de:08316:811")
                .setStopSequence(13)
                .setName("Waldkirch Kastelberghalle")
                .setPoint(new Point.PointBuilder(7.952947d, 48.090458d).build())
                .setArrivalTime(ZonedDateTime.parse("2020-09-30T14:29+02:00[Europe/Berlin]"))
                .setDepartureTime(ZonedDateTime.parse("2020-09-30T14:29:01+02:00[Europe/Berlin]"))
                .build();
    }

    public static TravelPoint getKollnauTrainStationTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setStopId("1:de:08316:6533:4")
                .setStopSequence(9)
                .setName("Kollnau Bf (Bus)")
                .setPoint(new Point.PointBuilder(7.972467d, 48.101665d).build())
                .setArrivalTime(ZonedDateTime.parse("2020-09-30T14:22+02:00[Europe/Berlin]"))
                .setDepartureTime(ZonedDateTime.parse("2020-09-30T14:22+02:00[Europe/Berlin]"))
                .build();
    }

    public static TravelPoint getWaldkirchTownCenterTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setStopId("1:de:08316:846")
                .setStopSequence(11)
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
                .setStopId("1:247103")
                .setStopSequence(27)
                .setName("Universität")
                .setPlatform("C")
                .setPoint(new Point.PointBuilder(8.463348d, 49.482188d).build())
                .setArrivalTime(ZonedDateTime.parse("2020-10-06T01:24:59+02:00[Europe/Berlin]"))
                .setDepartureTime(ZonedDateTime.parse("2020-10-06T01:25+02:00[Europe/Berlin]"))
                .build();
    }

    public static TravelPoint getBerlinerPlaceTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setStopId("1:206602")
                .setStopSequence(29)
                .setName("Berliner Platz")
                .setPlatform("B")
                .setPoint(new Point.PointBuilder(8.45065, 49.48049).build())
                .setArrivalTime(ZonedDateTime.parse("2020-10-06T01:28+02:00[Europe/Berlin]"))
                .setDepartureTime(ZonedDateTime.parse("2020-10-06T01:28:01+02:00[Europe/Berlin]"))
                .build();
    }

    public static TravelPoint getKonradAdenauerBrTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setStopId("1:242602")
                .setStopSequence(28)
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

    public static TravelPoint getStuttgarterStreetOneTravelPoint(Distance distanceInKilometers) {
        return new TravelPoint.TravelPointBuilder()
                .setName("Stuttgarter Straße 1, Rottweil, Deutschland")
                .setPoint(new Point.PointBuilder(8.674534d, 48.128923d).build())
                .setDistanceInKilometers(distanceInKilometers)
                .build();
    }

    public static TravelPoint getGermanyTravelPoint(Distance distanceInKilometers) {
        return new TravelPoint.TravelPointBuilder()
                .setName("Deutschland")
                .setPoint(new Point.PointBuilder(9.687096d, 50.970097d).build())
                .setDistanceInKilometers(distanceInKilometers)
                .build();
    }

    public static TravelPoint getRendsburgCountyTravelPoint(Distance distanceInKilometers) {
        return new TravelPoint.TravelPointBuilder()
                .setName("Kreis Rendsburg-Eckernförde, Deutschland")
                .setPoint(new Point.PointBuilder(9.7748d, 54.264295d).build())
                .setDistanceInKilometers(distanceInKilometers)
                .build();
    }

    public static TravelPoint getFurtwangenLocalityTravelPoint(Distance distanceInKilometers) {
        return new TravelPoint.TravelPointBuilder()
                .setName("Furtwangen im Schwarzwald, Deutschland")
                .setPoint(new Point.PointBuilder(8.195593d, 48.049034d).build())
                .setDistanceInKilometers(distanceInKilometers)
                .build();
    }

    public static TravelPoint getAmGrosshaubergTravelPoint(Distance distanceInKilometers) {
        return new TravelPoint.TravelPointBuilder()
                .setName("Am Großhausberg, Furtwangen im Schwarzwald, Deutschland")
                .setPoint(new Point.PointBuilder(8.209198d, 48.048381d).build())
                .setDistanceInKilometers(distanceInKilometers)
                .build();
    }

    public static TravelPoint getGermanWatchMuseumTravelPoint(Distance distanceInKilometers) {
        return new TravelPoint.TravelPointBuilder()
                .setName("Deutsches Uhrenmuseum Furtwangen, Furtwangen im Schwarzwald, Deutschland")
                .setPoint(new Point.PointBuilder(8.207673d, 48.051086d).build())
                .setDistanceInKilometers(distanceInKilometers)
                .build();
    }

    public static TravelPoint getBadDuerkheimTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setName("Bad Dürkheim Bahnhof")
                .setPoint(new Point.PointBuilder(8.1704281d, 49.4615289d).build())
                .setPlatform("1")
                .build();
    }

    public static TravelPoint getNeckarauTrainStationTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setName("Neckarau Bahnhof")
                .setPoint(new Point.PointBuilder(8.4942986d, 49.4554028d).build())
                .setPlatform("B")
                .build();
    }

    public static TravelPoint getKarlsbaderStreetTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setName("Karlsbader Straße")
                .setPoint(new Point.PointBuilder(8.4040203d, 49.4770297d).build())
                .setPlatform("A")
                .build();
    }

    public static TravelPoint getFurtwangenBirkeTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setName("Furtwangen Birke")
                .setPoint(new Point.PointBuilder(8.203244d, 48.079146d).build())
                .build();
    }

    public static TravelPoint getTribergStationStreetTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setName("Triberg Bahnhofstraße")
                .setPoint(new Point.PointBuilder(8.240066d, 48.137905d).build())
                .build();
    }

    public static TravelPoint getFurtwangenTownChurchTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setStopId("1:de:08326:1558")
                .setName("Furtwangen Stadtkirche")
                .setPoint(new Point.PointBuilder(8.20523d, 48.050348d).build())
                .setDistanceInKilometers(new Distance(0.367d, Metrics.KILOMETERS))
                .build();
    }

    public static TravelPoint getFurtwangenGerwigSchoolTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setStopId("1:de:08326:1916")
                .setName("Furtwangen Robert-Gerwigschule")
                .setPoint(new Point.PointBuilder(8.21406d, 48.047675d).build())
                .setDistanceInKilometers(new Distance(0.369d, Metrics.KILOMETERS))
                .build();
    }

    public static TravelPoint getFurtwangenRabenStreetTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setStopId("1:de:08326:1295")
                .setName("Furtwangen Rabenstraße")
                .setPoint(new Point.PointBuilder(8.19851d, 48.049765d).build())
                .setDistanceInKilometers(new Distance(0.808d, Metrics.KILOMETERS))
                .build();
    }

    public static TravelPoint getFurtwangenFriedrichSchoolTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setStopId("1:de:08326:1626")
                .setName("Furtwangen Friedrichschule")
                .setPoint(new Point.PointBuilder(8.204951d, 48.054017d).build())
                .setDistanceInKilometers(new Distance(0.701d, Metrics.KILOMETERS))
                .build();
    }

    public static TravelPoint getFurtwangenAllmendStreetTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setStopId("1:de:08326:1737")
                .setName("Furtwangen Allmendstraße")
                .setPoint(new Point.PointBuilder(8.21424d, 48.049765d).build())
                .setDistanceInKilometers(new Distance(0.404d, Metrics.KILOMETERS))
                .build();
    }

    public static TravelPoint getFurtwangenOttoHahnSchoolTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setStopId("1:de:08326:491")
                .setName("Furtwangen Otto-Hahn-Gym.")
                .setPoint(new Point.PointBuilder(8.197585d, 48.051591d).build())
                .setDistanceInKilometers(new Distance(0.933d, Metrics.KILOMETERS))
                .build();
    }

    public static TravelPoint getFurtwangenRoessleTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setStopId("1:de:08326:1181")
                .setName("Furtwangen Rößleplatz")
                .setPoint(new Point.PointBuilder(8.207098d, 48.052768d).build())
                .setDistanceInKilometers(new Distance(0.511d, Metrics.KILOMETERS))
                .build();
    }

    public static TravelPoint getFurtwangenIlbenStreetTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setStopId("1:de:08326:490")
                .setName("Furtwangen Ilbenstraße")
                .setPoint(new Point.PointBuilder(8.198995d, 48.047922d).build())
                .setDistanceInKilometers(new Distance(0.759d, Metrics.KILOMETERS))
                .build();
    }

    public static TravelPoint getWrongCoordinateTravelPoint() {
        return new TravelPoint.TravelPointBuilder()
                .setName("Wrong Coordinate TravelPoint")
                .setPoint(new Point.PointBuilder(0.0d, 0.0d).build())
                .build();
    }

}
