package spell

import charactersp.{BlackMage, Character, GameUnit, MagicalCharacter}
import enemy.Enemy
import exceptions.InvalidTargetException
/**
 * A concrete implementation of a black magic spell that inflicts damage on the target.
 * Extends the AbstractSpellBlack class.
 *
 * @param cost The mana cost of casting the spell.
 * @param percent The percentage of damage associated with the spell's effect.
 */
class Fire extends AbstractSpellBlack(15,0.2) {
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
