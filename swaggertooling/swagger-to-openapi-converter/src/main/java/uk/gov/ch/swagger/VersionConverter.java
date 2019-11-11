package uk.gov.ch.swagger;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Converts well formed swagger 1.3 and swagger 2 to OpenAPI3 json specifications.
 */
public class VersionConverter {

    private static Logger LOGGER = LoggerFactory.getLogger(VersionConverter.class);
    private static ISource source;

    public static void main(String... args) throws Exception {
        VersionConverter versionConverter = new VersionConverter();
        versionConverter.parseArgs(args);
        versionConverter.convertVersion();
    }

    /**
     * Using Swagger Codegen libraries, convert each input file. Note that the Codegen libraries
     * always output a file called <q>openapi.json</q> in the output directory. To enable this to
     * work with multiple input files, each file is created in a unique output directory. The file
     * is then copied to its final destination when a final patch is applied
     */
    private void convertVersion() throws Exception {
        final Map<String, Exception> errors = new TreeMap<>();
        Exception firstException = null;
        for (final File inputFile : source.getInputFiles()) {
            try {
                LOGGER.info("Converting: " + inputFile);
                final Path tmpdir = Files.createTempDirectory("OpenApiV3");
                tmpdir.toFile().deleteOnExit();
                final String[] aParams = createParameters(inputFile, tmpdir);
                final OpenApiConverter openApiConverter = new OpenApiConverter();
                openApiConverter.codeGenUpgrade(aParams);
                final Path createdFile = tmpdir.resolve("openapi.json");

                final JsonNode repaired = repairInfo(createdFile, inputFile);

                final Path targetPath = Paths.get(source.getOutputDir())
                        .resolve(inputFile.getName());
                writeFile(repaired, targetPath);

                //  Files.move(createdFile, targetPath);
            } catch (Exception e) {
                if (null == firstException) {
                    firstException = e;
                }
                final String canonicalPath = inputFile.getCanonicalPath();
                errors.put(canonicalPath, e);
                LOGGER.warn(canonicalPath, e);
            }
        }
        if (firstException != null) {
            for (final String errorFile : errors.keySet()) {
                LOGGER.error("Not processed :" + errorFile + " " + errors.get(errorFile));
            }
            throw firstException;
        }
    }

    private void writeFile(final JsonNode repaired, final Path targetPath)
            throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        // final ObjectMapper enable = objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        final String fixedString = objectMapper.writeValueAsString(repaired);
        final byte[] bytes = fixedString.getBytes(StandardCharsets.UTF_8);
        Files.write(targetPath, bytes);
    }

    private JsonNode repairInfo(final Path createdFile, final File inputFile) {
        final JsonPatcher patcher = new JsonPatcher(createdFile, inputFile);
        return patcher.patchInfo();
    }

    /**
     * Build a parameter set for the OpenAPI CLI. The result corresponds directly to the command
     * line inputs for Swagger-codegen to convert a file into OpenAPI3 format
     *
     * @param inputFile File that is to be converted
     * @param tmpdir Directory for the output to be generated
     * @return array of command line input parameters for swagger-codegen
     * @throws IOException If the path
     */
    private String[] createParameters(final File inputFile, final Path tmpdir) throws IOException {
        final List<String> parameters = new LinkedList<>();
        parameters.add(OpenApiConverter.GENERATE_COMMAND_NAME);
        parameters.add("-i");
        parameters.add(inputFile.getCanonicalPath());
        parameters.add("-o");
        parameters.add(tmpdir.toString());
        parameters.add("-l");
        parameters.add("openapi");
        return parameters.toArray(new String[0]);
    }

    private void parseArgs(String[] args) {
        ArgPackager argPackager = new ArgPackager(args);
        source = argPackager.getSource();
    }

}

