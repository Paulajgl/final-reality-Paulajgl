package effect

import charactersp.{GameUnit, MagicalCharacter}
import weaponry.MagicalWeapon

/**
 * Represents an effect that can be applied to a game unit.
 *
 * This trait defines the basic structure for effects that can be applied by magical characters
 * using magical weapons to game units. Effects can have different impacts on the target and
 * may require updating on each turn.
 */
trait Effect {

  /**
   * Applies the effect to the target game unit.
   *
   * This method is called when the effect is applied by a caster using a magical weapon.
   * The specific impact of the effect depends on its implementation.
   *
   * @param caster The magical character casting the effect.
   * @param target The game unit that is the target of the effect.
   * @param weapon The magical weapon used to cast the effect.
   */
  def apply(caster: MagicalCharacter, target: GameUnit, weapon: MagicalWeapon): Unit

  /**
   * Updates the status of the target game unit.
   *
   * This method is called on each turn to update the effect's impact on the target. The specific
   * behavior depends on the effect's implementation.
   *
   * @param target The game unit affected by the effect.
   */
  def update(target: GameUnit): Unit
}
