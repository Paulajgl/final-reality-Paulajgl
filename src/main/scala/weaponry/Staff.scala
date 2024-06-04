package weaponry
/**
 * A class representing a Staff.
 *
 * The Staff is defined by its name, attack points, magic attack points, weight, and owner.
 *
 * @param name              The name of the Staff.
 * @param magicAttackPoints The magic attack points of the Staff.
 * @param weight            The weight of the Staff, which determines the speed of the character wielding it.
 * @param owner             The owner of the Staff.
 * @constructor Creates a new Staff with the specified parameters.
 * @example
 * {{{
 * val staff = new Staff("Wizard Staff", 10, 30, 15, Some(character))
 * }}}
 * @author
 * @since 1.0.0
 * @version 1.0.0
 */
class Staff extends AbstractMagicalWeapon {
  val name = "Staff"
  val attackPoints = 10
  val magicAttackPoints = 30
  val weight = 15

  /**
   * Equips the Staff to the specified character.
   *
   * @param character The character to equip the Staff to.
   * @throws UnsupportedOperationException If the Staff is already equipped by another character.
   */
  override def equip(character: charactersp.Character): Unit = {
    if (!isEquipped) {
      character.equipStaff(this)
      isEquipped = true
      owner = Some(character)
    } else {
      throw new UnsupportedOperationException("This weapon is already equipped by another character.")
    }
  }

  /**
   * Performs the specific actions needed to unequip this Staff from the specified character.
   *
   * @param character The character from which the Staff is being unequipped.
   */
  override protected def specificUnequip(character: charactersp.Character): Unit = {
    character.unequipStaff(this)
  }
}