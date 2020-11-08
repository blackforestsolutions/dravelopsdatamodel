package de.blackforestsolutions.dravelopsdatamodel.util;

import org.junit.jupiter.api.Test;

import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.ApiTokenObjectMother.getApiTokenBuilderWithNoEmptyFields;
import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.ApiTokenObjectMother.getApiTokenWithNoEmptyFields;
import static org.assertj.core.api.Assertions.assertThat;

class ApiTokenTest {

    @Test
    void test_build_returns_an_equal_apiToken() {
        ApiToken.ApiTokenBuilder testData = getApiTokenBuilderWithNoEmptyFields();
        ApiToken expectedApiToken = getApiTokenWithNoEmptyFields();

        ApiToken result = testData.build();

        assertThat(result).isEqualToComparingFieldByField(expectedApiToken);
    }

    @Test
    void test_copy_constructor_returns_an_equal_apiToken() {
        ApiToken testData = getApiTokenWithNoEmptyFields();
        ApiToken.ApiTokenBuilder expectedApiTokenBuilder = getApiTokenBuilderWithNoEmptyFields();

        ApiToken.ApiTokenBuilder result = new ApiToken.ApiTokenBuilder(testData);

        assertThat(result).isEqualToComparingFieldByField(expectedApiTokenBuilder);
    }

    @Test
    void test_copy_constructor_returns_an_equal_apiToken_and_different_reference() {
        ApiToken.ApiTokenBuilder testData = getApiTokenBuilderWithNoEmptyFields();

        ApiToken.ApiTokenBuilder result = new ApiToken.ApiTokenBuilder(testData);

        assertThat(result).isEqualToComparingFieldByField(testData);
        assertThat(result).isNotEqualTo(testData);
    }
}
