package de.blackforestsolutions.dravelopsdatamodel.objectmothers;

import org.springframework.data.geo.Point;

import java.util.LinkedList;

public class WaypointsObjectMother {

    public static LinkedList<Point> getExampleWaypoints() {
        LinkedList<Point> track = new LinkedList<>();
        track.add(new Point(7.95293d, 48.09047d));
        return track;
    }

    public static LinkedList<Point> getFurtwangenExampleWaypoints() {
        LinkedList<Point> track = new LinkedList<>();

        track.add(new Point(7.95293d, 48.09047d));
        track.add(new Point(7.95288d, 48.09046d));
        track.add(new Point(7.95206d, 48.09034d));
        track.add(new Point(7.95194d, 48.09025d));
        track.add(new Point(7.95155d, 48.09020d));
        track.add(new Point(7.95156d, 48.09018d));
        track.add(new Point(7.95165d, 48.08995d));
        track.add(new Point(7.95170d, 48.08985d));
        track.add(new Point(7.95162d, 48.08982d));
        track.add(new Point(7.95172d, 48.08951d));
        track.add(new Point(7.95176d, 48.08932d));
        track.add(new Point(7.95184d, 48.08903d));
        track.add(new Point(7.95187d, 48.08885d));
        track.add(new Point(7.95162d, 48.08882d));
        track.add(new Point(7.95126d, 48.08878d));
        track.add(new Point(7.95094d, 48.08875d));
        track.add(new Point(7.95088d, 48.08874d));
        track.add(new Point(7.95069d, 48.08871d));
        track.add(new Point(7.95050d, 48.08867d));
        track.add(new Point(7.95044d, 48.08866d));
        track.add(new Point(7.95017d, 48.08857d));
        track.add(new Point(7.95047d, 48.08829d));
        track.add(new Point(7.95054d, 48.08822d));

        return track;
    }

    public static LinkedList<Point> getMannheimUniversityToMannheimBerlinerPlatzWaypoints() {
        LinkedList<Point> track = new LinkedList<>();

        track.add(new Point(8.46334d, 49.48218d));
        track.add(new Point(8.45857d, 49.48239d));
        track.add(new Point(8.45065d, 49.48049d));

        return track;
    }
}
