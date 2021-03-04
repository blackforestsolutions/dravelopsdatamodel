package de.blackforestsolutions.dravelopsdatamodel;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

class PointTest {

    @Test
    void test_equals_and_hashCode_contract_for_point() {
        EqualsVerifier.simple().forClass(Point.class).verify();
    }
}
