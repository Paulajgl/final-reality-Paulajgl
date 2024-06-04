package weaponry
/**
 * A class representing a Bow.
 *
 * The Bow is defined by its name, attack points, weight, and owner.
 *
 * @param name         The name of the Bow.
 * @param attackPoints The attack points of the Bow.
 * @param weight       The weight of the Bow, which determines the speed of the character wielding it.
 * @param owner        The owner of the Bow.
 * @constructor Creates a new Bow with the specified parameters.
 * @example
 * {{{
 * val bow = new Bow("Longbow", 40, 10, Some(character))
 * }}}
 * @author
 * @since 1.0.0
 * @version 1.0.0
 */
class Bow extends AbstractWeapon {
  val name = "Bow"
  val attackPoints = 40
  val weight = 10

  /**
   * Equips the Bow to the specified character.
   *
   * @param character The character to equip the Bow to.
   * @throws UnsupportedOperationException If the Bow is already equipped by another character.
   */
  override def equip(character: charactersp.Character): Unit = {
    if (!isEquipped) {
      character.equipBow(this)
      isEquipped = true
      owner = Some(character)
    } else {
      throw new UnsupportedOperationException("This weapon is already equipped by another character.")
    }
  }

  /**
   * Performs the specific actions needed to unequip this Bow from the specified character.
   *
   * @param character The character from which the Bow is being unequipped.
   */
  override protected def specificUnequip(character: charactersp.Character): Unit = {
    character.unequipBow(this)
  }
}