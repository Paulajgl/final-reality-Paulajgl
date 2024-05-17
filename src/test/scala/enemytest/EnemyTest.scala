package enemytest

import enemy.Enemy

class EnemyTest extends munit.FunSuite {

    test("Creating an Enemy") {
      val enemy = new Enemy(name = "Goblin", livePoints = 100, defensing = 10, attack = 15, weight = 5)

      assertEquals(enemy.name, "Goblin")
      assertEquals(enemy.livePoints, 100)
      assertEquals(enemy.defensing, 10)
      assertEquals(enemy.attack, 15)
      assertEquals(enemy.weight, 5)
    }

}