package characters
/** A class representing a Black Mage
 *
 * The Black Mage is defined by a name and extends Character, live points, defending, weight, mana points.
 *
 * @param name The name .
 * @param livePoints The live points of the warrior.
 * @param defending The defending of the warrior
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
class BlackMage extends MagicalCharacter {
  val name= "MagoNegro"
  val livePoints = 80
  val defending= 40
  val weight = 50
  val manaPoints= 30


}

