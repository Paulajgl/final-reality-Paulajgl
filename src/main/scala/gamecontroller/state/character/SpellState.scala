package gamecontroller.state.character

import charactersp.{Character, GameUnit}
import gamecontroller.GameController
import gamecontroller.state.AbstractGameState
import party.IParty
import spell.Spell
import weaponry.{NoWeapon, Weapon}

/**
 * Represents the state in which the player selects a spell to cast.
 *
 * In this state, the player can choose a spell to be used by the source game unit.
 * After selecting a spell, the state transitions to `TargetState` where the player can choose the target for the spell.
 *
 * @param src The game unit that will cast the spell.
 * @param weapon The weapon used in the action.
 * @param party The party to which the source and target units belong.
 */
class SpellState(private var src: GameUnit ,private val weapon: Weapon, private val party: IParty) extends AbstractGameState {
  private var selected: Option[Spell] = None
  /**
   * Secondary constructor for `SpellState` without specifying a weapon.
   *
   * @param source The game unit that will cast the spell.
   * @param party The party to which the source and target units belong.
   */
  def this(source: GameUnit, party: IParty) = {
    this(source, NoWeapon,party)
  }
  /**
   * Notifies the controller that the player is in the spell selection state.
   *
   * @param controller The game controller handling the game state.
   */
  override def notify(controller: GameController): Unit = {
    controller.notifyPlayerUnitSpells()
  }
  /**
   * Handles the player's input for selecting a spell.
   * Validates the input and updates the state based on the selected spell.
   *
   * @param controller The game controller handling the game state.
   */

  override def handleInput(controller: GameController): Unit = {
      val choice = controller.getNumericalInput()
      try {
        val spell = controller.getSpell(choice-1)
        src match {
          case src: Character =>
            if (!src.canUseSpell(spell)) {
              controller.notifyErrorCannotUseSpell()
              controller.state = new ActionState(src,weapon,party )
            }
            else selected = Some(spell)
          case _ =>
        }
      }  catch {
          case e: IndexOutOfBoundsException => controller.notifyErrorInvalidOption(choice)

      }

  }
  /**
   * Updates the game state by transitioning to `TargetState` for the selected spell.
   *
   * @param controller The game controller handling the game state.
   */
  override def update(controller: GameController): Unit = {
    if (selected.isDefined) {
      controller.state = new TargetState(src, weapon, selected,party)
    }

  }
}
