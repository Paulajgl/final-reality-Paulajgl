package gamecontroller.state.enemy

import charactersp.GameUnit
import gamecontroller.GameController
import gamecontroller.state.AbstractGameState
import party.IParty

class UnitState (private val party:IParty)extends AbstractGameState {
  private var selected: Option[GameUnit] = None


  override def notify(controller: GameController): Unit = {
    controller.notifyEnemyStart()
  }

  override def handleInput(controller: GameController): Unit = {
    selected = Some(controller.getAIUnit())
  }

  override def update(controller: GameController): Unit = {
    if (selected.isDefined)
      controller.state = new TargetState(selected.get,party )
  }
}