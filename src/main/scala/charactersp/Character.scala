package charactersp

import party.Party
import weaponry.{Axe, Bow, Staff, Sword, Wand, Weapon}

import scala.collection.mutable

/**
 * A trait representing a character in a game or simulation.
 *
 * @param name        The name of the character.
 * @param livePoints  The current number of hit points/life points of the character.
 * @param defending   The defense value of the character.
 * @param weight      The weight of the character, which may affect various aspects of gameplay.
 */
trait  Character extends  AbstractGameUnit {

}