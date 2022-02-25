package de.blackforestsolutions.dravelopsdatamodel;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.TravelProviderObjectMother.getSuedbadenTravelProvider;
import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.TravelProviderObjectMother.getTravelProviderBuilderWithNoEmptyFields;
import static org.assertj.core.api.Assertions.assertThat;

class TravelProviderMockIT {

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
    void test_travelProvider_with_all_properties_populated_to_be_dataSerializable() {
        TravelProvider testData = getSuedbadenTravelProvider();
        UUID testKey = UUID.randomUUID();
        IMap<UUID, TravelProvider> testMap = hazelcastMock.getMap("travel-providers");

        testMap.put(testKey, testData);
        TravelProvider result = testMap.get(testKey);

        assertThat(result).isEqualToComparingFieldByField(testData);
    }

    @Test
    void test_travelProvider_with_id_as_null_to_be_dataSerializable() {
        TravelProvider.TravelProviderBuilder testData = getTravelProviderBuilderWithNoEmptyFields();
        testData.setId(null);
        UUID testKey = UUID.randomUUID();
        IMap<UUID, TravelProvider> testMap = hazelcastMock.getMap("travel-providers");

        testMap.put(testKey, testData.build());
        TravelProvider result = testMap.get(testKey);

        assertThat(result).isEqualToComparingFieldByField(testData.build());
    }

    @Test
    void test_travelProvider_with_name_as_null_to_be_dataSerializable() {
        TravelProvider.TravelProviderBuilder testData = getTravelProviderBuilderWithNoEmptyFields();
        testData.setName(null);
        UUID testKey = UUID.randomUUID();
        IMap<UUID, TravelProvider> testMap = hazelcastMock.getMap("travel-providers");

        testMap.put(testKey, testData.build());
        TravelProvider result = testMap.get(testKey);

        assertThat(result).isEqualToComparingFieldByField(testData.build());
    }

    @Test
    void test_travelProvider_with_url_as_null_to_be_dataSerializable() {
        TravelProvider.TravelProviderBuilder testData = getTravelProviderBuilderWithNoEmptyFields();
        testData.setUrl(null);
        UUID testKey = UUID.randomUUID();
        IMap<UUID, TravelProvider> testMap = hazelcastMock.getMap("travel-providers");

        testMap.put(testKey, testData.build());
        TravelProvider result = testMap.get(testKey);

        assertThat(result).isEqualToComparingFieldByField(testData.build());
    }

    @Test
    void test_travelProvider_with_no_properties_populated_to_be_dataSerializable() {
        TravelProvider testData = new TravelProvider.TravelProviderBuilder().build();
        UUID testKey = UUID.randomUUID();
        IMap<UUID, TravelProvider> testMap = hazelcastMock.getMap("travel-providers");

        testMap.put(testKey, testData);
        TravelProvider result = testMap.get(testKey);

        assertThat(result).isEqualToComparingFieldByField(testData);
    }
}
