package uk.gov.ch.pipe;

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

@ExtendWith(MockitoExtension.class)
class NaiveValidatorPipeTest {
    @Mock
    ISource source;
    @Spy
    @InjectMocks
    NaiveValidatorPipe pipe;
    private String[] args = new String[]{"-o", "outputDir"};

    @Test
    void pipeMethodFunctions_test() throws Exception {
        doNothing().when(pipe).validate(args);
        when(source.getArgs("-o")).thenReturn(args);
        pipe.pipe();
        verify(source, times(1)).getArgs("-o");
        verify(pipe, times(1)).validate(args);
    }

    @Test
    void pipeMethodFunctions_invokesAbort_ifItErrors() throws Exception {
        doThrow(new IOException()).when(source).getArgs("-o");
        pipe.pipe();
        verify(source, times(1)).getArgs("-o");
        AbstractAPIPipelineVerifiers.verifyAbortWasCalled(pipe);
    }
}