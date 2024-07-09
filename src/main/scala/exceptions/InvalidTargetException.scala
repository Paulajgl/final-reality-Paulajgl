package exceptions
/**
 * An exception thrown to indicate that the target of an action is invalid.
 *
 * This exception is typically thrown when a character attempts to perform an action on an invalid target.
 *
 * @param message The error message describing the exception.
 * @constructor Creates a new `InvalidTargetException` with the specified error message.
 * @example
 * {{{
 * throw new InvalidTargetException("Invalid target specified")
 * }}}
 * @author
 * @since 1.0.0
 * @version 1.0.0
 */
class InvalidTargetException  (message: String) extends Exception(message)