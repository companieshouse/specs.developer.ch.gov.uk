package uk.gov.ch;

import uk.gov.ch.args.ArgsPacker;
import uk.gov.ch.pipe.AbstractAPIPipe;
import uk.gov.ch.pipe.SingleFileConverterPipe;
import uk.gov.ch.pipe.SingleFileFixerPipe;
import uk.gov.ch.pipe.ValidateAndRebasePipe;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;

public class APIValidatorPipeline {


    private AbstractAPIPipe startPipe;

    APIValidatorPipeline(AbstractAPIPipe... pipes) {
        buildPipe(pipes);
    }

    public APIValidatorPipeline(SingleFileFixerPipe fixer, SingleFileConverterPipe converter, ValidateAndRebasePipe validator) {
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

    private void cleanUpAbandonedFiles(ArgsPacker packedArgs) throws IOException {
        final Path badAPIFolder = packedArgs.getSource().getWorkingDir().resolve(
                packedArgs.getSource().getOutputDir()).resolve("bad");
        badAPIFolder.toFile().mkdir();
        for (File f : packedArgs.getSource().getFixedDir().toFile().listFiles()) {
            Path fPath = f.toPath();
            Files.move(
                    fPath,
                    badAPIFolder.resolve(f.getName())
            );
        }
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

    public void buildPipe(final AbstractAPIPipe... pipes) {
        startPipe = pipes[0];
        for (int i = 1; i < pipes.length; i++) {
            pipes[i - 1].setNext(pipes[i]);
        }
    }
}
