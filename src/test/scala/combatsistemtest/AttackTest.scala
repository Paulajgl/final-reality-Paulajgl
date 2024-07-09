package combatsistemtest

import party.Party
import charactersp.{BlackMage, Character, Ninja, Paladin, Warrior}
import enemy.Enemy
import munit.FunSuite
import weaponry.{Axe, Bow, Sword, Wand}

class AttackTest extends munit.FunSuite {
  test("Attack should throw UnsupportedOperationException if attacker does not have a weapon equipped") {
    val unit = new Warrior()
    val attacker = new Enemy("Goblin",  100,  10, 15,  5,100)
    val attackDamage = 10

    val exception = intercept[UnsupportedOperationException] {
      unit.attack(attacker, attackDamage)
    }

    assertEquals(exception.getMessage(), s"${unit.name} cannot attack without a weapon.")
  }
  test("Attack should reduce defender's livePoints when attacker has a weapon equipped") {
    val attacker = new Paladin()
    val defender = new Enemy("Goblin",  100,  10, 15,  5,100)
    val weapon = new Axe()
    val attackDamage = 20
    weapon.equip(attacker)
    assert(weapon.isEquipped)
    attacker.attack(defender , attackDamage)



  }
  test ("Enemy attack "){
    val enemy = new Enemy( "Martin",  100,  10, 15,  5,100)
    val character= new Ninja()
    enemy.attack(character)

  }
  test("Enemy can't attack a Enemy"){
    val enemy = new Enemy( "Goblin",  100,  10, 15,  5,100)
    val enemy2 = new Enemy( "Goblin",  90,  13, 13,  5,90)
    val exception = intercept[IllegalArgumentException] {
      enemy.attack(enemy2)
    }
    assertEquals(exception.getMessage(), "Defender can't be a Enemy")
  }
  test ("Character can't attack a Character"){
    val character = new Paladin()
    val character2= new Ninja()
    val attackDamage = 10
    val sword = new Sword()
    sword.equip(character)

    val exception = intercept[IllegalArgumentException] {
      character.attack(character2,attackDamage)
    }
    assertEquals(exception.getMessage(), "Defender must be an Character")

  }
  test("Enemy attack"){
    val enemy = new Enemy("Enemy",60,10,30,35,60)
    val paladin= new Paladin()
    enemy.attack(paladin)

  }
  test ("Magical cahracter attack"){
    val attacker = new BlackMage()
    val defender = new Enemy("Goblin",  100,  10, 15,  5,100)
    val weapon = new Wand()
    val attackDamage = 20
    weapon.equip(attacker)
    assert(weapon.isEquipped)
    attacker.attack(defender , attackDamage)
  }
  test ("MagicalCharacter can't attack a Character"){
    val character = new BlackMage()
    val character2= new Ninja()
    val attackDamage = 10
    val sword= new Sword()
    sword.equip(character)

    val exception = intercept[IllegalArgumentException] {
      character.attack(character2,attackDamage)
    }
    assertEquals(exception.getMessage(), "Defender must be an Enemy.")

  }
  test("Attack should throw UnsupportedOperationException if attacker does not have a weapon equipped") {
    val unit = new BlackMage()
    val attacker = new Enemy("Goblin",  100,  10, 15,  5,100)
    val attackDamage = 10

    val exception = intercept[UnsupportedOperationException] {
      unit.attack(attacker, attackDamage)
    }

    assertEquals(exception.getMessage(), s"${unit.name} cannot attack without a weapon.")
  }
}




