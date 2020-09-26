package de.blackforestsolutions.dravelopsdatamodel;

import java.io.Serializable;

public final class WalkStep implements Serializable { // todo
    public double distance = 0;

    //public RelativeDirection relativeDirection;

    public String streetName;

    // public AbsoluteDirection absoluteDirection;

    public String exit;

    public Boolean stayOn = false;

    public Boolean area = false;

    //   public final Set<StreetNote> streetNotes = new HashSet<>();

    public double angle;

    // public List<Edge> edges = Lists.newArrayList();

    //  public BikeRentalStationInfo bikeRentalOnStation;

    //  public BikeRentalStationInfo bikeRentalOffStation;


}
