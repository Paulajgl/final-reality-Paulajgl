package weapontest

import charactersp.{BlackMage, Paladin, Warrior, WhiteMage}
import weaponry.{Bow, Staff}

class BowTest extends munit.FunSuite {
  test ("Bow is a Weapon"){
    val bow = new Bow()
    val warrior = new Warrior
    bow.setOwner(warrior)
    assertEquals("Bow", bow.name)
    assertEquals(40, bow.attackPoints)
    assertEquals(10, bow.weight)
    assertEquals(bow.owner,Some(warrior))

  }

  test("setOwner does not assign the owner when the owner is not allowed") {
    val bow = new Bow()
    val blackMage = new BlackMage()
    assertEquals(bow.owner, None)

  }
  test("setOwner returns false if the weapon is already owned by another character") {
    val bow = new Bow()
    val warrior = new Warrior()
    val whiteMage = new WhiteMage()
    bow.setOwner(warrior)
    val result = bow.setOwner(whiteMage)
    assertEquals(result, false)
    assertEquals(bow.owner, Some(warrior))
  }
  test ("setOwner return false If the character attempts to equip the weapon that is not allowed for him"){
    val bow = new Bow()
    val paladin = new Paladin()
    val result = bow.setOwner(paladin)
    assertEquals(result, false)
  }
}
