package combatsistemtest

import party.Party
import charactersp.{Character, Ninja, Paladin, Warrior}
import combatsystem.Attack
import weapons.{Axe, Bow}

class AttackTest extends munit.FunSuite  {
  test("Attack should deal damage to defender if attacker has weapon and is in party") {
    val attack = new Attack
    val party = new Party("Test Party")
    val paladin = new Paladin()
    val warrior = new Warrior()
    val ninja = new Ninja()
    val bow= new Bow()
    party.addNewMember (paladin)
    party.addNewMember(warrior)
    attack.equipWeapon(warrior, bow)
    attack.attackDamage(warrior) = bow.attackPoints
    attack.defensePoints(ninja) = ninja.defending
    assertEquals(attack.attack(warrior, ninja, party), 70)
  }
  test("Attack should not deal damage if attacker doesn't have weapon") {
    val attack = new Attack
    val party = new Party("Test Party")
    val warrior = new Warrior()
    val ninja = new Ninja()
    party.addNewMember(warrior)
    party.addNewMember(ninja)
    attack.defensePoints(ninja) = ninja.defending
    assertEquals(attack.attack(warrior, ninja, party), 0)
  }

  test("Attack should not deal damage if attacker is not in party") {
    val attack = new Attack
    val party = new Party("Test Party")
    val warrior = new Warrior()
    val ninja = new Ninja()
    val axe = new Axe()
    attack.equipWeapon(warrior, axe)
    attack.defensePoints(ninja) = ninja.defending
    attack.attackDamage(warrior) = axe.attackPoints
    assertEquals(attack.attack(warrior, ninja, party), 0)
  }

    test("Attack should reduce defender's health to zero if damage exceeds health") {
      val party = new Party("Test Party")
      val warrior = new Warrior()
      val ninja = new Ninja()
      val attack = new Attack
      val axe = new Axe()
      party.addNewMember(warrior)
      party.addNewMember(ninja)
      attack.equipWeapon(warrior, axe)
      attack.defensePoints(ninja)=ninja.defending
      attack.attackDamage(warrior) = ninja.livePoints + ninja.defending + 1
      // Verificar que el daño es suficiente para reducir la salud del ninja a cero
      val remainingHealth= attack.attack(warrior, ninja, party)
      assertEquals(remainingHealth, 0, "Defender's health should be reduced to zero after attack")
    }


}








