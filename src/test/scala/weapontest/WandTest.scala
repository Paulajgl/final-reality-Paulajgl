package weapontest

import charactersp.{BlackMage, Ninja, Paladin, WhiteMage}
import munit.FunSuite
import weaponry.{Staff, Wand}

class WandTest extends FunSuite{
  test("wand should be equipped by a character") {
    val wand = new Wand()
    val character = new Ninja()
    wand.equip(character)
    assert(wand.isEquipped)

  }

  test("wand should not be equipped if already equipped by another character") {
    val wand = new Wand()
    val character1 = new Ninja()
    val character2 = new BlackMage()

    wand.equip(character1)
    intercept[UnsupportedOperationException] {
      wand.equip(character2)
    }
  }

  test("wand should be unequipped by a character") {
    val wand = new Wand()
    val character = new WhiteMage()

    wand.equip(character)
    wand.unequip(character)
    assert(!wand.isEquipped)
  }

  test("wand should not be unequipped if not equipped by the character") {
    val wand = new Wand()
    val character = new Paladin()

    intercept[UnsupportedOperationException] {
      wand.unequip(character)
    }
  }
  test("Equip and unequip Axe weapon") {
    val character = new Ninja()
    val wand = new Wand
    // Test equipping the axe
    wand.equip(character)
    assert(wand.isEquipped, "The axe should be equipped.")
    assert(wand.owner.contains(character), "The owner of the axe should be the character.")
  }

}
