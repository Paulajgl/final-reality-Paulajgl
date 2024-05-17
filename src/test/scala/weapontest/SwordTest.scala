package weapontest

import charactersp.{BlackMage, Ninja, Warrior, WhiteMage}
import weaponry.{MagicalWeapon, Sword, Wand}

class SwordTest extends munit.FunSuite {
  test("Sword is a  Weapon") {
    val sword = new Sword()
    val ninja= new Ninja()
    sword.setOwner(ninja)
    assertEquals("Sword", sword.name)
    assertEquals(30, sword.attackPoints)
    assertEquals(10, sword.weight)
    assertEquals(sword.owner, Some(ninja))
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
    val whiteMage = new WhiteMage()
    wand.setOwner(whiteMage)
    val result = wand.setOwner(whiteMage)
    assertEquals(result, false)
  }
}