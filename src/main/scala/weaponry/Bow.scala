package weaponry
/** A class representing a Bow
 *
 * The Bow is defined by a name, magicAttackPoints, weight and owner.
 *
 * @param name The name
 * @param attackPoints The points of attack
 * @param weight The weight of a character will determine the speed  of this to be able to access your turn
 * @param owner The Bow owner
 *  @constructor
 * @example
 * {{{
 *
 * }}}

 * @author
 * @since 1.0.0
 * @version 1.0.0
 */
class Bow extends Weapon {
  val name = "Bow"
  val attackPoints = 40
  val weight = 10
  val owner= List("Warrior","Ninja", "WhiteMage")

}
