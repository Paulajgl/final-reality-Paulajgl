package spelltest

import charactersp.{BlackMage, Paladin, Warrior, WhiteMage}
import enemy.Enemy
import exceptions.{InsufficientManaException, InvalidTargetException}
import munit.FunSuite
import spell.{Curing, Fire}
import weaponry.Staff

class FireTest extends FunSuite{
  test("Fire spell should decrease the mana points of the caster") {
    val blackMage = new BlackMage()
    val target = new Enemy("Enemy",30,40,30,20,30)
    val fireSpell = new Fire
    val staff = new Staff()
    staff.equip(blackMage)
    fireSpell.cast(blackMage, target)
    assertEquals(blackMage.manaPoints, 15) // 30 - 15 = 15
    staff.unequip(blackMage)
  }

  test("Fire spell should throw an InsufficientManaException if the caster does not have enough mana") {
    val blackMage = new BlackMage()
    val target = new Enemy("Enemy",30,40,30,20,30)
    val fireSpell = new Fire
    val staff = new Staff()
    staff.equip(blackMage)
    fireSpell.cast(blackMage, target)
    fireSpell.cast(blackMage, target)
    intercept[InsufficientManaException] {
      fireSpell.cast(blackMage, target)
    }
    staff.unequip(blackMage)
  }
  test("Fire spell should throw an InvalidTarget if target is not a enemy") {
    val blackMage = new BlackMage()
    val target = new Paladin("Paladin",60,20,10,0)
    val fireSpell = new Fire
    intercept[InvalidTargetException] {
      fireSpell.cast(blackMage, target)
    }

  }

  test("Fire spell should throw an InsufficientMana if caster is no a BlackMage") {
    val whiteMage = new WhiteMage()
    val target = new Enemy ("Enemy",30,40,30,20,30)
    val fireSpell = new Fire
    val staff = new Staff()
    staff.equip(whiteMage)
    val exception= intercept[InsufficientManaException] {
      fireSpell.cast(whiteMage, target)
    }
    assertEquals(exception.getMessage(),"Cannot cast black spell")
    staff.unequip(whiteMage)

  }
  test ("Fire spell should throw an UnsupportedOperationException if caster don't have a weapon"){
    val whiteMage = new WhiteMage()
    val target = new Enemy ("Enemy",30,40,30,20,30)
    val fireSpell = new Fire
    val exception = intercept[UnsupportedOperationException] {
      fireSpell.cast(whiteMage, target)
    }
    assertEquals(exception.getMessage(),"Caster must have a weapon equipped to cast a spell")

  }



}
