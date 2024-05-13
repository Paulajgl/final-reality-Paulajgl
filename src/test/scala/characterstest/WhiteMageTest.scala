package characterstest

import charactersp.WhiteMage


class WhiteMageTest extends munit.FunSuite {
  test("WhiteMage is a  MagicalCharacter") {
    val whiteMage = new WhiteMage()
    assertEquals("WhiteMage", whiteMage.name)
    assertEquals(90, whiteMage.livePoints)
    assertEquals(50, whiteMage.defending)
    assertEquals(40, whiteMage.weight)
    assertEquals(20, whiteMage.manaPoints)
  }
}
