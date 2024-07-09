package spell

import charactersp.{BlackMage, Character, GameUnit, MagicalCharacter}
import effect.FireEffect
import enemy.Enemy
import exceptions.{InsufficientManaException, InvalidTargetException}
import weaponry.{MagicalWeapon, Weapon}
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
  /**
   * Returns the name of the magic item.
   *
   * This method returns the name of the magic item as "Fire". The name
   * typically represents the main function or characteristic of the item.
   *
   * @return "Dire", the name of this magic item.
   */
  override def getName: String = "Fire"

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
          val fireEffect = new FireEffect()
          val  weapon =caster.weapon.get
          weapon match {
            case weapon: MagicalWeapon =>
              fireEffect.apply(caster, target, weapon)

              caster
          }


        case _ => throw new InsufficientManaException("Cannot cast black spell")
      }
    } else {
      throw new InvalidTargetException("Target must be alive to cast a spell")
    }
  }

}
