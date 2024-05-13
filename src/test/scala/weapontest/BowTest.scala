package weapontest

import weaponry.Bow

class BowTest extends munit.FunSuite {
  test ("Bow is a Weapon"){
    val bow = new Bow()
    assertEquals("Bow", bow.name)
    assertEquals(40, bow.attackPoints)
    assertEquals(10, bow.weight)
    assertEquals(List("Warrior","Ninja", "WhiteMage"), bow.owner)
  }

}
