package uk.gov.ch;

import uk.gov.ch.args.ArgsPacker;
import uk.gov.ch.pipe.NaiveConverterPipe;
import uk.gov.ch.pipe.NaiveFixerPipe;
import uk.gov.ch.pipe.ValidateAndRebasePipe;

public class APIValidatorPipeline {

    private NaiveFixerPipe fixWrapper = new NaiveFixerPipe();
    private NaiveConverterPipe naiveConverterPipe = new NaiveConverterPipe();
    private ValidateAndRebasePipe naiveValidatorPipe = new ValidateAndRebasePipe();

    public static void main(String... args) {
        APIValidatorPipeline pipeline = new APIValidatorPipeline();
        pipeline.processDocs(args);
    }

    void processDocs(String... args) {
        fixWrapper.setNext(naiveConverterPipe);
        naiveConverterPipe.setNext(naiveValidatorPipe);
        readArguments(args);
        fixWrapper.pipe();
    }

    private void readArguments(String[] args) {
        ArgsPacker packed = new ArgsPacker(args);
        fixWrapper.setSource(packed.getSource());
    }
}
