package de.blackforestsolutions.dravelopsdatamodel;

import org.assertj.core.api.WritableAssertionInfo;
import org.assertj.core.internal.Strings;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.regex.Pattern;

import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.JourneyObjectMother.getJourneyBuilderWithNoEmptyFields;
import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.JourneyObjectMother.getJourneyWithEmptyFields;
import static org.assertj.core.api.Assertions.assertThat;

class JourneyTest {

    /**
     * checks if journeyId is conform with shaId pattern (40 hex-characters)
     *
     * @throws IOException when io is not available
     */
    @Test
    void test_build_journey_generates_conform_sha1Id() throws IOException {
        Pattern sha1IdPattern = Pattern.compile("[0-9a-f]{40}");

        Journey result = new Journey.JourneyBuilder().build();

        Strings.instance().assertContainsPattern(new WritableAssertionInfo(), result.getId(), sha1IdPattern);
    }

    @Test
    void test_build_journey_generates_always_the_same_sha1Id() throws IOException {
        Journey.JourneyBuilder testData = getJourneyBuilderWithNoEmptyFields();

        Journey result = testData.build();

        assertThat(result.getId()).isEqualTo("6b8fc49341c09935792635b143372e0d451386a3");
    }

    @Test
    void test_build_journey_returns_for_two_equal_journeys_an_equal_sha1Id() throws IOException {
        Journey.JourneyBuilder firstTestData = getJourneyBuilderWithNoEmptyFields();
        Journey.JourneyBuilder secondTestData = getJourneyBuilderWithNoEmptyFields();

        Journey firstResult = firstTestData.build();
        Journey secondResult = secondTestData.build();

        assertThat(firstResult.getId()).isEqualTo(secondResult.getId());
    }

    @Test
    void test_build_journey_returns_for_two_different_journeys_a_different_sha1Id() throws IOException {
        Journey.JourneyBuilder firstTestData = getJourneyBuilderWithNoEmptyFields();
        Journey secondTestData = getJourneyWithEmptyFields();

        Journey firstResult = firstTestData.build();

        assertThat(firstResult.getId()).isNotEqualTo(secondTestData.getId());
    }
}
