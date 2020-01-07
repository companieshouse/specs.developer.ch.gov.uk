package uk.gov.ch.pipe;

import uk.gov.ch.tools.swagger.Fix1_2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SingleFileFixerPipe extends AbstractAPIPipe {
    @Override
    protected void handle() {
        try {
            final String inputs = this.getInputName();
            final String outputPath = getArgs().getFixedDir().toFile().getCanonicalPath();
            final String workingDir = getArgs().getWorkingDir().toFile().getCanonicalPath();
            fix(
                    inputs, outputPath, workingDir
            );
        } catch (IOException e) {
            e.printStackTrace();
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
