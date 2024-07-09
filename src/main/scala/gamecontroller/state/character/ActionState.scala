package gamecontroller.state.character

import charactersp.{Character, GameUnit}
import gamecontroller.GameController
import gamecontroller.state._
import party.IParty
import weaponry.Weapon
/**
 * Represents the state of the game where the player can choose an action to perform.
 *
 * In this state, the player decides what action to take, such as selecting a unit, targeting an enemy, or choosing a spell.
 * The state transitions to different states based on the player's input.
 *
 * @param ally The game unit representing the player's ally in the current action.
 * @param weapon The weapon used in the action by the player.
 * @param party The party to which the ally belongs.
 */
class ActionState(private val ally: GameUnit, private val weapon: Weapon, private val party: IParty) extends AbstractGameState {
  // Variable to hold the selected next state
  private var selected: Option[GameState] = None
  /**
   * Notifies the controller that the player is in the action state.
   *
   * @param controller The game controller handling the game state.
   */
  override def notify(controller: GameController): Unit = {
    controller.notifyPlayerAction()
  }

  /**
   * Handles the player's input to determine the next state based on the choice.
   *
   * @param controller The game controller handling the game state.
   */
  override def handleInput(controller: GameController): Unit = {
    val choice = controller.getNumericalInput()
    choice match {
      case 0 => selected = Some(new UnitState(party))
      case 1 => selected = Some(new TargetState(ally, weapon, party))
      case 2 => selected = Some(new SpellState(ally, party))
      case 3 => selected = Some(new WeaponState(ally, party))
      case _ => controller.notifyErrorInvalidOption(choice)
    }
  }

  /**
   * Updates the controller's state to the next state based on the player's choice.
   *
   * @param controller The game controller handling the game state.
   */
  override def update(controller: GameController): Unit = {
    if (selected.isDefined)
      controller.state = selected.get
  }
}