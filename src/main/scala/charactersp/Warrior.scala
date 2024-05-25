package charactersp
/** A class representing a Warrior
 *
 * The warrior is defined by a name and extends Character, live points, defending, weight.
 *
 * @param name The name .
 * @param livePoints The live points of the warrior.
 * @param defending The defending of the warrior
 * @param weight The weight of a character will determine the speed  of this to be able to access your turn
 *
 *  @constructor
 * @example
 * {{{
 *
 * }}}

 * @author
 * @since 1.0.0
 * @version 1.0.0
 */
class Warrior extends Character {
  val name= "Warrior"
  val livePoints= 80
  val defending = 25
  val weight= 20

}
