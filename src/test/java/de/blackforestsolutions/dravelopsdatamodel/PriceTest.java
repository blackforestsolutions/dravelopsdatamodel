package de.blackforestsolutions.dravelopsdatamodel;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

class PriceTest {

    @Test
    void test_equals_and_hashCode_contract_for_price() {
        EqualsVerifier.simple().forClass(Price.class).verify();
    }
}
