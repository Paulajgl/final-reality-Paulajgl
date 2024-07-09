package spell

import charactersp.{AbstractGameUnit, BlackMage, Character, GameUnit, MagicalCharacter, WhiteMage}
import exceptions.{IllegalAmountException, InsufficientManaException, InvalidTargetException}
/**
 * An abstract class representing a black spell.
 *
 * Black spells are offensive magical abilities that can cause paralysis to the target game unit.
 *
 * @constructor Creates a new instance of AbstractSpellBlack with the specified cost and paralysis percent.
 * @param cost The cost of casting the spell in terms of mana points.
 * @param effectPercent The percentage chance of causing effect to the target.
 */

abstract class AbstractSpellBlack (
  val cost: Int,
  val effectPercent: Double ) extends  SpellBlack {

  /**
   * Checks if the target game unit is alive.
   *
   * This method should be implemented by concrete spell classes to determine if the target is alive and can be targeted
   * by the spell.
   *
   * @param target The game unit being targeted by the spell.
   * @return True if the target is alive, otherwise false.
   */
  override def isTargetAlive(target: GameUnit): Boolean

  /**
   * Casts the black spell on the target game unit by the caster.
   *
   * This method implements the behavior of casting the spell by deducting mana points from the caster and checking
   * if the target is alive before applying the spell effect.
   *
   * @param caster The magical character casting the spell.
   * @param target The game unit being targeted by the spell.
   * @return The magical character after casting the spell.
   * @throws UnsupportedOperationException if the caster does not have a weapon equipped.
   * @throws InsufficientManaException     if the caster does not have enough mana points to cast the spell.
   * @throws InvalidTargetException        if the target is not alive.
   */
  override def cast(caster: MagicalCharacter, target: GameUnit): MagicalCharacter = {
    if (isTargetAlive(target)) {
      if (caster.weapon.isEmpty) {
        throw new UnsupportedOperationException("Caster must have a weapon equipped to cast a spell")
      }
      caster match {
        case blackMage: BlackMage if blackMage.manaPoints >= cost =>
          blackMage.manaPoints -= cost
          caster
        case _ => throw new InsufficientManaException("Cannot cast black spell")
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
  override def canUseByBlackMagician(): Boolean = true

  /**
   * Indicates whether this magic item can be used by a white magician.
   *
   * This method returns false, meaning that white magicians cannot use
   * this item. White magicians typically practice light or healing magic,
   * and this item is not suitable for their use.
   *
   * @return false, because this item cannot be used by white magicians.
   */
  override def canUseByWhiteMagician(): Boolean = false

}