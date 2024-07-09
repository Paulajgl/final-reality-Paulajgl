package gamecontroller

import charactersp.{Character, GameUnit}
import party.IParty
import spell.Spell
import weaponry.Weapon

import scala.io.StdIn
import scala.collection.mutable.{ArrayBuffer, Queue}
class GameView {
  private val queue = new Queue[String].empty
  def getNumericalInput(): Int = {
    val resp = StdIn.readLine()
    resp.toInt
  }
  def displayInitMessage(): Unit = {
    queue.enqueue("Welcome combat!!")
  }

  def displayPlayerStart(): Unit = {
    queue.enqueue("Player Turn")
  }

  def displayEnemyStart(): Unit = {
    queue.enqueue("Enemy Turn")
  }
  def displayWeaponAttack(src: GameUnit, dest: GameUnit, wpn:Weapon): Unit = {
  }
  def displaySpellAttack(src: GameUnit, dest: GameUnit, sp: Spell): Unit = {
    queue.enqueue(s"${src.name} attacks ${dest.name}")
  }
  def displayPlayerAction(): Unit = {
    queue.enqueue("Choose your action:")
    queue.enqueue("1) Attack")
    queue.enqueue("2) Choose a Spell")
    queue.enqueue("3) Choose a Weapon")
    queue.enqueue("0) Choose a Ally")

  }
  def displayCharacterInfo(character: GameUnit): Unit = {
    queue.enqueue(s"State of ${character.name}")
    queue.enqueue(s"LP: ${character.livePoints}/${character.livePointsMax}")


  }
  def displayWeaponError(): Unit = {
    queue.enqueue(s"this weapon is equipped")

  }
  def displayPartyError():Unit ={
    queue.enqueue(s"Can not add more than 3 members to the party.")
  }

  def displayErrorInvalidOption(choice: Int): Unit = {
    queue.enqueue(s"Opción inválida ${choice}")
  }
  def displayLose(): Unit = {
    queue.enqueue(s"You Lose ")
  }


  def displayErrorInvalidWeapon(): Unit = {
    queue.enqueue("That character cannot equip that weapon")
  }
  def displayErrorCannotUseSpell(): Unit = {
    queue.enqueue("That character cannot use this spell")
  }
  def displayPlayerUnits(allies: ArrayBuffer[GameUnit]): Unit = {
    queue.enqueue("Choose a Character:")
    for(i <- allies.indices) {
      queue.enqueue(s"${i+1}) ${allies(i).name}")
    }
  }
  def displayPlayerUnitWeapons(weapons: ArrayBuffer[Weapon]): Unit = {
    queue.enqueue("Choose your weapon:")
    for(i <- weapons.indices) {
      queue.enqueue(s"${i+1}) ${weapons(i).getName}")
    }
  }
  def displayPlayerUnitSpell(spells: ArrayBuffer[Spell]): Unit = {
    queue.enqueue("Choose your spell:")
    for(i <- spells.indices) {
      queue.enqueue(s"${i+1}) ${spells(i).getName}")
    }
  }
  def displayVictory(): Unit = {
    queue.enqueue("You win !")
  }

  def displayDefeat(): Unit = {
    queue.enqueue("You lose ")
  }

  def displayPlayerTarget(enemies: ArrayBuffer[GameUnit]): Unit = {
    queue.enqueue("Choose an enemy")
    for(i <- enemies.indices) {
      queue.enqueue(s"${i+1}) ${enemies(i).name} ${enemies(i).livePoints}/${enemies(i).livePointsMax} HP")
    }
  }
  def displaySimpleAttack(src: GameUnit, dest: GameUnit): Unit = {
    queue.enqueue(s"${src.name} attacks ${dest.name}")

  }
  def render(): Unit = {
    while (queue.nonEmpty) {
      println(queue.dequeue())
    }
  }

}
