package enemytest

import enemy.Enemy

class EnemyTest extends munit.FunSuite {
  var enemigo: Enemy = _

  override def beforeEach(context: BeforeEach): Unit = {
    enemigo = new Enemy("Duende", 100, 20, 10, 50)
  }

  test("El nombre del enemigo puede ser modificado") {
    enemigo.Nombre = "Duende"
    assertEquals("Duende", enemigo.Nombre)
  }

  test("Los puntos de vida del enemigo pueden ser modificados") {
    enemigo.PuntoVida = 150
    assertEquals(150, enemigo.PuntoVida)
  }

  test("El ataque del enemigo puede ser modificado") {
    enemigo.Ataque = 25
    assertEquals(25, enemigo.Ataque)
  }

  test("La defensa del enemigo puede ser modificada") {
    enemigo.Defensa = 15
    assertEquals(15, enemigo.Defensa)
  }

  test("El peso del enemigo puede ser modificado") {
    enemigo.Peso= 60
    assertEquals(60, enemigo.Peso)
  }
}