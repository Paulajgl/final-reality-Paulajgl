package spell

import charactersp.{Character, GameUnit, MagicalCharacter, WhiteMage}
import enemy.Enemy
import exceptions.InvalidTargetException
/**
 * A concrete implementation of a white magic spell that attempts to paralyze the target.
 * Extends the AbstractSpellWhite class.
 *
 * @param cost The mana cost of casting the spell.
 * @param percent The percentage associated with the spell's effect (in this case, it's not applicable).
 */
class Poison extends AbstractSpellWhite (30,0.0){
  /**
   * Checks if the target of the spell is alive.
   *
   * @param target The target of the spell.
   * @return `true` if the target is alive, `false` otherwise.
   * @throws InvalidTargetException If the target is a character, which is not allowed for this spell.
   */
  override def isTargetAlive(target: GameUnit): Boolean = target match {
    case _: Character => throw new InvalidTargetException("Target is a character.")
    case target: Enemy=> target.livePoints > 0
  }

}
