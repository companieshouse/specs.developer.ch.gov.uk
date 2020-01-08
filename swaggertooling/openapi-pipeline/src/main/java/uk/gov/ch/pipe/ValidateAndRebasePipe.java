package uk.gov.ch.pipe;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.gov.ch.openapi.validator.OpenAPI3Validator;
import uk.gov.ch.openapi.validator.ValidationResult;

public class ValidateAndRebasePipe extends AbstractAPIPipe {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractAPIPipe.class);

    @Override
    protected void handle() {
        String[] filesToValidate;
        try {
            filesToValidate = getFilePathsForConvertedFiles();
        } catch (IOException e) {
            LOGGER.error("", e);
            abort();
            return;
        }
        Stream.of(filesToValidate).forEach(f -> {
            try {
                validateAndMove(f);
            } catch (IOException e) {
                LOGGER.error("", e);
            }
        });
    }

    String[] getFilePathsForConvertedFiles() throws IOException {
        String[] filesToValidate;

        if (getInputName() != null) {
            final String fileName = new File(getInputName()).getName();
            final String inputPath = getArgs().getConvertDir().resolve(fileName).toFile()
                    .getCanonicalPath();
            return new String[]{inputPath};
        }

        filesToValidate = Arrays.stream(getArgs().getConvertDir().toFile().listFiles())
                .filter(f -> !f.isDirectory())
                .map(File::getPath)
                .toArray(String[]::new);

        return filesToValidate;
    }

    void validateAndMove(String filePath) throws IOException {
        final int output = invokeValidator(filePath);
        final File f = new File(filePath);
        final String outputDir = getArgs().getOutputDir();
        new File(outputDir).mkdir();
        final Path fileToPath = f.toPath();
        if (output != ValidationResult.PASS.resultValue) {
            final Path badOutPathName = Paths.get(outputDir).resolve("bad");
            badOutPathName.toFile().mkdir();
            Files.move(
                    fileToPath,
                    badOutPathName.resolve(f.getName())
            );
        } else {
            Files.move(
                    fileToPath,
                    Paths.get(outputDir).resolve(f.getName())
            );
        }
    }

    int invokeValidator(String filePath) {
        return OpenAPI3Validator.main("-i", filePath);
    }
}
