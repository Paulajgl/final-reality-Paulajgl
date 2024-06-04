package weaponry
/**
 * A class representing a Wand.
 *
 * The Wand is defined by its name, attack points, magic attack points, weight, and owner.
 *
 * @param name              The name of the Wand.
 * @param magicAttackPoints The magic attack points of the Wand.
 * @param weight            The weight of the Wand, which determines the speed of the character wielding it.
 * @param owner             The owner of the Wand.
 * @constructor Creates a new Wand with the specified parameters.
 * @example
 * {{{
 * val wand = new Wand("Magic Wand", 15, 40, 20, Some(character))
 * }}}
 * @author
 * @since 1.0.0
 * @version 1.0.0
 */
class Wand extends AbstractMagicalWeapon {
  val name = "Wand"
  val attackPoints = 15
  val magicAttackPoints = 40
  val weight = 20

  /**
   * Equips the Wand to the specified character.
   *
   * @param character The character to equip the Wand to.
   * @throws UnsupportedOperationException If the Wand is already equipped by another character.
   */
  override def equip(character: charactersp.Character): Unit = {
    if (!isEquipped) {
      character.equipWand(this)
      isEquipped = true
      owner = Some(character)
    } else {
      throw new UnsupportedOperationException("This weapon is already equipped by another character.")
    }
  }

  /**
   * Performs the specific actions needed to unequip this Wand from the specified character.
   *
   * @param character The character from which the Wand is being unequipped.
   */
  override protected def specificUnequip(character: charactersp.Character): Unit = {
    character.unequipWand(this)
  }
}
