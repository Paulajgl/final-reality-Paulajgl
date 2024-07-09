
import gamecontroller.state.character.UnitState
import gamecontroller.{GameController, GameModel, GameView}
import munit.FunSuite
import party.Party

class GameControllerTest extends munit.FunSuite {
  val controller: GameController = new GameController(new GameModel, new GameView)
  override def beforeEach(context: BeforeEach): Unit = {

  }
  test("test"){
    controller.update()
    controller.handleInput()







  }

}




