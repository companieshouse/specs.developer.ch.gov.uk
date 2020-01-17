package uk.gov.ch.args;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SourceTest {

    private static final List<String> INPUT_FILES = Collections
            .singletonList("singleFileDir/emptyJson.json");
    private static final String OUTPUT_DIR = "output";
    private static final String WORKING_DIR = "target/test-classes";
    private Source source;

    @BeforeEach
    void setup() throws IOException {
        source = new Source();
        source.setWorkingDir(WORKING_DIR);
        source.setInputFiles(INPUT_FILES);
        source.setOutputDir(OUTPUT_DIR);
    }

    @Test
    void getArgs_gets_inputs() throws IOException {
        Path p = Paths.get(WORKING_DIR).toAbsolutePath();
        String canonicalPath = p.resolve(INPUT_FILES.get(0)).toFile().getCanonicalPath();
        assertEquals(1, source.getInputFiles().size());
        File[] t = source.getInputFiles().toArray(new File[]{});
        assertEquals(canonicalPath, t[0].getCanonicalPath());
    }

    @Test
    void getArgs_gets_outputs() throws IOException {
        Path p = Paths.get(WORKING_DIR).toAbsolutePath();
        String canonicalPath = p.resolve(OUTPUT_DIR).toFile().getCanonicalPath();
        assertEquals(canonicalPath, source.getOutputDir());
    }

}