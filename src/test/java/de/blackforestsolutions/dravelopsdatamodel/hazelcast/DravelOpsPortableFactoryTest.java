package de.blackforestsolutions.dravelopsdatamodel.hazelcast;

import com.hazelcast.nio.serialization.Portable;
import de.blackforestsolutions.dravelopsdatamodel.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DravelOpsPortableFactoryTest {

    private final DravelOpsPortableFactory classUnderTest = new DravelOpsPortableFactory();

    @Test
    void test_create_with_journeyClassId_returns_an_empty_journey() throws IOException {
        Journey expectedJourney = new Journey.JourneyBuilder().build();

        Portable result = classUnderTest.create(DravelOpsPortableFactory.JOURNEY_CLASS_ID);

        assertThat(result).isEqualToComparingFieldByField(expectedJourney);
    }

    @Test
    void test_create_with_legClassId_returns_an_empty_leg() {
        Leg expectedLeg = new Leg.LegBuilder().build();

        Portable result = classUnderTest.create(DravelOpsPortableFactory.LEG_CLASS_ID);

        assertThat(result).isEqualToComparingFieldByField(expectedLeg);
    }

    @Test
    void test_create_with_pointClassId_returns_an_empty_point() {
        Point expectedPoint = new Point.PointBuilder().build();

        Portable result = classUnderTest.create(DravelOpsPortableFactory.POINT_CLASS_ID);

        assertThat(result).isEqualToComparingFieldByField(expectedPoint);
    }

    @Test
    void test_create_with_priceClassId_returns_an_empty_price() {
        Price expectedPrice = new Price.PriceBuilder().build();

        Portable result = classUnderTest.create(DravelOpsPortableFactory.PRICE_CLASS_ID);

        assertThat(result).isEqualToComparingFieldByField(expectedPrice);
    }

    @Test
    void test_create_with_travelPointClassId_returns_an_empty_travelPoint() {
        TravelPoint expectedTravelPoint = new TravelPoint.TravelPointBuilder().build();

        Portable result = classUnderTest.create(DravelOpsPortableFactory.TRAVEL_POINT_CLASS_ID);

        assertThat(result).isEqualToComparingFieldByField(expectedTravelPoint);
    }

    @Test
    void test_create_with_travelProviderClassId_returns_an_empty_travelProvider() {
        TravelProvider expectedTravelProvider = new TravelProvider.TravelProviderBuilder().build();

        Portable result = classUnderTest.create(DravelOpsPortableFactory.TRAVEL_PROVIDER_CLASS_ID);

        assertThat(result).isEqualToComparingFieldByField(expectedTravelProvider);
    }

    @Test
    void test_with_unsupportedClassId_throws_illegalArgumentException() {
        int unsupportedClassId = Integer.MAX_VALUE;

        assertThrows(IllegalArgumentException.class, () -> classUnderTest.create(unsupportedClassId));
    }

}
