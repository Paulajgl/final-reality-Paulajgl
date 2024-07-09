package test.effectest

import charactersp.{BlackMage, Warrior, WhiteMage}
import effect.{FireEffect, ParalysisEffect, PoisonEffect}
import enemy.Enemy
import munit.FunSuite
import weaponry.Wand

class EffectTest extends FunSuite {
  test ("FireEffect") {
    val unit = new BlackMage()
    val target = new Enemy("Goblin", 100, 10, 15, 5, 100)
    val fireEffect= new FireEffect()
    val weapon = new Wand
    weapon.equip(unit)
    fireEffect.apply(unit,target,weapon)
    assertEquals(target.livePoints,80)
    fireEffect.update(target)
    fireEffect.update(target)
    fireEffect.update(target)
    fireEffect.update(target)
    assertEquals(target.isActive(),false)


  }
  test ("Paralysis"){
    val unit = new WhiteMage()
    val target = new Enemy("Goblin", 100, 10, 15, 5, 100)
    val paralysisEffect= new ParalysisEffect()
    val weapon = new Wand
    weapon.equip(unit)
    paralysisEffect.apply(unit,target,weapon)
    assertEquals(target.livePoints,60)
    paralysisEffect.update(target)
    paralysisEffect.update(target)
    assertEquals(target.isActive(),false)
  }
  test("PoisonEffect"){
    val unit = new WhiteMage()
    val target = new Enemy("Goblin", 100, 10, 15, 5, 100)
    val poisonEffect= new PoisonEffect()
    val weapon = new Wand
    weapon.equip(unit)
    poisonEffect.apply(unit,target,weapon)
    assertEquals(target.livePoints,87)
    poisonEffect.update(target)
    poisonEffect.update(target)
    poisonEffect.update(target)
    assertEquals(target.isActive(),false)
  }
}
