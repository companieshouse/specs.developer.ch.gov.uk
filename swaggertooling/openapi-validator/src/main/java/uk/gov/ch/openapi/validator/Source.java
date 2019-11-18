package uk.gov.ch.openapi.validator;

import java.io.File;
import java.io.IOException;
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

public class Source implements ISource {

    private Collection<File> inputs;
    private String extension = ".json";
    private Path workingDir = Paths.get(System.getProperty("user.home"));

    Source() {
        inputs = Collections.emptySet();
    }

    @Override
    public Collection<File> getInputFiles() {
        return inputs;
    }

    @Override
    public void setInputFiles(final Collection<String> inputFiles) throws IOException {
        final Set<File> files = new LinkedHashSet<>();
        for (final String file : inputFiles) {
            final File path = getWorkingDir().resolve(file).toFile();
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

    @Override
    public Path getWorkingDir() {
        return workingDir;
    }

    @Override
    public void setWorkingDir(String s) {
        workingDir = Paths.get(s).toAbsolutePath();
    }

    private Stream<File> getInputFilesInDir(final File path) {
        final String[] list = path.list();
        return Arrays.stream(Objects.requireNonNull(list))
                .filter(f -> f.endsWith(extension))
                .map(pathname -> new File(path, pathname))
                .filter(File::isFile)
                .sorted();
    }

}
