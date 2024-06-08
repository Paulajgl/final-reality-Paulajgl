package party

import charactersp.MagicalCharacter
import exceptions.IllegalAmountException

import scala.collection.mutable.ArrayBuffer

/**
 * Represents a party of characters in a game.
 *
 * @constructor Create a new Party instance with a given name.
 * @param name The name of the party.
 */
class Party(val name: String) {

  val players: ArrayBuffer[charactersp.Character] = new ArrayBuffer[charactersp.Character]()

  /**
   * Method to add a new member to the party.
   *
   * @param member The character to add to the party.
   */
  def addNewMember(member: charactersp.Character): Unit = {
    if (players.size >= 3) {
      throw new IllegalAmountException("Cannot add more than 3 members to the party.")
    } else {
      players.addOne(member)
    }
  }

  /**
   * Method to remove a member from the party.
   *
   * @param member The character to remove from the party.
   */
  def removeMember(member: charactersp.Character): Unit = {
    val index: Int = players.indexOf(member)
    if (index != -1)
      players.remove(index)
  }

  /**
   * Method to check if a member exists in the party.
   *
   * @param member The character to check for existence in the party.
   * @return True if the member exists in the party, false otherwise.
   */
  def contains(member: charactersp.Character): Boolean = {
    players.contains(member)
  }

  /**
   * Method to check if all players in the party are dead.
   *
   * @return True if all players in the party have zero live points, false otherwise.
   */
  def allPlayersDead: Boolean = {
    players.forall(_.livePoints == 0)
  }

}
