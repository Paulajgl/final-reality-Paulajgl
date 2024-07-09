package charactersp

import enemy.{Enemy, UEnemy}
import gamecontroller.observer.ObserverAttack
import party.Party
import spell.Spell
import weaponry.UnitWeapon

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

/**
 * A trait representing a unit in the game.
 * Game units can be characters, enemies, or any other entities in the game.
 */
trait GameUnit {
  val name: String
  val livePointsMax: Int
  val defending: Int
  val weight: Int
  var livePoints: Int

  private var attackObs = ArrayBuffer.empty[ObserverAttack]
  def isActive: Boolean
  def registerAttackObserver(obs: ObserverAttack): Unit
  def isAlive: Boolean
  def canUseSpell(spell:Spell): Boolean

}
