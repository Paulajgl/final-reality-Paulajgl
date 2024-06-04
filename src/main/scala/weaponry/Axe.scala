package weaponry

import charactersp.GameUnit

/**
 * A class representing an Axe.
 *
 * The Axe is defined by its name, attack points, weight, and owner.
 *
 * @param name         The name of the Axe.
 * @param attackPoints The attack points of the Axe.
 * @param weight       The weight of the Axe, which determines the speed of the character wielding it.
 * @param owner        The owner of the Axe.
 * @constructor Creates a new Axe with the specified parameters.
 * @example
 * {{{
 * val axe = new Axe("Battle Axe", 20, 10, Some(character))
 * }}}
 * @author
 * @since 1.0.0
 * @version 1.0.0
 */
class Axe extends AbstractWeapon {
  val name = "Axe"
  val attackPoints = 20
  val weight = 10

  /**
   * Equips the Axe to the specified character.
   *
   * @param character The character to equip the Axe to.
   * @throws UnsupportedOperationException If the Axe is already equipped by another character.
   */
  override def equip(character: charactersp.Character): Unit = {
    if (!isEquipped) {
      character.equipAxe(this)
      isEquipped = true
      owner = Some(character)
    } else {
      throw new UnsupportedOperationException("This weapon is already equipped by another character.")
    }
  }

  /**
   * Performs the specific actions needed to unequip this Axe from the specified character.
   *
   * @param character The character from which the Axe is being unequipped.
   */
  override protected def specificUnequip(character: charactersp.Character): Unit = {
    character.unequipAxe(this)
  }
}