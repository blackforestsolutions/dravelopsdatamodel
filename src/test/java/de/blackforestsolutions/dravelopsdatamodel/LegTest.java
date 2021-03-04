package de.blackforestsolutions.dravelopsdatamodel;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

class LegTest {

    @Test
    void test_equals_and_hashCode_contract_for_leg() {
        EqualsVerifier.simple().forClass(Leg.class).verify();
    }
}
