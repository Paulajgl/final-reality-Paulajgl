package characterstest

import charactersp.Warrior

class WarriorTest extends munit.FunSuite {
  test("Warrior is a Character") {
    val warrior = new Warrior()
    assertEquals("Warrior", warrior.name)
    assertEquals(80, warrior.livePoints)
    assertEquals(25, warrior.defending)
    assertEquals(20, warrior.weight)
  }
}


