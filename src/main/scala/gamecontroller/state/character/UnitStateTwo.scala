package gamecontroller.state.character

import charactersp.{Character, GameUnit}
import gamecontroller.GameController
import gamecontroller.state.AbstractGameState
import party.IParty
import spell.Spell
import turnsheduler.ActionBar
import weaponry.{AbstractUnitWeapon, Weapon}

/**
 * Represents a game state where the player can view the information of all characters in their party.
 *
 * In this state, the player can see the details of each character in their party. After the information is displayed,
 * the state transitions to the `TargetState` if there are no dead players, or back to the `InitialState` if all players are dead.
 *
 * @param party The party to which the characters belong.
 */
class UnitStateTwo ( private val party: IParty)extends AbstractGameState {
  /**
   * Notifies the controller to display the information of all characters in the party.
   *
   * @param controller The game controller managing the game state.
   */
  override def notify(controller: GameController): Unit = {
    val character= party.getPlayers
    for( c <- character ) {
      controller.notifyCharacterInfo(c)
    }
  }
  /**
   * Updates the game state based on whether there are still alive players in the party.
   * If there are living players, transitions to `TargetState` where the player can select a target for an action.
   * Otherwise, transitions back to the `InitialState`.
   *
   * @param controller The game controller managing the game state.
   */
  override def update(controller: GameController): Unit ={
    if ( !party.allPlayersDead ) {
      val src=controller.getCharacterOnlyParty(party)
      val weapon= src.getWeapon
      try weapon match {
        case weapon: Weapon => controller.state= new TargetState(src,weapon,party)
      }
    }

  }

}
