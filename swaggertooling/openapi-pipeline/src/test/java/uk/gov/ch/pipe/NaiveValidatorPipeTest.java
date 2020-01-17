package uk.gov.ch.pipe;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.ch.args.ISource;

@ExtendWith(MockitoExtension.class)
class NaiveValidatorPipeTest {

    private final String outputDir = "outputDir";
    private final String[] args = new String[]{"-o", outputDir};
    @Mock
    ISource source;
    @Spy
    @InjectMocks
    NaiveValidatorPipe pipe;

    @Test
    void pipeMethodFunctions_test() {
        doNothing().when(pipe).validate(args);
        when(source.getOutputDir()).thenReturn(outputDir);
        pipe.pipe();
        verify(source, times(1)).getOutputDir();
        verify(pipe, times(1)).validate("-o", outputDir);
    }
}