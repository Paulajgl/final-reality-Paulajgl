package enemytest

import enemy.Enemy

class EnemyTest extends munit.FunSuite {
  var enemigo: Enemy = _

  override def beforeEach(context: BeforeEach): Unit = {
    enemigo = new Enemy("Duende", 100, 20, 10, 50)
  }

  test("El nombre del enemigo puede ser modificado") {
    enemigo.name = "Duende"
    assertEquals("Duende", enemigo.name)
  }

  test("Los puntos de vida del enemigo pueden ser modificados") {
    enemigo.livePoints= 150
    assertEquals(150, enemigo.livePoints)
  }

  test("El ataque del enemigo puede ser modificado") {
    enemigo.attack = 25
    assertEquals(25, enemigo.attack)
  }

  test("La defensa del enemigo puede ser modificada") {
    enemigo.defensing= 15
    assertEquals(15, enemigo.defensing)
  }

  test("El peso del enemigo puede ser modificado") {
    enemigo.weight= 60
    assertEquals(60, enemigo.weight)
  }
}