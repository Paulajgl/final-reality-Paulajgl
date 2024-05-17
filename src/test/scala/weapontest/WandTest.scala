package weapontest

import weaponry.{Bow, Wand}
import charactersp.{BlackMage, Character, Ninja, Warrior}
class WandTest extends munit.FunSuite {
  test("Bow ia a Weapon") {
    val wand = new Wand()
    val ninja = new Ninja()
    wand.setOwner(ninja)
    assertEquals("Wand", wand.name)
    assertEquals(15, wand.attackPoints)
    assertEquals(20, wand.weight)
    assertEquals(wand.owner, Some(ninja))
  }
  test("setOwner does not assign the owner when the owner is not allowed") {
    val wand = new Wand()
    val ninja = new Ninja()
    assertEquals(wand.owner, None)

  }
  test("setOwner returns false if the weapon is already owned by another character") {
    val wand = new Wand()
    val blackMage = new BlackMage()
    val ninja = new Ninja()
    wand.setOwner(ninja)
    val result = wand.setOwner(blackMage)
    assertEquals(result, false)
    assertEquals(wand.owner, Some(ninja))
  }

  test ("setOwner return false If the character attempts to equip the weapon that is not allowed for him"){
    val wand = new Wand()
    val warrior = new Warrior()
    wand.setOwner(warrior)
    val result = wand.setOwner(warrior)
    assertEquals(result, false)
  }

}