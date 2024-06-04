package charactersp

import party.Party

import scala.collection.mutable

/**
 * A trait representing a unit in the game.
 * Game units can be characters, enemies, or any other entities in the game.
 */
trait GameUnit {
  def isAlive: Boolean

}
