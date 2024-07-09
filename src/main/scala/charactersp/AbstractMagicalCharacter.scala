package charactersp

import enemy.Enemy
import spell.{AbstractSpell, AbstractSpellBlack, AbstractSpellWhite, Curing, Fire, Paralysis, Poison, Spell, SpellBlack, SpellWhite, Thunder}
import weaponry.{AbstractWeapon, Axe, Bow, Staff, Sword, UnitWeapon, Wand, Weapon}

import scala.collection.mutable.ArrayBuffer

/**
 * AbstractMagicalCharacter is an abstract class that represents a magical character in the game.
 * This class provides functionalities for magical characters, including handling mana points, attacking, and receiving damage.
 * Specific types of magical characters should extend this class and provide additional behaviors and properties.
 */
abstract class AbstractMagicalCharacter extends MagicalCharacter {
  /**
   * Performs an attack on a defender game unit with the specified attack damage.
   * The attack can only be performed if the defender is an Enemy and the character has a weapon equipped.
   *
   * @param defender     The game unit being attacked.
   * @param attackDamage The amount of attack damage to be dealt.
   * @throws UnsupportedOperationException if the character does not have a weapon equipped.
   * @throws IllegalArgumentException      if the defender is not an Enemy.
   */
  override def attack(defender: GameUnit, attackDamage: Int): Unit = {
    defender match {
      case defender: Enemy =>
        weapon match {
          case Some(_) =>
            val damage = (attackDamage - defender.defending) max 0 // Damage cannot be negative
            defender.livePoints = receiveDamage(defender, damage)
          case None =>
            throw new UnsupportedOperationException(s"$name cannot attack without a weapon.")
        }
      case _ =>
        throw new IllegalArgumentException("Defender must be an Enemy.")
    }
  }

  /**
   * Receives damage and reduces the character's live points accordingly.
   * If the resulting live points are less than or equal to zero, the character is considered defeated.
   *
   * @param damage The amount of damage to be received.
   */
  def receiveDamage(defender: GameUnit, damage: Int): Int = {
    var newlivePoints = 0
    newlivePoints = (defender.livePoints - damage) max 0 // Live points cannot be negative
    newlivePoints
  }

  /**
   * Determines if the character can use the specified spell.
   *
   * @param spell The spell to check.
   * @return Always returns false. Subclasses may override this behavior.
   */
  def canUseSpell(spell: Spell): Boolean = false

  // Define the spells available to the character
  private val fire = new Fire
  private val curing = new Curing
  private val thunder = new Thunder
  private val poison = new Poison
  private val paralysis = new Paralysis

  /**
   * Provides access to the list of spells available to the character.
   *
   * @return An ArrayBuffer containing the available spells: fire, curing, thunder, poison, and paralysis.
   */
  def spells: ArrayBuffer[Spell] = ArrayBuffer(fire, curing, thunder, poison, paralysis)

  /**
   * Retrieves the character's weapon.
   *
   * @return The character's weapon, if it is equipped.
   * @throws NoSuchElementException if the weapon is not equipped.
   */
  override def getWeapon: UnitWeapon = {
    weapon.get
  }
}

