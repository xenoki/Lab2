package exceptions;
/**
* This class represents an exception in the DAO configuration which cannot be resolved at runtime,
* such as a missing resource in the auto configuration file
*
*/
public class AutoFileException extends Exception {

    // Constants ----------------------------------------------------------------------------------

    private static final long serialVersionUID = 1L;

    // Constructors -------------------------------------------------------------------------------

    /**
    * Constructs a AutoFileException with the given detail message.
    * @param message The detail message of the AutoFileException.
    */
    public AutoFileException(String message) {
        super(message);
    }

    /**
    * Constructs a AutoFileException with the given root cause.
    * @param cause The root cause of the AutoFileException.
    */
    public AutoFileException(Throwable cause) {
        super(cause);
    }

    /**
    * Constructs a AutoFileException with the given detail message and root cause.
    * @param message The detail message of the AutoFileException.
    * @param cause The root cause of the AutoFileException.
    */
    public AutoFileException(String message, Throwable cause) {
        super(message, cause);
    }
}