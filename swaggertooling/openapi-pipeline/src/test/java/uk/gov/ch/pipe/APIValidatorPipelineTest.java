package uk.gov.ch.pipe;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.ch.APIValidatorPipeline;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class APIValidatorPipelineTest {

    @Spy
    SingleFileFixerPipe mockFixer;
    @Spy
    SingleFileConverterPipe mockConverter;
    @Spy
    ValidateAndRebasePipe mockValidator;
    @InjectMocks
    APIValidatorPipeline pipeline;

    @Test
    void argPacker_ThrowsExceptionIf_NoInputGiven_test() throws Exception {
        String outputName = new File("target/test-classes").getCanonicalPath();
        assertThrows(IllegalArgumentException.class,() -> pipeline.processDocs(
                "-o",outputName
        ));
    }
    @Test
    void argPacker_ThrowsExceptionIf_NoOutputGiven_test() throws Exception {
        String inputName = new File("target/test-classes").getCanonicalPath();
        assertThrows(IllegalArgumentException.class,() -> pipeline.processDocs(
                "-i",inputName
        ));
    }
    @Test
    void argPacker_ThrowsExceptionIfNoFilesInFolder_test() throws Exception {
        String outputName = new File("target/test-classes").getCanonicalPath();
        String inputName = new File("target/test-classes/emptyDir").getCanonicalPath();
        assertThrows(IllegalArgumentException.class, () -> pipeline.processDocs(
                "-i", inputName, "-o", outputName
        ));
    }

    @Test
    void argPacker_ThrowsExceptionIfWorkingFolder_test() throws Exception {
        String outputName = new File("target/test-classes").getCanonicalPath();
        String inputName = new File("target/test-classes").getCanonicalPath();
        assertThrows(IllegalArgumentException.class,() -> pipeline.processDocs(
                "-i",inputName,"-o",outputName
        ));
    }

    @Test
    void processDocs_invokesWrapperMethods_test() throws Exception {
        String outputName = "output";
        String inputName = "singleFileDir/emptyJson.json";
        File workingFile = new File("target/test-classes");
        String workingDir = workingFile.getCanonicalPath();

        doNothing().when(mockFixer).handle();
        doNothing().when(mockConverter).handle();
        doNothing().when(mockValidator).handle();

        pipeline.processDocs(
                "-i", inputName, "-o", outputName, "-w", workingDir
        );

        verify(mockFixer, times(1)).pipe();
        verify(mockConverter, times(1)).pipe();
        verify(mockValidator, times(1)).pipe();
    }
}