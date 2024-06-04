package weapontest

import charactersp.{Ninja, Paladin, Warrior}
import munit.FunSuite
import weaponry.{Axe, Bow}

class BowTest extends FunSuite{
  test("Bow should be equipped by a character") {
    val bow = new Bow()
    val character = new Ninja()
    bow.equip(character)
    assert(bow.isEquipped)

  }

  test("Bow should not be equipped if already equipped by another character") {
    val bow = new Bow()
    val character1 = new Ninja()
    val character2 = new Warrior()

    bow.equip(character1)
    intercept[UnsupportedOperationException] {
      bow.equip(character2)
    }
  }

  test("Bow should be unequipped by a character") {
    val bow = new Bow()
    val character = new Warrior()

    bow.equip(character)
    bow.unequip(character)
    assert(!bow.isEquipped)
  }

  test("Axe should not be unequipped if not equipped by the character") {
    val bow = new Bow()
    val character = new Paladin()

    intercept[UnsupportedOperationException] {
      bow.unequip(character)
    }
  }
  test("Equip and unequip Axe weapon") {
    val character = new Warrior()
    val bow = new Bow
    // Test equipping the axe
    bow.equip(character)
    assert(bow.isEquipped, "The axe should be equipped.")
    assert(bow.owner.contains(character), "The owner of the axe should be the character.")
  }

}
