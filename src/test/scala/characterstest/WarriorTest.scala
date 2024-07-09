package characterstest

import charactersp.{ Warrior}
import weaponry.{Axe, Bow, Staff, Sword, Wand}

class WarriorTest extends munit.FunSuite {
  test("Warrior is a Character") {
    val warrior = new Warrior()
    assertEquals("Warrior", warrior.name)
    assertEquals(80, warrior.livePoints)
    assertEquals(25, warrior.defending)
    assertEquals(20, warrior.weight)
  }

  test("Warrior should equip a Sword") {
    val warrior = new Warrior()
    val sword = new Sword()
    sword.equip(warrior)
    assertEquals(warrior.getWeapon,sword)
  }
  test("Warrior should unequip a Sword") {
    val warrior = new Warrior()
    val sword = new Sword()
    sword.equip(warrior)
    sword.unequip(warrior)
  }
  test("Warrior should equip a Bow") {
    val warrior = new Warrior()
    val bow = new Bow()
    bow.equip(warrior)
  }
  test("Warrior should unequip a Bow") {
    val warrior = new Warrior()
    val bow = new Bow()
    bow.equip(warrior)
    bow.unequip(warrior)
  }
  test("Warrior should equip a wand") {
    val warrior = new Warrior()
    val wand = new Wand()
    intercept[UnsupportedOperationException] {
      wand.equip(warrior)
    }
  }

  test("Warrior should equip an axe") {
    val warrior = new Warrior()
    val axe = new Axe()
    axe.equip(warrior)
  }
  test("Warrior should unequip an axe") {
    val warrior = new Warrior()
    val axe = new Axe()
    axe.equip(warrior)
    axe.unequip(warrior)

  }
  test("Warrior should not equip an Staff") {
    val warrior = new Warrior()
    val staff = new Staff()
    intercept[UnsupportedOperationException] {
      staff.equip(warrior)
    }
  }
}


