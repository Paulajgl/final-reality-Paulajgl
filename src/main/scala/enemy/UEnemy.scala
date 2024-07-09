package enemy

import charactersp.GameUnit

trait UEnemy extends GameUnit{
def attack (target: GameUnit): Unit
  def receiveDamage(defender: GameUnit,damage: Int): Int
}
