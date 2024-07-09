package weaponry
/**
 * A trait representing a unit weapon.
 * Unit weapons are weapons that can be equipped by characters in the game.
 */
trait UnitWeapon {
  val name: String

  /**
   * The attack points provided by this weapon.
   */
  val attackPoints: Int

  /**
   * The weight of the weapon.
   */
  val weight: Int
  def getName:String

}
