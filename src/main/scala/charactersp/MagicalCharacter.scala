package charactersp

/**
 * A abstract class representing a magical character in a game or simulation.
 *
 * @param name        The name of the character.
 * @param livePoints  The current number of hit points/life points of the character.
 * @param defending   The defense value of the character.
 * @param weight      The weight of the character, which may affect various aspects of gameplay.
 * @param manaPoints  The current number of mana points of the character, used for casting spells or performing magical actions.
 */
trait  MagicalCharacter extends Character {
  val manaPoints: Int
}
