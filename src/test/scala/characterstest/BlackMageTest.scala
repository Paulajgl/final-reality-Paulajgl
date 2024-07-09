package characterstest

import charactersp.BlackMage
import spell.Fire
import weaponry.{Axe, Bow, Staff, Sword, Wand}

class BlackMageTest extends munit.FunSuite {
  test("BlackMage is a  MagicalCharacter") {
    val blackMage = new BlackMage()
    assertEquals("BlackMage", blackMage.name)
    assertEquals(80, blackMage.livePoints)
    assertEquals(20, blackMage.defending)
    assertEquals(50, blackMage.weight)
    assertEquals(30, blackMage.manaPoints)
  }

  test("BlackMage should equip a staff") {
    val blackMage = new BlackMage()
    val staff = new Staff()
    staff.equip(blackMage)
    assertEquals(blackMage.getWeapon,staff)
  }
  test("BlackMage should unequip a staff") {
    val blackMage = new BlackMage()
    val staff = new Staff()
    staff.equip(blackMage)
    staff.unequip(blackMage)
  }
  test("BlackMage should equip a sword") {
    val blackMage = new BlackMage()
    val sword = new Sword()
    sword.equip(blackMage)
  }
  test("BlackMage should unequip a sword") {
    val blackMage = new BlackMage()
    val sword = new Sword()
    sword.equip(blackMage)
    sword.unequip(blackMage)
  }
  test("BlackMage should equip a wand") {
    val blackMage = new BlackMage()
    val wand = new Wand()
    wand.equip(blackMage)
  }
  test("BlackMage should unequip a wand") {
    val blackMage = new BlackMage()
    val wand = new Wand()
    wand.equip(blackMage)
    wand.unequip(blackMage)
  }

  test("BlackMage should not equip an axe") {
    val blackMage = new BlackMage()
    val axe = new Axe()
    intercept[UnsupportedOperationException] {
      axe.equip(blackMage)
    }
  }
  test("BlackMage should not equip an bow") {
    val blackMage = new BlackMage()
    val bow = new Bow()
    intercept[UnsupportedOperationException] {
      bow.equip(blackMage)
    }
  }
  test("Can use a spell?"){
    val blackMage = new BlackMage()
    val staff = new Staff()
    val spell= new Fire
    staff.equip(blackMage)
    assertEquals(blackMage.canUseSpell(spell),true)
  }

}
