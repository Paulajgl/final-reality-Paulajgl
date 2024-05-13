package weapontest

import weaponry.Bow

class WandTest extends munit.FunSuite {
  test("Wand ia a Weapon"){
    val wand = new Wand()
    assertEquals("Wand",wand.name)
    assertEquals(15,wand.attackPoints)
    assertEquals(20, wand.weight)
    assertEquals(List("Ninja", "BlackMage", "WhiteMage"), bow.owner)
  }

}
