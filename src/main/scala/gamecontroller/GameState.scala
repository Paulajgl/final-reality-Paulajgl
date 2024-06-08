package gamecontroller

import charactersp.{Character, GameUnit}

trait GameState {
  def startBattle(): Unit
  def getEnemy(): GameUnit
  def getCharacter():Character
  def incrementActionBars(): Unit
  def decideAction(char: Character):Unit
  def executeTurn(): Unit

}
