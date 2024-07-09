package spell

import charactersp.{GameUnit, MagicalCharacter, WhiteMage}
import enemy.Enemy
import exceptions.InvalidTargetException
/**
 * A trait representing a spell in the game.
 * Spells are magical abilities that can be cast by characters or entities in the game.
 */
trait Spell{
def getName: String
  def cast(caster: MagicalCharacter, target: GameUnit): MagicalCharacter

  def canUseByWhiteMagician(): Boolean

  def canUseByBlackMagician(): Boolean
}
