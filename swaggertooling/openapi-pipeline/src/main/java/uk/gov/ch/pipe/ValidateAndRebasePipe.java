package uk.gov.ch.pipe;

import uk.gov.ch.openapi.validator.OpenAPI3Validator;
import uk.gov.ch.openapi.validator.ValidationResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class ValidateAndRebasePipe extends AbstractAPIPipe {
    @Override
    protected void handle() {
        String[] filesToValidate;
        try {
            filesToValidate = getFilePathsForConvertedFiles();
        } catch (IOException e) {
            e.printStackTrace();
            abort();
            return;
        }
        Stream.of(filesToValidate).forEach(f-> {
            try {
                validateAndMove(f);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    String[] getFilePathsForConvertedFiles() throws IOException {
        String[] filesToValidate;

        if (getInputName() != null) {
            final String fileName = new File(getInputName()).getName();
            final String inputPath = getArgs().getConvertDir().resolve(fileName).toFile().getCanonicalPath();
            return new String[]{inputPath};
        }

        filesToValidate = Arrays.asList(getArgs().getConvertDir().toFile().listFiles()).stream()
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
        if (output != ValidationResult.PASS.resultValue) {
            final Path badOutPathName = Paths.get(outputDir).resolve("bad");
            badOutPathName.toFile().mkdir();
            Files.move(
                    f.toPath(),
                    badOutPathName.resolve(f.getName())
            );
        } else {
            Files.move(
                    f.toPath(),
                    Paths.get(outputDir).resolve(f.getName())
            );
        }
    }

    /**
     * Wrapper to allow testing of moves
     * @param filePath
     * @return
     */
    int invokeValidator(String filePath) {
        return OpenAPI3Validator.main("-i", filePath);
    }
}
