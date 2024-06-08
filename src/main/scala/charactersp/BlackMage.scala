package charactersp

import spell.{AbstractSpellBlack, AbstractSpellWhite, Spell, SpellBlack, SpellWhite}
import weaponry.{AbstractWeapon, Axe, Bow, Staff, Sword, Wand, Weapon}

/**
 * A class representing a Black Mage.
 *
 * The Black Mage is defined by a name and extends Character, live points, defending, weight, and mana points.
 *
 * @param name The name of the Black Mage.
 * @param livePointsMax The maximum live points of the Black Mage.
 * @param defending The defense points of the Black Mage.
 * @param weight The weight of the Black Mage, determining their speed and turn order.
 * @param manaPointsMax The maximum mana points of the Black Mage, used for magical abilities.
 * @param manaPoints The current mana points of the Black Mage.
 * @param livePoints The current live points of the Black Mage.
 * @constructor Creates a new Black Mage with the specified attributes.
 * @example
 * {{{
 * val mage = new BlackMage(name = "Gandalf", livePointsMax = 100, defending = 50, weight = 40, manaPointsMax = 100, manaPoints = 100, livePoints = 100)
 * mage.equipStaff(new Staff("Mystic Staff", 30, 5))
 * mage.attack(enemy, 20)
 * }}}
 * @since 1.0.0
 * @version 1.0.0
 */
class BlackMage(
                 val name: String = "BlackMage",
                 val livePointsMax: Int = 80,
                 val defending: Int = 40,
                 val weight: Int = 50,
                 val manaPointsMax: Int = 30,
                 var manaPoints: Int = 30,
                 var livePoints: Int = 80
               ) extends AbstractMagicalCharacter {

  /**
   * Throws an UnsupportedOperationException, as Black Mage cannot equip an axe.
   * @param axe The axe to equip.
   */
  override def equipAxe(axe: Axe): Unit = {
    throw new UnsupportedOperationException(s"$name cannot equip an axe.")
  }

  /**
   * Throws an UnsupportedOperationException, as Black Mage cannot equip a bow.
   * @param bow The bow to equip.
   */
  override def equipBow(bow: Bow): Unit = {
    throw new UnsupportedOperationException(s"$name cannot equip a bow.")
  }

  /**
   * Equips a staff to the Black Mage.
   * @param staff The staff to equip.
   */
  override def equipStaff(staff: Staff): Unit = {
    this.weapon = Some(staff)
    println(s"$name equips ${staff.name}")
  }

  /**
   * Unequips a staff from the Black Mage.
   * @param staff The staff to unequip.
   */
  override def unequipStaff(staff: Staff): Unit = {
    this.weapon = None
    println(s"$name unequips ${staff.name}")
  }

  /**
   * Equips a sword to the Black Mage.
   * @param sword The sword to equip.
   */
  override def equipSword(sword: Sword): Unit = {
    this.weapon = Some(sword)
  }

  /**
   * Unequips a sword from the Black Mage.
   * @param sword The sword to unequip.
   */
  override def unequipSword(sword: Sword): Unit = {
    this.weapon = None
  }

  /**
   * Equips a wand to the Black Mage.
   * @param wand The wand to equip.
   */
  override def equipWand(wand: Wand): Unit = {
    this.weapon = Some(wand)
  }

  /**
   * Unequips a wand from the Black Mage.
   * @param wand The wand to unequip.
   */
  override def unequipWand(wand: Wand): Unit = {
    this.weapon = None
  }
}