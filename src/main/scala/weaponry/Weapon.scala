package weaponry
import charactersp.Character
 trait Weapon {
   val name: String
   val attackPoints: Int
   val weight: Int
   private var _owner: Option[Character] = None
   protected val allowedOwners: List[String]
   def owner: Option[Character] = _owner
   def setOwner(character: Character): Boolean = {
     if (_owner.isEmpty && allowedOwners.contains(character.name)) {
       _owner = Some(character)
        true
     } else if (_owner.isDefined) {
       //println(s"$name ya está equipada por ${_owner.get.name}. No se puede cambiar de propietario.")
        false
     } else {
       //println(s"${character.name} no puede equipar $name.")
        false
     }
   }


 }
