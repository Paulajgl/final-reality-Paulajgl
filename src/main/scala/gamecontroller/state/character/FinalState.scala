package gamecontroller.state.character

import charactersp.GameUnit
import exceptions.InvalidWeaponAssignment
import gamecontroller.GameController
import gamecontroller.state.AbstractGameState
import spell.Spell
import gamecontroller.state.enemy.UnitState
import party.IParty
import weaponry.{NoWeapon, Weapon}
/**
 * Represents the final state of the game after an action is performed.
 *
 * In this state, the game processes the outcome of an attack or spell cast and then transitions
 * to the `UnitState` for the next action. It handles the application of the weapon's attack and,
 * if applicable, the casting of a spell on the target.
 *
 * @param source The game unit initiating the attack or spell.
 * @param weapon The weapon used in the action.
 * @param spell An optional spell to be cast during the action.
 * @param target The game unit being attacked or targeted by the spell.
 * @param party The party to which the source and target units belong.
 */

class FinalState(private val source: GameUnit,private val weapon: Weapon, private val spell:Option[Spell],private val target: GameUnit,private val party:IParty)
extends AbstractGameState {


  /**
   * Updates the game state by performing the attack with the weapon and casting the spell, if applicable.
   * Transitions to the `UnitState` for the next action.
   *
   * @param controller The game controller handling the game state.
   */
  override def update(controller: GameController): Unit = {
    if (weapon.isEquipped) {
      try {
        source match {
          case source: charactersp.Character =>
            val source2= controller.getCharacterTurn(weapon,party)
            source2.attack(target, weapon.attackPoints)
            if (spell.isDefined) {
              spell match {
                case spell: Spell =>
                  source match {
                    case source2: charactersp.MagicalCharacter =>
                      spell.cast(source2, target)

                  }

              }
            }
        }
      }
      catch {
        case x: InvalidWeaponAssignment => controller.notifyErrorInvalidWeapon()
      }
    }
    controller.state = new UnitState(party)

  }
}