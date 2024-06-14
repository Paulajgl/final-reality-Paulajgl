package gamecontroller

import charactersp.GameUnit ,charactersp.Character
import enemy.Enemy

class GameController {
  var state: GameState= New SomeState(this)
  def startBattle(): Unit = {}
  def getEnemy(): GameUnit= {}
  def getCharacter():Character {}
  def incrementActionBars(): Unit{}
  def decideAction(char: Character):Unit{}
  def executeTurn(): Unit{}

  }
