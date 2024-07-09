package partytest

import charactersp.{BlackMage, Character, Ninja, Paladin, Warrior}
import exceptions.IllegalAmountException
import party.Party

import scala.collection.mutable.ArrayBuffer
class PartyTest extends munit.FunSuite {
  test("adding and removing members from party") {
    val party = new Party("PWB")
    val paladin = new Paladin()
    val warrior = new Warrior()
    val blackMage= new BlackMage()

      assertEquals(party.players.length, 0)

      party.addNewMember(paladin)
      assertEquals(party.players.length, 1)
      assertEquals(party.players.head, paladin)

      party.addNewMember(warrior)
      assertEquals(party.players.length, 2)
      assertEquals(party.players.last, warrior)

      party.removeMember(paladin)
      assertEquals(party.players.length, 1)
      assertEquals(party.players.head, warrior)

      party.removeMember(blackMage)
      assertEquals(party.players.length, 1)
      assertEquals(party.players.head, warrior)
    }
  test ("all members in the party are dead"){
    val party = new Party("PWB")
    val paladin = new Paladin("Paladin",60,20,10,0)
    val warrior = new Warrior("Warrior",80,25,20,0)
    val blackMage= new BlackMage("BlackMage",80,40,50,30,30,0)
    party.addNewMember(paladin)
    party.addNewMember(warrior)
    party.addNewMember(blackMage)
    val result = party.allPlayersDead
    assertEquals(result, true)
  }
  test ("the party "){
    val party = new Party("PWB")
    val paladin = new Paladin()
    val warrior = new Warrior()
    val blackMage= new BlackMage()
    val ninja = new Ninja()
    party.addNewMember(paladin)
    party.addNewMember(warrior)
    party.addNewMember(blackMage)
    val exception= intercept[IllegalAmountException]{
      party.addNewMember(ninja)
    }
    assertEquals(exception.getMessage,"Cannot add more than 3 members to the party.")
  }
  test("true if party contains a character and false if character is not in the party") {
    val party = new Party("PWB")
    val paladin = new Paladin()
    val warrior = new Warrior()
    party.addNewMember(paladin)
    val result = party.contains(paladin)
    assertEquals(result,true)
    val result2 =party.contains(warrior)
    assertEquals(result2,false)

  }
  test ("get players"){
    val party = new Party("PWB")
    val paladin = new Paladin()
    val warrior = new Warrior()
    val blackMage= new BlackMage()
    party.addNewMember(paladin)
    party.addNewMember(warrior)
    party.addNewMember(blackMage)
    val result= party.getPlayers
    val result2= ArrayBuffer(paladin,warrior,blackMage)
    assertEquals(result,result2)
  }
}


