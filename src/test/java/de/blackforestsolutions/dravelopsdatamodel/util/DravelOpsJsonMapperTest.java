package de.blackforestsolutions.dravelopsdatamodel.util;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.ApiTokenObjectMother.getApiTokenWithNoEmptyFields;
import static de.blackforestsolutions.dravelopsdatamodel.testutil.TestUtils.getResourceFileAsString;
import static org.apache.commons.lang.StringUtils.deleteWhitespace;
import static org.assertj.core.api.Assertions.assertThat;

class DravelOpsJsonMapperTest {

    private final DravelOpsJsonMapper classUnderTest = new DravelOpsJsonMapper();

    @Test
    void test_map_apiToken_returns_jsonObject() {
        ApiToken testData = getApiTokenWithNoEmptyFields();
        String expectedJsonApiToken = getResourceFileAsString("json/apitoken.json");

        Mono<String> result = classUnderTest.map(testData);

        StepVerifier.create(result)
                .assertNext(apiToken -> assertThat(deleteWhitespace(apiToken)).isEqualTo(deleteWhitespace(expectedJsonApiToken)))
                .verifyComplete();
    }

    @Test
    void test_mapJsonToApiToken_with_valid_json_returns_apiTokenObject() {
        String jsonApiToken = getResourceFileAsString("json/apitoken.json");
        ApiToken expectedApiToken = getApiTokenWithNoEmptyFields();

        Mono<ApiToken> result = classUnderTest.mapJsonToApiToken(jsonApiToken);

        StepVerifier.create(result)
                .assertNext(apiToken -> assertThat(apiToken).isEqualToComparingFieldByField(expectedApiToken))
                .verifyComplete();
    }

    @Test
    void test_mapJsonToApiToken_with_invalid_json_returns_error() {
        String jsonError = "";

        Mono<ApiToken> result = classUnderTest.mapJsonToApiToken(jsonError);

        StepVerifier.create(result)
                .expectError(MismatchedInputException.class)
                .verify();
    }
}
