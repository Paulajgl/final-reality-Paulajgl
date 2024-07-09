package gamecontroller.state

import gamecontroller.GameController

/**
 * Represents a base abstract class for all game states in the game.
 *
 * This class defines the basic methods that must be implemented by all specific game states.
 * The default implementation of these methods performs no action. Subclasses must provide
 * concrete implementations according to the behavior required for each game state.
 *
 * @note This class extends `GameState` and provides empty implementations for `handleInput`, `update`, and `notify`.
 */
abstract class AbstractGameState extends GameState {
  /**
   * Handles user input. In the base implementation, no action is performed.
   *
   * Subclasses must override this method to handle user input specific to the game state.
   *
   * @param controller The game controller that manages the game state.
   */
  override def handleInput(controller: GameController): Unit = {}

  /**
   * Updates the game state. In the base implementation, no action is performed.
   *
   * Subclasses must override this method to update the game state based on the game's logic.
   *
   * @param controller The game controller that manages the game state.
   */
  override def update(controller: GameController): Unit = {}

  /**
   * Notifies the controller about events or updates in the game state. In the base implementation, no action is performed.
   *
   * Subclasses must override this method to notify the controller about events specific to the game state.
   *
   * @param controller The game controller that manages the game state.
   */
  override def notify(controller: GameController): Unit = {}
}
