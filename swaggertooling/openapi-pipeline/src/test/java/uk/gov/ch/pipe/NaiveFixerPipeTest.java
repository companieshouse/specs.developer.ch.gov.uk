package uk.gov.ch.pipe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.ch.AbstractAPIPipelineVerifiers;
import uk.gov.ch.args.ISource;

import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class NaiveFixerPipeTest {
    @Mock
    ISource source;
    @Spy
    @InjectMocks
    NaiveFixerPipe pipe;
    private String[] args = new String[]{"-i","input","-o","tempDir"};

    @Test
    void pipeMethodFunctions_test() throws IOException {
        doNothing().when(pipe).fix(args);
        when(source.getArgs("-i","-o:t1")).thenReturn(args);
        pipe.pipe();
        verify(source,times(1)).getArgs("-i","-o:t1");
        verify(pipe,times(1)).fix(args);
    }

    @Test
    void pipeMethodFunctions_invokesAbort_ifItErrors() throws Exception {
        doThrow(new IOException()).when(source).getArgs("-i","-o:t1");
        pipe.pipe();
        verify(source,times(1)).getArgs("-i","-o:t1");
        AbstractAPIPipelineVerifiers.verifyAbortWasCalled(pipe);
    }
}