package uk.gov.ch;

import uk.gov.ch.args.ArgsPacker;
import uk.gov.ch.pipe.AbstractAPIPipe;
import uk.gov.ch.pipe.SingleFileConverterPipe;
import uk.gov.ch.pipe.SingleFileFixerPipe;
import uk.gov.ch.pipe.ValidateAndRebasePipe;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class APIValidatorPipeline {


    private AbstractAPIPipe startPipe;

    private APIValidatorPipeline(AbstractAPIPipe... pipes) {
        buildPipe(pipes);
    }

    APIValidatorPipeline(SingleFileFixerPipe fixer, SingleFileConverterPipe converter, ValidateAndRebasePipe validator) {
        this(new AbstractAPIPipe[]{fixer, converter, validator});
    }

    public static void main(final String... args) {
        APIValidatorPipeline pipeline = new APIValidatorPipeline(
                new SingleFileFixerPipe(),
                new SingleFileConverterPipe(),
                new ValidateAndRebasePipe());
        pipeline.processDocs(args);
    }

    public void processDocs(final String... args) {
        ArgsPacker packedArgs = readArguments(args);
        Collection<File> files = packedArgs.getSource().getInputFiles();
        files.forEach(f -> {
            try {
                startPipe.setInputFileName(f.getCanonicalPath());
                startPipe.pipe();
                resetPipe();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
//        try {
//            cleanUpAbandonedFiles(packedArgs);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    private void resetPipe() {
        AbstractAPIPipe curr = startPipe;
        while (curr != null) {
            curr.setAbort(false);
            curr = curr.getNext();
        }
    }

    private ArgsPacker readArguments(final String... args) {
        final ArgsPacker packed = new ArgsPacker(args);
        startPipe.setSource(packed.getSource());
//        return packed.getSource().getInputFiles();
        return packed;
    }

    private void buildPipe(final AbstractAPIPipe... pipes) {
        startPipe = pipes[0];
        for (int i = 1; i < pipes.length; i++) {
            pipes[i - 1].setNext(pipes[i]);
        }
    }
}
