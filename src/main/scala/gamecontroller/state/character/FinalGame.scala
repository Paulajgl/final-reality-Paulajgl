package gamecontroller.state.character

import gamecontroller.GameController
import gamecontroller.state.AbstractGameState

class FinalGame extends AbstractGameState {
  override def notify(controller: GameController): Unit = {
    controller.notifyLose()
  }




}
