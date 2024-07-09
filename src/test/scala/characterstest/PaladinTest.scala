package characterstest
import charactersp.{ Paladin}
import weaponry.{Axe, Bow, Staff, Sword, Wand}
class PaladinTest extends munit.FunSuite {
    test("Paladin is a Character") {
      val paladin = new Paladin()
      assertEquals("Paladin", paladin.name)
      assertEquals(60, paladin.livePoints)
      assertEquals(20, paladin.defending)
      assertEquals(10, paladin.weight)
    }
  test("Paladin should equip a Sword") {
    val paladin = new Paladin()
    val sword = new Sword()
    sword.equip(paladin)
    assertEquals(paladin.getWeapon,sword)
  }
  test("Paladin should unequip a Sword") {
    val paladin = new Paladin()
    val sword = new Sword()
    sword.equip(paladin)
    sword.unequip(paladin)
  }
  test("Paladin should equip a Bow") {
    val paladin = new Paladin()
    val bow = new Bow()
    intercept[UnsupportedOperationException] {
      bow.equip(paladin)
    }
  }

  test("Paladin should equip a wand") {
    val paladin = new Paladin()
    val wand = new Wand()
    intercept[UnsupportedOperationException] {
      wand.equip(paladin)
    }
  }

  test("Paladin should  equip an axe") {
    val paladin = new Paladin()
    val axe = new Axe()
     axe.equip(paladin)

  }
  test("Paladin should unequip an axe") {
    val paladin = new Paladin()
    val axe = new Axe()
    axe.equip(paladin)
    axe.unequip(paladin)

  }
  test("Paladin should not equip an Staff") {
    val paladin = new Paladin()
    val staff = new Staff()
    intercept[UnsupportedOperationException] {
      staff.equip(paladin)
    }
  }
}
