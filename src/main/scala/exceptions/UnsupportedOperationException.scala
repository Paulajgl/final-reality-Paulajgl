package exceptions
/**
 * An exception thrown to indicate that an operation is not supported.
 *
 * This exception is typically thrown when a method or operation is called that is not supported by the current implementation or context.
 *
 * @param message The error message describing the unsupported operation.
 * @constructor Creates a new `UnsupportedOperationException` with the specified error message.
 * @example
 * {{{
 * throw new UnsupportedOperationException("This operation is not supported")
 * }}}
 * @author
 * @since 1.0.0
 * @version 1.0.0
 */
class UnsupportedOperationException  (message: String) extends Exception(message)
