package characters

abstract class Character {
  val name: String
  var livePoints: Int
  val defending: Int
  val weight: Int
  var weapon: Option[weapons.Weapon] = None
}