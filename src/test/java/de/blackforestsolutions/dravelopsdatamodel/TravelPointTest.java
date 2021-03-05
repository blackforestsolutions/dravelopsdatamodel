package de.blackforestsolutions.dravelopsdatamodel;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

class TravelPointTest {

    @Test
    void test_equals_and_hashCode_contract_for_travelPoint() {
        EqualsVerifier.simple().forClass(TravelPoint.class).verify();
    }
}
