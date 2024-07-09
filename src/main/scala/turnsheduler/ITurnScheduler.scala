package turnsheduler

import scala.collection.mutable

trait ITurnScheduler {
  def removeCharacter(characterName: charactersp.Character): Unit
  def addCharacter(characterName: charactersp.Character, characterActionBar: ActionBar): Unit
  def getCharacterNextTurn(characterListInBattle: mutable.Map[charactersp.Character, ActionBar]) : Option[charactersp.Character]
  def characterListInBattle: mutable.Map[charactersp.Character, ActionBar]
}
