package uk.gov.ch.pipe;

import uk.gov.ch.AbstractAPIPipe;
import uk.gov.ch.args.ArgsPacker;
import uk.gov.ch.openapi.validator.OpenAPI3Validator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class ValidateAndRebasePipe extends AbstractAPIPipe {
    @Override
    protected void handle() {
        String[] filesToValidate;
        try {
            filesToValidate = getFilePathsForConvertedFiles();
        } catch (IOException e) {
            e.printStackTrace();
            abort();
            return;
        }
        System.out.println(Arrays.toString(filesToValidate));
        Stream.of(filesToValidate).forEach(f-> {
            try {
                validateAndMove(f);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    String[] getFilePathsForConvertedFiles() throws IOException {
        String[] filesToValidate;
        ArgsPacker ap = new ArgsPacker(getArgs().getArgs("-i:t2","-o"));
        filesToValidate = ap.getSource().getInputFiles().stream()
                .filter(f -> !f.isDirectory())
                .map(File::getPath)
                .toArray(String[]::new);
        return filesToValidate;
    }

    void validateAndMove(String filePath) throws IOException {
        int output = invokeValidator(filePath);
        File f = new File(filePath);
        if (!new File(getArgs().getOutputDir()).exists())
            new File(getArgs().getOutputDir()).mkdir();
        if(output!=1){
            if (!new File(getArgs().getOutputDir()+"/bad").exists())
                new File(getArgs().getOutputDir()+"/bad").mkdir();
            Files.move(
                    Paths.get(filePath),
                    Paths.get(getArgs().getOutputDir()+"/bad/"+f.getName())
            );
        } else {
            Files.move(
                    Paths.get(filePath),
                    Paths.get(getArgs().getOutputDir()+"/"+f.getName())
            );
        }
    }

    /**
     * Wrapper to allow testing of moves
     * @param filePath
     * @return
     */
    int invokeValidator(String filePath) {
        return OpenAPI3Validator.main("-i", filePath);
    }
}
