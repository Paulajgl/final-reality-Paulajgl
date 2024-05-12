package characterstest

import charactersp.Ninja

class NinjaTest extends munit.FunSuite {
  test("Ninja is a  Character") {
    val ninja = new Ninja()
    assertEquals("Ninja", ninja.name)
    assertEquals(80, ninja.livePoints)
    assertEquals(30, ninja.defending)
    assertEquals(25, ninja.weight)
  }
}
