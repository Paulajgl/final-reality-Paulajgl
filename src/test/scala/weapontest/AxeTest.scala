package weapontest

import charactersp.{Paladin, Warrior}
import munit.FunSuite
import weaponry.Axe

class AxeTest extends FunSuite{
  test("Axe should be equipped by a character") {
    val axe = new Axe()
    val character = new Warrior()
    axe.equip(character)
    assert(axe.isEquipped)

  }

  test("Axe should not be equipped if already equipped by another character") {
    val axe = new Axe()
    val character1 = new Warrior()
    val character2 = new Paladin()

    axe.equip(character1)
    intercept[UnsupportedOperationException] {
      axe.equip(character2)
    }
  }

  test("Axe should be unequipped by a character") {
    val axe = new Axe()
    val character = new Warrior()

    axe.equip(character)
    axe.unequip(character)
    assert(!axe.isEquipped)
  }

  test("Axe should not be unequipped if not equipped by the character") {
    val axe = new Axe()
    val character = new Warrior()

    intercept[UnsupportedOperationException] {
      axe.unequip(character)
    }
  }
  test("Equip and unequip Axe weapon") {
    val character = new Warrior()
    val axe = new Axe
    // Test equipping the axe
    axe.equip(character)
    assert(axe.isEquipped, "The axe should be equipped.")
    assert(axe.owner.contains(character), "The owner of the axe should be the character.")
  }
}
