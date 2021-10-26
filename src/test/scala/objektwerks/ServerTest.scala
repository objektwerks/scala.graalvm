package objektwerks

import akka.actor.ActorSystem

import akka.http.scaladsl.Http
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.testkit.ScalatestRouteTest

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