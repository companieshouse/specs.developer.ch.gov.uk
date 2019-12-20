package uk.gov.ch.pipe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatcher;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.ch.AbstractAPIPipelineVerifiers;
import uk.gov.ch.args.ISource;


import java.io.IOException;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class NaiveConverterPipeTest {

    private String[] args = new String[]{"-i","tempDir1","-o","tempDir2"};
    @Mock
    ISource source;
    @Spy
    @InjectMocks
    NaiveConverterPipe pipe;

    @Test
    void pipeMethodFunctions_test() throws Exception {
        doNothing().when(pipe).convert(args);
        when(source.getArgs("-i:t1","-o:t2")).thenReturn(args);
        pipe.pipe();
        verify(source,times(1)).getArgs("-i:t1","-o:t2");
        verify(pipe,times(1)).convert(args);
    }

    @Test
    void pipeMethodFunctions_invokesAbort_ifItErrors() throws Exception {
        doThrow(new Exception()).when(pipe).convert(args);
        when(source.getArgs("-i:t1","-o:t2")).thenReturn(args);
        pipe.pipe();
        verify(source,times(1)).getArgs("-i:t1","-o:t2");
        verify(pipe,times(1)).convert(args);
        AbstractAPIPipelineVerifiers.verifyAbortWasCalled(pipe);
    }

    @Test
    void pipeMethodFunctions_invokesAbort_ifArgsErrors() throws Exception {
        doThrow(new IOException()).when(source).getArgs("-i:t1","-o:t2");
        pipe.pipe();
        AbstractAPIPipelineVerifiers.verifyAbortWasCalled(pipe);
    }
}