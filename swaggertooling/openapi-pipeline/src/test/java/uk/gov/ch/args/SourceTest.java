package uk.gov.ch.args;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SourceTest {

    private static final java.util.List<String> INPUT_FILES = Collections.singletonList("singleFileDir/emptyJson.json");
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
        assertArrayEquals(new String[]{"-i",canonicalPath}, source.getArgs("-i"));
    }

    @Test
    void getArgs_gets_outputs() throws IOException {
        Path p = Paths.get(WORKING_DIR).toAbsolutePath();
        String canonicalPath = p.resolve(OUTPUT_DIR).toFile().getCanonicalPath();
        assertArrayEquals(new String[]{"-o",canonicalPath}, source.getArgs("-o"));
    }

}