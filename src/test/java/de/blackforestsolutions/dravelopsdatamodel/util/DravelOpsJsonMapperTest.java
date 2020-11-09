package de.blackforestsolutions.dravelopsdatamodel.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import de.blackforestsolutions.dravelopsdatamodel.Journey;
import de.blackforestsolutions.dravelopsdatamodel.TravelPoint;
import org.junit.jupiter.api.Test;

import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.ApiTokenObjectMother.getApiTokenWithNoEmptyFields;
import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.JourneyObjectMother.getJourneyWithNoEmptyFields;
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
    void test_readValue_with_valid_json_returns_apiTokenObject() throws JsonProcessingException {
        String jsonApiToken = getResourceFileAsString("json/apitoken.json");
        ApiToken expectedApiToken = getApiTokenWithNoEmptyFields();

        ApiToken result = classUnderTest.readValue(jsonApiToken, ApiToken.class);

        assertThat(result).isEqualToComparingFieldByField(expectedApiToken);
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

        assertThat(result.getId()).isEqualTo(expectedJourney.getId());
        assertThat(result.getLegs().size()).isEqualTo(1);
        assertThat(result.getLegs().get(0)).isEqualToIgnoringGivenFields(expectedJourney.getLegs().get(0), "departure", "arrival", "travelProvider", "intermediateStops");
        assertThat(result.getLegs().get(0).getDeparture()).isEqualToComparingFieldByField(expectedJourney.getLegs().get(0).getDeparture());
        assertThat(result.getLegs().get(0).getArrival()).isEqualToComparingFieldByField(expectedJourney.getLegs().get(0).getArrival());
        assertThat(result.getLegs().get(0).getTravelProvider()).isEqualToComparingFieldByField(expectedJourney.getLegs().get(0).getTravelProvider());
        assertThat(result.getLegs().get(0).getIntermediateStops().size()).isEqualTo(1);
        assertThat(result.getLegs().get(0).getIntermediateStops().get(0)).isEqualToComparingFieldByField(expectedJourney.getLegs().get(0).getIntermediateStops().get(0));
        assertThat(result.getPrices().size()).isEqualTo(1);
        assertThat(result.getPrices().get(0)).isEqualToComparingFieldByField(expectedJourney.getPrices().get(0));
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

        assertThat(result).isEqualToComparingFieldByField(expectedTravelPoint);
    }
}
