package turnshedulertest

import charactersp.{BlackMage, Ninja, Paladin, Warrior, WhiteMage}
import junit.framework.Assert.assertFalse
import turnsheduler.{ActionBar, TurnScheduler}

class TurnSchedulerTest extends munit.FunSuite {
    test("addCharacter should add character to character list") {
      val turnScheduler = new TurnScheduler
      val character = new Ninja
      val actionBar = new ActionBar(characterWeight = 100, weaponWeight = 20)

      turnScheduler.addCharacter(character, actionBar)
      assertEquals(turnScheduler.characterList.size, 1)
      assert(turnScheduler.characterList.contains(character))
      assertEquals(turnScheduler.characterList(character), actionBar)
    }

    test("removeCharacter should remove character from character list") {
      val turnScheduler = new TurnScheduler
      val character = new Ninja
      val character2= new BlackMage
      val actionBarNinja = new ActionBar(characterWeight = character.weight, weaponWeight = 20)
      val actionBarBlackMage = new ActionBar(characterWeight = character2.weight, weaponWeight = 30)
      turnScheduler.addCharacter(character, actionBarNinja)
      turnScheduler.addCharacter(character2,actionBarBlackMage)
      assertEquals(turnScheduler.characterList.size, 2)
      turnScheduler.removeCharacter(character)
      assertEquals(turnScheduler.characterList.size, 1)
      assertFalse(turnScheduler.characterList.contains(character))
    }

  test("maxActionBar should return list with maximum action bar values for each character") {
    val turnScheduler = new TurnScheduler
    val paladin= new Paladin
    val actionBarPaladin = new ActionBar(characterWeight = paladin.weight, weaponWeight = 20)
    actionBarPaladin.actionBarCalculate
    turnScheduler.addCharacter(paladin, actionBarPaladin)
    val ninja = new Ninja
    val actionBarNinja= new ActionBar(characterWeight = ninja.weight, weaponWeight = 30)
    actionBarNinja.actionBarCalculate
    turnScheduler.addCharacter(ninja, actionBarNinja)

    val whiteMage = new WhiteMage
    val actionBarWhiteMage = new ActionBar(characterWeight = whiteMage.weight , weaponWeight = 10)
    actionBarWhiteMage.actionBarCalculate
    turnScheduler.addCharacter(whiteMage, actionBarWhiteMage)

    val maxValues = turnScheduler.maxActionBar()

    assertEquals(maxValues, List(40.0, 20.0, 45.0))
  }
  test("increaseActionBarInBattle should increase the value of all action bars in battle by specified amount") {
    val turnScheduler = new TurnScheduler
    val character = new Ninja
    val character2= new BlackMage
    val actionBarNinja = new ActionBar(characterWeight = character.weight, weaponWeight = 20)
    val actionBarBlackMage = new ActionBar(characterWeight = character2.weight, weaponWeight = 30)
    turnScheduler.addCharacterInBattle(character,actionBarNinja)
    turnScheduler.addCharacterInBattle(character2, actionBarBlackMage)
    turnScheduler.increaseActionBarInBattle(10)
    assertEquals(actionBarNinja.value, 10)
    assertEquals(actionBarBlackMage.value, 10)
  }

  test("isActionBarFull should return false if character's action bar is not full") {
    val turnScheduler = new TurnScheduler
    val blackMage = new BlackMage
    val actionBarBlackMage = new ActionBar(characterWeight = blackMage.weight, weaponWeight = 30)
    turnScheduler.addCharacterInBattle(blackMage, actionBarBlackMage)
    assertEquals(turnScheduler.isActionBarFull(blackMage), false)
  }
  test("isActionBarFull should return true if character's action bar is  full") {
    val turnScheduler = new TurnScheduler
    val blackMage = new BlackMage
    val actionBarBlackMage = new ActionBar(characterWeight = blackMage.weight, weaponWeight = 30)
    actionBarBlackMage.actionBarCalculate
    turnScheduler.addCharacterInBattle(blackMage, actionBarBlackMage)
    actionBarBlackMage.increaseValue(actionBarBlackMage.actionBarCalculate)
    assertEquals(turnScheduler.isActionBarFull(blackMage), true)
  }
  test("getCharactersWithFullActionBar should return a list of characters with full action bars for a valid character") {
    val turnScheduler = new TurnScheduler
    val ninja = new Ninja
    val actionBar = new ActionBar(characterWeight = 10, weaponWeight = 20)
    turnScheduler.addCharacterInBattle(ninja, actionBar)
    turnScheduler.increaseActionBarInBattle(actionBar.actionBarCalculate)
    val charactersWithFullActionBar = turnScheduler.getCharactersWithFullActionBar(turnScheduler.characterListInBattle)
    assertEquals(charactersWithFullActionBar, List(ninja))
  }

  test("getCharactersWithFullActionBar should return an empty list for a character with incomplete action bar") {
    val turnScheduler = new TurnScheduler
    val warrior = new Warrior
    val actionBar = new ActionBar(characterWeight = 5, weaponWeight = 10)
    turnScheduler.addCharacterInBattle(warrior, actionBar)

    val charactersWithFullActionBar = turnScheduler.getCharactersWithFullActionBar(turnScheduler.characterListInBattle)
    assertEquals(charactersWithFullActionBar, List.empty)
  }

  test("getCharactersWithFullActionBar should return an empty list for an invalid character") {
    val turnScheduler = new TurnScheduler
    val invalidCharacter = new BlackMage

    val charactersWithFullActionBar = turnScheduler.getCharactersWithFullActionBar(turnScheduler.characterListInBattle)
    assertEquals(charactersWithFullActionBar, List.empty)
  }

  test("getCharactersWithFullActionBar should return a list sorted by action bar value in descending order") {
    val turnScheduler = new TurnScheduler
    val ninja = new Ninja
    val paladin = new Paladin
    val warrior = new  Warrior
    val actionBarNinja = new ActionBar(characterWeight = 5, weaponWeight = 10)
    val actionBarPaladin = new ActionBar(characterWeight = 20, weaponWeight = 30)
    val actionBarWarrior = new ActionBar(characterWeight = 12, weaponWeight = 10)
    turnScheduler.addCharacterInBattle(ninja, actionBarNinja)
    turnScheduler.addCharacterInBattle(paladin, actionBarPaladin)
    turnScheduler.addCharacterInBattle(warrior, actionBarWarrior)
    actionBarWarrior.increaseValue(actionBarWarrior.actionBarCalculate)
    actionBarPaladin.increaseValue(actionBarPaladin.actionBarCalculate)
    val charactersWithFullActionBar = turnScheduler.getCharactersWithFullActionBar(turnScheduler.characterListInBattle)
    assertEquals(charactersWithFullActionBar, List(paladin, warrior))

  }
  test ("resetActionBar should set the action bar value of all characters to zero"){
    val turnScheduler = new TurnScheduler
    val ninja = new Ninja
    val paladin = new Paladin
    val warrior = new  Warrior
    val actionBarNinja = new ActionBar(characterWeight = 5, weaponWeight = 10)
    val actionBarPaladin = new ActionBar(characterWeight = 20, weaponWeight = 30)
    val actionBarWarrior = new ActionBar(characterWeight = 12, weaponWeight = 10)
    turnScheduler.addCharacter(ninja, actionBarNinja)
    turnScheduler.addCharacter(paladin, actionBarPaladin)
    turnScheduler.addCharacter(warrior, actionBarWarrior)
    actionBarWarrior.increaseValue(actionBarWarrior.actionBarCalculate)
    actionBarPaladin.increaseValue(actionBarPaladin.actionBarCalculate)
    actionBarNinja.increaseValue(30)
    turnScheduler.resetActionBar(turnScheduler.characterList)
    assertEquals(actionBarNinja.value,0)
    assertEquals(actionBarWarrior.value,0)
    assertEquals(actionBarPaladin.value,0)
  }
  test ("getCharacterNextTurn should return the character with fullest and highest action bar"){
    val turnScheduler = new TurnScheduler
    val ninja = new Ninja
    val paladin = new Paladin
    val warrior = new  Warrior
    val actionBarNinja = new ActionBar(characterWeight = 5, weaponWeight = 10)
    val actionBarPaladin = new ActionBar(characterWeight = 20, weaponWeight = 30)
    val actionBarWarrior = new ActionBar(characterWeight = 12, weaponWeight = 10)
    turnScheduler.addCharacterInBattle(ninja, actionBarNinja)
    turnScheduler.addCharacterInBattle(paladin, actionBarPaladin)
    turnScheduler.addCharacterInBattle(warrior, actionBarWarrior)
    actionBarWarrior.increaseValue(actionBarWarrior.actionBarCalculate)
    actionBarPaladin.increaseValue(actionBarPaladin.actionBarCalculate)
    actionBarNinja.increaseValue(30)
    val characterTurn =turnScheduler.getCharacterNextTurn(turnScheduler.characterListInBattle)
    assertEquals(characterTurn,Some(paladin))

  }



}
