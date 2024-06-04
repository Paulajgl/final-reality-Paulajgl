package enemy

import charactersp.GameUnit

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
import charactersp.Character
class Enemy (
  val name:String,
  val livePointsMax: Int,
  val defending: Int,
  val attack:Int,
  val weight:Int,
  var livePoints: Int) extends GameUnit {
  def isAlive: Boolean = livePoints>0
  def attack(defender:GameUnit): Unit = {
   defender  match {
     case defender:Character =>
       val damage = (attack - defender.defending) max 0
       defender.receiveDamage(damage)
     case _ =>
       throw new IllegalArgumentException("Defender can't be a Enemy")
   }
 }
  def receiveDamage(damage: Int): Unit = {
    livePoints = (livePoints - damage) max 0 // Los puntos de vida no pueden ser negativos
    if (!isAlive) println(s"$name has been defeated!")
  }




}
