package uk.gov.ch;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class AbstractAPIPipelineVerifiers {
    public static void verifyAbortWasCalled(AbstractAPIPipe pipe){
        verify(pipe,times(1)).abort();
    }
}
