package charactersp

import enemy.{Enemy, UEnemy}
import gamecontroller.observer.ObserverAttack
import weaponry.{Axe, Bow, Staff, Sword, UnitWeapon, Wand, Weapon}

import scala.collection.mutable.ArrayBuffer

/**
 * AbstractGameUnit is an abstract class that represents a basic game unit in the game.
 * This class serves as a template for various types of game units, defining common properties
 * and behaviors they must have. Specific types of game units should extend this class and
 * provide concrete implementations for the abstract methods.
 */
abstract class AbstractGameUnit extends GameUnit {
  /**
   * The name of the game unit.
   */
  val name: String

  /**
   * The maximum amount of live points the game unit can have.
   */
  val livePointsMax: Int

  /**
   * The defense points of the game unit, used to reduce incoming damage.
   */
  val defending: Int

  /**
   * The weight of the game unit, which might affect various gameplay mechanics.
   */
  val weight: Int

  /**
   * The current amount of live points the game unit has.
   */
  var livePoints: Int

  /**
   * The currently equipped weapon of the game unit, if any.
   */
  var weapon: Option[UnitWeapon] = None

  private var attackObs = ArrayBuffer.empty[ObserverAttack]
  /**
   * Checks if the game unit is alive.
   * @return true if the game unit has more than 0 live points, false otherwise.
   */
  def isAlive: Boolean = livePoints > 0

  /**
   * Attacks the specified defender game unit with the given attack damage.
   * This method should be implemented by subclasses to define the specific attack behavior.
   * @param defender The game unit being attacked.
   * @param attackDamage The amount of attack damage to be dealt.
   */
  def attack(defender: GameUnit, attackDamage: Int): Unit

  /**
   * Receives damage and reduces the game unit's live points accordingly.
   * This method should be implemented by subclasses to define how damage is processed.
   * @param damage The amount of damage to be received.
   */
  def receiveDamage(defender: GameUnit,damage: Int): Int

  /**
   * Attempts to equip an Axe to the game unit.
   * Throws an UnsupportedOperationException if the game unit cannot equip an Axe.
   * @param axe The Axe to be equipped.
   */
  def equipAxe(axe: Axe): Unit = {
    throw new UnsupportedOperationException(s"$name cannot equip an axe.")
  }

  /**
   * Attempts to unequip an Axe from the game unit.
   * Throws an UnsupportedOperationException if the game unit cannot unequip an Axe.
   * @param axe The Axe to be unequipped.
   */
  def unequipAxe(axe: Axe): Unit = {
    throw new UnsupportedOperationException(s"$name cannot unequip an axe.")
  }

  /**
   * Attempts to equip a Bow to the game unit.
   * Throws an UnsupportedOperationException if the game unit cannot equip a Bow.
   * @param bow The Bow to be equipped.
   */
  def equipBow(bow: Bow): Unit = {
    throw new UnsupportedOperationException(s"$name cannot equip a bow.")
  }

  /**
   * Attempts to unequip a Bow from the game unit.
   * Throws an UnsupportedOperationException if the game unit cannot unequip a Bow.
   * @param bow The Bow to be unequipped.
   */
  def unequipBow(bow: Bow): Unit = {
    throw new UnsupportedOperationException(s"$name cannot unequip a bow.")
  }

  /**
   * Attempts to equip a Staff to the game unit.
   * Throws an UnsupportedOperationException if the game unit cannot equip a Staff.
   * @param staff The Staff to be equipped.
   */
  def equipStaff(staff: Staff): Unit = {
    throw new UnsupportedOperationException(s"$name cannot equip a staff.")
  }

  /**
   * Attempts to unequip a Staff from the game unit.
   * Throws an UnsupportedOperationException if the game unit cannot unequip a Staff.
   * @param staff The Staff to be unequipped.
   */
  def unequipStaff(staff: Staff): Unit = {
    throw new UnsupportedOperationException(s"$name cannot unequip a staff.")
  }

  /**
   * Attempts to equip a Sword to the game unit.
   * Throws an UnsupportedOperationException if the game unit cannot equip a Sword.
   * @param sword The Sword to be equipped.
   */
  def equipSword(sword: Sword): Unit = {
    throw new UnsupportedOperationException(s"$name cannot equip a sword.")
  }

  /**
   * Attempts to unequip a Sword from the game unit.
   * Throws an UnsupportedOperationException if the game unit cannot unequip a Sword.
   * @param sword The Sword to be unequipped.
   */
  def unequipSword(sword: Sword): Unit = {
    throw new UnsupportedOperationException(s"$name cannot unequip a sword.")
  }

  /**
   * Attempts to equip a Wand to the game unit.
   * Throws an UnsupportedOperationException if the game unit cannot equip a Wand.
   * @param wand The Wand to be equipped.
   */
  def equipWand(wand: Wand): Unit = {
    throw new UnsupportedOperationException(s"$name cannot equip a wand.")
  }

  /**
   * Attempts to unequip a Wand from the game unit.
   * Throws an UnsupportedOperationException if the game unit cannot unequip a Wand.
   * @param wand The Wand to be unequipped.
   */
  def unequipWand(wand: Wand): Unit = {
    throw new UnsupportedOperationException(s"$name cannot unequip a wand.")
  }
  /**
   * Registers an observer for attack events.
   *
   * This method adds the specified observer to the list of attack observers. These observers
   * will be notified of attack events.
   *
   * @param obs The observer to register.
   */
  def registerAttackObserver(obs: ObserverAttack): Unit = {
    attackObs += obs
  }

  /**
   * Checks if the character is currently active.
   *
   * @return Always returns false. Subclasses may override this behavior to provide actual status.
   */
  def isActive(): Boolean = false

}