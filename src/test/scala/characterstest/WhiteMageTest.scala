package characterstest

import charactersp.WhiteMage
import spell.Poison
import weaponry.{Axe, Bow, Staff, Sword, Wand}


class WhiteMageTest extends munit.FunSuite {
  test("WhiteMage is a  MagicalCharacter") {
    val whiteMage = new WhiteMage()
    assertEquals("WhiteMage", whiteMage.name)
    assertEquals(90, whiteMage.livePoints)
    assertEquals(10, whiteMage.defending)
    assertEquals(40, whiteMage.weight)
    assertEquals(30, whiteMage.manaPoints)
  }
  test("WhiteMage should equip a Sword") {
    val whiteMage = new WhiteMage()
    val sword = new Sword()
    intercept[UnsupportedOperationException] {
      sword.equip(whiteMage)
    }
  }
  test("WhiteMage should equip a Bow") {
    val whiteMage = new WhiteMage()
    val bow = new Bow()
    bow.equip(whiteMage)
  }
  test("WhiteMage should unequip a Bow") {
    val whiteMage = new WhiteMage()
    val bow = new Bow()
    bow.equip(whiteMage)
    bow.unequip(whiteMage)
  }
  test("WhiteMage should equip a wand") {
    val whiteMage = new WhiteMage()
    val wand = new Wand()
    wand.equip(whiteMage)
  }
  test("WhiteMage should unequip a wand") {
    val whiteMage = new WhiteMage()
    val wand = new Wand()
    wand.equip(whiteMage)
    wand.unequip(whiteMage)
  }

  test("WhiteMage should not equip an axe") {
    val whiteMage = new WhiteMage()
    val axe = new Axe()
    intercept[UnsupportedOperationException] {
      axe.equip(whiteMage)
    }

  }
  test("WhiteMage should not equip an Staff") {
    val whiteMage = new WhiteMage()
    val staff = new Staff()
    staff.equip(whiteMage)
  }
  test("WhiteMage should not equip an Staff") {
    val whiteMage = new WhiteMage()
    val staff = new Staff()
    staff.equip(whiteMage)
    staff.unequip(whiteMage)
  }
  test("Can use a spell?"){
    val whiteMage = new WhiteMage()
    val staff = new Staff()
    val spell= new Poison
    staff.equip(whiteMage)
    assertEquals(whiteMage.canUseSpell(spell),true)
  }
}
