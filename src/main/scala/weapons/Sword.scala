package weapons
/** A class representing a Sword
 *
 * The Sword is defined by a name, AttackPoints, weight and owner.
 *
 * @param name The name  .
 * @param magicAttackPoints The points of attack
 * @param weight The weight of a character will determine the speed  of this to be able to access your turn
 * @param owner The Sword owner
 *  @constructor
 * @example
 * {{{
 *
 * }}}

 * @author
 * @since 1.0.0
 * @version 1.0.0
 */
class Sword extends Weapon {
  val name = "Sword"
  val attackPoints = 30
  val weight= 10
  val owner= List("Paladin", "Warrior","Ninja", "BlackMage")
}
