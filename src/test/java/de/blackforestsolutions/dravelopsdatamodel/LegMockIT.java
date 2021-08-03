package de.blackforestsolutions.dravelopsdatamodel;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.LegObjectMother.getLegBuilderWithNoEmptyFields;
import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.LegObjectMother.getLegWithNoEmptyFields;
import static org.assertj.core.api.Assertions.assertThat;

class LegMockIT {

    private HazelcastInstance hazelcastMock;

    @BeforeEach
    void init() {
        hazelcastMock = Hazelcast.newHazelcastInstance();
    }

    @AfterEach
    void tearDown() {
        Hazelcast.shutdownAll();
    }

    @Test
    void test_leg_with_all_properties_populated_to_be_dataSerializable() {
        Leg testData = getLegWithNoEmptyFields();
        UUID testKey = UUID.randomUUID();
        IMap<UUID, Leg> testMap = hazelcastMock.getMap("legs");

        testMap.put(testKey, testData);
        Leg result = testMap.get(testKey);

        assertThat(result).isEqualToComparingFieldByFieldRecursively(testData);
    }

    @Test
    void test_with_departure_as_null_leg_to_be_dataSerializable() {
        Leg.LegBuilder testData = getLegBuilderWithNoEmptyFields();
        testData.setDeparture(null);
        UUID testKey = UUID.randomUUID();
        IMap<UUID, Leg> testMap = hazelcastMock.getMap("legs");

        testMap.put(testKey, testData.build());
        Leg result = testMap.get(testKey);

        assertThat(result).isEqualToComparingFieldByFieldRecursively(testData.build());
    }

    @Test
    void test_with_arrival_as_null_leg_to_be_dataSerializable() {
        Leg.LegBuilder testData = getLegBuilderWithNoEmptyFields();
        testData.setArrival(null);
        UUID testKey = UUID.randomUUID();
        IMap<UUID, Leg> testMap = hazelcastMock.getMap("legs");

        testMap.put(testKey, testData.build());
        Leg result = testMap.get(testKey);

        assertThat(result).isEqualToComparingFieldByFieldRecursively(testData.build());
    }

    @Test
    void test_leg_delayInMinutes_as_null_to_be_dataSerializable_with() {
        Leg.LegBuilder testData = getLegBuilderWithNoEmptyFields();
        testData.setDelayInMinutes(null);
        UUID testKey = UUID.randomUUID();
        IMap<UUID, Leg> testMap = hazelcastMock.getMap("legs");

        testMap.put(testKey, testData.build());
        Leg result = testMap.get(testKey);

        assertThat(result).isEqualToComparingFieldByFieldRecursively(testData.build());
    }

    @Test
    void test_leg_with_distanceInKilometers_as_null_to_be_dataSerializable() {
        Leg.LegBuilder testData = getLegBuilderWithNoEmptyFields();
        testData.setDistanceInKilometers(null);
        UUID testKey = UUID.randomUUID();
        IMap<UUID, Leg> testMap = hazelcastMock.getMap("legs");

        testMap.put(testKey, testData.build());
        Leg result = testMap.get(testKey);

        assertThat(result).isEqualToComparingFieldByFieldRecursively(testData.build());
    }

    @Test
    void test_leg_with_vehicleType_as_null_to_be_dataSerializable() {
        Leg.LegBuilder testData = getLegBuilderWithNoEmptyFields();
        testData.setVehicleType(null);
        UUID testKey = UUID.randomUUID();
        IMap<UUID, Leg> testMap = hazelcastMock.getMap("legs");

        testMap.put(testKey, testData.build());
        Leg result = testMap.get(testKey);

        assertThat(result).isEqualToComparingFieldByFieldRecursively(testData.build());
    }

    @Test
    void test_leg_with_polyline_as_null_to_be_dataSerializable() {
        Leg.LegBuilder testData = getLegBuilderWithNoEmptyFields();
        testData.setPolyline(null);
        UUID testKey = UUID.randomUUID();
        IMap<UUID, Leg> testMap = hazelcastMock.getMap("legs");

        testMap.put(testKey, testData.build());
        Leg result = testMap.get(testKey);

        assertThat(result).isEqualToComparingFieldByFieldRecursively(testData.build());
    }

    @Test
    void test_leg_with_waypoints_as_null_to_be_dataSerializable() {
        Leg.LegBuilder testData = getLegBuilderWithNoEmptyFields();
        testData.setWaypoints(null);
        UUID testKey = UUID.randomUUID();
        IMap<UUID, Leg> testMap = hazelcastMock.getMap("legs");

        testMap.put(testKey, testData.build());
        Leg result = testMap.get(testKey);

        assertThat(result).isEqualToComparingFieldByFieldRecursively(testData.build());
    }

    @Test
    void test_leg_with_travelProvider_as_null_to_be_dataSerializable() {
        Leg.LegBuilder testData = getLegBuilderWithNoEmptyFields();
        testData.setTravelProvider(null);
        UUID testKey = UUID.randomUUID();
        IMap<UUID, Leg> testMap = hazelcastMock.getMap("legs");

        testMap.put(testKey, testData.build());
        Leg result = testMap.get(testKey);

        assertThat(result).isEqualToComparingFieldByFieldRecursively(testData.build());
    }

    @Test
    void test_leg_with_vehicleNumber_as_null_to_be_dataSerializable() {
        Leg.LegBuilder testData = getLegBuilderWithNoEmptyFields();
        testData.setVehicleNumber(null);
        UUID testKey = UUID.randomUUID();
        IMap<UUID, Leg> testMap = hazelcastMock.getMap("legs");

        testMap.put(testKey, testData.build());
        Leg result = testMap.get(testKey);

        assertThat(result).isEqualToComparingFieldByFieldRecursively(testData.build());
    }

    @Test
    void test_leg_with_vehicleName_as_null_to_be_dataSerializable() {
        Leg.LegBuilder testData = getLegBuilderWithNoEmptyFields();
        testData.setVehicleName(null);
        UUID testKey = UUID.randomUUID();
        IMap<UUID, Leg> testMap = hazelcastMock.getMap("legs");

        testMap.put(testKey, testData.build());
        Leg result = testMap.get(testKey);

        assertThat(result).isEqualToComparingFieldByFieldRecursively(testData.build());
    }

    @Test
    void test_leg_with_intermediateStops_as_null_to_be_dataSerializable() {
        Leg.LegBuilder testData = getLegBuilderWithNoEmptyFields();
        testData.setIntermediateStops(null);
        UUID testKey = UUID.randomUUID();
        IMap<UUID, Leg> testMap = hazelcastMock.getMap("legs");

        testMap.put(testKey, testData.build());
        Leg result = testMap.get(testKey);

        assertThat(result).isEqualToComparingFieldByFieldRecursively(testData.build());
    }

    @Test
    void test_leg_with_walkSteps_as_null_to_be_dataSerializable() {
        Leg.LegBuilder testData = getLegBuilderWithNoEmptyFields();
        testData.setWalkSteps(null);
        UUID testKey = UUID.randomUUID();
        IMap<UUID, Leg> testMap = hazelcastMock.getMap("legs");

        testMap.put(testKey, testData.build());
        Leg result = testMap.get(testKey);

        assertThat(result).isEqualToComparingFieldByFieldRecursively(testData.build());
    }

    @Test
    void test_leg_with_no_properties_populated_to_be_dataSerializable() {
        Leg.LegBuilder testData = new Leg.LegBuilder();
        UUID testKey = UUID.randomUUID();
        IMap<UUID, Leg> testMap = hazelcastMock.getMap("legs");

        testMap.put(testKey, testData.build());
        Leg result = testMap.get(testKey);

        assertThat(result).isEqualToComparingFieldByFieldRecursively(testData.build());
    }
}
