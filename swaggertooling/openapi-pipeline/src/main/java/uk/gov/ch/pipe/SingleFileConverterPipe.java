package uk.gov.ch.pipe;

import uk.gov.ch.swagger.VersionConverter;

import java.io.File;
import java.nio.file.Path;

public class SingleFileConverterPipe extends AbstractAPIPipe {
    @Override
    protected void handle() {
        try {
            final String fileName = new File(getInputName()).getName();
            final Path fixedDir = getArgs().getFixedDir();
            final Path convertDir = getArgs().getConvertDir();
            convert(
                    fileName,
                    fixedDir,
                    convertDir
//                    ,
//                    getArgs().getWorkingDir()
            );
        } catch (Exception e) {
            e.printStackTrace();
            abort();
        }
    }

    void convert(String fileName, Path fixedDir, Path convertDir) throws Exception {
        final String inputPath = fixedDir.resolve(fileName).toFile().getCanonicalPath();
        final String outputPath = convertDir.toFile().getCanonicalPath();
        VersionConverter.main("-i", inputPath,
                "-o", outputPath
        );
    }
    

}
