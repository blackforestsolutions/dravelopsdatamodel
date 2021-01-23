package de.blackforestsolutions.dravelopsdatamodel.objectmothers;

import de.blackforestsolutions.dravelopsdatamodel.Point;

import java.util.LinkedList;

public class WaypointsObjectMother {

    public static LinkedList<Point> getExampleWaypoints() {
        LinkedList<Point> track = new LinkedList<>();
        track.add(new Point.PointBuilder(7.95293d, 48.09047d).build());
        return track;
    }

    public static LinkedList<Point> getFurtwangenExampleWaypoints() {
        LinkedList<Point> track = new LinkedList<>();

        track.add(new Point.PointBuilder(7.95293d, 48.09047d).build());
        track.add(new Point.PointBuilder(7.95288d, 48.09046d).build());
        track.add(new Point.PointBuilder(7.95206d, 48.09034d).build());
        track.add(new Point.PointBuilder(7.95194d, 48.09025d).build());
        track.add(new Point.PointBuilder(7.95155d, 48.09020d).build());
        track.add(new Point.PointBuilder(7.95156d, 48.09018d).build());
        track.add(new Point.PointBuilder(7.95165d, 48.08995d).build());
        track.add(new Point.PointBuilder(7.95170d, 48.08985d).build());
        track.add(new Point.PointBuilder(7.95162d, 48.08982d).build());
        track.add(new Point.PointBuilder(7.95172d, 48.08951d).build());
        track.add(new Point.PointBuilder(7.95176d, 48.08932d).build());
        track.add(new Point.PointBuilder(7.95184d, 48.08903d).build());
        track.add(new Point.PointBuilder(7.95187d, 48.08885d).build());
        track.add(new Point.PointBuilder(7.95162d, 48.08882d).build());
        track.add(new Point.PointBuilder(7.95126d, 48.08878d).build());
        track.add(new Point.PointBuilder(7.95094d, 48.08875d).build());
        track.add(new Point.PointBuilder(7.95088d, 48.08874d).build());
        track.add(new Point.PointBuilder(7.95069d, 48.08871d).build());
        track.add(new Point.PointBuilder(7.95050d, 48.08867d).build());
        track.add(new Point.PointBuilder(7.95044d, 48.08866d).build());
        track.add(new Point.PointBuilder(7.95017d, 48.08857d).build());
        track.add(new Point.PointBuilder(7.95047d, 48.08829d).build());
        track.add(new Point.PointBuilder(7.95054d, 48.08822d).build());

        return track;
    }

    public static LinkedList<Point> getMannheimUniversityToMannheimBerlinerPlatzWaypoints() {
        LinkedList<Point> track = new LinkedList<>();

        track.add(new Point.PointBuilder(8.46334d, 49.48218d).build());
        track.add(new Point.PointBuilder(8.45857d, 49.48239d).build());
        track.add(new Point.PointBuilder(8.45065d, 49.48049d).build());

        return track;
    }
}
