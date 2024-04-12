package characterstest

import characters.BlackMage

class BlackMageTest extends munit.FunSuite {
  test("BlackMage is a  MagicalCharacter") {
    val blackMage = new BlackMage()
    assertEquals("MagoNegro", blackMage.name)
    assertEquals(80, blackMage.livePoints)
    assertEquals(40, blackMage.defending)
    assertEquals(50, blackMage.weight)
    assertEquals(30, blackMage.manaPoints)
  }
}
