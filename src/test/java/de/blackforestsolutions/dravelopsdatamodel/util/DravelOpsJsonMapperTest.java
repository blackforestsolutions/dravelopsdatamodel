package de.blackforestsolutions.dravelopsdatamodel.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import de.blackforestsolutions.dravelopsdatamodel.*;
import org.junit.jupiter.api.Test;
import org.locationtech.jts.geom.Polygon;

import java.util.Map;

import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.ApiTokenObjectMother.getApiTokenWithNoEmptyFields;
import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.ApiTokenObjectMother.getTestSoftwareApiTokens;
import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.BoxObjectMother.getBoxWithNoEmptyFields;
import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.CallStatusObjectMother.getSuccessfulJourneyCallStatusTab;
import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.JourneyObjectMother.getJourneyWithNoEmptyFields;
import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.PolygonObjectMother.getPolygonWithNoEmptyFields;
import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.TravelPointObjectMother.getTravelPointWithNoEmptyFields;
import static de.blackforestsolutions.dravelopsdatamodel.testutil.TestUtils.getResourceFileAsString;
import static org.apache.commons.lang.StringUtils.deleteWhitespace;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DravelOpsJsonMapperTest {

    private final DravelOpsJsonMapper classUnderTest = new DravelOpsJsonMapper();

    @Test
    void test_writeValueAsString_with_apiToken_returns_jsonObject() throws JsonProcessingException {
        ApiToken testData = getApiTokenWithNoEmptyFields();
        String expectedJsonApiToken = getResourceFileAsString("json/apitoken.json");

        String result = classUnderTest.writeValueAsString(testData);

        assertThat(deleteWhitespace(result)).isEqualTo(deleteWhitespace(expectedJsonApiToken));
    }

    @Test
    void test_readValue_with_valid_json_returns_apiTokenObject_and_correct_languages() throws JsonProcessingException {
        String jsonApiToken = getResourceFileAsString("json/apitoken.json");
        ApiToken expectedApiToken = getApiTokenWithNoEmptyFields();

        ApiToken result = classUnderTest.readValue(jsonApiToken, ApiToken.class);

        assertThat(result).isEqualToComparingFieldByFieldRecursively(expectedApiToken);
        assertThat(result.getLanguage().toLanguageTag()).isEqualTo("de");
        assertThat(result.getLanguage().getLanguage()).isEqualTo("de");
    }

    @Test
    void test_readValue_with_invalid_json_throws_error() {
        String jsonError = "";

        assertThrows(MismatchedInputException.class, () -> classUnderTest.readValue(jsonError, ApiToken.class));
    }

    @Test
    void test_writeValueAsString_with_journey_returns_journey_as_json_string() throws JsonProcessingException {
        Journey testData = getJourneyWithNoEmptyFields();
        String expectedJsonJourney = getResourceFileAsString("json/journey.json");

        String result = classUnderTest.writeValueAsString(testData);

        assertThat(deleteWhitespace(result)).isEqualTo(deleteWhitespace(expectedJsonJourney));
    }

    @Test
    void test_readValue_with_valid_json_as_journey_returns_journeyObject() throws JsonProcessingException {
        String jsonJourney = getResourceFileAsString("json/journey.json");
        Journey expectedJourney = getJourneyWithNoEmptyFields();

        Journey result = classUnderTest.readValue(jsonJourney, Journey.class);

        assertThat(result).isEqualToComparingFieldByFieldRecursively(expectedJourney);
    }

    @Test
    void test_mapJsonToPojo_with_invalid_json_throws_error() {
        String jsonError = "";

        assertThrows(MismatchedInputException.class, () -> classUnderTest.readValue(jsonError, Journey.class));
    }

    @Test
    void test_writeValueAsString_with_travelPoint_returns_travelPoint_as_json_string() throws JsonProcessingException {
        TravelPoint testData = getTravelPointWithNoEmptyFields();
        String expectedJsonTravelPoint = getResourceFileAsString("json/travelpoint.json");

        String result = classUnderTest.writeValueAsString(testData);

        assertThat(deleteWhitespace(result)).isEqualTo(deleteWhitespace(expectedJsonTravelPoint));
    }

    @Test
    void test_readValue_with_valid_json_as_travelPoint_returns_travelPointObject() throws JsonProcessingException {
        String jsonTravelPoint = getResourceFileAsString("json/travelpoint.json");
        TravelPoint expectedTravelPoint = getTravelPointWithNoEmptyFields();

        TravelPoint result = classUnderTest.readValue(jsonTravelPoint, TravelPoint.class);

        assertThat(result).isEqualToComparingFieldByFieldRecursively(expectedTravelPoint);
    }

    @Test
    void test_writeValueAsString_with_polygon_returns_polygon_as_json_string() throws JsonProcessingException {
        Polygon testPolygon = getPolygonWithNoEmptyFields();
        String expectedJsonPolygon = getResourceFileAsString("json/polygon.json");

        String result = classUnderTest.writeValueAsString(testPolygon);

        assertThat(deleteWhitespace(result)).isEqualTo(deleteWhitespace(expectedJsonPolygon));
    }

    @Test
    void test_readValue_with_valid_json_as_polygon_returns_polygonObject() throws JsonProcessingException {
        String jsonPolygon = getResourceFileAsString("json/polygon.json");
        Polygon expectedPolygon = getPolygonWithNoEmptyFields();

        Polygon result = classUnderTest.readValue(jsonPolygon, Polygon.class);

        assertThat(result).isEqualToComparingFieldByFieldRecursively(expectedPolygon);
    }

    @Test
    void test_writeValueAsString_with_box_returns_box_as_json_string() throws JsonProcessingException {
        Box testBox = getBoxWithNoEmptyFields();
        String expectedJsonBox = getResourceFileAsString("json/box.json");

        String result = classUnderTest.writeValueAsString(testBox);

        assertThat(deleteWhitespace(result)).isEqualTo(deleteWhitespace(expectedJsonBox));
    }

    @Test
    void test_readValue_with_valid_json_as_box_returns_boxObject() throws JsonProcessingException {
        String jsonBox = getResourceFileAsString("json/box.json");
        Box expectedBox = getBoxWithNoEmptyFields();

        Box result = classUnderTest.readValue(jsonBox, Box.class);

        assertThat(result).isEqualToComparingFieldByFieldRecursively(expectedBox);
    }

    @Test
    void test_writeValueAsString_with_callStatus_returns_callStatus_as_json_string() throws JsonProcessingException {
        CallStatus<GraphQlTab> testCallStatus = getSuccessfulJourneyCallStatusTab();
        String expectedJsonCallStatus = getResourceFileAsString("json/callstatus.json");

        String result = classUnderTest.writeValueAsString(testCallStatus);

        assertThat(deleteWhitespace(result)).isEqualTo(deleteWhitespace(expectedJsonCallStatus));
    }

    @Test
    void test_readValue_with_valid_json_as_callStatus_returns_callStatusObject() throws JsonProcessingException {
        String jsonCallStatus = getResourceFileAsString("json/callstatus.json");
        CallStatus<GraphQlTab> expectedCallStatus = getSuccessfulJourneyCallStatusTab();

        JavaType callStatusType = classUnderTest.getTypeFactory().constructParametricType(CallStatus.class, GraphQlTab.class);
        CallStatus<GraphQlTab> result = classUnderTest.readValue(jsonCallStatus, callStatusType);

        assertThat(result).isEqualToComparingFieldByField(expectedCallStatus);
    }

    @Test
    void test_writeValueAsString_with_apiTokenMap_returns_apiTokenMap_as_json_string() throws JsonProcessingException {
        Map<GraphQlTab, ApiToken> testApiTokenMap = getTestSoftwareApiTokens();

        String result = classUnderTest.writeValueAsString(testApiTokenMap);

        assertThat(result).containsOnlyOnce(GraphQlTab.JOURNEY_QUERY.toString());
        assertThat(result).containsOnlyOnce(GraphQlTab.ADDRESS_AUTOCOMPLETION.toString());
        assertThat(result).containsOnlyOnce(GraphQlTab.NEAREST_ADDRESSES.toString());
        assertThat(result).containsOnlyOnce(GraphQlTab.NEAREST_STATIONS.toString());
    }

    @Test
    void test_readValue_with_valid_json_as_apiTokenMap_returns_apiTokenMapObject() throws JsonProcessingException {
        String jsonApiTokenMap = getResourceFileAsString("json/apitokenmap.json");
        Map<GraphQlTab, ApiToken> expectedApiTokenMap = getTestSoftwareApiTokens();

        JavaType javaType = classUnderTest.getTypeFactory().constructMapType(Map.class, GraphQlTab.class, ApiToken.class);
        Map<GraphQlTab, ApiToken> result = classUnderTest.readValue(jsonApiTokenMap, javaType);

        assertThat(result.size()).isEqualTo(expectedApiTokenMap.size());
        assertThat(result.get(GraphQlTab.JOURNEY_QUERY)).isEqualToComparingFieldByFieldRecursively(expectedApiTokenMap.get(GraphQlTab.JOURNEY_QUERY));
        assertThat(result.get(GraphQlTab.ADDRESS_AUTOCOMPLETION)).isEqualToComparingFieldByFieldRecursively(expectedApiTokenMap.get(GraphQlTab.ADDRESS_AUTOCOMPLETION));
        assertThat(result.get(GraphQlTab.NEAREST_ADDRESSES)).isEqualToComparingFieldByFieldRecursively(expectedApiTokenMap.get(GraphQlTab.NEAREST_ADDRESSES));
        assertThat(result.get(GraphQlTab.NEAREST_STATIONS)).isEqualToComparingFieldByFieldRecursively(expectedApiTokenMap.get(GraphQlTab.NEAREST_STATIONS));
    }
}
