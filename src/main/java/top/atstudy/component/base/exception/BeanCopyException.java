package top.atstudy.component.base.exception;

public class BeanCopyException extends RuntimeException {

    private static final long serialVersionUID = -1109101399703220536L;

    public BeanCopyException(Exception e) {
        super(e);
    }

}
