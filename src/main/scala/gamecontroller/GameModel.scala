package gamecontroller

import charactersp.{BlackMage, GameUnit, Ninja, Paladin, Warrior, WhiteMage}
import enemy.Enemy
import party.{IParty, Party}
import spell.{Curing, Fire, Paralysis, Poison, Spell, Thunder}
import turnsheduler.{ActionBar, ITurnScheduler, TurnScheduler}
import weaponry.{Axe, Bow, Staff, Sword, Wand, Weapon}

import scala.collection.mutable.ArrayBuffer

class GameModel {
  private val _allies = ArrayBuffer.empty[GameUnit]
  private val _enemies = ArrayBuffer.empty[GameUnit]
  private val _weapons = ArrayBuffer.empty[Weapon]
  private var scheduler = new TurnScheduler
  private val _spells = ArrayBuffer.empty[Spell]
  def init(controller: GameController): Unit = {
    val paladin = new Paladin()
    val warrior = new Warrior()
    val ninja = new Ninja()
    val blackMage = new BlackMage()
    val whiteMage = new WhiteMage()

    controller.registerUnit(paladin)
    controller.registerUnit(warrior)
    controller.registerUnit(ninja)
    controller.registerUnit(blackMage)
    controller.registerUnit(whiteMage)

    _allies += paladin
    _allies += warrior
    _allies += ninja
    _allies += blackMage
    _allies += whiteMage




    val enemy = new Enemy("Enemy",60,10,30,35,60)
    controller.registerUnit(enemy)
    val gru = new Enemy("gru",90,10,40,10,90)
    _enemies += enemy
    _enemies += gru


    var axe = new Axe
    var bow = new Bow
    var staff = new Staff
    var sword = new Sword
    var wand = new Wand

    _weapons += axe
    _weapons += bow
    _weapons += staff
    _weapons += sword
    _weapons += wand

    var curing = new Curing
    var fire = new Fire
    var paralysis = new Paralysis
    var poison = new Poison
    var thunder = new Thunder

    _spells += curing
    _spells += fire
    _spells += paralysis
    _spells += poison
    _spells += thunder

  }

  def allies: ArrayBuffer[GameUnit] = _allies

  def enemies: ArrayBuffer[GameUnit] = _enemies
  def weapons: ArrayBuffer[Weapon]= _weapons
  def spells : ArrayBuffer[Spell]= _spells
  def turnScheduler:  TurnScheduler = scheduler

  def alliesAlive(): Boolean = {
    var alive = false
    for (u <- allies) {
      alive ||= u.isAlive
    }
    alive
  }
  def enemiesAlive(): Boolean = {
    var alive = false
    for (u <- enemies) {
      if (u.livePoints >0){
        alive= true
      }
      else alive =false
    }
    alive
  }
}
