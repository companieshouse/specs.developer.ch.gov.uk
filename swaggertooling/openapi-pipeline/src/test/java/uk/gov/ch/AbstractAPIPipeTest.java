package uk.gov.ch;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import uk.gov.ch.args.ISource;
import uk.gov.ch.pipe.AbstractAPIPipe;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AbstractAPIPipeTest {
    @Mock
    ISource mockSource;

    @Nested
    class SingleTests{

        AtomicInteger handleCounter;
        AbstractAPIPipe pipeA;
        @BeforeEach
        void setup(){
            handleCounter = new AtomicInteger(0);
            pipeA = createNewPipe();
        }

        @Test
        void setSource() {
            pipeA.setSource(mockSource);
            assertEquals(mockSource, pipeA.getArgs());
        }

        @Test
        void pipe() {
            pipeA.pipe();
            assertEquals(1,handleCounter.get());
        }

        @Nested
        class ChainedTests {
            AbstractAPIPipe pipeB;
            AbstractAPIPipe pipeC;
            @BeforeEach
            void setup(){
                pipeB = createNewPipe();
                pipeC = createNewPipe();
                pipeA.setNext(pipeB).setNext(pipeC);
            }

            @Test
            void setSource() {
                pipeA.setSource(mockSource);
                assertEquals(mockSource, pipeA.getArgs());
                assertEquals(mockSource, pipeB.getArgs());
                assertEquals(mockSource, pipeC.getArgs());
            }

            @Test
            void pipe() {
                pipeA.pipe();
                assertEquals(3,handleCounter.get());
            }
            @Test
            void pipe_whenBAborts() {
                pipeB= createAbortingPipe();
                pipeA.setNext(pipeB);
                pipeA.pipe();
                assertEquals(2,handleCounter.get());
            }
        }

        private AbstractAPIPipe createNewPipe() {
            return new AbstractAPIPipe() {
                @Override
                protected void handle() {
                    handleCounter.getAndIncrement();
                }
            };
        }
        private AbstractAPIPipe createAbortingPipe() {
            return new AbstractAPIPipe() {
                @Override
                protected void handle() {
                    handleCounter.getAndIncrement();
                    abort();
                }
            };
        }
    }
}