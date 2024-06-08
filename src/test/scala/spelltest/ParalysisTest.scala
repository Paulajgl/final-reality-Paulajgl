package spelltest

import charactersp.{BlackMage, Paladin, Warrior, WhiteMage}
import enemy.Enemy
import exceptions.{InsufficientManaException, InvalidTargetException}
import munit.FunSuite
import spell.{Curing, Fire, Paralysis}
import weaponry.{Bow, Staff}

class ParalysisTest extends FunSuite{
  test("Paralysis spell should decrease the mana points of the caster") {
    val whiteMage = new WhiteMage()
    val target = new Enemy ("Enemy", 60, 30, 10, 60, 60)
    val paralysisSpell =new Paralysis
    val bow = new Bow()
    bow.equip(whiteMage)
    paralysisSpell.cast(whiteMage, target)
    assertEquals(whiteMage.manaPoints, 5) // 20 - 25 = 5
  }

  test("Paralysis spell should throw an InsufficientManaException if the caster does not have enough mana") {
    val whiteMage = new WhiteMage()
    val target = new Enemy ("Enemy", 60, 20, 10, 60, 60)
    val paralysisSpell = new Paralysis
    val staff = new Staff()
    staff.equip(whiteMage)
    paralysisSpell.cast(whiteMage, target)
    intercept[InsufficientManaException] {
      paralysisSpell.cast(whiteMage, target)
    }
  }
  test("Paralysis spell should throw an InvalidTarget if target is not a enemy ") {
    val whiteMage = new WhiteMage()
    val target = new Paladin("Paladin",60,20,10,0)
    val paralysisSpell = new Paralysis
    val staff = new Staff()
    staff.equip(whiteMage)
    intercept[InvalidTargetException] {
      paralysisSpell.cast(whiteMage, target)
    }


  }

  test("Paralysis spell should throw an InsufficientMana if caster is no a WhiteMage") {
    val blackMage = new BlackMage()
    val target = new Enemy ("Enemy", 60, 20, 10, 60, 60)
    val paralysisSpell = new Paralysis
    val staff = new Staff()
    staff.equip(blackMage)
    intercept[InsufficientManaException] {
      paralysisSpell.cast(blackMage, target)
    }
  }
  test ("Paralysis spell should throw an UnsupportedOperationException if caster don't have a weapon"){
    val whiteMage = new WhiteMage()
    val target = new Enemy ("Enemy",30,40,30,20,30)
    val paralysisSpell = new Paralysis
    val exception = intercept[UnsupportedOperationException] {
      paralysisSpell.cast(whiteMage, target)
    }
    assertEquals(exception.getMessage(),"Caster must have a weapon equipped to cast a spell")
  }
  }
