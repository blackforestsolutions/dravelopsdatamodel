package de.blackforestsolutions.dravelopsdatamodel.testutil;

import de.blackforestsolutions.dravelopsdatamodel.util.DravelOpsJsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.http.HttpHeaders;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.zip.ZipFile;

import static java.nio.charset.StandardCharsets.UTF_8;

@Slf4j
public class TestUtils {

    private static final String ZIP_EXTENSION = "zip";

    /**
     * Reads given resource file as a string.
     *
     * @param fileName the path to the resource file
     * @return the file's contents or null if the file could not be found
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
     * NEVER USE IN PRODUCTIVE CODE!
     * Parse the given
     *
     * @param path     such as gtfs/sbg.zip
     * @param fileType such as .zip
     * @return
     * @throws IOException
     */
    public static File getResourceAsFile(String path, String fileType) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(path);
        try {
            File targetFile = File.createTempFile(path, fileType);
            if (inputStream != null) {
                FileUtils.copyInputStreamToFile(inputStream, targetFile);
                return targetFile;
            }
            return null;
        } catch (IOException e) {
            log.error("Error while creating file: ", e);
            return null;
        }
    }

    /**
     * Reads the given resource file and property name as a string
     *
     * @param fileName     the path to the resource file
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
     * Parse the given json resource into object of type pojo
     *
     * @param resource   the given json file path
     * @param returnType pojo the class the json has to be parsed
     * @param <T>        type of the class the json has to be parsed
     * @return object
     */
    public static <T> T retrieveJsonToPojo(String resource, Class<T> returnType) {
        String json = getResourceFileAsString(resource);
        return retrieveJsonToReactivePojo(json, returnType).block();
    }

    private static <T> Mono<T> retrieveJsonToReactivePojo(String json, Class<T> pojo) {
        try {
            DravelOpsJsonMapper mapper = new DravelOpsJsonMapper();
            return Mono.just(mapper.readValue(json, pojo));
        } catch (Exception e) {
            return Mono.error(e);
        }
    }

    /**
     * NEVER USE IN PRODUCTIVE CODE!
     * Parse the given json resource into list object of type pojo
     *
     * @param resource   the given json file path
     * @param returnType pojo of class json has to be parsed
     * @param <T>        type of the class json has to be parsed
     * @return object
     */
    public static <T> List<T> retrieveJsonToListPojo(String resource, Class<T> returnType) {
        String json = getResourceFileAsString(resource);
        return retrieveJsonToReactivePojoList(json, returnType).collectList().block();
    }

    private static <T> Flux<T> retrieveJsonToReactivePojoList(String json, Class<T> pojo) {
        try {
            DravelOpsJsonMapper mapper = new DravelOpsJsonMapper();
            List<T> pojoList = mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, pojo));
            return Flux.fromIterable(pojoList);
        } catch (Exception e) {
            return Flux.error(e);
        }
    }

    /**
     * verifies if the file has a zip file extension
     *
     * @param f File
     * @return true if the file has the .zip extension or false if not
     */
    public static boolean hasZipFileExtension(File f) {
        String fileName = f.getName();
        String extension = FilenameUtils.getExtension(fileName);
        return extension.equals(ZIP_EXTENSION);
    }

    /**
     * converts a File to a ZipFile
     *
     * @param f file to convert to ZipFile
     * @return ZipFile
     */
    public static ZipFile convertToZipFile(File f) {
        try {
            return new ZipFile(f);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * converts a map with a string as key and value to an Spring HttpHeader
     *
     * @param headersMap with key as string and value as string
     * @return HttpHeaders of Spring framework
     */
    public static HttpHeaders convertToHeaders(Map<String, String> headersMap) {
        HttpHeaders httpHeaders = new HttpHeaders();
        headersMap.forEach(httpHeaders::add);
        return httpHeaders;
    }

}
