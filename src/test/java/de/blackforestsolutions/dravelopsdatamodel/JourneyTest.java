package de.blackforestsolutions.dravelopsdatamodel;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.JourneyObjectMother.getJourneyBuilderWithNoEmptyFields;
import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.JourneyObjectMother.getJourneyWithNoEmptyFields;
import static org.assertj.core.api.Assertions.assertThat;

class JourneyTest {

    @Test
    void test_equals_and_hashCode_contract_for_journey() {
        EqualsVerifier.simple().forClass(Journey.class).withIgnoredFields("id").verify();
    }

    @Test
    void test_copy_constructor_returns_a_equal_journey_builder() {
        Journey testData = getJourneyWithNoEmptyFields();

        Journey.JourneyBuilder result = new Journey.JourneyBuilder(testData);

        assertThat(result).isEqualToComparingFieldByFieldRecursively(getJourneyBuilderWithNoEmptyFields());
    }
}
