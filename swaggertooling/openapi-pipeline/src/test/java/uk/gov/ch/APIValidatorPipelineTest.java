package uk.gov.ch;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatcher;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.ch.pipe.NaiveConverterPipe;
import uk.gov.ch.pipe.NaiveFixerPipe;
import uk.gov.ch.pipe.NaiveValidatorPipe;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class APIValidatorPipelineTest {

    @Mock
    NaiveFixerPipe mockFixer;
    @Mock
    NaiveConverterPipe mockConverter;
    @Mock
    NaiveValidatorPipe mockValidator;
    @InjectMocks
    APIValidatorPipeline pipeline;

    @Test
    void argPacker_ThrowsExceptionIf_NoInputGiven() throws Exception {
        String outputName = new File("src/test/resources").getCanonicalPath();
        assertThrows(IllegalArgumentException.class,() -> pipeline.processDocs(
                "-o",outputName
        ));
    }
    @Test
    void argPacker_ThrowsExceptionIf_NoOutputGiven() throws Exception {
        String inputName = new File("src/test/resources").getCanonicalPath();
        assertThrows(IllegalArgumentException.class,() -> pipeline.processDocs(
                "-i",inputName
        ));
    }
    @Test
    void argPacker_ThrowsExceptionIfNoFilesInFolder() throws Exception {
        String outputName = new File("src/test/resources").getCanonicalPath();
        String inputName = new File("src/test/resources/emptyDir").getCanonicalPath();
        assertThrows(IllegalArgumentException.class,() -> pipeline.processDocs(
                "-i",inputName,"-o",outputName
        ));
    }

//    @Test
//    void  processDocs_pipesThroughAllSteps_test() throws IOException {
//        //This do nothing is used to disable it from invoking the main methods.
////        doNothing().when(mockFixer).handle();
////        doNothing().when(mockConverter).handle();
////        doNothing().when(mockValidator).handle();
//        StopSpyHandling(mockFixer);
//        doAnswer((a)-> {System.out.println(a); return null;}).when(mockFixer).pipe();
//        StopSpyHandling(mockConverter);
//        StopSpyHandling(mockConverter);
//        pipeline.processDocs("-w","src/test/resources","-i","singleFileDir","-o","output");
//        verifyHandleInvoked(mockFixer,1);
//        verifyHandleInvoked(mockConverter,1);
//        verifyHandleInvoked(mockValidator,1);
////        verify(mockConverter,times(1)).handle();
////        verify(mockValidator,times(1)).handle();
//    }

    /**
     *  Method used to down cast pipe to so that Handle method is visible
     * @param spiedPipe
     * @param times
     */
    private void verifyHandleInvoked(AbstractAPIPipe spiedPipe, int times) {
        verify(spiedPipe,times(times)).handle();
    }

    /**
     *  Method used to down cast pipe to so that Handle method is visible
     * @param spiedPipe
     */
    public static void StopSpyHandling(AbstractAPIPipe spiedPipe){
        doAnswer((a)-> {System.out.println(a); return null;}).when(spiedPipe).pipe();
//        doNothing().when(spiedPipe).handle();
    }
//    @Test
//    void processDocs_invokesWrapperMethods_WithCorrectArgs_NoWorkingDir_() throws Exception {
//
//        String outputName = new File("src/test/resources").getCanonicalPath();
//        String inputName = new File("src/test/resources/singleFileDir/emptyJson.json").getCanonicalPath();
////        pipeline.processDocs(
////                "-i",inputName,"-o",outputName
////        );
//
////        verify(mockFixer, times(1)).fix(
////                argThat(inputArgMatcher()),
////                argThat(specificStringMatcher(inputName)),
////                argThat(outputArgMatcher()),
////                anyString());
////        verify(mockConverter, times(1)).convert(
////                argThat(inputArgMatcher()),
////                anyString(),
////                argThat(outputArgMatcher()),
////                argThat(specificStringMatcher(outputName)));
////        verify(mockValidator, times(1)).validate("-i",outputName);
//    }
//
//    @Test
//    void processDocs_invokesWrapperMethods_WithCorrectArgs_WithWorkingDir_() throws Exception {
//        String outputName = "output";
//        String inputName = "singleFileDir/emptyJson.json";
//        File workingFile = new File("src/test/resources");
//        String workingDir = workingFile.getCanonicalPath();
//
//        String resolvedOut = workingFile.toPath().resolve(outputName).toFile().getCanonicalPath();
//        String resolvedIn = workingFile.toPath().resolve(inputName).toFile().getCanonicalPath();
//
////        pipeline.processDocs(
////                "-i",inputName,"-o",outputName,"-w",workingDir
////        );
//
////        verify(mockFixer, times(1)).fix(
////                argThat(inputArgMatcher()),
////                argThat(specificStringMatcher(resolvedIn)),
////                argThat(outputArgMatcher()),
////                anyString()
////        );
////        verify(mockConverter, times(1)).convert(
////                argThat(inputArgMatcher()),
////                anyString(),
////                argThat(outputArgMatcher()),
////                argThat(specificStringMatcher(resolvedOut))
////        );
////        verify(mockValidator, times(1)).validate(
////                "-i",resolvedOut
////        );
//    }

    private ArgumentMatcher<String> inputArgMatcher() {
        return argument -> argument.startsWith("-i");
    }
    private ArgumentMatcher<String> outputArgMatcher() {
        return argument -> argument.startsWith("-o");
    }
    private ArgumentMatcher<String> specificStringMatcher(String matchAgainst) {
        return new SpecificStringMatcher(matchAgainst);
    }

    private class SpecificStringMatcher implements ArgumentMatcher<String> {
        private final String comparison;

        SpecificStringMatcher(String matchAgainst) {
            this.comparison = matchAgainst;
        }

        @Override
        public boolean matches(String argument) {
            return argument.equals(comparison);
        }
    }
}