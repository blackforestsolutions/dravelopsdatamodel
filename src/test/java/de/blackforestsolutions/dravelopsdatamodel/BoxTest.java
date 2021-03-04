package de.blackforestsolutions.dravelopsdatamodel;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

class BoxTest {

    @Test
    void test_equals_and_hashCode_contract_for_box() {
        EqualsVerifier.simple().forClass(Box.class).verify();
    }
}
