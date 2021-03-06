package de.blackforestsolutions.dravelopsdatamodel;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class PointMockIT {

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
    void test_point_with_all_properties_populated_to_be_dataSerializable() {
        Point testData = new Point.PointBuilder(0.0d, 0.0d).build();
        UUID testKey = UUID.randomUUID();
        IMap<UUID, Point> testMap = hazelcastMock.getMap("points");

        testMap.put(testKey, testData);
        Point result = testMap.get(testKey);

        assertThat(result).isEqualToComparingFieldByField(testData);
    }

    @Test
    void test_point_with_no_properties_populated_to_be_dataSerializable() {
        Point testData = new Point.PointBuilder().build();
        UUID testKey = UUID.randomUUID();
        IMap<UUID, Point> testMap = hazelcastMock.getMap("points");

        testMap.put(testKey, testData);
        Point result = testMap.get(testKey);

        assertThat(result).isEqualToComparingFieldByField(testData);
    }

}
