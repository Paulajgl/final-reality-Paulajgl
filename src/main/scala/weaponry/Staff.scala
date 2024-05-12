package weaponry
/** A class representing a Staff
 *
 * The Staff is defined by a name, magicAttackPoints, weight and owner.
 *
 * @param name The name  .
 * @param magicAttackPoints The points of attack
 * @param weight The weight of a character will determine the speed  of this to be able to access your turn
 * @param owner The Staff owner
 * @constructor
 * @example
 * {{{
 *
 * }}}

 * @author
 * @since 1.0.0
 * @version 1.0.0
 */
class Staff extends MagicalWeapon {
  val name = "Staff"
  val attackPoints=10
  val magicAttackPoints= 30
  val weight =15
  val owner= List("BlackMage","WhiteMage")

}
