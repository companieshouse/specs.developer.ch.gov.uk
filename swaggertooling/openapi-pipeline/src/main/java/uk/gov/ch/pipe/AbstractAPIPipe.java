package uk.gov.ch.pipe;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.gov.ch.args.ISource;

public abstract class AbstractAPIPipe {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractAPIPipe.class);

    private ISource args;
    private AbstractAPIPipe next;
    private boolean abort = false;
    private String inputName;

    public void setSource(ISource args) {
        this.args = args;
        if (this.next != null) {
            this.next.setSource(args);
        }
    }

    public ISource getArgs() {
        return this.args;
    }

    public void setInputFileName(String name) {
        this.inputName = name;
        if (this.next != null) {
            this.next.setInputFileName(name);
        }
    }

    public void pipe() {
        handle();
        if (abort) {
            handleAbort();
        } else {
            Optional.ofNullable(next).ifPresent(AbstractAPIPipe::pipe);
        }
    }

    protected void abort() {
        this.abort = true;
    }

    void handleAbort() {
        LOGGER.error("Aborted pipeline on " + getInputName());
    }

    protected abstract void handle();

    String getInputName() {
        return inputName;
    }

    public AbstractAPIPipe getNext() {
        return this.next;
    }

    public AbstractAPIPipe setNext(AbstractAPIPipe next) {
        assert (next != this);
        if (this.next != null) {
            next.setNext(this.next);
        }
        this.next = next;
        return next;
    }

    public void setAbort(boolean b) {
        this.abort = b;
    }

}
