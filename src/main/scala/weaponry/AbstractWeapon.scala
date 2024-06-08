package weaponry

import charactersp.{Character, GameUnit}

/**
 * An abstract class representing a generic weapon.
 * Extends the Weapon trait.
 */
abstract class AbstractWeapon extends Weapon {

  /**
   * Equips this weapon to the specified character.
   *
   * @param character The character to equip the weapon to.
   */
  override def equip(character: charactersp.Character): Unit

  /**
   * Unequips this weapon from the specified character.
   *
   * @param character The character to unequip the weapon from.
   * @throws UnsupportedOperationException If the weapon is not currently equipped by the specified character.
   */
  override def unequip(character: Character): Unit = {
    if (isEquipped && owner.contains(character)) {
      specificUnequip(character)
      isEquipped = false
      owner = None
    } else {
      throw new UnsupportedOperationException(s"$name is not currently equipped by this character.")
    }
  }

}
