package de.blackforestsolutions.dravelopsdatamodel;

import de.blackforestsolutions.dravelopsdatamodel.objectmothers.JourneyObjectMother;
import org.junit.jupiter.api.Test;

import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.UUIDObjectMother.TEST_UUID_2;
import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.UUIDObjectMother.TEST_UUID_3;
import static org.assertj.core.api.Assertions.assertThat;

class JourneyTest {

    @Test
    void test_setLegs_with_double_legs_are_sorted_out_and_order_is_not_different() {
        Journey testData = JourneyObjectMother.getJourneyWithDoubleLegAndPriceKey();

        assertThat(testData.getLegs().size()).isEqualTo(2);
        assertThat(testData.getLegs().get(0).getId()).isEqualTo(TEST_UUID_2);
        assertThat(testData.getLegs().get(1).getId()).isEqualTo(TEST_UUID_3);
    }

    @Test
    void test_setPrices_with_double_price_returns_sorted_and_distinct_prices() {
        Journey testData = JourneyObjectMother.getJourneyWithDoubleLegAndPriceKey();

        assertThat(testData.getPrices().size()).isEqualTo(2);
        assertThat(testData.getPrices().get(0).getPriceType()).isEqualTo(PriceType.REGULAR);
        assertThat(testData.getPrices().get(1).getPriceType()).isEqualTo(PriceType.SENIOR);
    }
}
