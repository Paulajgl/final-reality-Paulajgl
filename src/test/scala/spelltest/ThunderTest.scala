package spelltest

import charactersp.{BlackMage, Paladin, Warrior, WhiteMage}
import enemy.Enemy
import exceptions.{InsufficientManaException, InvalidTargetException}
import munit.FunSuite
import spell.{Fire, Paralysis, Thunder}
import weaponry.Wand

class ThunderTest extends FunSuite{
  test("Thunder spell should decrease the mana points of the caster") {
    val blackMage = new BlackMage()
    val target = new Enemy ("Enemy", 60, 20, 10, 60, 60)
    val thunderSpell = new Thunder
    val wand= new Wand()
    wand.equip(blackMage)

    thunderSpell.cast(blackMage, target)

    assertEquals(blackMage.manaPoints, 10)
  }

  test("Thunder spell should throw an InsufficientManaException if the caster does not have enough mana") {
    val blackMage = new BlackMage()
    val target = new Enemy ("Enemy", 60, 20, 10, 60, 60)
    val thunderSpell = new Thunder
    val wand= new Wand()
    wand.equip(blackMage)
    thunderSpell.cast(blackMage, target)
    intercept[InsufficientManaException] {
      thunderSpell.cast(blackMage, target)
    }
  }
  test("Thunder spell should throw an InvalidTarget if target live =0  ") {
    val blackMage = new BlackMage()
    val target = new Enemy ("Enemy", 60, 20, 10, 60, 0)
    val thunderSpell = new Thunder
    val wand= new Wand()
    wand.equip(blackMage)
    intercept[InvalidTargetException] {
      thunderSpell.cast(blackMage, target)
    }

  }
  test("Thunder spell should throw an InvalidTarget if target  is not a enemy ") {
    val blackMage = new BlackMage()
    val target = new Warrior()
    val thunderSpell = new Thunder
    val wand= new Wand()
    wand.equip(blackMage)
    intercept[InvalidTargetException] {
      thunderSpell.cast(blackMage, target)
    }
  }
  test("Target is a Enemy") {
    val blackMage = new BlackMage()
    val target = new Enemy("Enemy",60,20,10,60,60)
    val thunderSpell = new Thunder
    val wand= new Wand()
    wand.equip(blackMage)
    thunderSpell.cast(blackMage, target)
    assertEquals(blackMage.manaPoints, 10)
  }
  test("Thunder spell should throw an InsufficientMana if caster is no a BlackMage") {
    val whiteMage = new WhiteMage()
    val target = new Enemy ("Enemy", 60, 20, 10, 60, 60)
    val thunderSpell = new Thunder
    val wand= new Wand()
    wand.equip(whiteMage)
    intercept[InsufficientManaException] {
      thunderSpell.cast(whiteMage, target)
    }

  }
  test ("Thunder spell should throw an UnsupportedOperationException if caster don't have a weapon"){
    val blackMage = new BlackMage()
    val target = new Enemy ("Enemy",30,40,30,20,30)
    val paralysisSpell = new Paralysis
    val exception = intercept[UnsupportedOperationException] {
      paralysisSpell.cast(blackMage, target)
    }
    assertEquals(exception.getMessage(),"Caster must have a weapon equipped to cast a spell")
  }

}
