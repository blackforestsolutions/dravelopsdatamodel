package de.blackforestsolutions.dravelopsdatamodel.objectmothers;

import de.blackforestsolutions.dravelopsdatamodel.CompassDirection;
import de.blackforestsolutions.dravelopsdatamodel.Point;
import de.blackforestsolutions.dravelopsdatamodel.WalkStep;
import de.blackforestsolutions.dravelopsdatamodel.WalkingDirection;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;

import java.util.LinkedList;
import java.util.Optional;

import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.PointObjectMother.getAmGrosshausbergPoint;
import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.PointObjectMother.getSickAgPoint;

public class WalkStepObjectMother {

    private static final Metrics DEFAULT_TEST_DISTANCE_METRIC = Metrics.KILOMETERS;
    private static final String DEFAULT_TEST_PATH_STREET_NAME = "Weg";
    private static final String DEFAULT_TEST_FOOTPATH_STREET_NAME = "Fußweg";

    public static WalkStep getWalkStepWithNoEmptyFields() {
        return getWalkStepBuilderWithNoEmptyFields()
                .build();
    }

    public static WalkStep.WalkStepBuilder getWalkStepBuilderWithNoEmptyFields() {
        return new WalkStep.WalkStepBuilder()
                .setStreetName(DEFAULT_TEST_PATH_STREET_NAME)
                .setDistanceInKilometers(new Distance(1.253d, DEFAULT_TEST_DISTANCE_METRIC))
                .setStartPoint(getAmGrosshausbergPoint())
                .setEndPoint(getSickAgPoint())
                .setWalkingDirection(WalkingDirection.RIGHT)
                .setCompassDirection(CompassDirection.NORTH)
                .setCircleExit("3")
                .setStreetNameGenerated(false)
                .setPlaceOrTrainPlatform(false);
    }

    public static WalkStep getAmGrosshausbergStreetWalkStep() {
        return new WalkStep.WalkStepBuilder()
                .setStreetName("Am Großhausberg")
                .setDistanceInKilometers(new Distance(0.120d, DEFAULT_TEST_DISTANCE_METRIC))
                .setStartPoint(new Point.PointBuilder(8.210010d, 48.048340d).build())
                .setEndPoint(new Point.PointBuilder(8.208427d, 48.048347d).build())
                .setWalkingDirection(WalkingDirection.DEPART)
                .setCompassDirection(CompassDirection.NORTHWEST)
                .setStreetNameGenerated(false)
                .setPlaceOrTrainPlatform(false)
                .build();
    }

    public static WalkStep getAmGrosshausbergStreetToMartinSchmittStreetWalkStep() {
        return new WalkStep.WalkStepBuilder()
                .setStreetName(DEFAULT_TEST_PATH_STREET_NAME)
                .setDistanceInKilometers(new Distance(0.350d, DEFAULT_TEST_DISTANCE_METRIC))
                .setStartPoint(new Point.PointBuilder(8.208427d, 48.048347d).build())
                .setEndPoint(new Point.PointBuilder(8.203926d, 48.047521d).build())
                .setWalkingDirection(WalkingDirection.CONTINUE)
                .setCompassDirection(CompassDirection.WEST)
                .setStreetNameGenerated(true)
                .setPlaceOrTrainPlatform(false)
                .build();
    }

    public static WalkStep getMartinSchmittStreetWalkStep() {
        return new WalkStep.WalkStepBuilder()
                .setStreetName("Martin-Schmitt-Straße")
                .setDistanceInKilometers(new Distance(0.102d, DEFAULT_TEST_DISTANCE_METRIC))
                .setStartPoint(new Point.PointBuilder(8.203926d, 48.047521d).build())
                .setEndPoint(new Point.PointBuilder(8.202655d, 48.047183d).build())
                .setWalkingDirection(WalkingDirection.SLIGHTLY_LEFT)
                .setCompassDirection(CompassDirection.SOUTHWEST)
                .setStreetNameGenerated(false)
                .setPlaceOrTrainPlatform(false)
                .build();
    }

    public static WalkStep getWeibertMahlerStreetWalkStep() {
        return new WalkStep.WalkStepBuilder()
                .setStreetName("Weibert-Mahler-Straße")
                .setDistanceInKilometers(new Distance(0.187d, DEFAULT_TEST_DISTANCE_METRIC))
                .setStartPoint(new Point.PointBuilder(8.202655d, 48.047183d).build())
                .setEndPoint(new Point.PointBuilder(8.201638d, 48.048698d).build())
                .setWalkingDirection(WalkingDirection.RIGHT)
                .setCompassDirection(CompassDirection.NORTHWEST)
                .setStreetNameGenerated(false)
                .setPlaceOrTrainPlatform(false)
                .build();
    }

    public static WalkStep getBregstreetWalkStep(LinkedList<Point> waypoints) {
        return new WalkStep.WalkStepBuilder()
                .setStreetName("Bregstraße")
                .setDistanceInKilometers(new Distance(0.219d, DEFAULT_TEST_DISTANCE_METRIC))
                .setStartPoint(new Point.PointBuilder(8.201638d, 48.048698d).build())
                .setEndPoint(extractEndPointFrom(waypoints))
                .setWalkingDirection(WalkingDirection.LEFT)
                .setCompassDirection(CompassDirection.WEST)
                .setStreetNameGenerated(false)
                .setPlaceOrTrainPlatform(false)
                .build();
    }

    public static WalkStep getFreiburgerStreetWalkStep() {
        return new WalkStep.WalkStepBuilder()
                .setStreetName("Freiburger Straße")
                .setDistanceInKilometers(new Distance(0.067d, DEFAULT_TEST_DISTANCE_METRIC))
                .setStartPoint(new Point.PointBuilder(7.952940d, 48.090477d).build())
                .setEndPoint(new Point.PointBuilder(7.952065d, 48.090344d).build())
                .setWalkingDirection(WalkingDirection.DEPART)
                .setCompassDirection(CompassDirection.WEST)
                .setStreetNameGenerated(false)
                .setPlaceOrTrainPlatform(false)
                .build();
    }

    public static WalkStep getFreiburgerStreetToUnterfelderPathWalkStep() {
        return new WalkStep.WalkStepBuilder()
                .setStreetName(DEFAULT_TEST_PATH_STREET_NAME)
                .setDistanceInKilometers(new Distance(0.089d, DEFAULT_TEST_DISTANCE_METRIC))
                .setStartPoint(new Point.PointBuilder(7.952065d, 48.090344d).build())
                .setEndPoint(new Point.PointBuilder(7.951626d, 48.089830d).build())
                .setWalkingDirection(WalkingDirection.SLIGHTLY_LEFT)
                .setCompassDirection(CompassDirection.SOUTHWEST)
                .setStreetNameGenerated(true)
                .setPlaceOrTrainPlatform(false)
                .build();
    }

    public static WalkStep getUnterfelderPathWalkStep() {
        return new WalkStep.WalkStepBuilder()
                .setStreetName("Unterfelderweg")
                .setDistanceInKilometers(new Distance(0.110d, DEFAULT_TEST_DISTANCE_METRIC))
                .setStartPoint(new Point.PointBuilder(7.951626d, 48.089830d).build())
                .setEndPoint(new Point.PointBuilder(7.951876d, 48.088853d).build())
                .setWalkingDirection(WalkingDirection.SLIGHTLY_LEFT)
                .setCompassDirection(CompassDirection.SOUTH)
                .setStreetNameGenerated(false)
                .setPlaceOrTrainPlatform(false)
                .build();
    }

    public static WalkStep getHansjakobStreetWalkStep() {
        return new WalkStep.WalkStepBuilder()
                .setStreetName("Hansjakobstraße")
                .setDistanceInKilometers(new Distance(0.131d, DEFAULT_TEST_DISTANCE_METRIC))
                .setStartPoint(new Point.PointBuilder(7.951876d, 48.088853d).build())
                .setEndPoint(new Point.PointBuilder(7.950172d, 48.088572d).build())
                .setWalkingDirection(WalkingDirection.RIGHT)
                .setCompassDirection(CompassDirection.WEST)
                .setStreetNameGenerated(false)
                .setPlaceOrTrainPlatform(false)
                .build();
    }

    public static WalkStep getErwinSickStreetWalkStep(LinkedList<Point> waypoints) {
        return new WalkStep.WalkStepBuilder()
                .setStreetName("Erwin-Sick-Straße")
                .setDistanceInKilometers(new Distance(0.048d, DEFAULT_TEST_DISTANCE_METRIC))
                .setStartPoint(new Point.PointBuilder(7.950172d, 48.088572d).build())
                .setEndPoint(extractEndPointFrom(waypoints))
                .setWalkingDirection(WalkingDirection.LEFT)
                .setCompassDirection(CompassDirection.SOUTHEAST)
                .setStreetNameGenerated(false)
                .setPlaceOrTrainPlatform(false)
                .build();
    }

    public static WalkStep getCarlTheodorPlaceWalkStep() {
        return new WalkStep.WalkStepBuilder()
                .setStreetName("Carl-Theodor-Platz")
                .setDistanceInKilometers(new Distance(0.046d, DEFAULT_TEST_DISTANCE_METRIC))
                .setStartPoint(new Point.PointBuilder(8.464206d, 49.483549d).build())
                .setEndPoint(new Point.PointBuilder(8.464752d, 49.483335d).build())
                .setWalkingDirection(WalkingDirection.DEPART)
                .setCompassDirection(CompassDirection.SOUTHEAST)
                .setStreetNameGenerated(false)
                .setPlaceOrTrainPlatform(false)
                .build();
    }


    public static WalkStep getCarlTheodorPlaceToOttoSelzStreetFootpathWalkStep() {
        return new WalkStep.WalkStepBuilder()
                .setStreetName(DEFAULT_TEST_FOOTPATH_STREET_NAME)
                .setDistanceInKilometers(new Distance(0.027d, DEFAULT_TEST_DISTANCE_METRIC))
                .setStartPoint(new Point.PointBuilder(8.464752d, 49.483335d).build())
                .setEndPoint(new Point.PointBuilder(8.464599d, 49.483121d).build())
                .setWalkingDirection(WalkingDirection.RIGHT)
                .setCompassDirection(CompassDirection.SOUTHWEST)
                .setStreetNameGenerated(true)
                .setPlaceOrTrainPlatform(false)
                .build();
    }

    public static WalkStep getCarlTheodorPlaceToOttoSelzStreetPathWalkStep() {
        return new WalkStep.WalkStepBuilder()
                .setStreetName(DEFAULT_TEST_PATH_STREET_NAME)
                .setDistanceInKilometers(new Distance(0.062d, DEFAULT_TEST_DISTANCE_METRIC))
                .setStartPoint(new Point.PointBuilder(8.464599d, 49.483121d).build())
                .setEndPoint(new Point.PointBuilder(8.465324d, 49.482829d).build())
                .setWalkingDirection(WalkingDirection.LEFT)
                .setCompassDirection(CompassDirection.SOUTHEAST)
                .setStreetNameGenerated(true)
                .setPlaceOrTrainPlatform(false)
                .build();
    }

    public static WalkStep getOttoSelzStreetWalkStep() {
        return new WalkStep.WalkStepBuilder()
                .setStreetName("Otto-Selz-Straße")
                .setDistanceInKilometers(new Distance(0.125d, DEFAULT_TEST_DISTANCE_METRIC))
                .setStartPoint(new Point.PointBuilder(8.465324d, 49.482829d).build())
                .setEndPoint(new Point.PointBuilder(8.464055d, 49.482167d).build())
                .setWalkingDirection(WalkingDirection.RIGHT)
                .setCompassDirection(CompassDirection.SOUTHWEST)
                .setStreetNameGenerated(false)
                .setPlaceOrTrainPlatform(false)
                .build();
    }

    public static WalkStep getOttoSelzStreetToPlatformThreeWalkStep() {
        return new WalkStep.WalkStepBuilder()
                .setStreetName(DEFAULT_TEST_FOOTPATH_STREET_NAME)
                .setDistanceInKilometers(new Distance(0.015d, DEFAULT_TEST_DISTANCE_METRIC))
                .setStartPoint(new Point.PointBuilder(8.464055d, 49.482167d).build())
                .setEndPoint(new Point.PointBuilder(8.463937d, 49.482134d).build())
                .setWalkingDirection(WalkingDirection.LEFT)
                .setCompassDirection(CompassDirection.SOUTH)
                .setStreetNameGenerated(true)
                .setPlaceOrTrainPlatform(false)
                .build();
    }

    public static WalkStep getPlatformThreeWalkStep(LinkedList<Point> waypoints) {
        return new WalkStep.WalkStepBuilder()
                .setStreetName("Plattform 3")
                .setDistanceInKilometers(new Distance(0.046d, DEFAULT_TEST_DISTANCE_METRIC))
                .setStartPoint(new Point.PointBuilder(8.463937d, 49.482134d).build())
                .setEndPoint(extractEndPointFrom(waypoints))
                .setWalkingDirection(WalkingDirection.LEFT)
                .setCompassDirection(CompassDirection.SOUTH)
                .setStreetNameGenerated(false)
                .setPlaceOrTrainPlatform(true)
                .build();
    }

    public static WalkStep getPlatformWalkStep() {
        return new WalkStep.WalkStepBuilder()
                .setStreetName("Plattform")
                .setDistanceInKilometers(new Distance(0.005d, DEFAULT_TEST_DISTANCE_METRIC))
                .setStartPoint(new Point.PointBuilder(8.450661d, 49.480491d).build())
                .setEndPoint(new Point.PointBuilder(8.450670d, 49.480525d).build())
                .setWalkingDirection(WalkingDirection.DEPART)
                .setCompassDirection(CompassDirection.NORTH)
                .setStreetNameGenerated(true)
                .setPlaceOrTrainPlatform(false)
                .build();
    }

    public static WalkStep getPlatformToLudwigStreetWalkStep() {
        return new WalkStep.WalkStepBuilder()
                .setStreetName(DEFAULT_TEST_FOOTPATH_STREET_NAME)
                .setDistanceInKilometers(new Distance(0.013d, DEFAULT_TEST_DISTANCE_METRIC))
                .setStartPoint(new Point.PointBuilder(8.450670d, 49.480525d).build())
                .setEndPoint(new Point.PointBuilder(8.450767d, 49.480595d).build())
                .setWalkingDirection(WalkingDirection.LEFT)
                .setCompassDirection(CompassDirection.NORTH)
                .setStreetNameGenerated(true)
                .setPlaceOrTrainPlatform(false)
                .build();
    }

    public static WalkStep getLudwigStreetWalkStep() {
        return new WalkStep.WalkStepBuilder()
                .setStreetName("Ludwigstraße")
                .setDistanceInKilometers(new Distance(0.004d, DEFAULT_TEST_DISTANCE_METRIC))
                .setStartPoint(new Point.PointBuilder(8.450767d, 49.480595d).build())
                .setEndPoint(new Point.PointBuilder(8.450745d, 49.480632d).build())
                .setWalkingDirection(WalkingDirection.LEFT)
                .setCompassDirection(CompassDirection.NORTH)
                .setStreetNameGenerated(false)
                .setPlaceOrTrainPlatform(false)
                .build();
    }

    public static WalkStep getBerlinerPlaceWalkStep() {
        return new WalkStep.WalkStepBuilder()
                .setStreetName("Berliner Platz")
                .setDistanceInKilometers(new Distance(0.160d, DEFAULT_TEST_DISTANCE_METRIC))
                .setStartPoint(new Point.PointBuilder(8.450745d, 49.480632d).build())
                .setEndPoint(new Point.PointBuilder(8.452390d, 49.480165d).build())
                .setWalkingDirection(WalkingDirection.RIGHT)
                .setCompassDirection(CompassDirection.EAST)
                .setStreetNameGenerated(false)
                .setPlaceOrTrainPlatform(true)
                .build();
    }

    public static WalkStep getHenyRoosPassageWalkStep() {
        return new WalkStep.WalkStepBuilder()
                .setStreetName("Heny-Roos-Passage")
                .setDistanceInKilometers(new Distance(0.047d, DEFAULT_TEST_DISTANCE_METRIC))
                .setStartPoint(new Point.PointBuilder(8.452390d, 49.480165d).build())
                .setEndPoint(new Point.PointBuilder(8.452393d, 49.479744d).build())
                .setWalkingDirection(WalkingDirection.RIGHT)
                .setCompassDirection(CompassDirection.SOUTH)
                .setStreetNameGenerated(false)
                .setPlaceOrTrainPlatform(false)
                .build();
    }

    public static WalkStep getHenyRoosPassageToDestinationFootpathWalkStep() {
        return new WalkStep.WalkStepBuilder()
                .setStreetName(DEFAULT_TEST_FOOTPATH_STREET_NAME)
                .setDistanceInKilometers(new Distance(0.086d, DEFAULT_TEST_DISTANCE_METRIC))
                .setStartPoint(new Point.PointBuilder(8.452393d, 49.479744d).build())
                .setEndPoint(new Point.PointBuilder(8.453171d, 49.479153d).build())
                .setWalkingDirection(WalkingDirection.SLIGHTLY_LEFT)
                .setCompassDirection(CompassDirection.SOUTHEAST)
                .setStreetNameGenerated(true)
                .setPlaceOrTrainPlatform(false)
                .build();
    }

    public static WalkStep getHenyRoosPassageToDestinationPathWalkStep(LinkedList<Point> waypoints) {
        return new WalkStep.WalkStepBuilder()
                .setStreetName(DEFAULT_TEST_PATH_STREET_NAME)
                .setDistanceInKilometers(new Distance(0.003d, DEFAULT_TEST_DISTANCE_METRIC))
                .setStartPoint(new Point.PointBuilder(8.453171d, 49.479153d).build())
                .setEndPoint(extractEndPointFrom(waypoints))
                .setWalkingDirection(WalkingDirection.RIGHT)
                .setCompassDirection(CompassDirection.SOUTHWEST)
                .setStreetNameGenerated(false)
                .setPlaceOrTrainPlatform(false)
                .build();
    }

    private static Point extractEndPointFrom(LinkedList<Point> waypoints) {
        if (Optional.ofNullable(waypoints).isEmpty() || waypoints.size() == 0) {
            return null;
        }
        return new Point.PointBuilder(waypoints.getLast().getX(), waypoints.getLast().getY()).build();
    }

}
