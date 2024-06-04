package exceptions

/**
 * An exception thrown when an illegal amount is encountered.
 *
 * This exception is typically thrown when an operation receives an amount that is not valid.
 *
 * @param message The error message describing the exception.
 * @constructor Creates a new IllegalAmountException with the specified error message.
 * @example
 * {{{
 * throw new IllegalAmountException("Amount must be positive")
 * }}}
 * @author
 * @since 1.0.0
 * @version 1.0.0
 */
class IllegalAmountException(message: String) extends Exception(message)