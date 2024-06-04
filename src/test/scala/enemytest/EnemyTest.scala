package enemytest

import charactersp.Ninja
import enemy.Enemy

class EnemyTest extends munit.FunSuite {
  test("Creating an Enemy") {
      val enemy = new Enemy( "Goblin",  100,  10, 15,  5,100)
      assertEquals(enemy.name, "Goblin")
      assertEquals(enemy.livePoints, 100)
      assertEquals(enemy.defending, 10)
      assertEquals(enemy.attack, 15)
      assertEquals(enemy.weight, 5)
  }

}