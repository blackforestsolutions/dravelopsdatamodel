package de.blackforestsolutions.dravelopsdatamodel.testutil;

import de.blackforestsolutions.dravelopsdatamodel.Journey;
import de.blackforestsolutions.dravelopsdatamodel.util.ApiToken;
import de.blackforestsolutions.dravelopsdatamodel.util.DravelOpsJsonMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.stream.Collectors;

import static java.nio.charset.StandardCharsets.UTF_8;

public class TestUtils {

    /**
     * Reads given resource file as a string.
     *
     * @param fileName the path to the resource file
     * @return the file's contents or null if the file could not be opened
     */
    public static String getResourceFileAsString(String fileName) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);
        if (inputStream != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, UTF_8));
            return reader.lines().collect(Collectors.joining(System.lineSeparator()));
        }
        return null;
    }

    /**
     * Reads the given resource file and property name as a string
     *
     * @param fileName the path to the resource file
     * @param propertyName the name of the property within resource file
     * @return property value
     */
    public static String getPropertyFromFileAsString(String fileName, String propertyName) {
        try {
            Resource resource = new FileSystemResource(fileName);
            if (!resource.exists()) {
                resource = new ClassPathResource(fileName);
            }
            Properties properties = PropertiesLoaderUtils.loadProperties(resource);
            return properties.getProperty(propertyName);
        } catch (Exception ignored) {
            return null;
        }
    }

    /**
     * NEVER USE IN PRODUCTIVE CODE!
     * Parse the given json into object of type pojo
     *
     * @param json the given json
     * @param pojo the class the json has to be parsed
     * @param <T>  type of the class the json has to be parsed
     * @return object
     */
    public static <T> T retrieveJsonToPojo(String json, Class<T> pojo) {
        DravelOpsJsonMapper mapper = new DravelOpsJsonMapper();
        return mapper.mapJsonToPojo(json, pojo).block();
    }

    /**
     * NEVER USE IN PRODUCTIVE CODE!
     * Stringify the given Journey to Json
     *
     * @param journey to stringify
     * @return jsonJourney
     */
    public static String toJson(Journey journey) {
        DravelOpsJsonMapper mapper = new DravelOpsJsonMapper();
        return mapper.map(journey).block();
    }

    /**
     * NEVER USE IN PRODUCTIVE CODE!
     * Stringify the given ApiToken to Json
     *
     * @param apiToken to stringify
     * @return jsonApiToken
     */
    public static String toJson(ApiToken apiToken) {
        DravelOpsJsonMapper mapper = new DravelOpsJsonMapper();
        return mapper.map(apiToken).block();
    }


}
