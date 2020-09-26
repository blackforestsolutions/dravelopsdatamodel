package de.blackforestsolutions.dravelopsdatamodel;

import org.springframework.data.geo.Point;

import java.io.Serializable;
import java.time.LocalDateTime;

public final class TravelPoint implements Serializable {

    private final String name;
    private final Point coordinates;
    private final LocalDateTime arrivalTime;
    private final LocalDateTime departureTime;
    private final String platform;
    private final VertexType vertexType;

    public TravelPoint(String name, Point coordinates, LocalDateTime arrivalTime, LocalDateTime departureTime, String platform, VertexType vertexType) {
        this.name = name;
        this.coordinates = coordinates;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.platform = platform;
        this.vertexType = vertexType;
    }
}
