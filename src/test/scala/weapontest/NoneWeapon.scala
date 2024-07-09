package weapontest

import charactersp.{Paladin, Warrior}
import exceptions.InsufficientManaException
import munit.FunSuite
import weaponry.NoWeapon

class NoneWeapon extends FunSuite{
  test("NoneWeapon") {
    val paladin= new Paladin()
    intercept[UnsupportedOperationException] {
      NoWeapon.equip(paladin)
    }



  }
}
