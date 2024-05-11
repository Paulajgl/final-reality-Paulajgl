package combatsystem
import party.Party

import scala.collection.mutable
/**
 * Class representing attacks in a game.
 *
 * @constructor Create a new Attack instance with empty attack damage, defense points, and weapons maps.
 */
class Attack {

  // Maps to store attack damage, defense points, and weapons for characters
  private val _attackDamage: mutable.Map[charactersp.Character, Int] = mutable.Map()
  private val _defensePoints: mutable.Map[charactersp.Character, Int] = mutable.Map()
  private val _weapons: mutable.Map[charactersp.Character, weapons.Weapon] = mutable.Map()

  /**
   * Getter for defense points map.
   *
   * @return Mutable map of characters to defense points.
   */
  def defensePoints: mutable.Map[charactersp.Character, Int] = _defensePoints

  /**
   * Getter for attack damage map.
   *
   * @return Mutable map of characters to attack damage.
   */
  def attackDamage: mutable.Map[charactersp.Character, Int] = _attackDamage

  /**
   * Getter for weapons map.
   *
   * @return Mutable map of characters to weapons.
   */
  def getWeapons: mutable.Map[charactersp.Character, weapons.Weapon] = _weapons

  /**
   * Method to calculate attack damage and apply it to a defender character.
   *
   * @param attacker The character initiating the attack.
   * @param defender The character being attacked.
   * @param party The party to which the attacker belongs.
   * @return Remaining health points of the defender after the attack.
   */
  def attack(attacker: charactersp.Character, defender: charactersp.Character, party: Party): Int = {
    if (party.contains(attacker)) {
      val damage = if (_weapons.contains(attacker)) {
        _attackDamage.getOrElse(attacker, 0) - _defensePoints.getOrElse(defender, 0)
      } else {
        0
      }
      if (damage <= 0) {
        0
      } else {
        val remainingHealth = defender.livePoints - damage
        if (remainingHealth < 0) 0 else remainingHealth
      }
    } else {
      0
    }
  }

  /**
   * Method to equip a weapon to a character.
   *
   * @param character The character to equip the weapon to.
   * @param weapon The weapon to be equipped.
   */
  def equipWeapon(character: charactersp.Character, weapon: weapons.Weapon): Unit = {
    _weapons(character) = weapon
  }
}