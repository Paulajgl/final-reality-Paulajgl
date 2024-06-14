package spell

import charactersp.{BlackMage, GameUnit, MagicalCharacter, WhiteMage,Character}
import exceptions.{IllegalAmountException, InsufficientManaException, InvalidTargetException}

/**
 * An abstract class representing a white magic spell.
 *
 * @param cost     The mana cost of the spell.
 * @param percent  The percentage associated with the spell's effect (may vary depending on concrete implementation).
 */
abstract class AbstractSpellWhite(val cost: Int, val percent: Double) extends SpellWhite {

  /**
   * Checks if the spell's target is alive.
   *
   * @param target The target of the spell.
   * @return `true` if the target is alive, `false` if dead.
   */
  def isTargetAlive(target: GameUnit): Boolean

  /**
   * Casts the spell.
   *
   * @param caster The magical character casting the spell.
   * @param target The target of the spell.
   * @return The magical character after casting the spell.
   * @throws UnsupportedOperationException If the caster doesn't have a weapon equipped.
   * @throws InsufficientManaException      If the caster doesn't have enough mana points to cast the spell.
   * @throws InvalidTargetException         If the spell's target is not alive.
   */
  override def cast(caster: MagicalCharacter, target: GameUnit): MagicalCharacter = {
    if (isTargetAlive(target)) {
      if (caster.weapon.isEmpty) {
        throw new UnsupportedOperationException("Caster must have a weapon equipped to cast a spell")
      }
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







}
