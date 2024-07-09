package charactersp

import weaponry.{Axe, Bow, Staff, Sword, Wand, Weapon}

/**
 * A class representing a Ninja.
 *
 * The Ninja is defined by a name and extends Character, live points, defending, and weight.
 *
 * @param name The name of the Ninja.
 * @param livePointsMax The maximum live points of the Ninja.
 * @param defending The defense points of the Ninja.
 * @param weight The weight of the Ninja, determining their speed and turn order.
 * @param livePoints The current live points of the Ninja.
 * @constructor Creates a new Ninja with the specified attributes.
 * @example
 * {{{
 * val ninja = new Ninja(name = "Hanzo", livePointsMax = 100, defending = 30, weight = 25, livePoints = 100)
 * ninja.equipSword(new Sword("Katana", 40, 5))
 * ninja.attack(enemy, 50)
 * }}}
 * @since 1.0.0
 * @version 1.0.0
 */
class Ninja(
             val name: String = "Ninja",
             val livePointsMax: Int = 80,
             val defending: Int = 30,
             val weight: Int = 25,
             var livePoints: Int = 80
           ) extends AbstractCharacter {




  /**
   * Throws an UnsupportedOperationException, as Ninja cannot equip an axe.
   * @param axe The axe to equip.
   */
  override def equipAxe(axe: Axe): Unit = {
    throw new UnsupportedOperationException(s"$name cannot equip an axe.")
  }

  /**
   * Equips a bow to the Ninja.
   * @param bow The bow to equip.
   */
  override def equipBow(bow: Bow): Unit = {
    this.weapon = Some(bow)
  }

  /**
   * Unequips a bow from the Ninja.
   * @param bow The bow to unequip.
   */
  override def unequipBow(bow: Bow): Unit = {
    this.weapon = None
  }

  /**
   * Throws an UnsupportedOperationException, as Ninja cannot equip a staff.
   * @param staff The staff to equip.
   */
  override def equipStaff(staff: Staff): Unit = {
    throw new UnsupportedOperationException(s"$name cannot equip a staff.")
  }

  /**
   * Equips a sword to the Ninja.
   * @param sword The sword to equip.
   */
  override def equipSword(sword: Sword): Unit = {
    this.weapon = Some(sword)
  }

  /**
   * Unequips a sword from the Ninja.
   * @param sword The sword to unequip.
   */
  override def unequipSword(sword: Sword): Unit = {
    this.weapon = None
  }

  /**
   * Equips a wand to the Ninja.
   * @param wand The wand to equip.
   */
  override def equipWand(wand: Wand): Unit = {
    this.weapon = Some(wand)

  }

  /**
   * Unequips a wand from the Ninja.
   * @param wand The wand to unequip.
   */
  override def unequipWand(wand: Wand): Unit = {
    this.weapon = None
  }
}