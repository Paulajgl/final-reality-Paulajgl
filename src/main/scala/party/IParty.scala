package party

import scala.collection.mutable.ArrayBuffer

trait IParty {
  def addNewMember(member: charactersp.Character): Unit
  def contains(member: charactersp.Character): Boolean
  def allPlayersDead: Boolean
  def getPlayers: ArrayBuffer[charactersp.Character]
  def removeMember(member: charactersp.Character): Unit
}
