package enemytest

import enemy.Enemy

class EnemyTest extends munit.FunSuite {
  var enemy: Enemy = _

  override def beforeEach(context: BeforeEach): Unit = {
    enemy = new Enemy("Goblin", 100, 20, 10, 50)
  }

  test("The name of the enemy can be modified") {
    enemy.name = "Goblin"
    assertEquals("Goblin", enemy.name)
  }

  test("The enemy's health points can be modified") {
    enemy.livePoints= 150
    assertEquals(150, enemy.livePoints)
  }

  test("The enemy's attack can be modified") {
    enemy.attack = 25
    assertEquals(25, enemy.attack)
  }

  test("The enemy's defense can be modified") {
    enemy.defensing= 15
    assertEquals(15, enemy.defensing)
  }

  test("The enemy's weight can be modified") {
    enemy.weight= 60
    assertEquals(60, enemy.weight)
  }
}