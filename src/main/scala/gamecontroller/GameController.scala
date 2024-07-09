package gamecontroller

import charactersp.{Character, GameUnit, MagicalCharacter}
import com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time
import com.sun.org.apache.xerces.internal.dom.DOMMessageFormatter.init
import effect.Effect
import gamecontroller.observer.ObserverAttack
import gamecontroller.state.GameState
import gamecontroller.state.character.InitialState
import gamecontroller.state.enemy.TargetState
import gamecontroller.state.enemy.UnitState
import gamecontroller.uninitialize.uninitialized
import party.{IParty, Party}
import spell.Spell
import turnsheduler.{ActionBar, ITurnScheduler, TurnScheduler}
import weaponry.Weapon

import scala.::
import scala.Console.in
import scala.collection.mutable.ArrayBuffer
import scala.util.Random

/**
 * The `GameController` class manages the flow of the game, including state transitions, user inputs,
 * and interactions between the game model and the game view. It coordinates between different components
 * of the game, including the game state, the game model, and the game view.
 *
 * @param model The game model that holds the game data and logic.
 * @param view The game view that handles user interactions and displays information.
 */
class GameController (private val model: GameModel, private val view: GameView) {
  private var _state: GameState = uninitialized
  private var party: IParty= new Party("Party")
  private val ai = new Random()
  private val attackObs = new ArrayBuffer[ObserverAttack].empty
  init()
  /**
   * Initializes the game controller, setting up the initial game state and notifying the view.
   */
  private def init():Unit ={
    notifyInitMessage()
    attackObs += new ObserverAttack(view)
    model.init(this)
    state = new InitialState(party)

  }
  /**
   * Checks if the game is finished by evaluating win or lose conditions.
   */
  private def checkFinished(): Unit = {
    if (win()) {
      view.displayVictory()
    } else if (lose()) {
      view.displayDefeat()
    }
  }
  /**
   * Retrieves an AI-controlled enemy unit that is still alive.
   *
   * @return An alive AI-controlled enemy unit.
   */
  def getAIUnit(): GameUnit = {
    var choice = ai.nextInt(model.enemies.length)
    while(!model.enemies(choice).isAlive) {
      choice = ai.nextInt(model.enemies.length)
    }
    model.enemies(choice)
  }
  /**
   * Retrieves a random target from the party.
   *
   * @param party The party from which to select a target.
   * @return A randomly selected target from the party.
   */
  def getTargetforEnemy( party: IParty): GameUnit = {
    val party2= new Party("party2")
    val choice = party.getPlayers
    for (c<- choice){
      if (c.livePoints>0){
        party2.addNewMember(c)
      }
    }
    val choice2 = party2.getPlayers
    val randomIndex = Random.nextInt(choice2.length)
    choice(randomIndex)
  }
  /**
   * Retrieves the character who will take the next turn based on the weapon and party.
   *
   * @param weapon The weapon to be used by the character.
   * @param party The party of characters.
   * @return The character who will take the next turn.
   */

  def getCharacterTurn(weapon: Weapon,party: IParty):Character={
    val scheduler= new TurnScheduler
    val choice= party.getPlayers
    for (c <-choice){

      val peso= c.weight
      val pesoweapon= weapon.weight
      val actionbar = new ActionBar(peso,pesoweapon)
      actionbar.increaseValue(actionbar.actionBarCalculate)
      scheduler.addCharacterInBattle(c,actionbar)
    }
    val turn= scheduler.getCharacterNextTurn(scheduler.characterListInBattle)
    turn.get
  }
  /**
   * Retrieves the character from the party who will take the next turn.
   *
   * @param party The party of characters.
   * @return The character who will take the next turn.
   */

  def getCharacterOnlyParty(party: IParty): Character = {
    val choice = party.getPlayers
    val scheduler = new TurnScheduler
    for (c <- choice) {
      if (c.livePoints > 0) {
        val weapon = c.getWeapon
        val weightplayer = c.weight
        val weightweapon = weapon.weight
        val actionbar = new ActionBar(weightplayer, weightweapon)
        actionbar.increaseValue(actionbar.actionBarCalculate)
        scheduler.addCharacterInBattle(c, actionbar)
      }
    }
    val turn = scheduler.getCharacterNextTurn(scheduler.characterListInBattle)
    turn.get
  }
  /**
   * Gets the current game state.
   *
   * @return The current game state.
   */
  def state: GameState = _state
  /**
   * Sets a new game state and notifies the game controller.
   *
   * @param other The new game state.
   */
  def state_=(other: GameState): Unit = {
    _state =  other
    _state.notify(this)
  }
  /**
   * Handles user input through the current game state.
   */
  def handleInput(): Unit = {
    state.handleInput(this)
  }
  /**
   * Checks if the game has finished by evaluating win or lose conditions.
   *
   * @return True if the game is finished, otherwise false.
   */
  def hasFinished(): Boolean = {
    win() || lose()
  }
  /**
   * Updates the game state and checks if the game has finished.
   */
  def update(): Unit = {
    checkFinished()
    state.update(this)
    view.render()
  }
  /**
   * Retrieves an ally unit from the model based on the provided choice.
   *
   * @param choice The index of the ally to retrieve.
   * @return The selected ally unit.
   */
  def getAlly(choice: Int): GameUnit = {
    val u = model.allies(choice)
    notifyAllyChoose(u)
    u
  }
  /**
   * Retrieves an enemy unit from the model based on the provided choice.
   *
   * @param choice The index of the enemy to retrieve.
   * @return The selected enemy unit.
   */
  def getEnemy(choice: Int): GameUnit= {
    val u = model.enemies(choice)
    u
  }
  /**
   * Retrieves a weapon from the model based on the provided choice.
   *
   * @param choice The index of the weapon to retrieve.
   * @return The selected weapon.
   */
  def getWeapons(choice: Int): Weapon = {
    val u = model.weapons(choice)
    u
  }
  /**
   * Retrieves a spell from the model based on the provided choice.
   *
   * @param choice The index of the spell to retrieve.
   * @return The selected spell.
   */
  def getSpell(choice: Int): Spell = {
    val u = model.spells(choice)
    u
  }
  /**
   * Removes a character from the party.
   *
   * @param character The character to remove.
   * @param party The party from which to remove the character.
   */
  def removeCharacter(character: Character, party: IParty): Unit = {
    val choice = party.getPlayers
    val scheduler = new TurnScheduler
    for (c <- choice) {
      val weapon = c.getWeapon
      val weightplayer = c.weight
      val weightweapon = weapon.weight
      val actionbar = new ActionBar(weightplayer, weightweapon)
      actionbar.increaseValue(actionbar.actionBarCalculate)
      scheduler.addCharacterInBattle(c, actionbar)
      scheduler.removeCharacter(character)
    }

  }

  /**
   * Retrieves a numerical input from the user.
   *
   * @return The numerical input from the user.
   */
  def getNumericalInput(): Int = {
    view.getNumericalInput()
  }
  /**
   * Notifies the view about the game initialization.
   */
  def notifyInitMessage(): Unit = {
    view.displayInitMessage()
  }
  /**
   * Notifies the view that the player should start their turn.
   */
  def notifyPlayerStart() = {
    view.displayPlayerStart()
  }
  /**
   * Notifies the view that the player should take an action.
   */
  def notifyPlayerAction() = {
    view.displayPlayerAction()
  }
  /**
   * Notifies the view that the enemy's turn is starting.
   */
  def notifyEnemyStart()={
    view.displayEnemyStart()
  }
  /**
   * Notifies the info of ally.
   */

  def notifyAllyChoose(pUnit: GameUnit) = {
    view.displayCharacterInfo(pUnit)
  }
  /**
   * Notifies the view about an invalid option selected by the user.
   *
   * @param choice The invalid option.
   */
  def notifyErrorInvalidOption(choice: Int) = {
    view.displayErrorInvalidOption(choice)
  }
  /**
   * Notifies the view to display the available spells for the player unit.
   */
  def notifyPlayerUnitSpells() = {
     view.displayPlayerUnitSpell(model.spells)
  }
  /**
   * Notifies the view about an invalid weapon assignment.
   */
  def notifyErrorInvalidWeapon(): Unit = {
    view.displayErrorInvalidWeapon()
  }

  def notifyWeaponisEquipped():Unit={
    view.displayWeaponError()
  }
  /**
   * Registers a game unit with all attack observers.
   *
   * @param gUnit The game unit to be registered with attack observers.
   */
  def registerUnit(gUnit: GameUnit): Unit = {
    for (o <- attackObs) {
      gUnit.registerAttackObserver(o)
    }
  }
  /**
   * Notifies the view to display the list of player units in the party.
   */
  def notifyPlayerUnits() = {
    view.displayPlayerUnits(model.allies)
  }
  /**
   * Notifies the view to display the list of weapons available to the player.
   */
  def notifyPlayerUnitWeapons() : Unit= {
    view.displayPlayerUnitWeapons(model.weapons)
  }
  /**
   * Notifies the view about an error when a spell cannot be used.
   */
  def notifyErrorCannotUseSpell(): Unit = {
    view.displayErrorCannotUseSpell()
  }
  /**
   * Notifies the view with information about a specific game unit.
   *
   * @param character The game unit to display information about.
   */
  def notifyCharacterInfo(character: GameUnit ):Unit= {
    view.displayCharacterInfo(character)
  }
  /**
   * Notifies the view to prompt the player to select a target from the list of enemies.
   */
  def notifyPlayerTarget():Unit ={
    view.displayPlayerTarget(model.enemies)
  }
  def notifyPartyError():Unit={
    view.displayPartyError()
  }
  def notifyLose():Unit={
    view.displayLose()
  }
  /**
   * Checks if the game has been won.
   *
   * @return True if all enemies are defeated, otherwise false.
   */
 private def win(): Boolean = {
    !model.enemiesAlive()
  }
  /**
   * Checks if the game has been lost.
   *
   * @return True if all allies are defeated, otherwise false.
   */
  private def lose(): Boolean = {
    !model.alliesAlive()

  }


}
