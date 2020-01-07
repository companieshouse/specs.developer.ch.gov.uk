package uk.gov.ch.pipe;

import uk.gov.ch.tools.swagger.Fix1_2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class NaiveFixerPipe extends AbstractAPIPipe {

    static private String getCanonicalPathNoThrow(File p) {
        try {
            return p.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    void fix(final List<String> inFiles, final String outDir, final String workingDir) {
        List<String> args = new ArrayList<>();
        args.add("-i");
        args.addAll(inFiles);
        args.add("-o");
        args.add(outDir);
        args.add("-w");
        args.add(workingDir);
        Fix1_2.main(args.toArray(new String[]{}));
    }

    @Override
    protected void handle() {
        try {
            final List<String> inputs = getArgs().getInputFiles().stream().map(
                    NaiveFixerPipe::getCanonicalPathNoThrow
            ).filter(Objects::nonNull)
                    .collect(Collectors.toList());
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
}
