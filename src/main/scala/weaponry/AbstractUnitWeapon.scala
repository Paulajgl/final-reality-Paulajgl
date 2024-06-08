package weaponry

import charactersp.{Character, GameUnit}

/**
 * An abstract class representing a unit weapon.
 * Extends the UnitWeapon trait.
 */
abstract class AbstractUnitWeapon extends UnitWeapon {

  /**
   * The name of the weapon.
   */
  val name: String

  /**
   * The attack points provided by this weapon.
   */
  val attackPoints: Int

  /**
   * The weight of the weapon.
   */
  val weight: Int

  /**
   * Indicates whether the weapon is currently equipped.
   */
  var isEquipped: Boolean = false

  /**
   * The owner of the weapon, if any.
   */
  var owner: Option[Character] = None

  /**
   * Equips this weapon to the specified character.
   *
   * @param character The character to equip the weapon to.
   */
  def equip(character: charactersp.Character): Unit

  /**
   * Unequips this weapon from the specified character.
   *
   * @param character The character to unequip the weapon from.
   * @throws UnsupportedOperationException If the weapon is not currently equipped.
   */
  def unequip(character: charactersp.Character): Unit = {
    if (isEquipped) {
      specificUnequip(character)
      isEquipped = false
    } else {
      throw new UnsupportedOperationException(s"$name is not currently equipped.")
    }
  }

  /**
   * Performs the specific actions needed to unequip this weapon from the specified character.
   *
   * @param character The character from which the weapon is being unequipped.
   */
  protected def specificUnequip(character: charactersp.Character): Unit
}
