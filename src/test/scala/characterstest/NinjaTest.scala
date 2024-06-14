package characterstest

import charactersp.Ninja
import weaponry.{Axe, Bow, Staff, Sword, Wand}

class NinjaTest extends munit.FunSuite {
  test("Ninja is a  Character") {
    val ninja = new Ninja()
    assertEquals("Ninja", ninja.name)
    assertEquals(80, ninja.livePoints)
    assertEquals(30, ninja.defending)
    assertEquals(25, ninja.weight)
  }
  test("Ninja should equip a Sword") {
    val ninja = new Ninja()
    val sword = new Sword()
    sword.equip(ninja)
  }
  test("Ninja should unequip a Sword") {
    val ninja = new Ninja()
    val sword = new Sword()
    sword.equip(ninja)
    sword.unequip(ninja)
  }
  test("Ninja should equip a Bow") {
    val ninja = new Ninja()
    val bow = new Bow()
    bow.equip(ninja)
  }
  test("Ninja should unequip a Bow") {
    val ninja = new Ninja()
    val bow = new Bow()
    bow.equip(ninja)
    bow.unequip(ninja)
  }
  test("Ninja should equip a wand") {
    val ninja = new Ninja()
    val wand = new Wand()
    wand.equip(ninja)
  }
  test("Ninja should unequip a wand") {
    val ninja = new Ninja()
    val wand = new Wand()
    wand.equip(ninja)
    wand.unequip(ninja)
  }

  test("Ninja should not equip an axe") {
    val ninja = new Ninja()
    val axe = new Axe()
    intercept[UnsupportedOperationException] {
      axe.equip(ninja)
    }
  }
  test("Ninja should not equip an Staff") {
    val ninja = new Ninja()
    val staff = new Staff()
    intercept[UnsupportedOperationException] {
      staff.equip(ninja)
    }
  }
}
