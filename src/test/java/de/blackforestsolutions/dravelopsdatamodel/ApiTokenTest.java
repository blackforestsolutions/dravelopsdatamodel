package de.blackforestsolutions.dravelopsdatamodel;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.ApiTokenObjectMother.getApiTokenWithNoEmptyFields;
import static org.assertj.core.api.Assertions.assertThat;

class ApiTokenTest {

    @Test
    void test_equals_and_hashCode_contract_for_apiToken() {
        EqualsVerifier.simple().forClass(ApiToken.class).verify();
    }

    @Test
    void test_copy_constructor_returns_an_equal_apiToken() {
        ApiToken testData = getApiTokenWithNoEmptyFields();

        ApiToken result = new ApiToken(testData);

        assertThat(result).isEqualToComparingFieldByFieldRecursively(testData);
    }
}
