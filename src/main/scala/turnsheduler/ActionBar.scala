package turnsheduler

/**
 * Represents an action bar used for turn scheduling in a game.
 *
 * @constructor Create a new ActionBar instance with given character and weapon weights.
 * @param characterWeight The weight assigned to the character's action.
 * @param weaponWeight The weight assigned to the weapon's action.
 */
class ActionBar(val characterWeight: Int, val weaponWeight: Int) {

  // Private variable to store the current value of the action bar
  private var _value: Int = 0

  /**
   * Getter for the current value of the action bar.
   *
   * @return The current value of the action bar.
   */
  def value: Int = _value

  /**
   * Setter for the value of the action bar.
   *
   * @param newValue The new value to set for the action bar.
   */
  def setValue(newValue: Int): Unit = {
    _value = newValue
  }

  /**
   * Method to increase the value of the action bar by a certain amount.
   *
   * @param amount The amount by which to increase the action bar value.
   */
  def increaseValue(amount: Int): Unit = {
    _value += amount
  }

  /**
   * Method to calculate the total value of the action bar based on character and weapon weights.
   *
   * @return The calculated total value of the action bar.
   */
  def actionBarCalculate: Int = (characterWeight + 0.5 * weaponWeight).toInt

  /**
   * Method to check if the action bar is full.
   *
   * @return True if the action bar is full, false otherwise.
   */
  def isFull: Boolean = value == (characterWeight + 0.5 * weaponWeight)
}