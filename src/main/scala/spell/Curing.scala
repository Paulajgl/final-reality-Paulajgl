package spell

import charactersp.{Character, GameUnit, MagicalCharacter, WhiteMage}
import exceptions.{InsufficientManaException, InvalidTargetException}

/**
 * A concrete implementation of a white magic spell that heals a target.
 * Extends the AbstractSpellWhite class.
 *
 * @param cost The mana cost of casting the spell.
 * @param percent The percentage of healing associated with the spell's effect.
 */
class Curing extends AbstractSpellWhite(cost = 15, percent = 0.3) {

  /**
   * Checks if the target of the spell is alive.
   *
   * @param target The target of the spell.
   * @return `true` if the target is alive, `false` otherwise.
   */
  override def isTargetAlive(target: GameUnit): Boolean = target match {
    case character: Character => character.livePoints > 0
    case _ => false
  }

  /**
   * Casts the curing spell on the target.
   *
   * @param caster The magical character casting the spell.
   * @param target The target of the spell.
   * @return The magical character after casting the spell.
   * @throws InsufficientManaException If the caster doesn't have enough mana points to cast the spell.
   * @throws InvalidTargetException    If the target of the spell is not alive.
   */
  override def cast(caster: MagicalCharacter, target: GameUnit): MagicalCharacter = {
    if (isTargetAlive(target)) {
      caster match {
        case whiteMage: WhiteMage if whiteMage.manaPoints >= cost =>
          whiteMage.manaPoints -= cost
          caster
        case _ => throw new InsufficientManaException("Cannot cast white spell due to insufficient mana")
      }
    } else {
      throw new InvalidTargetException("Target must be alive to cast a spell")
    }
  }
  /**
   * Returns the name of the magic item.
   *
   * This method returns the name of the magic item as "Curing". The name
   * typically represents the main function or characteristic of the item.
   *
   * @return "Curing", the name of this magic item.
   */
  override def getName: String = "Curing"
}