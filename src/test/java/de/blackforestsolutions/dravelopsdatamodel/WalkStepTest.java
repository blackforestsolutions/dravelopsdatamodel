package de.blackforestsolutions.dravelopsdatamodel;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

class WalkStepTest {

    @Test
    void test_equals_and_hashCode_contract_for_walkStep() {
        EqualsVerifier.simple().forClass(WalkStep.class).verify();
    }
}
