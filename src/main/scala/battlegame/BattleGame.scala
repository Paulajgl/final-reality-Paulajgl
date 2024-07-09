package battlegame

  import gamecontroller.{GameController, GameModel, GameView}

  class BattleGame {

    def run() = {
      val controller: GameController = new GameController(new GameModel, new GameView)
      while(!controller.hasFinished()) {
        controller.handleInput()
        controller.update()
      }
    }


  }


