package partytest

import charactersp.{BlackMage, Character, Ninja, Paladin, Warrior}
import party.Party
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
    val paladin = new Paladin()
    val warrior = new Warrior()
    val blackMage= new BlackMage()
    party.addNewMember(paladin)
    party.addNewMember(warrior)
    party.addNewMember(blackMage)
  }
  }


