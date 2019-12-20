package uk.gov.ch.args;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Collection;

public interface ISource {
    Collection<File> getInputFiles();

    void setInputFiles(Collection<String> strings) throws IOException;

    String getOutputDir();

    void setOutputDir(String s) throws IOException;

    Path getWorkingDir();

    void setWorkingDir(String s);

    Path getFixedDir() throws IOException;

    void validateArgs() throws IllegalArgumentException;

    String[] getArgs(String... s) throws IOException;
}
