package de.blackforestsolutions.dravelopsdatamodel.util;

import de.blackforestsolutions.dravelopsdatamodel.ApiToken;
import org.junit.jupiter.api.Test;

import java.io.UncheckedIOException;
import java.net.URL;

import static de.blackforestsolutions.dravelopsdatamodel.objectmothers.ApiTokenObjectMother.getApiTokenWithNoEmptyFields;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DravelOpsHttpCallBuilderTest {

    @Test
    void test_buildUrlWith_protocol_host_port_and_path_returns_correct_url() {
        ApiToken testData = getApiTokenWithNoEmptyFields();

        URL result = DravelOpsHttpCallBuilder.buildUrlWith(testData);

        assertThat(result.getProtocol()).isEqualTo(testData.getProtocol());
        assertThat(result.getHost()).isEqualTo(testData.getHost());
        assertThat(result.getPort()).isEqualTo(testData.getPort());
        assertThat(result.getPath()).isEqualTo(testData.getPath());
        assertThat(result.toString()).isEqualTo("http://localhost:8000/path");
    }

    @Test
    void test_buildUrlWith_protocol_host_port_as_zero_and_path_returns_correct_url() {
        ApiToken.ApiTokenBuilder testData = new ApiToken.ApiTokenBuilder(getApiTokenWithNoEmptyFields());
        testData.setPort(0);

        URL result = DravelOpsHttpCallBuilder.buildUrlWith(testData.build());

        assertThat(result.getProtocol()).isEqualTo(testData.getProtocol());
        assertThat(result.getHost()).isEqualTo(testData.getHost());
        assertThat(result.getPort()).isEqualTo(-1);
        assertThat(result.getPath()).isEqualTo(testData.getPath());
        assertThat(result.toString()).isEqualTo("http://localhost/path");
    }

    @Test
    void test_buildUrlWith_protocol_host_port_as_minus_one_and_path_returns_correct_url() {
        ApiToken.ApiTokenBuilder testData = new ApiToken.ApiTokenBuilder(getApiTokenWithNoEmptyFields());
        testData.setPort(-1);

        URL result = DravelOpsHttpCallBuilder.buildUrlWith(testData.build());

        assertThat(result.getProtocol()).isEqualTo(testData.getProtocol());
        assertThat(result.getHost()).isEqualTo(testData.getHost());
        assertThat(result.getPort()).isEqualTo(testData.getPort());
        assertThat(result.getPath()).isEqualTo(testData.getPath());
        assertThat(result.toString()).isEqualTo("http://localhost/path");
    }

    @Test
    void test_buildUrlWith_protocol_as_null_host_port_and_path_throws_exception() {
        ApiToken.ApiTokenBuilder testData = new ApiToken.ApiTokenBuilder(getApiTokenWithNoEmptyFields());
        testData.setProtocol(null);

        assertThrows(NullPointerException.class, () -> DravelOpsHttpCallBuilder.buildUrlWith(testData.build()));
    }

    @Test
    void test_buildUrlWith_wrong_protocol_host_port_path_throws_exception() {
        ApiToken.ApiTokenBuilder builder = new ApiToken.ApiTokenBuilder(getApiTokenWithNoEmptyFields());
        builder.setProtocol("wrong");

        assertThrows(UncheckedIOException.class, () -> DravelOpsHttpCallBuilder.buildUrlWith(builder.build()));
    }

    @Test
    void test_buildUrlWith_wrong_testData_throws_exception() {
        ApiToken.ApiTokenBuilder testData = new ApiToken.ApiTokenBuilder(getApiTokenWithNoEmptyFields());
        testData.setHost(null);

        assertThrows(NullPointerException.class, () -> DravelOpsHttpCallBuilder.buildUrlWith(testData.build()));
    }

    @Test
    void test_buildUrlWith_protocol_host_as_null_port_and_path_throws_exception() {
        ApiToken.ApiTokenBuilder testData = new ApiToken.ApiTokenBuilder(getApiTokenWithNoEmptyFields());
        testData.setHost(null);

        assertThrows(NullPointerException.class, () -> DravelOpsHttpCallBuilder.buildUrlWith(testData.build()));
    }

    @Test
    void test_buildUrlWith_protocol_host_port_as_null_and_path_throws_exception() {
        ApiToken.ApiTokenBuilder testData = new ApiToken.ApiTokenBuilder(getApiTokenWithNoEmptyFields());
        testData.setPort(null);

        assertThrows(NullPointerException.class, () -> DravelOpsHttpCallBuilder.buildUrlWith(testData.build()));
    }

    @Test
    void test_buildUrlWith_protocol_host_port_and_path_as_null_throws_exception() {
        ApiToken.ApiTokenBuilder testData = new ApiToken.ApiTokenBuilder(getApiTokenWithNoEmptyFields());
        testData.setPath(null);

        assertThrows(NullPointerException.class, () -> DravelOpsHttpCallBuilder.buildUrlWith(testData.build()));
    }
}
