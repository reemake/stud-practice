package exception;

/**
 * Exception that throwing when filename parameter wasn't specified.
 */
public class FilenameNotSpecifiedException extends Exception {
    /**
     * @param message The error message.
     */
    public FilenameNotSpecifiedException(final String message) {
        super(message);
    }
}
