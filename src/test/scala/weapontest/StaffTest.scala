package weapontest

import charactersp.{BlackMage, Ninja, Paladin, Warrior, WhiteMage}
import munit.FunSuite
import weaponry.{Bow, Staff}

class StaffTest extends FunSuite{
  test("Staff should be equipped by a character") {
    val staff = new Staff()
    val character = new WhiteMage()
    staff.equip(character)
    assert(staff.isEquipped)

  }

  test("Staff should not be equipped if already equipped by another character") {
    val staff = new Staff()
    val character1 = new WhiteMage()
    val character2 = new BlackMage()

    staff.equip(character1)
    intercept[UnsupportedOperationException] {
      staff.equip(character2)
    }
  }

  test("Staff should be unequipped by a character") {
    val staff = new Staff()
    val character = new BlackMage()

    staff.equip(character)
    staff.unequip(character)
    assert(!staff.isEquipped)
  }

  test("Staff should not be unequipped if not equipped by the character") {
    val staff = new Staff()
    val character = new Paladin()

    intercept[UnsupportedOperationException] {
      staff.unequip(character)
    }
  }
  test("Equip and unequip Axe weapon") {
    val character = new WhiteMage()
    val staff = new Staff
    // Test equipping the axe
    staff.equip(character)
    assert(staff.isEquipped, "The axe should be equipped.")
    assert(staff.owner.contains(character), "The owner of the axe should be the character.")
  }


}
