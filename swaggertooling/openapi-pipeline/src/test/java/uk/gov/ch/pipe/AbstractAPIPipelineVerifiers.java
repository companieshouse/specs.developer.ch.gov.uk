package uk.gov.ch.pipe;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class AbstractAPIPipelineVerifiers {
    static void verifyAbortWasCalled(AbstractAPIPipe pipe) {
        verify(pipe, times(1)).abort();
    }
}
