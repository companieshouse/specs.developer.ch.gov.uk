package uk.gov.ch.args;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Source implements ISource {

    private static final Logger LOGGER = LoggerFactory.getLogger(Source.class);

    private final String extension = ".json";
    private String outputDir = "";
    private Collection<File> inputs;
    private Path workingDir;
    private Path fixedDir;
    private Path convertDir;

    Source() {
        inputs = Collections.emptySet();
    }

    @Override
    public String getOutputDir() {

        return outputDir;
    }

    @Override
    public void setOutputDir(final String oDir) throws IOException {
        File path;
        if (getWorkingDir() != null) {
            path = getWorkingDir().resolve(oDir).toFile();
        } else {
            path = Paths.get(oDir).toFile();
        }
        if (path.exists()) {
            if ((!path.isDirectory()) || (!path.canWrite())) {
                throw new IOException("No writeable directory at '" + path.getAbsolutePath()
                        + "' so output not possible");
            }
        } else {
            LOGGER.info("Creating output directory");
            if (!path.mkdir()) {
                throw new IOException(
                        "Unable to create output directory '" + path.getAbsolutePath() + "'");
            }
        }
        outputDir = path.getAbsolutePath();
    }

    @Override
    public Collection<File> getInputFiles() {
        return inputs;
    }

    @Override
    public void setInputFiles(final Collection<String> inputFiles) throws IOException {
        final Set<File> files = new LinkedHashSet<>();
        for (final String file : inputFiles) {
            final File path;
            if (getWorkingDir() != null) {
                path = getWorkingDir().resolve(file).toFile();
            } else {
                path = new File(file);
            }
            if (!path.exists()) {
                throw new IOException("Input path '" + path.getAbsolutePath() + "' not found");
            }
            if (path.isDirectory()) {
                files.addAll(getInputFilesInDir(path)
                        .collect(Collectors.toList()));
            } else {
                files.add(path);
            }
        }
        inputs = files;
    }

    private Stream<File> getInputFilesInDir(final File path) {
        final String[] list = path.list();
        return Arrays.stream(Objects.requireNonNull(list))
                .filter(f -> f.endsWith(extension))
                .map(pathname -> new File(path, pathname))
                .filter(File::isFile)
                .sorted();
    }

    public Path getWorkingDir() {
        return workingDir;
    }

    @Override
    public void setWorkingDir(String s) {
        workingDir = Paths.get(s).toAbsolutePath();
    }

    @Override
    public Path getFixedDir() throws IOException {
        if (fixedDir == null) {
            fixedDir = Files.createTempDirectory("fixedJson");
            fixedDir.toFile().deleteOnExit();
        }
        return fixedDir;
    }

    public Path getConvertDir() throws IOException {
        if (convertDir == null) {
            convertDir = Files.createTempDirectory("convertedJson");
            convertDir.toFile().deleteOnExit();
        }
        return convertDir;
    }

    @Override
    public void validateArgs() throws IllegalArgumentException {
        String ret = "";
        if (getInputFiles().isEmpty()) {
            ret += "No input files where provided. ";
        }
        if (getOutputDir().isEmpty()) {
            ret += "No output directory was provided. ";
        }
        if (getWorkingDir() == null) {
            ret += "No working directory was provided.";
        }
        if (!ret.isEmpty()) {
            throw new IllegalArgumentException(ret);
        }
    }

}
