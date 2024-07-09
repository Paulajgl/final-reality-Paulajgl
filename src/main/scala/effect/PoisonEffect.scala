package effect

import charactersp.{GameUnit, MagicalCharacter}
import weaponry.{MagicalWeapon, Weapon}

/**
 * Represents a poison effect that can be applied to a game unit.
 *
 * @param duration The duration of the poison effect in turns. Default is 4 turns.
 */
class PoisonEffect(private var duration: Int = 4) extends Effect {

  /**
   * Applies the poison effect to the target game unit.
   *
   * This method is called when the effect is applied by a caster using a magical weapon.
   * If the weapon is equipped, the target's live points are reduced by one-third of the weapon's magic attack points.
   * Additionally, the target is marked as poisoned and a message is printed.
   *
   * @param caster The magical character casting the effect.
   * @param target The game unit that is the target of the effect.
   * @param weapon The magical weapon used to cast the effect.
   */
  override def apply(caster: MagicalCharacter, target: GameUnit, weapon: MagicalWeapon): Unit = {
    if (weapon.isEquipped) {
      target.livePoints = target.livePoints - (weapon.magicAttackPoints / 3)
      target.isActive == true
      println(s"${target.name} is poisoned.")
    }
  }

  /**
   * Updates the status of the target game unit.
   *
   * This method is called on each turn to update the effect's impact on the target. If the target
   * is still active and the duration of the effect has expired (duration is 0), the target is deactivated.
   * Otherwise, a message is printed indicating that the target loses their turn, and the duration
   * is decreased by 1.
   *
   * @param target The game unit affected by the poison effect.
   */
  override def update(target: GameUnit): Unit = {
    if (target.isActive && duration == 0) {
      target.isActive == false
    } else {
      println(s"${target.name} loses their turn.")
      duration -= 1
    }
  }
}