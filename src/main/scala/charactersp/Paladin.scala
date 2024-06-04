package charactersp

import weaponry.{Axe, Bow, Staff, Sword, Wand, Weapon}

/**
 * A class representing a Paladin.
 *
 * The Paladin is defined by a name and extends Character, live points, defending, and weight.
 *
 * @param name The name of the Paladin.
 * @param livePointsMax The maximum live points of the Paladin.
 * @param defending The defense points of the Paladin.
 * @param weight The weight of the Paladin, determining their speed and turn order.
 * @param livePoints The current live points of the Paladin.
 * @constructor Creates a new Paladin with the specified attributes.
 * @example
 * {{{
 * val paladin = new Paladin(name = "Arthur", livePointsMax = 60, defending = 20, weight = 10, livePoints = 60)
 * paladin.equipAxe(new Axe("Battle Axe", 30, 10))
 * paladin.attack(enemy, 50)
 * }}}
 * @since 1.0.0
 * @version 1.0.0
 */
class Paladin(
               val name: String = "Paladin",
               val livePointsMax: Int = 60,
               val defending: Int = 20,
               val weight: Int = 10,
               var livePoints: Int = 60
             ) extends AbstractCharacter {

  /**
   * Equips an axe to the Paladin.
   * @param axe The axe to equip.
   */
  override def equipAxe(axe: Axe): Unit = {
    this.weapon = Some(axe)
    println(s"$name equips ${axe.name}")
  }

  /**
   * Unequips an axe from the Paladin.
   * @param axe The axe to unequip.
   */
  override def unequipAxe(axe: Axe): Unit = {
    this.weapon = None
    println(s"$name unequips ${axe.name}")
  }

  /**
   * Throws an UnsupportedOperationException, as Paladin cannot equip a bow.
   * @param bow The bow to equip.
   */
  override def equipBow(bow: Bow): Unit = {
    throw new UnsupportedOperationException(s"$name cannot equip a bow.")
  }

  /**
   * Throws an UnsupportedOperationException, as Paladin cannot equip a staff.
   * @param staff The staff to equip.
   */
  override def equipStaff(staff: Staff): Unit = {
    throw new UnsupportedOperationException(s"$name cannot equip a staff.")
  }

  /**
   * Equips a sword to the Paladin.
   * @param sword The sword to equip.
   */
  override def equipSword(sword: Sword): Unit = {
    this.weapon = Some(sword)
    println(s"$name equips ${sword.name}")
  }

  /**
   * Unequips a sword from the Paladin.
   * @param sword The sword to unequip.
   */
  override def unequipSword(sword: Sword): Unit = {
    this.weapon = None
    println(s"$name unequips ${sword.name}")
  }

  /**
   * Throws an UnsupportedOperationException, as Paladin cannot equip a wand.
   * @param wand The wand to equip.
   */
  override def equipWand(wand: Wand): Unit = {
    throw new UnsupportedOperationException(s"$name cannot equip a wand.")
  }
}
