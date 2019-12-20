package uk.gov.ch;

import uk.gov.ch.args.ISource;

import java.io.IOException;
import java.util.Optional;

public abstract class AbstractAPIPipe {
    private ISource args;
    private AbstractAPIPipe next;
    private boolean abort = false;

    public void setSource(ISource args) {
        this.args = args;
        if (this.next != null)
            this.next.setSource(args);
    }

    public ISource getArgs() {
        return this.args;
    }

    public AbstractAPIPipe setNext(AbstractAPIPipe next) {
        if (this.next != null) {
            next.setNext(this.next);
        }
        this.next = next;
        return next;
    }

    protected void abort() {
        this.abort = true;
    }

    public void pipe() {
        handle();
        if (!abort)
            Optional.ofNullable(next).ifPresent(AbstractAPIPipe::pipe);
    }

    protected abstract void handle() ;

}
