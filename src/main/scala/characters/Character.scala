package characters

trait Character {
  val name: String
  val livePoints: Int
  val defending: Int
  val weight: Int
  var arma: Option[weapons.Weapon] = None
}