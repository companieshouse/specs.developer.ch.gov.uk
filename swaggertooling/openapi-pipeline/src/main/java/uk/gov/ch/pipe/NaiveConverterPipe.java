package uk.gov.ch.pipe;

import uk.gov.ch.swagger.VersionConverter;

import java.nio.file.Path;

public class NaiveConverterPipe extends AbstractAPIPipe {
    @Override
    protected void handle() {
        try {
            convert(getArgs().getFixedDir(),
                    getArgs().getConvertDir()
            );
        } catch (Exception e) {
            e.printStackTrace();
            abort();
        }
    }

    void convert(Path fixedDir, Path convertDir) throws Exception {
        VersionConverter.main("-i", fixedDir.toFile().getCanonicalPath(), "-o", convertDir.toFile().getCanonicalPath());
    }
}
