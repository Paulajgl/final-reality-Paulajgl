package turnsheduler

import scala.collection.mutable
import turnsheduler.ActionBar

import scala.collection.mutable.ListBuffer

/**
 * Manages the turn scheduling and action bars for characters in a game.
 */
class TurnScheduler {

  // Variables to store action bars, character lists, and action bars in battle
  private var _actionbar: ActionBar = _
  private val _characterList: mutable.Map[charactersp.Character, ActionBar] = mutable.Map[charactersp.Character, ActionBar]()
  private val _characterListInBattle: mutable.Map[charactersp.Character, ActionBar] = mutable.Map[charactersp.Character, ActionBar]()
  private val _actionBarsInBattle: mutable.Set[ActionBar] = mutable.Set[ActionBar]()

  /**
   * Getter for the action bars in battle.
   *
   * @return The mutable set of action bars in battle.
   */
  def actionBarsInBattle: mutable.Set[ActionBar] = _actionBarsInBattle

  /**
   * Getter for the character list.
   *
   * @return The mutable map of characters to action bars.
   */
  def characterList: mutable.Map[charactersp.Character, ActionBar] = _characterList

  /**
   * Getter for the character list in battle.
   *
   * @return The mutable map of characters to action bars in battle.
   */
  def characterListInBattle: mutable.Map[charactersp.Character, ActionBar] = _characterListInBattle

  /**
   * Method to add a character and their action bar to the character list.
   *
   * @param characterName The character to add.
   * @param characterActionBar The action bar associated with the character.
   */
  def addCharacter(characterName: charactersp.Character, characterActionBar: ActionBar): Unit = {
    _characterList += (characterName -> characterActionBar)
  }

  /**
   * Method to add a character and their action bar to the character list in battle.
   *
   * @param characterName The character to add.
   * @param characterActionBar The action bar associated with the character.
   */
  def addCharacterInBattle(characterName: charactersp.Character, characterActionBar: ActionBar): Unit = {
    _characterListInBattle += (characterName -> characterActionBar)
  }

  /**
   * Method to remove a character from the character list.
   *
   * @param characterName The character to remove.
   */
  def removeCharacter(characterName: charactersp.Character): Unit = {
    _characterList -= characterName
  }

  /**
   * Method to calculate the maximum action bar values for all characters.
   *
   * @return A list of maximum action bar values.
   */
  def maxActionBar(): List[Double] = {
    val maxValues = ListBuffer[Double]()
    for ((_, actionBar) <- _characterList) {
      val maxValue = actionBar.actionBarCalculate
      maxValues += maxValue
    }
    maxValues.toList
  }

  /**
   * Method to add an action bar to the action bars in battle.
   *
   * @param actionBar The action bar to add.
   */
  def addActionBarToBattle(actionBar: ActionBar): Unit = {
    _actionBarsInBattle += actionBar
  }

  /**
   * Method to reset action bars to zero for a given character list.
   *
   * @param characterList The character list whose action bars need to be reset.
   */
  def resetActionBar(characterList: mutable.Map[charactersp.Character, ActionBar]): Unit = {
    for ((_, actionBar) <- characterList) {
      actionBar.setValue(0)
    }
  }

  /**
   * Method to increase the action bars in battle by a specified amount.
   *
   * @param amount The amount by which to increase the action bars.
   */
  def increaseActionBarInBattle(amount: Int): Unit = {
    for ((_, actionBar) <- _characterListInBattle) {
      actionBar.increaseValue(amount)
    }
  }

  /**
   * Method to check if the action bar of a specific character in battle is full.
   *
   * @param character The character to check.
   * @return True if the character's action bar is full, false otherwise.
   */
  def isActionBarFull(character: charactersp.Character): Boolean = {
    if (_characterListInBattle.contains(character)) {
      val actionBar = _characterListInBattle(character)
      actionBar.isFull
    } else {
      false
    }
  }

  /**
   * Method to get characters with full action bars in battle, sorted by action bar value (descending).
   *
   * @param characterListInBattle The character list in battle to check.
   * @return A list of characters with full action bars, sorted by action bar value (descending).
   */
  def getCharactersWithFullActionBar(characterListInBattle: mutable.Map[charactersp.Character, ActionBar]): List[charactersp.Character] = {
    val charactersWithFullActionBar = ListBuffer[charactersp.Character]()
    for ((character, actionBar) <- characterListInBattle) {
      if (actionBar.isFull) {
        charactersWithFullActionBar += character
      }
    }
    charactersWithFullActionBar.toList.sortBy(character => -characterListInBattle(character).value)
  }
}
