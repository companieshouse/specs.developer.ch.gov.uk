package uk.gov.ch.pipe;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.gov.ch.swagger.VersionConverter;

public class SingleFileConverterPipe extends AbstractAPIPipe {

    private static final Logger LOGGER = LoggerFactory.getLogger(SingleFileConverterPipe.class);

    @Override
    protected void handle() {
        try {
            final String fileName = new File(getInputName()).getName();
            final Path fixedDir = getArgs().getFixedDir();
            final Path convertDir = getArgs().getConvertDir();
            convert(fileName, fixedDir, convertDir);
        } catch (Exception e) {
            LOGGER.error("", e);
            abort();
        }
    }

    private void convert(final String fileName, final Path fixedDir, final Path convertDir)
            throws Exception {
        final String inputPath = fixedDir.resolve(fileName).toFile().getCanonicalPath();
        final String outputPath = convertDir.toFile().getCanonicalPath();
        VersionConverter.main("-i", inputPath, "-o", outputPath);
    }

    @Override
    protected void handleAbort() {
        super.handleAbort();
        String localName = new File(getInputName()).getName();
        Path badDirectory = Paths.get(getArgs().getOutputDir()).resolve("unconvertable");
        badDirectory.toFile().mkdir();
        try {
            Path thisFile = getArgs().getFixedDir().resolve(localName);
            Files.move(
                    thisFile,
                    badDirectory.resolve(localName)
            );
        } catch (IOException e) {
            LOGGER.error("", e);
        }
    }
}
