package characters
/** A class representing a WhiteMage
 *
 * The WhiteMage is defined by a name and extends Character, live points, defending, weight.
 *
 * @param name The name .
 * @param livePoints The live points of the WhiteMage.
 * @param defending The defending of the WhiteMage
 * @param weight The weight of a character will determine the speed  of this to be able to access your turn
 * @param manaPoints The mana Points are only for magical characters
 *  @constructor
 * @example
 * {{{
 *
 * }}}

 * @author
 * @since 1.0.0
 * @version 1.0.0
 */

class WhiteMage extends MagicalCharacter {
  val name= "WhiteMage"
  val livePoints = 90
  val defending= 50
  val weight = 40
  val manaPoints = 20


}
