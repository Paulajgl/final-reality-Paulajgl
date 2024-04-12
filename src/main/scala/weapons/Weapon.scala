package weapons

 trait Weapon {
   val name: String
   val attackPoints: Int
   val weight: Int
   val owner: List[String]

   def OwnerWeapon(CharacterType: String): Boolean = {
     owner.contains(CharacterType)
   }
 }
