package weapontest

import charactersp.{BlackMage, Ninja, Warrior, WhiteMage}
import weaponry.{Staff, Wand, Weapon}

class StaffTest extends munit.FunSuite {
  test ("Staff is a MagicWeapon"){
    val staff = new Staff()
    val blackMage= new BlackMage()
    staff.setOwner(blackMage)
    assertEquals("Staff", staff.name)
    assertEquals(30,staff.magicAttackPoints)
    assertEquals(15, staff.weight)
    assertEquals(staff.owner,Some(blackMage))
  }
  test("setOwner does not assign the owner when the owner is not allowed") {
    val staff = new Staff()
    val blackMage = new BlackMage()
    assertEquals(staff.owner, None)

  }
  test("setOwner returns false if the weapon is already owned by another character") {
    val staff = new Staff()
    val blackMage = new BlackMage()
    val whiteMage = new WhiteMage()
    staff.setOwner(whiteMage)
    val result = staff.setOwner(blackMage)
    assertEquals(result, false)
    assertEquals(staff.owner, Some(whiteMage))
  }
  test ("setOwner return false If the character attempts to equip the weapon that is not allowed for him"){
    val staff = new Staff()
    val warrior = new Warrior()
    val result = staff.setOwner(warrior)
    assertEquals(result, false)
  }
}
