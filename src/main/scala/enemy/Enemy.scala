package enemy
/** A class representing a Axe
 *
 * The Enemy is defined by a name, livePoints, defensing, attack and weight.
 *
 * @param name enemy name  .
 * @param livePoints enemy's life points
 * @param defensing   the defense of the enemy
 * @param attack The attack of the enemy
 * @param weight The weight of a character will determine the speed  of this to be able to access your turn
 *  @constructor
 * @example
 * {{{
 *
 * }}}

 * @author
 * @since 1.0.0
 * @version 1.0.0
 */

class Enemy(val name: String, val livePoints: Int,
            val defensing: Int, val attack: Int, val weight: Int)
