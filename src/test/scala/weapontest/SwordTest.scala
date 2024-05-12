package weapontest

import weaponry.{MagicalWeapon, Sword}

class SwordTest extends munit.FunSuite {
  test("Sword is a  Weapon") {
    val sword = new Sword()
    assertEquals("Sword", sword.name)
    assertEquals(30, sword.attackPoints)
    assertEquals(10, sword.weight)
    assertEquals(List("Paladin", "Warrior", "Ninja", "BlackMage"), sword.owner)
  }
}