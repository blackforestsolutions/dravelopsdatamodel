package de.blackforestsolutions.dravelopsdatamodel;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.UUID;

import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.JourneyObjectMother.getJourneyBuilderWithNoEmptyFields;
import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.JourneyObjectMother.getJourneyWithNoEmptyFields;
import static org.assertj.core.api.Assertions.assertThat;

class JourneyMockIT {

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
    void test_journey_with_all_properties_populated_to_be_dataSerializable() {
        Journey testData = getJourneyWithNoEmptyFields();
        IMap<UUID, Journey> testMap = hazelcastMock.getMap("journeys");

        testMap.put(testData.getId(), testData);
        Journey result = testMap.get(testData.getId());

        assertThat(result).isEqualToComparingFieldByFieldRecursively(testData);
    }

    @Test
    void test_journey_with_id_as_null_to_be_dataSerializable() throws IOException {
        Journey testData = getJourneyBuilderWithNoEmptyFields().setId(null).build();
        UUID testKey = UUID.randomUUID();
        IMap<UUID, Journey> testMap = hazelcastMock.getMap("journeys");

        testMap.put(testKey, testData);
        Journey result = testMap.get(testKey);

        assertThat(result).isEqualToComparingFieldByFieldRecursively(testData);
    }

    @Test
    void test_journey_with_language_as_null_to_be_dataSerializable() throws IOException {
        Journey testData = getJourneyBuilderWithNoEmptyFields().setLanguage(null).build();
        IMap<UUID, Journey> testMap = hazelcastMock.getMap("journeys");

        testMap.put(testData.getId(), testData);
        Journey result = testMap.get(testData.getId());

        assertThat(result).isEqualToComparingFieldByFieldRecursively(testData);
    }

    @Test
    void test_journey_with_legs_as_null_to_be_dataSerializable() throws IOException {
        Journey testData = getJourneyBuilderWithNoEmptyFields().setLegs(null).build();
        IMap<UUID, Journey> testMap = hazelcastMock.getMap("journeys");

        testMap.put(testData.getId(), testData);
        Journey result = testMap.get(testData.getId());

        assertThat(result).isEqualToComparingFieldByFieldRecursively(testData);
    }

    @Test
    void test_journey_with_prices_as_null_to_be_dataSerializable() throws IOException {
        Journey testData = getJourneyBuilderWithNoEmptyFields().setPrices(null).build();
        IMap<UUID, Journey> testMap = hazelcastMock.getMap("journeys");

        testMap.put(testData.getId(), testData);
        Journey result = testMap.get(testData.getId());

        assertThat(result).isEqualToComparingFieldByFieldRecursively(testData);
    }

    @Test
    void test_journey_with_no_properties_populated_to_be_dataSerializable() throws IOException {
        Journey.JourneyBuilder testData = new Journey.JourneyBuilder(null);
        UUID testKey = UUID.randomUUID();
        IMap<UUID, Journey> testMap = hazelcastMock.getMap("journeys");

        testMap.put(testKey, testData.build());
        Journey result = testMap.get(testKey);

        assertThat(result).isEqualToComparingFieldByFieldRecursively(testData.build());
    }
}
