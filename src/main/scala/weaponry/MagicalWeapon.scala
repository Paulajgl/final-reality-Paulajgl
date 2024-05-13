package weaponry

trait MagicalWeapon extends Weapon {
  val name: String
  val attackPoints:Int
  val magicAttackPoints: Int
  val weight: Int
  val owner: List[String]

}
