package gamecontroller.state

import gamecontroller.GameController

/**
 * Trait representing the state of the game. All specific game states should implement this trait.
 *
 * This trait defines the core methods that each game state must provide. These methods are used
 * by the game controller to manage the game flow, handle user input, and update the state of the game.
 *
 * Implementations of this trait should provide concrete behavior for handling inputs, updating game state,
 * and notifying the game controller of events.
 */
trait GameState {
  /**
   * Notifies the game controller about events or updates in the game state.
   *
   * This method should be implemented to perform actions or updates based on the current game state.
   *
   * @param controller The game controller that manages the game state.
   */
  def notify(controller: GameController): Unit

  /**
   * Handles user input. This method should be implemented to manage input from the user specific to the current game state.
   *
   * @param controller The game controller that manages the game state.
   */
  def handleInput(controller: GameController): Unit

  /**
   * Updates the game state based on the game's logic. This method should be implemented to define how the game state
   * progresses or changes over time.
   *
   * @param controller The game controller that manages the game state.
   */
  def update(controller: GameController): Unit
}