package characters
/** A class representing a Paladin
 *
 * The paladin is defined by a name and extends Character, live points, defending, weight.
 *
 * @param name The name .
 * @param livePoints The live points of the paladin
 * @param defending The defending of the paladin
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

class Paladin extends Character {
  val name = "Paladin"
  val livePoints= 60
  val defending= 20
  val weight= 10


}
