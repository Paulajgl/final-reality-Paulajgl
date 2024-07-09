package gamecontroller.state.character

import charactersp.{Character, GameUnit}
import exceptions.InvalidWeaponAssignment
import gamecontroller.GameController
import gamecontroller.state.AbstractGameState
import party.IParty
import weaponry.Weapon
/**
 * Represents the state in the game where the player selects a weapon for a character.
 *
 * In this state, the player can choose a weapon from a list of available weapons for the character.
 * Once a weapon is selected and equipped, the state transitions to the `ActionState` where the player can perform an action.
 *
 * @param src The game unit (character) for which the weapon is being selected.
 * @param party The party to which the character belongs.
 */
class WeaponState (private var src :GameUnit, private val party: IParty) extends AbstractGameState {
  private var selected: Option[Weapon]= None

  /**
   * Notifies the controller to display the list of weapons available for the character.
   *
   * @param controller The game controller managing the game state.
   */
  override def notify(controller: GameController): Unit = {
    controller.notifyPlayerUnitWeapons()
  }
  /**
   * Handles the player's input to select a weapon from the list of available weapons.
   *
   * @param controller The game controller managing the game state.
   */

  override def handleInput(controller: GameController): Unit = {
    val choice = controller.getNumericalInput()
        try {
          val weapon = controller.getWeapons(choice - 1)
          src match {
            case src: Character =>
              selected = Some(weapon)
          }
        } catch {
          case e: InvalidWeaponAssignment =>
            controller.notifyErrorInvalidWeapon()
          case e: IndexOutOfBoundsException =>
            controller.notifyErrorInvalidWeapon()
          case e: UnsupportedOperationException =>
            controller.notifyErrorInvalidWeapon()
    }


  }
  /**
   * Updates the game state by equipping the selected weapon to the character and transitioning to the `ActionState`.
   *
   * @param controller The game controller managing the game state.
   */

  override def update(controller: GameController): Unit = {
    if (!selected.get.isEquipped) {
      try {
        src match {
          case src: Character =>
            selected.get.equip(src)
        }
      }
      catch {
        case x: InvalidWeaponAssignment => controller.notifyErrorInvalidWeapon()
        case e: UnsupportedOperationException => controller.notifyErrorInvalidWeapon()

      }
      controller.state = new ActionState(src,selected.get,party )
    }
    else{
      controller.notifyWeaponisEquipped()
      controller.state = new ActionState(src,selected.get,party )

    }


  }
  }


