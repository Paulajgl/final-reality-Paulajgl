package gamecontroller.state.character

import charactersp.{Character, GameUnit}
import exceptions.IllegalAmountException
import gamecontroller.GameController
import gamecontroller.state.AbstractGameState
import gamecontroller.state.character.ActionState
import party.{IParty, Party}
/**
* Represents the state in which the player selects a unit from their party to perform an action.
*
* In this state, the player chooses a unit from the party to proceed with the next steps in the game,
* such as selecting a weapon or a spell. After selecting a unit, the state transitions to `WeaponState`
* if there are no dead players in the party.
*
* @param party The party to which the units belong.
*/
class UnitState (private val party: IParty)extends AbstractGameState {
  private var selected: Option[GameUnit] = None
  /**
   * Notifies the controller that the player is in the unit selection state.
   *
   * @param controller The game controller handling the game state.
   */
  override def notify(controller: GameController): Unit = {
    controller.notifyPlayerUnits()
  }
  /**
   * Handles the player's input for selecting a unit from their party.
   * Validates the input and updates the state based on the selected unit.
   *
   * @param controller The game controller handling the game state.
   */
  override def handleInput(controller: GameController): Unit = {
    val choice = controller.getNumericalInput()
    selected= Some (controller.getAlly(choice-1))
    try {
      selected.get match {
        case selected: Character =>
          party.addNewMember(selected)
      }
    } catch {
      case e : IndexOutOfBoundsException => controller.notifyErrorInvalidOption(choice)
      case e : IllegalAmountException => controller.notifyPartyError()
    }
  }
  /**
   * Updates the game state by transitioning to `WeaponState` if a unit is selected and no players in the party are dead.
   *
   * @param controller The game controller handling the game state.
   */

  override def update(controller: GameController): Unit = {
    if (selected.isDefined & !party.allPlayersDead ) {
      controller.state= new WeaponState(selected.get,party)
    }


  }
}


