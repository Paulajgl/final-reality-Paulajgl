package weaponry

import charactersp.Character

/**
 * An abstract class representing a magical weapon that enhances magical attacks.
 * Extends the MagicalWeapon trait.
 */
abstract class AbstractMagicalWeapon extends MagicalWeapon {

  /**
   * The magic attack points provided by this magical weapon.
   */
  val magicAttackPoints: Int

  /**
   * Equips this magical weapon to the specified character.
   *
   * @param character The character to equip the weapon to.
   */
  override def equip(character: Character): Unit
}