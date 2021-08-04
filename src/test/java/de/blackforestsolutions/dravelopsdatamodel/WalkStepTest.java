package de.blackforestsolutions.dravelopsdatamodel;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.WalkStepObjectMother.getWalkStepBuilderWithNoEmptyFields;
import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.WalkStepObjectMother.getWalkStepWithNoEmptyFields;
import static org.assertj.core.api.Assertions.assertThat;

class WalkStepTest {

    @Test
    void test_equals_and_hashCode_contract_for_walkStep() {
        EqualsVerifier.simple().forClass(WalkStep.class).verify();
    }

    @Test
    void test_copy_constructor_returns_a_equal_walkStep_builder() {
        WalkStep testData = getWalkStepWithNoEmptyFields();

        WalkStep.WalkStepBuilder result = new WalkStep.WalkStepBuilder(testData);

        assertThat(result).isEqualToComparingFieldByFieldRecursively(getWalkStepBuilderWithNoEmptyFields());
    }
}
