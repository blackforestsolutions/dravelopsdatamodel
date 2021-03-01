package de.blackforestsolutions.dravelopsdatamodel.util;

import de.blackforestsolutions.dravelopsdatamodel.ApiToken;
import lombok.extern.slf4j.Slf4j;

import java.io.UncheckedIOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

@Slf4j
public class DravelOpsHttpCallBuilder {

    public static URL buildUrlWith(ApiToken apiToken) {
        Objects.requireNonNull(apiToken.getProtocol(), "protocol is not allowed to be null");
        Objects.requireNonNull(apiToken.getHost(), "host is not allowed to be null");
        Objects.requireNonNull(apiToken.getPath(), "path is not allowed to be null");
        Objects.requireNonNull(apiToken.getPort(), "port is not allowed to be null");
        try {
            if (apiToken.getPort() == 0 || apiToken.getPort() == -1) {
                return new URL(apiToken.getProtocol(), apiToken.getHost(), apiToken.getPath());
            }
            return new URL(apiToken.getProtocol(), apiToken.getHost(), apiToken.getPort(), apiToken.getPath());
        } catch (MalformedURLException e) {
            log.error("Url could not be build because of wrong part in url");
            throw new UncheckedIOException(e);
        }
    }

}
