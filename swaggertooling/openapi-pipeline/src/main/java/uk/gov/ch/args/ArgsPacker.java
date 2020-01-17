package uk.gov.ch.args;

import java.io.IOException;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArgsPacker {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArgsPacker.class);

    private final static String OUTPUT_DIR_PARAM = "-o";
    private static final String INPUT_DIR_PARAM = "-i";
    private static final String WORKING_DIR_PARAM = "-w";
    private final ISource source = new Source();

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
            LOGGER.error("", ex);
        }
        source.validateArgs();
    }

    private Optional<String> uniqueDir(Collection<String> dirs) {
        return dirs.stream().findFirst();
    }

    private void generateWorkingDir(final Collection<String> workingDirs) {
        setSingleOption(WORKING_DIR_PARAM, workingDirs, source::setWorkingDir);
    }

    private void setSingleOption(final String option, final Collection<String> possibles,
            Consumer<String> setter) {
        switch (possibles.size()) {
            case 0: {
                LOGGER.error("Option '" + option + " requires a single value must be supplied");
                break;
            }
            case 1: {
                Optional<String> first = uniqueDir(possibles);
                setter.accept(first.get());
                break;
            }
            default: {
                LOGGER.error(
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
                LOGGER.error(e.getLocalizedMessage(), e);
            }
        });
    }

    public ISource getSource() {
        return source;
    }
}
