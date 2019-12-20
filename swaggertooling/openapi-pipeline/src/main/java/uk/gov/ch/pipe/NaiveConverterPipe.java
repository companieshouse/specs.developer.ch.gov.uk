package uk.gov.ch.pipe;

import uk.gov.ch.AbstractAPIPipe;
import uk.gov.ch.swagger.VersionConverter;

public class NaiveConverterPipe extends AbstractAPIPipe {
    void convert(String... args) throws Exception {
        VersionConverter.main(args);
    }

    @Override
    protected void handle() {
        try {
            convert(getArgs().getArgs("-i:t1", "-o:t2"));
        } catch (Exception e) {
            e.printStackTrace();
            abort();
        }
    }
}
