package weaponry
/** A class representing a Wand
 *
 * The Wand is defined by a name, magicAttackPoints, weight and owner.
 *
 * @param name The name  .
 * @param magicAttackPoints The points of attack
 * @param weight The weight of a character will determine the speed  of this to be able to access your turn
 * @param owner The Wand owner
 *  @constructor
 * @example
 * {{{
 *
 * }}}

 * @author
 * @since 1.0.0
 * @version 1.0.0
 */

class Wand extends MagicalWeapon {
  val name = "Wand"
  val attackPoints= 15
  val magicAttackPoints= 40
  val weight = 20
  override protected val allowedOwners: List[String]= List("Ninja", "BlackMage","WhiteMage")

}
