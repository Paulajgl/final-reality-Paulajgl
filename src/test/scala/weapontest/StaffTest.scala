package weapontest

import weaponry.{Staff, Weapon}

class StaffTest extends munit.FunSuite {
  test ("Staff is a MagicWeapon"){
    val staff = new Staff()
    assertEquals("Staff", staff.name)
    assertEquals(30,staff.magicAttackPoints)
    assertEquals(15, staff.weight)
    assertEquals(List("BlackMage","WhiteMage"), staff.owner)
  }


}
