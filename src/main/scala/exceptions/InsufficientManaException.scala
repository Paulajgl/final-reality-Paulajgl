package exceptions
/**
 * An exception thrown to indicate that a character does not have sufficient mana to perform an action.
 *
 * This exception is typically thrown when a character attempts to use a magical ability but lacks the required mana.
 *
 * @param message The error message describing the exception.
 * @constructor Creates a new `InsufficientManaException` with the specified error message.
 * @example
 * {{{
 * throw new InsufficientManaException("Not enough mana to cast spell")
 * }}}
 * @author
 * @since 1.0.0
 * @version 1.0.0
 */
class InsufficientManaException (message: String) extends Exception(message)