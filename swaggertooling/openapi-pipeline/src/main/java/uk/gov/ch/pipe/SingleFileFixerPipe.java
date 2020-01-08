package uk.gov.ch.pipe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.gov.ch.tools.swagger.Fix1_2;

public class SingleFileFixerPipe extends AbstractAPIPipe {

    private static final Logger LOGGER = LoggerFactory.getLogger(SingleFileFixerPipe.class);

    @Override
    protected void handle() {
        final String inputs = this.getInputName();
        try {
            final String outputPath = getArgs().getFixedDir().toFile().getCanonicalPath();
            final String workingDir = getArgs().getWorkingDir().toFile().getCanonicalPath();
            fix(inputs, outputPath, workingDir);
        } catch (IOException e) {
            LOGGER.error(
                    "Error reading parameters from output or working directory when processing "
                            + inputs,
                    e
            );
            abort();
        }
    }

    private void fix(String input, String outputPath, String workingDir) {
        List<String> args = new ArrayList<>();
        args.add("-i");
        args.add(input);
        args.add("-o");
        args.add(outputPath);
        args.add("-w");
        args.add(workingDir);
        Fix1_2.main(args.toArray(new String[]{}));
    }
}
