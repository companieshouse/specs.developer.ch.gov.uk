package uk.gov.ch.pipe;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.ch.args.ISource;

import java.io.File;
import java.nio.file.Path;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class NaiveConverterPipeTest {

    private String[] args = new String[]{"-i","tempDir1","-o","tempDir2"};
    @Mock
    ISource source;
    @Spy
    @InjectMocks
    NaiveConverterPipe pipe;
    private Path inputFolder = new File("input").toPath();
    private Path outputFolder = new File("output").toPath();


    @Test
    void pipeMethodFunctions_test() throws Exception {
        doNothing().when(pipe).convert(inputFolder, outputFolder);
        when(source.getFixedDir()).thenReturn(inputFolder);
        when(source.getConvertDir()).thenReturn(outputFolder);
        pipe.pipe();
        verify(source, times(1)).getFixedDir();
        verify(source, times(1)).getConvertDir();
        verify(pipe, times(1)).convert(inputFolder, outputFolder);
    }

    @Test
    void pipeMethodFunctions_invokesAbort_ifItErrors() throws Exception {
        doThrow(new Exception()).when(pipe).convert(inputFolder, outputFolder);
        when(source.getFixedDir()).thenReturn(inputFolder);
        when(source.getConvertDir()).thenReturn(outputFolder);
        pipe.pipe();
        verify(source, times(1)).getFixedDir();
        verify(source, times(1)).getConvertDir();
        verify(pipe, times(1)).convert(inputFolder, outputFolder);
        AbstractAPIPipelineVerifiers.verifyAbortWasCalled(pipe);
    }
}