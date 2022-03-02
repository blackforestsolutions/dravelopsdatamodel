package de.blackforestsolutions.dravelopsdatamodel;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.TravelPointObjectMother.getTravelPointBuilderWithNoEmptyFields;
import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.TravelPointObjectMother.getTravelPointWithNoEmptyFields;
import static org.assertj.core.api.Assertions.assertThat;

class TravelPointTest {

    @Test
    void test_equals_and_hashCode_contract_for_travelPoint() {
        EqualsVerifier.simple().forClass(TravelPoint.class).verify();
    }

    @Test
    void test_copy_constructor_returns_a_equal_travel_point_builder() {
        TravelPoint testData = getTravelPointWithNoEmptyFields();

        TravelPoint.TravelPointBuilder result = new TravelPoint.TravelPointBuilder(testData);

        assertThat(result).isEqualToComparingFieldByFieldRecursively(getTravelPointBuilderWithNoEmptyFields());
    }
}
