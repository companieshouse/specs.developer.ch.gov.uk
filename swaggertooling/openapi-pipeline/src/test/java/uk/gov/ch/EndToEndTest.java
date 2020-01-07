package uk.gov.ch;

import org.junit.jupiter.api.Test;
import uk.gov.ch.pipe.SingleFileConverterPipe;
import uk.gov.ch.pipe.SingleFileFixerPipe;
import uk.gov.ch.pipe.ValidateAndRebasePipe;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EndToEndTest {

    @Test
    public void fullTest() throws IOException {
        String spec = "spec";
        File workingFile = new File("target/test-classes");
        String specOut = "specsOutput";

        APIValidatorPipeline pipeline = new APIValidatorPipeline(
                new SingleFileFixerPipe(),
                new SingleFileConverterPipe(),
                new ValidateAndRebasePipe()
        );
        pipeline.processDocs("-i", spec, "-o", specOut, "-w", workingFile.getCanonicalPath());


        File specOutDir = workingFile.toPath().resolve(specOut).toFile();
        assertTrue(specOutDir.isDirectory());
        File specOutBadDir = specOutDir.toPath().resolve("bad").toFile();
        assertTrue(specOutBadDir.isDirectory());

        File specsDir = workingFile.toPath().resolve(spec).toFile();
        assertTrue(specOutDir.isDirectory());

        final List<File> goodFiles = Collections.unmodifiableList(Arrays.asList(specOutDir.listFiles()));
        final List<File> badFiles = Collections.unmodifiableList(Arrays.asList(specOutBadDir.listFiles()));
        final List<File> tempAllFiles = new ArrayList<>(goodFiles);
        tempAllFiles.addAll(badFiles);
        final List<File> allFiles = Collections.unmodifiableList(tempAllFiles);
        assertEquals(specsDir.listFiles().length, allFiles.size());
        for (File f : specsDir.listFiles()) {
            assertTrue(matchesInGoodOrBad(f, allFiles));
        }
//        for(file in specOutDir){
//            assert(valid)
//        }
//        for(file in specOut.bad){
//            assert(notValid)
//        }
    }

    private boolean matchesInGoodOrBad(File f, List<File> allFiles) {
        return allFiles.stream().anyMatch(af -> af.getName().equals(f.getName()));
    }
}
