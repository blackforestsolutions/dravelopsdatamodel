package de.blackforestsolutions.dravelopsdatamodel;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.TravelPointObjectMother.getTravelPointBuilderWithNoEmptyFields;
import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.TravelPointObjectMother.getTravelPointWithNoEmptyFields;
import static org.assertj.core.api.Assertions.assertThat;

class TravelPointMockIT {

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
    void test_travelPoint_with_all_properties_populated_to_be_dataSerializable() {
        TravelPoint testData = getTravelPointWithNoEmptyFields();
        UUID testKey = UUID.randomUUID();
        IMap<UUID, TravelPoint> testMap = hazelcastMock.getMap("travel-points");

        testMap.put(testKey, testData);
        TravelPoint result = testMap.get(testKey);

        assertThat(result).isEqualToComparingFieldByFieldRecursively(testData);
    }

    @Test
    void test_travelPoint_with_name_as_null_to_be_dataSerializable() {
        TravelPoint.TravelPointBuilder testData = getTravelPointBuilderWithNoEmptyFields();
        testData.setName(null);
        UUID testKey = UUID.randomUUID();
        IMap<UUID, TravelPoint> testMap = hazelcastMock.getMap("travel-points");

        testMap.put(testKey, testData.build());
        TravelPoint result = testMap.get(testKey);

        assertThat(result).isEqualToComparingFieldByFieldRecursively(testData.build());
    }

    @Test
    void test_travelPoint_with_point_as_null_to_be_dataSerializable() {
        TravelPoint.TravelPointBuilder testData = getTravelPointBuilderWithNoEmptyFields();
        testData.setPoint(null);
        UUID testKey = UUID.randomUUID();
        IMap<UUID, TravelPoint> testMap = hazelcastMock.getMap("travel-points");

        testMap.put(testKey, testData.build());
        TravelPoint result = testMap.get(testKey);

        assertThat(result).isEqualToComparingFieldByFieldRecursively(testData.build());
    }

    @Test
    void test_travelPoint_with_arrivalTime_as_null_to_be_dataSerializable() {
        TravelPoint.TravelPointBuilder testData = getTravelPointBuilderWithNoEmptyFields();
        testData.setArrivalTime(null);
        UUID testKey = UUID.randomUUID();
        IMap<UUID, TravelPoint> testMap = hazelcastMock.getMap("travel-points");

        testMap.put(testKey, testData.build());
        TravelPoint result = testMap.get(testKey);

        assertThat(result).isEqualToComparingFieldByFieldRecursively(testData.build());
    }

    @Test
    void test_travelPoint_with_departureTime_as_null_to_be_dataSerializable() {
        TravelPoint.TravelPointBuilder testData = getTravelPointBuilderWithNoEmptyFields();
        testData.setDepartureTime(null);
        UUID testKey = UUID.randomUUID();
        IMap<UUID, TravelPoint> testMap = hazelcastMock.getMap("travel-points");

        testMap.put(testKey, testData.build());
        TravelPoint result = testMap.get(testKey);

        assertThat(result).isEqualToComparingFieldByFieldRecursively(testData.build());
    }

    @Test
    void test_travelPoint_with_platform_as_null_to_be_dataSerializable() {
        TravelPoint.TravelPointBuilder testData = getTravelPointBuilderWithNoEmptyFields();
        testData.setPlatform(null);
        UUID testKey = UUID.randomUUID();
        IMap<UUID, TravelPoint> testMap = hazelcastMock.getMap("travel-points");

        testMap.put(testKey, testData.build());
        TravelPoint result = testMap.get(testKey);

        assertThat(result).isEqualToComparingFieldByFieldRecursively(testData.build());
    }

    @Test
    void test_travelPoint_with_no_properties_populated_to_be_dataSerializable() {
        TravelPoint testData = new TravelPoint.TravelPointBuilder().build();
        UUID testKey = UUID.randomUUID();
        IMap<UUID, TravelPoint> testMap = hazelcastMock.getMap("travel-points");

        testMap.put(testKey, testData);
        TravelPoint result = testMap.get(testKey);

        assertThat(result).isEqualToComparingFieldByFieldRecursively(testData);
    }
}
