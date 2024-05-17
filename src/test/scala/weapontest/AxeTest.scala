package weapontest

import charactersp.{BlackMage, Paladin, Warrior, WhiteMage}
import weaponry.{Axe, Bow}

class AxeTest extends  munit.FunSuite {
  test ("Axe is a Weapon"){
    val axe = new Axe()
    val paladin= new Paladin
    axe.setOwner(paladin)
    assertEquals("Axe", axe.name)
    assertEquals(20, axe.attackPoints)
    assertEquals(10, axe.weight)
    assertEquals(axe.owner, Some(paladin))
  }
  test("setOwner does not assign the owner when the owner is not allowed") {
    val axe = new Axe()
    val paladin = new Paladin()
    assertEquals(axe.owner, None)
  }
  test("setOwner returns false if the weapon is already owned by another character") {
    val axe = new Axe()
    val warrior = new Warrior()
    val paladin = new Paladin()
    axe.setOwner(paladin)
    val result = axe.setOwner(warrior)
    assertEquals(result, false)
    assertEquals(axe.owner, Some(paladin))
  }




}
