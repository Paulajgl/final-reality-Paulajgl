package charactersp

import enemy.Enemy
import party.Party
import weaponry.{AbstractWeapon, Axe, Bow, Staff, Sword, UnitWeapon, Wand, Weapon}

import scala.collection.mutable

/**
 * AbstractCharacter is an abstract class that represents a basic character in the game.
 * This class provides common functionalities for characters, such as attacking and receiving damage.
 * Specific types of characters should extend this class and provide additional behaviors and properties.
 */
abstract class AbstractCharacter extends Character {
  /**
   * Performs an attack on a defender game unit with the specified attack damage.
   * The attack can only be performed if the defender is an Enemy and the character has a weapon equipped.
   * @param defender The game unit being attacked.
   * @param attackDamage The amount of attack damage to be dealt.
   * @throws UnsupportedOperationException if the character does not have a weapon equipped.
   * @throws IllegalArgumentException if the defender is not an Enemy.
   */
  def attack(defender: GameUnit, attackDamage: Int): Unit = {
    defender match {
      case defender: Enemy =>
        weapon match {
          case Some(_) =>
            val damage = (attackDamage - defender.defending) max 0 // Damage cannot be negative
            defender.receiveDamage(damage)
          case None =>
            throw new UnsupportedOperationException(s"$name cannot attack without a weapon.")
        }
      case _ =>
        throw new IllegalArgumentException("Defender must be an Character")
    }
  }

  /**
   * Receives damage and reduces the character's live points accordingly.
   * If the resulting live points are less than or equal to zero, the character is considered defeated.
   * @param damage The amount of damage to be received.
   */
  def receiveDamage(damage: Int): Unit = {
    livePoints = (livePoints - damage) max 0 // Live points cannot be negative
    if (!isAlive) println(s"$name has been defeated!")
  }
}