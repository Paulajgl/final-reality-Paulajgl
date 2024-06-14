package charactersp

import spell.{AbstractSpellBlack, AbstractSpellWhite}
import weaponry.{Axe, Bow, Staff, Sword, Wand, Weapon}

/**
 * A class representing a WhiteMage.
 *
 * The WhiteMage is defined by a name and extends Character, live points, defending, weight, and mana points.
 *
 * @param name The name of the WhiteMage.
 * @param livePointsMax The maximum live points of the WhiteMage.
 * @param defending The defending points of the WhiteMage.
 * @param weight The weight of the WhiteMage, determining their speed and turn order.
 * @param manaPointsMax The maximum mana points of the WhiteMage.
 * @param livePoints The current live points of the WhiteMage.
 * @param manaPoints The current mana points of the WhiteMage.
 * @constructor Creates a new WhiteMage with the specified attributes.
 * @example
 * {{{
 * val whiteMage = new WhiteMage(name = "Gandalf", livePointsMax = 90, defending = 50, weight = 40, manaPointsMax = 30, livePoints = 90, manaPoints = 30)
 * whiteMage.equipStaff(new Staff("Healing Staff", 10, 5))
 * whiteMage.castSpell(enemy, "Healing", 20)
 * }}}
 * @since 1.0.0
 * @version 1.0.0
 */
class WhiteMage(
                 val name: String = "WhiteMage",
                 val livePointsMax: Int = 90,
                 val defending: Int = 50,
                 val weight: Int = 40,
                 val manaPointsMax: Int = 30,
                 var livePoints: Int = 90,
                 var manaPoints: Int = 30
               ) extends AbstractMagicalCharacter {

  /**
   * Throws an UnsupportedOperationException, as WhiteMage cannot equip an axe.
   * @param axe The axe to equip.
   */
  override def equipAxe(axe: Axe): Unit = {
    throw new UnsupportedOperationException(s"$name cannot equip an axe.")
  }

  /**
   * Equips a bow to the WhiteMage.
   * @param bow The bow to equip.
   */
  override def equipBow(bow: Bow): Unit = {
    this.weapon = Some(bow)
  }

  /**
   * Unequips a bow from the WhiteMage.
   * @param bow The bow to unequip.
   */
  override def unequipBow(bow: Bow): Unit = {
    this.weapon = None
  }

  /**
   * Equips a staff to the WhiteMage.
   * @param staff The staff to equip.
   */
  override def equipStaff(staff: Staff): Unit = {
    this.weapon = Some(staff)
  }

  /**
   * Unequips a staff from the WhiteMage.
   * @param staff The staff to unequip.
   */
  override def unequipStaff(staff: Staff): Unit = {
    this.weapon = None
  }

  /**
   * Throws an UnsupportedOperationException, as WhiteMage cannot equip a sword.
   * @param sword The sword to equip.
   */
  override def equipSword(sword: Sword): Unit = {
    throw new UnsupportedOperationException(s"$name cannot equip a sword.")
  }

  /**
   * Equips a wand to the WhiteMage.
   * @param wand The wand to equip.
   */
  override def equipWand(wand: Wand): Unit = {
    this.weapon = Some(wand)
  }

  /**
   * Unequips a wand from the WhiteMage.
   * @param wand The wand to unequip.
   */
  override def unequipWand(wand: Wand): Unit = {
    this.weapon = None
  }
}
