package turnshedulertest

import junit.framework.Assert.{assertFalse, assertTrue}
import turnsheduler.ActionBar

class ActionBarTest extends munit.FunSuite {

    test("increaseValue should correctly increase the value") {
      val actionBar = new ActionBar(characterWeight = 100, weaponWeight = 20)

      actionBar.increaseValue(30)
      assertEquals(actionBar.value, 30)

      actionBar.increaseValue(50)
      assertEquals(actionBar.value, 80)
    }

    test("isFull should return true when value is equal to or greater than the threshold") {
      val actionBar = new ActionBar(characterWeight = 100, weaponWeight = 20)

      actionBar.increaseValue(90) //  total: 90
      assertFalse(actionBar.isFull) // 90 < (100 + 0.5 * 20) = 110

      actionBar.increaseValue(20) //  total: 110
      assertTrue(actionBar.isFull) // 110 >= (100 + 0.5 * 20) = 110
    }

    test("isFull should return false when value is less than the threshold") {
      val actionBar = new ActionBar(characterWeight = 100, weaponWeight = 20)

      actionBar.increaseValue(30) //  total: 30
      assertFalse(actionBar.isFull) // 30 < (100 + 0.5 * 20) = 110
    }

}
