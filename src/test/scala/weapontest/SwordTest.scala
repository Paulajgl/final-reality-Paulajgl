package weapontest

import charactersp.{BlackMage, Paladin, WhiteMage}
import munit.FunSuite
import weaponry.Sword

class SwordTest extends FunSuite{
  test("Sword should be equipped by a character") {
    val sword = new Sword()
    val character = new Paladin()
    sword.equip(character)
    assert(sword.isEquipped)

  }

  test("sword should not be equipped if already equipped by another character") {
    val sword = new Sword()
    val character1 = new Paladin()
    val character2 = new BlackMage()

    sword.equip(character1)
    intercept[UnsupportedOperationException] {
      sword.equip(character2)
    }
  }

  test("sword should be unequipped by a character") {
    val sword = new Sword()
    val character = new Paladin()

    sword.equip(character)
    sword.unequip(character)
    assert(!sword.isEquipped)
  }

  test("sword should not be unequipped if not equipped by the character") {
    val sword = new Sword()
    val character = new Paladin()

    intercept[UnsupportedOperationException] {
      sword.unequip(character)
    }
  }
  test("Equip and unequip Axe weapon") {
    val character = new Paladin()
    val sword = new Sword
    // Test equipping the axe
    sword.equip(character)
    assert(sword.isEquipped, "The axe should be equipped.")
    assert(sword.owner.contains(character), "The owner of the axe should be the character.")
  }

}
