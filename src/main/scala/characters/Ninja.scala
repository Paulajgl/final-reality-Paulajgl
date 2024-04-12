package characters
/** A class representing a Ninja
 *
 * The ninja is defined by a name and extends Character, live points, defending, weight.
 *
 * @param name The name .
 * @param livePoints The live points of the ninja.
 * @param defending The defending of the ninja.
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
class Ninja extends Character {
  val name = "Ninja"
  val livePoints= 80
  val defending= 30
  val weight= 25


}
