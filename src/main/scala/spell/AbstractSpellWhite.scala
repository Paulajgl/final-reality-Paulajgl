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
   * @throws InsufficientManaException     If the caster doesn't have enough mana points to cast the spell.
   * @throws InvalidTargetException        If the spell's target is not alive.
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
  /**
   * Indicates whether this magic item can be used by a black magician.
   *
   * This method returns true, meaning that black magicians are allowed
   * to use this item. Black magicians typically practice dark or forbidden
   * magic, so this item is suited for their use.
   *
   * @return true, because this item can be used by black magicians.
   */
  override def canUseByBlackMagician(): Boolean = false

  /**
   * Indicates whether this magic item can be used by a white magician.
   *
   * This method returns false, meaning that white magicians cannot use
   * this item. White magicians typically practice light or healing magic,
   * and this item is not suitable for their use.
   *
   * @return false, because this item cannot be used by white magicians.
   */
  override def canUseByWhiteMagician(): Boolean = true





}
