package de.blackforestsolutions.dravelopsdatamodel;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

class TravelProviderTest {

    @Test
    void test_equals_and_hashCode_contract_for_travelProvider() {
        EqualsVerifier.simple().forClass(TravelProvider.class).verify();
    }
}
