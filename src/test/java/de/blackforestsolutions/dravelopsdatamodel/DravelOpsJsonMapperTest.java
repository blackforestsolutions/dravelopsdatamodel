package de.blackforestsolutions.dravelopsdatamodel;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;

import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.ApiTokenObjectMother.getApiTokenWithNoEmptyFields;
import static de.blackforestsolutions.dravelopsdatamodel.testutil.TestUtils.getResourceFileAsString;
import static org.apache.commons.lang.StringUtils.deleteWhitespace;
import static org.assertj.core.api.Assertions.assertThat;

class DravelOpsJsonMapperTest {

    private final DravelOpsJsonMapper classUnderTest = new DravelOpsJsonMapper();

    @Test
    void test_map_apiToken_returns_jsonObject() throws JsonProcessingException {
        ApiToken testData = getApiTokenWithNoEmptyFields();
        String expectedJsonApiToken = getResourceFileAsString("json/apitoken.json");

        String result = classUnderTest.map(testData);

        assertThat(deleteWhitespace(result)).isEqualTo(deleteWhitespace(expectedJsonApiToken));
    }

    @Test
    void test_mapJsonToApiToken_with_valid_json_returns_apiTokenObject() throws JsonProcessingException {
        String jsonApiToken = getResourceFileAsString("json/apitoken.json");
        ApiToken expectedApiToken = getApiTokenWithNoEmptyFields();

        ApiToken result = classUnderTest.mapJsonToApiToken(jsonApiToken);

        assertThat(result).isEqualToComparingFieldByField(expectedApiToken);
    }
}
