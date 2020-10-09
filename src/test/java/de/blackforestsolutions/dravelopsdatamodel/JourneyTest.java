package de.blackforestsolutions.dravelopsdatamodel;

import de.blackforestsolutions.dravelopsdatamodel.objectmothers.JourneyObjectMother;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JourneyTest {

    @Test
    void test_setLegs_and_setPrices_with_double_price_and_double_legs_are_sorted_out() {
        Journey testData = JourneyObjectMother.getJourneyWithDoubleLegAndPriceKey();

        assertThat(testData.getLegs().size()).isEqualTo(2);
        assertThat(testData.getPrices().size()).isEqualTo(2);
    }
}
