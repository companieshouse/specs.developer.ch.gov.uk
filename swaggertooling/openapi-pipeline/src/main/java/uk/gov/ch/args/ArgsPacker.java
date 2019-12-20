package uk.gov.ch.args;

import java.io.IOException;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Consumer;

public class ArgsPacker {

    private final static String OUTPUT_DIR_PARAM = "-o";
    private static final String INPUT_DIR_PARAM = "-i";
    /**
     * Working Dir is never passed to the pipeline job as Source resolves all paths to absolutes.
     */
    private static final String WORKING_DIR_PARAM = "-w";
    private ISource source = new Source();

    public ArgsPacker(final String... args) {
        try {
            ArgParser argParser = new ArgParser(args);
            if (argParser.hasAny()) {
                if (argParser.has(WORKING_DIR_PARAM)) {
                    generateWorkingDir(argParser.get(WORKING_DIR_PARAM));
                }
                if (argParser.has(INPUT_DIR_PARAM)) {
                    source.setInputFiles(argParser.get(INPUT_DIR_PARAM));
                }
                if (argParser.has(OUTPUT_DIR_PARAM)) {
                    generateOutputDir(argParser.get(OUTPUT_DIR_PARAM));
                }
            }
        } catch (final Exception ex) {
            System.err.println(ex.getLocalizedMessage());
            ex.printStackTrace();
        }
        source.validateArgs();
    }

    private Optional<String> uniqueDir(Collection<String> dirs) {
        return dirs.stream().findFirst();
    }

    private void generateWorkingDir(final Collection<String> workingDirs) {
        setSingleOption(WORKING_DIR_PARAM, workingDirs, s -> {
//            try {
            source.setWorkingDir(s);
//            } catch (IOException e) {
//                System.err.println(e.getLocalizedMessage());
//                e.printStackTrace();
//            }
        });

    }

    private void setSingleOption(final String option, final Collection<String> possibles,
                                 Consumer<String> setter) {
        switch (possibles.size()) {
            case 0: {
                System.err
                        .println("Option '" + option + " requires a single value must be supplied");
                break;
            }
            case 1: {
                Optional<String> first = uniqueDir(possibles);
                setter.accept(first.get());
                break;
            }
            default: {
                System.err.println(
                        "If " + option + " is specified, it must be a single value not " + possibles
                                .size());
            }
        }
    }

    private void generateOutputDir(final Collection<String> outputs) {
        setSingleOption(OUTPUT_DIR_PARAM, outputs, s -> {
            try {
                source.setOutputDir(s);
            } catch (IOException e) {
                System.err.println(e.getLocalizedMessage());
                e.printStackTrace();
            }
        });
    }

    public ISource getSource() {
        return source;
    }

//    public String[] getFixerArgs() throws IOException {
//        ArrayList<String> argList = new ArrayList<>();
//        argList.add("-i");
//        argList.addAll(source.getInputFiles().stream()
//                .map(f->f.getPath())
//                .collect(Collectors.toList())
//        );
//        argList.add("-o");
//        argList.add(source.getFixedDir().toFile().getCanonicalPath());
////        if(source.getWorkingDir()!=null){
////            argList.add("-w");
////            argList.add(source.getWorkingDir().toFile().getCanonicalPath());
////        }
//        return argList.stream().collect(Collectors.joining(" ")).split(" ");
//    }
//
//    public String[] getConverterArgs() throws IOException {
//        ArrayList<String> argList = new ArrayList<>();
//        argList.add("-i");
//        argList.add(source.getFixedDir().toFile().getCanonicalPath());
//        argList.add("-o");
//        argList.add(source.getOutputDir());
////        if(source.getWorkingDir()!=null){
////            argList.add("-w");
////            argList.add(source.getWorkingDir().toFile().getCanonicalPath());
////        }
//        return argList.stream().collect(Collectors.joining(" ")).split(" ");
//    }
//
//    public String[] getValidatorArgs() throws IOException {
//        ArrayList<String> argList = new ArrayList<>();
//        argList.add("-i");
//        argList.add(source.getOutputDir());
////        if(source.getWorkingDir()!=null){
////            argList.add("-w");
////            argList.add(source.getWorkingDir().toFile().getCanonicalPath());
////        }
//        return argList.stream().collect(Collectors.joining(" ")).split(" ");
//    }
}
