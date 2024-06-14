package spell

import charactersp.{BlackMage, GameUnit, MagicalCharacter}
import exceptions.{InsufficientManaException, InvalidTargetException}

/**
 * An abstract class representing a spell.
 *
 * Spells are magical abilities that can be cast by magical characters on game units.
 *
 * @constructor Creates a new instance of AbstractSpell with the specified cost.
 * @param cost The cost of casting the spell in terms of mana points.
 * @example
 *          {{{ val spell = new FireballSpell(10) }}}
 * @author
 * @since 1.0.0
 * @version 1.0.0
 */
abstract class AbstractSpell extends Spell {
  val cost: Int

  /**
   * Checks if the target game unit is alive.
   *
   * This method should be implemented by concrete spell classes to determine if the target is alive and can be targeted
   * by the spell.
   *
   * @param target The game unit being targeted by the spell.
   * @return True if the target is alive, otherwise false.
   */
  def isTargetAlive(target: GameUnit): Boolean

  /**
   * Casts the spell on the target game unit by the caster.
   *
   * This method should be implemented by concrete spell classes to define the behavior of the spell when cast by a
   * magical character on a game unit.
   *
   * @param caster The magical character casting the spell.
   * @param target The game unit being targeted by the spell.
   * @return The magical character after casting the spell.
   */
  def cast(caster: MagicalCharacter, target: GameUnit): MagicalCharacter

}