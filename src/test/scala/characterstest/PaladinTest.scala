package characterstest
import charactersp.Paladin
class PaladinTest extends munit.FunSuite {
    test("Paladin is a Character") {
      val paladin = new Paladin()
      assertEquals("Paladin", paladin.name)
      assertEquals(60, paladin.livePoints)
      assertEquals(20, paladin.defending)
      assertEquals(10, paladin.weight)
    }
}
