package spelltest

import charactersp.{BlackMage, Paladin, Warrior, WhiteMage}
import enemy.Enemy
import exceptions.{InsufficientManaException, InvalidTargetException}
import munit.FunSuite
import spell.{Curing, Fire, Paralysis, Poison}
import weaponry.{Bow, Staff, Wand}

class PoisonTest extends FunSuite{
  test("Poison spell should decrease the mana points of the caster") {
    val whiteMage = new WhiteMage()
    val target = new Enemy ("Enemy", 60, 20, 10, 60, 60)
    val poisonSpell =new Poison
    val staff = new Staff()
    staff.equip(whiteMage)
    poisonSpell.cast(whiteMage, target)
    assertEquals(whiteMage.manaPoints, 0)
  }

  test("Poison spell should throw an InsufficientManaException if the caster does not have enough mana") {
    val whiteMage = new WhiteMage()
    val target = new Enemy ("Enemy", 60, 20, 10, 60, 60)
    val poisonSpell = new Poison
    val staff= new Staff()
    staff.equip(whiteMage)
    poisonSpell.cast(whiteMage, target)
    intercept[InsufficientManaException] {
      poisonSpell.cast(whiteMage, target)
    }
  }
  test("Poison spell should throw an InvalidTarget if target is not a enemy") {
    val whiteMage = new WhiteMage()
    val target = new Paladin("Paladin",60,20,10,0)
    val poisonSpell = new Poison
    val bow = new Bow()
    bow.equip(whiteMage)
    val exception= intercept[InvalidTargetException] {
      poisonSpell.cast(whiteMage, target)
    }
    assertEquals(exception.getMessage(),"Target is a character.")

  }

  test("Poison spell should throw an InsufficientMana if caster is no a WhiteMage") {
    val blackMage = new BlackMage()
    val target = new Enemy ("Enemy", 60, 20, 10, 60, 60)
    val poisonSpell = new Poison
    val wand = new Wand()
    wand.equip(blackMage)
    intercept[InsufficientManaException] {
      poisonSpell.cast(blackMage, target)
    }
  }
  test ("Poison spell should throw an UnsupportedOperationException if caster don't have a weapon") {
    val whiteMage = new WhiteMage()
    val target = new Enemy("Enemy", 30, 40, 30, 20, 30)
    val poisonSpell = new Poison
    val exception = intercept[UnsupportedOperationException] {
      poisonSpell.cast(whiteMage, target)
    }
    assertEquals(exception.getMessage(), "Caster must have a weapon equipped to cast a spell")
  }

  test("Poison spell should throw an InvalidTargetException Target must be alive to cast a spell") {
    val whiteMage = new WhiteMage()
    val target = new Enemy("Enemy", 30, 40, 30, 20, 0)
    val poisonSpell = new Poison
    val bow = new Bow()
    bow.equip(whiteMage)
    val exception= intercept[InvalidTargetException] {
      poisonSpell.cast(whiteMage, target)
    }
    assertEquals(exception.getMessage(),"Target must be alive to cast a spell")

  }
  test ("Poison getName"){
    val poisonSpell = new Poison
    val result= poisonSpell.getName
    assertEquals(result, "Poison")
  }
  }
