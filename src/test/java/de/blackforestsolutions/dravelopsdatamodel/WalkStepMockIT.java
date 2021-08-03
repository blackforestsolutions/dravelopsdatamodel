package de.blackforestsolutions.dravelopsdatamodel;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.WalkStepObjectMother.getWalkStepBuilderWithNoEmptyFields;
import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.WalkStepObjectMother.getWalkStepWithNoEmptyFields;
import static org.assertj.core.api.Assertions.assertThat;

class WalkStepMockIT {

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
    void test_walkStep_with_all_properties_populated_to_be_dataSerializable() {
        WalkStep testData = getWalkStepWithNoEmptyFields();
        UUID testKey = UUID.randomUUID();
        IMap<UUID, WalkStep> testMap = hazelcastMock.getMap("walk-steps");

        testMap.put(testKey, testData);
        WalkStep result = testMap.get(testKey);

        assertThat(result).isEqualToComparingFieldByFieldRecursively(testData);
    }

    @Test
    void test_walkStep_with_streetName_as_null_to_be_dataSerializable() {
        WalkStep.WalkStepBuilder testData = getWalkStepBuilderWithNoEmptyFields();
        testData.setStreetName(null);
        UUID testKey = UUID.randomUUID();
        IMap<UUID, WalkStep> testMap = hazelcastMock.getMap("walk-steps");

        testMap.put(testKey, testData.build());
        WalkStep result = testMap.get(testKey);

        assertThat(result).isEqualToComparingFieldByFieldRecursively(testData);
    }

    @Test
    void test_walkStep_with_distanceInKilometers_as_null_to_be_dataSerializable() {
        WalkStep.WalkStepBuilder testData = getWalkStepBuilderWithNoEmptyFields();
        testData.setDistanceInKilometers(null);
        UUID testKey = UUID.randomUUID();
        IMap<UUID, WalkStep> testMap = hazelcastMock.getMap("walk-steps");

        testMap.put(testKey, testData.build());
        WalkStep result = testMap.get(testKey);

        assertThat(result).isEqualToComparingFieldByFieldRecursively(testData);
    }

    @Test
    void test_walkStep_with_startPoint_as_null_to_be_dataSerializable() {
        WalkStep.WalkStepBuilder testData = getWalkStepBuilderWithNoEmptyFields();
        testData.setStartPoint(null);
        UUID testKey = UUID.randomUUID();
        IMap<UUID, WalkStep> testMap = hazelcastMock.getMap("walk-steps");

        testMap.put(testKey, testData.build());
        WalkStep result = testMap.get(testKey);

        assertThat(result).isEqualToComparingFieldByFieldRecursively(testData);
    }

    @Test
    void test_walkStep_with_endPoint_as_null_to_be_dataSerializable() {
        WalkStep.WalkStepBuilder testData = getWalkStepBuilderWithNoEmptyFields();
        testData.setEndPoint(null);
        UUID testKey = UUID.randomUUID();
        IMap<UUID, WalkStep> testMap = hazelcastMock.getMap("walk-steps");

        testMap.put(testKey, testData.build());
        WalkStep result = testMap.get(testKey);

        assertThat(result).isEqualToComparingFieldByFieldRecursively(testData);
    }

    @Test
    void test_walkStep_with_walkingDirection_as_null_to_be_dataSerializable() {
        WalkStep.WalkStepBuilder testData = getWalkStepBuilderWithNoEmptyFields();
        testData.setWalkingDirection(null);
        UUID testKey = UUID.randomUUID();
        IMap<UUID, WalkStep> testMap = hazelcastMock.getMap("walk-steps");

        testMap.put(testKey, testData.build());
        WalkStep result = testMap.get(testKey);

        assertThat(result).isEqualToComparingFieldByFieldRecursively(testData);
    }

    @Test
    void test_walkStep_with_compassDirection_as_null_to_be_dataSerializable() {
        WalkStep.WalkStepBuilder testData = getWalkStepBuilderWithNoEmptyFields();
        testData.setCompassDirection(null);
        UUID testKey = UUID.randomUUID();
        IMap<UUID, WalkStep> testMap = hazelcastMock.getMap("walk-steps");

        testMap.put(testKey, testData.build());
        WalkStep result = testMap.get(testKey);

        assertThat(result).isEqualToComparingFieldByFieldRecursively(testData);
    }

    @Test
    void test_walkStep_with_circleExit_as_null_to_be_dataSerializable() {
        WalkStep.WalkStepBuilder testData = getWalkStepBuilderWithNoEmptyFields();
        testData.setCircleExit(null);
        UUID testKey = UUID.randomUUID();
        IMap<UUID, WalkStep> testMap = hazelcastMock.getMap("walk-steps");

        testMap.put(testKey, testData.build());
        WalkStep result = testMap.get(testKey);

        assertThat(result).isEqualToComparingFieldByFieldRecursively(testData);
    }

    @Test
    void test_walkStep_with_no_properties_populated_to_be_dataSerializable() {
        WalkStep.WalkStepBuilder testData = new WalkStep.WalkStepBuilder();
        UUID testKey = UUID.randomUUID();
        IMap<UUID, WalkStep> testMap = hazelcastMock.getMap("walk-steps");

        testMap.put(testKey, testData.build());
        WalkStep result = testMap.get(testKey);

        assertThat(result).isEqualToComparingFieldByFieldRecursively(testData);
    }
}
