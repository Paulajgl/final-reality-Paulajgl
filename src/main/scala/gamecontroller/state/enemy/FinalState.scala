package gamecontroller.state.enemy

import charactersp.GameUnit
import charactersp.Character
import enemy.{Enemy, UEnemy}
import gamecontroller.GameController
import gamecontroller.state.character.{FinalGame, InitialState, UnitState, UnitStateTwo}
import gamecontroller.state.AbstractGameState
import party.IParty

import java.lang.ModuleLayer.Controller

class FinalState(private val source: GameUnit,private val target: GameUnit, private val party:IParty) extends AbstractGameState{

  override  def update(controller: GameController): Unit = {
     source match {
       case source: UEnemy => source.attack(target)
         target match {
           case target: Character =>
             if (!target.isAlive) {
               controller.removeCharacter(target,party)
               if (!party.allPlayersDead) {
                 controller.state = new UnitStateTwo(party)
               }
               else {controller.state = new FinalGame}
             }else{
               controller.state = new UnitStateTwo(party)
             }
         }
     }

     }

}
