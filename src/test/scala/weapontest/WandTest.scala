package weapontest

import weaponry.Bow

class WandTest extends munit.FunSuite {
  test("Wand ia a Weapon"){
    val wand = new Wand()
    assertEquals("Wand",wand.name)
    assertEquals(40,wand.attackPoints)
    assertEquals(10, wand.weight)
    assertEquals(List("Warrior", "Ninja", "WhiteMage"), bow.owner)
  }

}
