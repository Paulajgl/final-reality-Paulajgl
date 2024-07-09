package gamecontroller.observer

import charactersp.GameUnit
import gamecontroller.GameView
import spell.Spell
import weaponry.Weapon

/**
 * Represents an observer for attack events in the game.
 *
 * This class is responsible for handling notifications of different types of attacks
 * and displaying them using the game view.
 *
 * @param view The game view used to display attack notifications.
 */
class ObserverAttack(private val view: GameView) {

  /**
   * Notifies and displays a simple attack event.
   *
   * @param src The game unit that initiated the attack.
   * @param dest The game unit that is the target of the attack.
   * @param dmg The amount of damage dealt in the attack.
   */
  def notifySimpleAttack(src: GameUnit, dest: GameUnit): Unit = {
    view.displaySimpleAttack(src, dest)
  }

  /**
   * Notifies and displays a spell attack event.
   *
   * @param src The game unit that cast the spell.
   * @param dest The game unit that is the target of the spell.
   * @param sp The spell that was cast.
   */
  def notifySpellAttack(src: GameUnit, dest: GameUnit, sp: Spell): Unit = {
    view.displaySpellAttack(src, dest, sp)
  }
}
