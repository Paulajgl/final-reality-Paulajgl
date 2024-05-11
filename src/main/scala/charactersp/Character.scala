package charactersp

import party.Party
import weapons.Weapon

/**
 * A trait representing a character in a game or simulation.
 *
 * @param name        The name of the character.
 * @param livePoints  The current number of hit points/life points of the character.
 * @param defending   The defense value of the character.
 * @param weight      The weight of the character, which may affect various aspects of gameplay.
 */
trait  Character {
  val name: String
  val livePoints: Int
  val defending: Int
  val weight: Int
  var weapon: Option[weapons.Weapon] = None


}