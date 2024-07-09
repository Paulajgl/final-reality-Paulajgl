package gamecontroller.state.enemy

import charactersp.GameUnit
import enemy.Enemy
import gamecontroller.GameController
import gamecontroller.state.AbstractGameState
import charactersp.Character
import gamecontroller.state.character.UnitStateTwo
import party.IParty

class TargetState (private val source: GameUnit ,private val party: IParty) extends AbstractGameState{
  private var selected: Option[GameUnit]=None

  override def notify(controller: GameController): Unit = {

  }

  override def handleInput(controller: GameController): Unit = {
    selected = Some(controller.getTargetforEnemy(party))
  }

  override def update(controller: GameController): Unit = {
    if (selected.isDefined && source.isActive==false) {
      controller.state = new FinalState(source, selected.get,party)
    }
    else{
      controller.state = new UnitStateTwo(party)

    }
  }

}
