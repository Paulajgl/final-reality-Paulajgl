package gamecontroller
import charactersp.GameUnit
class SomeState (val controller : GameController) extends GameState{
  override def decideAction(char: charactersp.Character): Unit = ???

  override def getCharacter(): charactersp.Character = ???

  override def incrementActionBars(): Unit = ???

  override def getEnemy(): GameUnit = ???

  override def executeTurn(): Unit = ???

  override def startBattle(): Unit = ???

}
