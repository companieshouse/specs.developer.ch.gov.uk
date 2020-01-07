package uk.gov.ch.args;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Source implements ISource {


    private String outputDir = "";
    private Collection<File> inputs;
    private final String extension = ".json";
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
            System.out.println("Creating output directory");
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
                final boolean fileList = files.addAll(getInputFilesInDir(path)
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
//            File fixedDirFile = workingDir.resolve("apitoolfixed").toFile();
//            if (!fixedDirFile.exists()) {
//                fixedDirFile.mkdir();
//            }
//            fixedDir = fixedDirFile.toPath();
        }
        return fixedDir;
    }

    public Path getConvertDir() throws IOException {
        if (convertDir == null) {
            convertDir = Files.createTempDirectory("convertedJson");
            convertDir.toFile().deleteOnExit();
//            File convertDirFile = workingDir.resolve("apitoolconverted").toFile();
//            if (!convertDirFile.exists()) {
//                convertDirFile.mkdir();
//            }
//            convertDir = convertDirFile.toPath();
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

    @Override
    public String[] getArgs(final String... s) throws IOException {
        final ArrayList<String> ret = new ArrayList<>();
        ArgParser parser = new ArgParser(s);
        if (parser.has("-i")) {
            ret.add("-i");
            ret.addAll(getInputFiles().stream()
                    .map(File::getPath)
                    .collect(Collectors.toList()));
        } else if (parser.has("-i:t1")) {
            ret.add("-i");
            ret.add(getFixedDir().toFile().getCanonicalPath());
        } else if (parser.has("-i:t2")) {
            ret.add("-i");
            ret.add(getConvertDir().toFile().getCanonicalPath());
        }

        if (parser.has("-o")) {
            ret.add("-o");
            ret.add(getOutputDir());
        } else if (parser.has("-o:t1")) {
            ret.add("-o");
            ret.add(getFixedDir().toFile().getCanonicalPath());
        } else if (parser.has("-o:t2")) {
            ret.add("-o");
            ret.add(getConvertDir().toFile().getCanonicalPath());
        }
        return ret.toArray(new String[]{});
    }

}
