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
import uk.gov.ch.args.ISource;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ValidateAndRebasePipeTest {

    @Mock
    ISource source;
    @InjectMocks @Spy
    ValidateAndRebasePipe pipe;
    private String outDir = (new File("target/test-classes/output")).getCanonicalPath();

    ValidateAndRebasePipeTest() throws IOException {
    }

    @Test
    void test_AbortExecutedIfArgPackingThrowsException() throws IOException {
        doThrow(new IOException()).when(source).getConvertDir();
        pipe.pipe();
        AbstractAPIPipelineVerifiers.verifyAbortWasCalled(pipe);
    }

    @Nested
    class singleFileTests{
        String singleFileDir = (new File("target/test-classes/singleFileDir")).getCanonicalPath();
        private String[] singleFileArgs = new String[]{"-i",singleFileDir,"-o",outDir};

        singleFileTests() throws IOException {
        }

        @BeforeEach
        void setUp() throws IOException {
            System.out.println(singleFileDir);
//            doReturn(singleFileArgs).when(source).getArgs("-i:t2","-o");
            doReturn(new File(singleFileDir).toPath()).when(source).getConvertDir();
//            doReturn(outDir).when(source).getOutputDir();
        }
        @Test
        void test_ValidateAndRebase_getFilePathsForConvertedFiles_ReturnsExpectedFile() throws IOException {
            String[] files = pipe.getFilePathsForConvertedFiles();
            String expected = new File("target/test-classes/singleFileDir/emptyJson.json").getCanonicalPath();
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
        String multFileDir = (new File("target/test-classes/multipleFileDir")).getCanonicalPath();
        private String[] doubleFileArgs = new String[]{"-i", multFileDir,"-o",outDir};

        multipleFileTests() throws IOException {
        }

        @BeforeEach
        void setUp() throws IOException {
            System.out.println(multFileDir);
//            doReturn(doubleFileArgs).when(source).getArgs("-i:t2","-o");
            doReturn(new File(multFileDir).toPath()).when(source).getConvertDir();
//            doReturn(outDir).when(source).getOutputDir();
        }

        @Test
        void test_ValidateAndRebase_getFilePathsForConvertedFiles_ReturnsExpectedFile() throws IOException {
            String[] files = pipe.getFilePathsForConvertedFiles();
            String expectedOne = new File("target/test-classes/multipleFileDir/emptyJson.json").getCanonicalPath();
            String expectedTwo = new File("target/test-classes/multipleFileDir/secondJson.json").getCanonicalPath();
            assertEquals(2,files.length);
            //I don't think I can guarentee order.
            if (files[0] == expectedOne) {
                assertEquals(expectedTwo, files[1]);
            } else {
                assertEquals(expectedTwo, files[0]);
            }
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
            moveDir = new File("target/test-classes/movement");
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