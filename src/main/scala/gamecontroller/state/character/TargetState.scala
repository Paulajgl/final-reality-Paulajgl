package gamecontroller.state.character

import charactersp.GameUnit
import gamecontroller.GameController
import gamecontroller.state.AbstractGameState
import spell.Spell
import weaponry.{NoWeapon, NoneWeapon, Weapon}
import charactersp.Character
import party.IParty
/**
 * Represents the state in which the player selects a target for a spell or weapon attack.
 *
 * In this state, the player can choose a target from the enemies for the selected spell or weapon attack.
 * After selecting a target, the state transitions to `FinalState` where the actual attack or spell casting occurs.
 *
 * @param source The game unit that will perform the attack or cast the spell.
 * @param weapon The weapon used in the action.
 * @param spell An optional spell to be cast during the action.
 * @param party The party to which the source and target units belong.
 */
class TargetState (private val source: GameUnit,private val weapon: Weapon, private val spell: Option[Spell], private val party:IParty) extends AbstractGameState {
  private var selected: Option[GameUnit] = None
  /**
   * Secondary constructor for `TargetState` without specifying a spell.
   *
   * @param source The game unit that will perform the attack or cast the spell.
   * @param weapon The weapon used in the action.
   * @param party The party to which the source and target units belong.
   */
  def this(source: GameUnit, weapon: Weapon,party: IParty) = {
    this(source, weapon, None,party)
  }
  /**
   * Notifies the controller that the player is in the target selection state.
   *
   * @param controller The game controller handling the game state.
   */
  override def notify(controller: GameController):Unit = {
    controller.notifyPlayerTarget()
  }
  /**
   * Handles the player's input for selecting a target.
   * Validates the input and updates the state based on the selected target.
   *
   * @param controller The game controller handling the game state.
   */
  override def handleInput(controller: GameController): Unit = {
    val choice = controller.getNumericalInput()
    try {
      val enemy= Some(controller.getEnemy(choice - 1))
      selected = enemy

    } catch {
      case e: IndexOutOfBoundsException => controller.notifyErrorInvalidOption(choice)
    }
  }
  /**
   * Handles the player's input for selecting a target.
   * Validates the input and updates the state based on the selected target.
   *
   * @param controller The game controller handling the game state.
   */
  override def update(controller: GameController): Unit = {
    if (selected.isDefined) {
      controller.state= new FinalState(source,weapon ,spell, selected.get,party  )

    }
  }
}
