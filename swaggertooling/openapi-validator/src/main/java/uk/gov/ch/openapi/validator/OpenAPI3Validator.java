package uk.gov.ch.openapi.validator;

import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.LogLevel;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OpenAPI3Validator {

    private static Logger LOGGER = LoggerFactory.getLogger(OpenAPI3Validator.class);
    private static ISource source;

    static public int main(final String... args) {
        final OpenAPI3Validator openAPI3Validator = new OpenAPI3Validator();
        openAPI3Validator.parseArgs(args);
        openAPI3Validator.validateInputFiles();
        return 0;
    }

    private void validateInputFiles() {

        final Collection<File> inputFiles = source.getInputFiles();
        final Map<File, Exception> exceptions = new ConcurrentHashMap<>();
        final Map<File, ProcessingReport> reportMap = new HashMap<>();
        final List<File> successList = new ArrayList<>(inputFiles.size());

        final SchemaValidator validator;
        try {
            validator = new SchemaValidator();
        } catch (IOException | ProcessingException exception) {
            LOGGER.error("Unable to create " + SchemaValidator.class.getName(), exception);
            return;
        }
        for (File inputFile : inputFiles) {
            sortResults(inputFile, validator, successList, reportMap, exceptions);
        }

        LOGGER.info(source.getInputFiles().size() + " Files processed");
        reportSuccess(successList);
        reportExceptions(exceptions);
        reportIssues(reportMap);
    }

    private void reportSuccess(final List<File> successList) {
        if (!successList.isEmpty()) {
            LOGGER.info(successList.size() + " Files Passed");
            for (final File f : successList) {
                LOGGER.info("Pass: " + f);
            }
        }
    }

    private void reportIssues(final Map<File, ProcessingReport> reportMap) {
        if (!reportMap.isEmpty()) {
            LOGGER.warn(reportMap.size() + " Files Failed");
            final AtomicInteger nWarnings = new AtomicInteger(0);

            reportMap.entrySet().forEach(row -> {
                Report1Failure(row, nWarnings);
            });
            LOGGER.warn(nWarnings + " Files Failed");
        }
    }

    private void Report1Failure(Entry<File, ProcessingReport> row, AtomicInteger nWarnings) {
        try {
            LOGGER.warn("Fail: " + row.getKey().getCanonicalPath());
            for (final ProcessingMessage message : row.getValue()) {
                nWarnings.incrementAndGet();
                final LogLevel level = message.getLogLevel();
                final String messageContent = message.getMessage();
                switch (level) {
                    case DEBUG: {
                        LOGGER.debug(messageContent);
                        break;
                    }
                    case FATAL: {
                        LOGGER.error(messageContent);
                        break;
                    }
                    default: {
                        LOGGER.warn(messageContent);
                    }
                }
            }
        } catch (IOException e) {
            LOGGER.error("Problem reporting error", e);
        }
    }

    /**
     * Categorise the processing of each file through the validator
     *
     * @param f Input File
     * @param validator SchemaValidator to use
     * @param successList Files that pass with no problems
     * @param reportMap Files that fail and produce a report
     * @param exceptions Files that throw Exceptions during processing.
     */
    private void sortResults(final File f, final SchemaValidator validator,
            final List<File> successList, final Map<File, ProcessingReport> reportMap,
            final Map<File, Exception> exceptions) {
        try {
            final ProcessingReport report = validator.checkSchema(f);
            if (report.isSuccess()) {
                successList.add(f);
            } else {
                reportMap.put(f, report);
            }
        } catch (final IOException | ProcessingException exception) {
            exceptions.put(f, exception);
        }
    }

    private void reportExceptions(final Map<File, Exception> exceptions) {
        for (final Entry<File, Exception> kvp : exceptions.entrySet()) {
            try {
                LOGGER.error(kvp.getKey().getCanonicalPath(), kvp.getValue());
            } catch (final IOException ioException) {
                LOGGER.error(ioException.getLocalizedMessage(), ioException);
            }
        }
    }

    private void parseArgs(final String... args) {
        ArgPackager argPackager = new ArgPackager(args);
        source = argPackager.getSource();
    }


}
