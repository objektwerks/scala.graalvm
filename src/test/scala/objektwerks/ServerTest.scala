package objektwerks

import org.apache.pekko.actor.ActorSystem
import org.apache.pekko.http.scaladsl.Http
import org.apache.pekko.http.scaladsl.model.StatusCodes
import org.apache.pekko.http.scaladsl.testkit.ScalatestRouteTest

import com.typesafe.config.ConfigFactory

import org.scalatest.BeforeAndAfterAll
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class ServerTest extends AnyWordSpec with Matchers with ScalatestRouteTest with BeforeAndAfterAll {
  val actorRefFactory = ActorSystem.create("now", ConfigFactory.load("test.conf"))

  val server = Http()
    .newServerAt("localhost", 0)
    .bindFlow(Server.route)

  override protected def afterAll(): Unit = {
    server
      .flatMap(_.unbind())
      .onComplete(_ => system.terminate())
  }

  "Server" should {
    "get now" in {
      Get("/now") ~> Server.route ~> check {
        status shouldBe StatusCodes.OK
      }
    }
  }
}