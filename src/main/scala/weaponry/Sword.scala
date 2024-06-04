package weaponry

/**
 * A class representing a Sword.
 *
 * The Sword is defined by its name, attack points, weight, and owner.
 *
 * @param name              The name of the Sword.
 * @param attackPoints      The attack points of the Sword.
 * @param weight            The weight of the Sword, which determines the speed of the character wielding it.
 * @param owner             The owner of the Sword.
 * @constructor Creates a new Sword with the specified parameters.
 * @example
 * {{{
 * val sword = new Sword("Broad Sword", 30, 10, Some(character))
 * }}}
 * @author
 * @since 1.0.0
 * @version 1.0.0
 */
class Sword extends AbstractWeapon {
  val name = "Sword"
  val attackPoints = 30
  val weight = 10

  /**
   * Equips the Sword to the specified character.
   *
   * @param character The character to equip the Sword to.
   * @throws UnsupportedOperationException If the Sword is already equipped by another character.
   */
  override def equip(character: charactersp.Character): Unit = {
    if (!isEquipped) {
      character.equipSword(this)
      isEquipped = true
      owner = Some(character)
    } else {
      throw new UnsupportedOperationException("This weapon is already equipped by another character.")
    }
  }

  /**
   * Performs the specific actions needed to unequip this Sword from the specified character.
   *
   * @param character The character from which the Sword is being unequipped.
   */
  override protected def specificUnequip(character: charactersp.Character): Unit = {
    character.unequipSword(this)
  }
}