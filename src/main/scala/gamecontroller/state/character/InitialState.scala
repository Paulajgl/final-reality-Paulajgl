package gamecontroller.state.character

import gamecontroller.GameController
import gamecontroller.state.AbstractGameState
import party.IParty
import gamecontroller.state.character.UnitState
/**
 * Represents the initial state of the game when the player starts the game.
 *
 * In this state, the game initializes the game environment and transitions
 * to the `UnitState` where the player can start interacting with the game units.
 *
 * @param party The party to which the game units belong.
 */
class InitialState (private val party:IParty) extends AbstractGameState{
  /**
   * Updates the game state by transitioning to the `UnitState` for the player to begin the game.
   *
   * @param controller The game controller handling the game state.
   */
  override def update(controller: GameController): Unit = {
    if (party.allPlayersDead) {
      controller.state = new UnitState(party)
    }

  }

  /**
   * Notifies the controller that the player has started the game.
   *
   * @param controller The game controller handling the game state.
   */
  override def notify(controller: GameController): Unit = {
    if (!party.allPlayersDead) {
      controller.notifyPlayerStart()
    }

  }
}