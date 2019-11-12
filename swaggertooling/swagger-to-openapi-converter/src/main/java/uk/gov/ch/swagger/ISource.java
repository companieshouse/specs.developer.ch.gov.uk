package uk.gov.ch.swagger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Collection;

public interface ISource {

    String getOutputDir();

    void setOutputDir(final String oDirs) throws IOException;

    Collection<File> getInputFiles();

    void setInputFiles(final Collection<String> inputFiles) throws IOException;

    Path getWorkingDir();

    void setWorkingDir(final String s) throws IOException;
}
