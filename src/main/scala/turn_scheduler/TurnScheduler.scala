package turn_scheduler
import characters.Character
import weapons.Weapon
class TurnScheduler(val name: String) {
  private var characters: Set[Character] = Set()

  def addCharacter(character: Character): Unit = {
    characters += character
  }

  def removeCharacter(character: Character): Unit = {
    characters -= character
  }

  def maxActionPoints: Int = characters.map(_.weight).max

  def increaseActionPoints(amount: Int): Unit = {
    characters.foreach(_.weight += amount)
  }
}
