package party
import characters.Character

class Party(var character: Set[Character] = Set()) {
  def addMember(newCharacter: Character): Unit = {
    character += newCharacter
  }
}