package weapons
/** A class representing a Axe
 *
 * The Axe is defined by a name, magicAttackPoints, weight and owner.
 *
 * @param name The name  .
 * @param attackPoints The points of attack
 * @param weight The weight of a character will determine the speed  of this to be able to access your turn
 * @param owner The Axe owner
 *  @constructor
 * @example
 * {{{
 *
 * }}}

 * @author
 * @since 1.0.0
 * @version 1.0.0
 */
class Axe extends Weapon {
  val name = "Axe"
  val attackPoints= 20
  val weight = 10
  val owner= List("Paladin", "Warrior")

}
