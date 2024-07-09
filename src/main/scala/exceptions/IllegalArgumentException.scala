package exceptions
/**
 * An exception thrown to
 indicate that a method has been passed an illegal or inappropriate argument.
 *

 This exception is typically thrown when a method receives an argument that is not valid according to its contract.
@param message The error message describing the exception.
@constructor Creates a new IllegalArgumentException with the specified error message.
@example
{{{
throw new IllegalArgumentException("Argument must be positive")
}}}
@author
@since 1.0.0
@version 1.0.0
 */
class IllegalArgumentException (message: String) extends Exception(message)
