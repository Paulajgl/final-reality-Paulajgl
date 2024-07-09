package enemy

import charactersp.GameUnit
import gamecontroller.observer.ObserverAttack
import spell.Spell

import scala.collection.mutable.ArrayBuffer
import scala.reflect.ClassManifestFactory.Null

abstract class AbstractEnemy extends UEnemy {
  private var attackObs = ArrayBuffer.empty[ObserverAttack]
  override def registerAttackObserver(obs: ObserverAttack): Unit = {
    attackObs += obs
  }
  def isActive (): Boolean = false
  def isAlive: Boolean
  def canUseSpell (spell: Spell): Boolean= false

}
