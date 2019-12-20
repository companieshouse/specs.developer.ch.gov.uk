package uk.gov.ch.pipe;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.ch.AbstractAPIPipelineVerifiers;
import uk.gov.ch.args.ISource;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ValidateAndRebasePipeTest {

    @Mock
    ISource source;
    @InjectMocks @Spy
    ValidateAndRebasePipe pipe;
    private String outDir = (new File("src/test/resources/output")).getCanonicalPath();

    ValidateAndRebasePipeTest() throws IOException {
    }

    @Test
    void test_AbortExecutedIfArgPackingThrowsException() throws IOException {
        doThrow(new IOException()).when(source).getArgs("-i:t2", "-o");
        pipe.pipe();
        AbstractAPIPipelineVerifiers.verifyAbortWasCalled(pipe);
    }

    @Nested
    class singleFileTests{
        String singleFileDir = (new File("src/test/resources/singleFileDir")).getCanonicalPath();
        private String[] singleFileArgs = new String[]{"-i",singleFileDir,"-o",outDir};

        singleFileTests() throws IOException {
        }

        @BeforeEach
        void setUp() throws IOException {
            System.out.println(singleFileDir);
            doReturn(singleFileArgs).when(source).getArgs("-i:t2","-o");
        }
        @Test
        void test_ValidateAndRebase_getFilePathsForConvertedFiles_ReturnsExpectedFile() throws IOException {
            String[] files = pipe.getFilePathsForConvertedFiles();
            String expected = new File("src/test/resources/singleFileDir/emptyJson.json").getCanonicalPath();
            assertEquals(expected,files[0]);
            assertEquals(1,files.length);
        }

        @Test
        void test_ValidateAndRebase_AttemptsTo_ValidatesSingleFiles() throws IOException {
            doNothing().when(pipe).validateAndMove(anyString());
            pipe.pipe();
            verify(pipe, times(1)).validateAndMove(anyString());
        }

    }

    @Nested
    class multipleFileTests{
        String multFileDir = (new File("src/test/resources/multipleFileDir")).getCanonicalPath();
        private String[] doubleFileArgs = new String[]{"-i", multFileDir,"-o",outDir};

        multipleFileTests() throws IOException {
        }

        @BeforeEach
        void setUp() throws IOException {
            System.out.println(multFileDir);
            doReturn(doubleFileArgs).when(source).getArgs("-i:t2","-o");
        }

        @Test
        void test_ValidateAndRebase_getFilePathsForConvertedFiles_ReturnsExpectedFile() throws IOException {
            String[] files = pipe.getFilePathsForConvertedFiles();
            String expectedOne = new File("src/test/resources/multipleFileDir/emptyJson.json").getCanonicalPath();
            String expectedTwo = new File("src/test/resources/multipleFileDir/secondJson.json").getCanonicalPath();
            System.out.println(Arrays.toString(files));
            assertEquals(expectedOne,files[0]);
            assertEquals(expectedTwo,files[1]);
            assertEquals(2,files.length);
        }

        @Test
        void test_ValidateAndRebase_AttemptsTo_ValidatesMultipleFiles() throws IOException {
            doNothing().when(pipe).validateAndMove(anyString());
            pipe.pipe();
            verify(pipe, times(2)).validateAndMove(anyString());
        }
    }

    @Nested class movesFiles{
        private File moveDir;
        private File fakeTempFile;
        private File destination;

        @BeforeEach
        void setup() throws IOException {
            moveDir = new File("src/test/resources/movement");
            moveDir.mkdir();
            fakeTempFile = new File(moveDir.getPath() + "/test.json");
            fakeTempFile.createNewFile();
            destination = new File(moveDir.getPath() + "/output");
            destination.mkdir();

            doReturn(destination.getCanonicalPath()).when(source).getOutputDir();

        }
        @AfterEach
        void tearDown() throws IOException {
            Files.walk(moveDir.toPath(), FileVisitOption.FOLLOW_LINKS)
                    .sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    .forEach(File::delete);
        }

        @Test
        void test_validateAndMoves_MovesSuccessfullyValidatedFile() throws IOException {
            doAnswer(a-> { System.out.println(a);return 1;}).when(pipe).invokeValidator(anyString());
            pipe.validateAndMove(fakeTempFile.getPath());
            System.out.println( new File(destination.getPath()+fakeTempFile.getName()).getCanonicalPath());
            assertTrue( new File(destination.getPath()+"/"+fakeTempFile.getName()).exists());
        }
        @Test
        void test_validateAndMoves_MovesUnsuccessfullyValidatedFile() throws IOException {
            doReturn(2).when(pipe).invokeValidator(anyString());
            pipe.validateAndMove(fakeTempFile.getPath());
            assertTrue( new File(destination.getPath()+"/bad/"+fakeTempFile.getName()).exists());
        }
    }
}