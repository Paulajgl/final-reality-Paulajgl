package spelltest

import charactersp.{GameUnit, MagicalCharacter, Ninja, Paladin, WhiteMage}
import enemy.Enemy
import exceptions.{InsufficientManaException, InvalidTargetException}
import munit.FunSuite
import spell.Curing

class CuringTest extends FunSuite {
  test("Curing spell should decrease the mana points of the caster") {
    val whiteMage = new WhiteMage()
    val target = new Paladin()
    val curingSpell = new Curing
    curingSpell.cast(whiteMage, target)
    assertEquals(whiteMage.manaPoints, 15) // 30 - 15 = 5
  }

  test("Curing spell should throw an InsufficientManaException if the caster does not have enough mana") {
    val whiteMage = new WhiteMage()
    val target = new Paladin()
    val curingSpell = new Curing
    curingSpell.cast(whiteMage, target)
    curingSpell.cast(whiteMage, target)
    intercept[InsufficientManaException] {
      curingSpell.cast(whiteMage, target)
    }
  }
    test("Curing spell should throw an InvalidTarget if livePoints is 0 ") {
      val whiteMage = new WhiteMage()
      val target = new Paladin("Paladin",60,20,10,0)
      val curingSpell = new Curing
      intercept[InvalidTargetException] {
        curingSpell.cast(whiteMage, target)
      }

    }
   test("Curing spell should throw an InvalidTarget if target is no a character") {
     val whiteMage = new WhiteMage()
     val target = new Enemy("Enemy", 60, 20, 10, 60, 60)
     val curingSpell = new Curing
     intercept[InvalidTargetException] {
       curingSpell.cast(whiteMage, target)
     }
   }



}




