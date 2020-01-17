package uk.gov.ch.pipe;

import java.io.IOException;
import java.nio.file.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.gov.ch.swagger.VersionConverter;

public class NaiveConverterPipe extends AbstractAPIPipe {

    private static final Logger LOGGER = LoggerFactory.getLogger(NaiveConverterPipe.class);

    @Override
    protected void handle() {
        try {
            convert(getArgs().getFixedDir(),
                    getArgs().getConvertDir()
            );
        } catch (IOException ioE) {
            LOGGER.error("Error reading parameters ", ioE);
            abort();

        } catch (Exception e) {
            LOGGER.error("Error in Conversion process ", e);
            abort();
        }
    }

    void convert(Path fixedDir, Path convertDir) throws Exception {
        VersionConverter.main("-i", fixedDir.toFile().getCanonicalPath(), "-o",
                convertDir.toFile().getCanonicalPath());
    }
}
