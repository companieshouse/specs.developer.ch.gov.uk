package uk.gov.ch.pipe;

import uk.gov.ch.AbstractAPIPipe;
import uk.gov.ch.tools.swagger.Fix1_2;

import java.io.IOException;

public class NaiveFixerPipe extends AbstractAPIPipe {

    void fix(String[] args) {
        Fix1_2.main(args);
    }

    @Override
    protected void handle() {
        try {
            fix(getArgs().getArgs("-i", "-o:t1"));
        } catch (IOException e) {
            e.printStackTrace();
            abort();
        }
    }
}
