package uk.gov.ch.pipe;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.ch.args.ISource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class NaiveFixerPipeTest {
    private final List<File> inputFiles = Collections.singletonList(new File("input"));
    private final List<String> inputNames = inputFiles.stream().map(f -> {
        try {
            return f.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }).filter(Objects::nonNull).collect(Collectors.toList());
    private final Path outputDir = new File("output").toPath();
    private final Path workingDir = new File("working").toPath();
    @Mock
    ISource source;
    @Spy
    @InjectMocks
    NaiveFixerPipe pipe;
    private String[] args = new String[]{"-i","input","-o","tempDir"};

    @Test
    void pipeMethodFunctions_test() throws IOException {
        doNothing().when(pipe).fix(inputNames, outputDir.toFile().getCanonicalPath(), workingDir.toFile().getCanonicalPath());
        when(source.getInputFiles()).thenReturn(inputFiles);
        when(source.getFixedDir()).thenReturn(outputDir);
        when(source.getWorkingDir()).thenReturn(workingDir);
        pipe.pipe();
        verify(source, times(1)).getInputFiles();
        verify(source, times(1)).getFixedDir();
        verify(pipe, times(1)).fix(inputNames, outputDir.toFile().getCanonicalPath(), workingDir.toFile().getCanonicalPath());
    }

    @Test
    void pipeMethodFunctions_invokesAbort_ifItErrors() throws Exception {
        doThrow(new IOException()).when(source).getFixedDir();
        pipe.pipe();
        verify(source, times(1)).getFixedDir();
        verify(source, times(1)).getInputFiles();
        AbstractAPIPipelineVerifiers.verifyAbortWasCalled(pipe);
    }
}