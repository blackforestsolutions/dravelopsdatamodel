package de.blackforestsolutions.dravelopsdatamodel;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.LegObjectMother.getLegBuilderWithNoEmptyFields;
import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.LegObjectMother.getLegWithNoEmptyFields;
import static org.assertj.core.api.Assertions.assertThat;

class LegTest {

    @Test
    void test_equals_and_hashCode_contract_for_leg() {
        EqualsVerifier.simple().forClass(Leg.class).withIgnoredFields("tripId").verify();
    }

    @Test
    void test_copy_constructor_returns_a_equal_leg_builder() {
        Leg testData = getLegWithNoEmptyFields();

        Leg.LegBuilder result = new Leg.LegBuilder(testData);

        assertThat(result).isEqualToComparingFieldByFieldRecursively(getLegBuilderWithNoEmptyFields());
    }
}
