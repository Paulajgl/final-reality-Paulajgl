package weaponry

class NoneWeapon extends AbstractWeapon {
  val name = "None"
  val attackPoints = 0
  val weight = 0
  override def equip(character: charactersp.Character): Unit = {
      throw new UnsupportedOperationException("None.")

  }
  override protected def specificUnequip(character: charactersp.Character): Unit = {
    throw new UnsupportedOperationException("None")
  }
}
