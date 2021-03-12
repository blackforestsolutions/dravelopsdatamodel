package de.blackforestsolutions.dravelopsdatamodel;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

class JourneyTest {

    @Test
    void test_equals_and_hashCode_contract_for_journey() {
        EqualsVerifier.simple().forClass(Journey.class).withIgnoredFields("id").verify();
    }
}
