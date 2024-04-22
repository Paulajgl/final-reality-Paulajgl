package weapontest

import weapons.Axe

class AxeTest extends  munit.FunSuite {
  test ("Axe is a Weapon"){
    val axe = new Axe()
    assertEquals("Axe", axe.name)
    assertEquals(20, axe.attackPoints)
    assertEquals(10, axe.weight)
    assertEquals(List("Paladin", "Warrior"), axe.owner)
  }

}
