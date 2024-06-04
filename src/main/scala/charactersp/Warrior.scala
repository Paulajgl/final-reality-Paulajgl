package charactersp

import weaponry.{Axe, Bow, Staff, Sword, Wand, Weapon}

/**
 * A class representing a Warrior.
 *
 * The Warrior is defined by a name and extends Character, live points, defending, and weight.
 *
 * @param name The name of the Warrior.
 * @param livePointsMax The maximum live points of the Warrior.
 * @param defending The defense points of the Warrior.
 * @param weight The weight of the Warrior, determining their speed and turn order.
 * @param livePoints The current live points of the Warrior.
 * @constructor Creates a new Warrior with the specified attributes.
 * @example
 * {{{
 * val warrior = new Warrior(name = "Conan", livePointsMax = 80, defending = 25, weight = 20, livePoints = 80)
 * warrior.equipAxe(new Axe("Battle Axe", 30, 10))
 * warrior.attack(enemy, 50)
 * }}}
 * @since 1.0.0
 * @version 1.0.0
 */
class Warrior(
               val name: String = "Warrior",
               val livePointsMax: Int = 80,
               val defending: Int = 25,
               val weight: Int = 20,
               var livePoints: Int = 80
             ) extends AbstractCharacter {

  /**
   * Equips an axe to the Warrior.
   * @param axe The axe to equip.
   */
  override def equipAxe(axe: Axe): Unit = {
    this.weapon = Some(axe)
    println(s"$name equips ${axe.name}")
  }

  /**
   * Unequips an axe from the Warrior.
   * @param axe The axe to unequip.
   */
  override def unequipAxe(axe: Axe): Unit = {
    this.weapon = None
    println(s"$name unequips ${axe.name}")
  }

  /**
   * Equips a bow to the Warrior.
   * @param bow The bow to equip.
   */
  override def equipBow(bow: Bow): Unit = {
    this.weapon = Some(bow)
    println(s"$name equips ${bow.name}")
  }

  /**
   * Unequips a bow from the Warrior.
   * @param bow The bow to unequip.
   */
  override def unequipBow(bow: Bow): Unit = {
    this.weapon = None
    println(s"$name unequips ${bow.name}")
  }

  /**
   * Throws an UnsupportedOperationException, as Warrior cannot equip a staff.
   * @param staff The staff to equip.
   */
  override def equipStaff(staff: Staff): Unit = {
    throw new UnsupportedOperationException(s"$name cannot equip a staff.")
  }

  /**
   * Equips a sword to the Warrior.
   * @param sword The sword to equip.
   */
  override def equipSword(sword: Sword): Unit = {
    this.weapon = Some(sword)
    println(s"$name equips ${sword.name}")
  }

  /**
   * Unequips a sword from the Warrior.
   * @param sword The sword to unequip.
   */
  override def unequipSword(sword: Sword): Unit = {
    this.weapon = None
    println(s"$name unequips ${sword.name}")
  }

  /**
   * Throws an UnsupportedOperationException, as Warrior cannot equip a wand.
   * @param wand The wand to equip.
   */
  override def equipWand(wand: Wand): Unit = {
    throw new UnsupportedOperationException(s"$name cannot equip a wand.")
  }
}


