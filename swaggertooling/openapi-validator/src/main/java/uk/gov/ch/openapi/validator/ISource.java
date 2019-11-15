package uk.gov.ch.openapi.validator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Collection;

public interface ISource {

    Collection<File> getInputFiles();

    void setInputFiles(final Collection<String> inputFiles) throws IOException;

    Path getWorkingDir();

    void setWorkingDir(final String s) throws IOException;
}
