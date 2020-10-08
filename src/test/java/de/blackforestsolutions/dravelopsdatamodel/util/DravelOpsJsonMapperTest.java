package de.blackforestsolutions.dravelopsdatamodel.util;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import de.blackforestsolutions.dravelopsdatamodel.Journey;
import de.blackforestsolutions.dravelopsdatamodel.PriceType;
import de.blackforestsolutions.dravelopsdatamodel.TravelPoint;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.ApiTokenObjectMother.getApiTokenWithNoEmptyFields;
import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.JourneyObjectMother.getJourneyWithNoEmptyFields;
import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.TravelPointObjectMother.getTravelPointWithNoEmptyFields;
import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.UUIDObjectMother.TEST_UUID_2;
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

    @Test
    void test_map_journey_returns_journey_as_json_string() {
        Journey testData = getJourneyWithNoEmptyFields();
        String expectedJsonJourney = getResourceFileAsString("json/journey.json");

        Mono<String> result = classUnderTest.map(testData);

        StepVerifier.create(result)
                .assertNext(journey -> assertThat(deleteWhitespace(journey)).isEqualTo(deleteWhitespace(expectedJsonJourney)))
                .verifyComplete();
    }

    @Test
    void test_mapJsonToPojo_with_valid_json_as_journey_returns_journeyObject() {
        String jsonJourney = getResourceFileAsString("json/journey.json");
        Journey expectedJourney = getJourneyWithNoEmptyFields();

        Mono<Journey> result = classUnderTest.mapJsonToPojo(jsonJourney, Journey.class);

        StepVerifier.create(result)
                .assertNext(journey -> {
                    assertThat(journey.getId()).isEqualTo(expectedJourney.getId());
                    assertThat(journey.getLegs().size()).isEqualTo(1);
                    assertThat(journey.getLegs().get(TEST_UUID_2)).isEqualToIgnoringGivenFields(expectedJourney.getLegs().get(TEST_UUID_2), "departure", "arrival", "travelProvider", "intermediateStops");
                    assertThat(journey.getLegs().get(TEST_UUID_2).getDeparture()).isEqualToComparingFieldByField(expectedJourney.getLegs().get(TEST_UUID_2).getDeparture());
                    assertThat(journey.getLegs().get(TEST_UUID_2).getArrival()).isEqualToComparingFieldByField(expectedJourney.getLegs().get(TEST_UUID_2).getArrival());
                    assertThat(journey.getLegs().get(TEST_UUID_2).getTravelProvider()).isEqualToComparingFieldByField(expectedJourney.getLegs().get(TEST_UUID_2).getTravelProvider());
                    assertThat(journey.getLegs().get(TEST_UUID_2).getIntermediateStops().size()).isEqualTo(1);
                    assertThat(journey.getLegs().get(TEST_UUID_2).getIntermediateStops().get(0)).isEqualToComparingFieldByField(expectedJourney.getLegs().get(TEST_UUID_2).getIntermediateStops().get(0));
                    assertThat(journey.getPrices().size()).isEqualTo(1);
                    assertThat(journey.getPrices().get(PriceType.REGULAR)).isEqualToComparingFieldByField(expectedJourney.getPrices().get(PriceType.REGULAR));
                })
                .verifyComplete();
    }

    @Test
    void test_mapJsonToPojo_with_invalid_json_returns_error() {
        String jsonError = "";

        Mono<Journey> result = classUnderTest.mapJsonToPojo(jsonError, Journey.class);

        StepVerifier.create(result)
                .expectError(MismatchedInputException.class)
                .verify();
    }

    @Test
    void test_map_travelPoint_returns_travelPoint_as_json_string() {
        TravelPoint testData = getTravelPointWithNoEmptyFields();
        String expectedJsonTravelPoint = getResourceFileAsString("json/travelpoint.json");

        Mono<String> result = classUnderTest.map(testData);

        StepVerifier.create(result)
                .assertNext(travelPoint -> assertThat(deleteWhitespace(travelPoint)).isEqualTo(deleteWhitespace(expectedJsonTravelPoint)))
                .verifyComplete();
    }

    @Test
    void test_mapJsonToPojo_with_valid_json_as_travelPoint_returns_travelPointObject() {
        String jsonTravelPoint = getResourceFileAsString("json/travelpoint.json");
        TravelPoint expectedTravelPoint = getTravelPointWithNoEmptyFields();

        Mono<TravelPoint> result = classUnderTest.mapJsonToPojo(jsonTravelPoint, TravelPoint.class);

        StepVerifier.create(result)
                .assertNext(travelPoint -> assertThat(travelPoint).isEqualToComparingFieldByField(expectedTravelPoint))
                .verifyComplete();
    }
}
