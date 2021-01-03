package de.blackforestsolutions.dravelopsdatamodel.hazelcast;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import de.blackforestsolutions.dravelopsdatamodel.Price;
import de.blackforestsolutions.dravelopsdatamodel.PriceType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static de.blackforestsolutions.dravelopsdatamodel.hazelcast.classdefinition.PriceClassDefinition.buildPriceClassDefinition;
import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.PriceObjectMother.getPriceBuilderWithNoEmptyFields;
import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.PriceObjectMother.getPriceWithNoEmptyFields;
import static org.assertj.core.api.Assertions.assertThat;

class PriceMockIT {

    private HazelcastInstance hazelcastMock;

    @BeforeEach
    void init() {
        Config config = new Config();
        config.getSerializationConfig().addPortableFactory(1, new DravelOpsPortableFactory());
        config.getSerializationConfig().addClassDefinition(buildPriceClassDefinition());

        hazelcastMock = Hazelcast.newHazelcastInstance(config);
    }

    @AfterEach
    void tearDown() {
        Hazelcast.shutdownAll();
    }

    @Test
    void test_price_with_all_properties_populated_to_be_portable() {
        Price testData = getPriceWithNoEmptyFields(PriceType.REGULAR);
        UUID testKey = UUID.randomUUID();
        IMap<UUID, Price> testMap = hazelcastMock.getMap("prices");

        testMap.put(testKey, testData);
        Price result = testMap.get(testKey);

        assertThat(result).isEqualToComparingFieldByField(testData);
    }

    @Test
    void test_price_with_priceType_as_null_to_be_portable() {
        Price.PriceBuilder testData = getPriceBuilderWithNoEmptyFields();
        testData.setPriceType(null);
        UUID testKey = UUID.randomUUID();
        IMap<UUID, Price> testMap = hazelcastMock.getMap("prices");

        testMap.put(testKey, testData.build());
        Price result = testMap.get(testKey);

        assertThat(result).isEqualToComparingFieldByField(testData.build());
    }

    @Test
    void test_price_with_currencyCode_as_null_to_be_portable() {
        Price.PriceBuilder testData = getPriceBuilderWithNoEmptyFields();
        testData.setCurrencyCode(null);
        UUID testKey = UUID.randomUUID();
        IMap<UUID, Price> testMap = hazelcastMock.getMap("prices");

        testMap.put(testKey, testData.build());
        Price result = testMap.get(testKey);

        assertThat(result).isEqualToComparingFieldByField(testData.build());
    }

    @Test
    void test_price_with_smallestCurrencyValue_as_null_to_be_portable() {
        Price.PriceBuilder testData = getPriceBuilderWithNoEmptyFields();
        testData.setSmallestCurrencyValue(null);
        UUID testKey = UUID.randomUUID();
        IMap<UUID, Price> testMap = hazelcastMock.getMap("prices");

        testMap.put(testKey, testData.build());
        Price result = testMap.get(testKey);

        assertThat(result).isEqualToComparingFieldByField(testData.build());
    }

    @Test
    void test_price_with_no_properties_populated_to_be_portable() {
        Price testData = new Price.PriceBuilder().build();
        UUID testKey = UUID.randomUUID();
        IMap<UUID, Price> testMap = hazelcastMock.getMap("prices");

        testMap.put(testKey, testData);
        Price result = testMap.get(testKey);

        assertThat(result).isEqualToComparingFieldByField(testData);
    }
}
