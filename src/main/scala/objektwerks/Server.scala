package objektwerks

import akka.actor.ActorSystem

import akka.http.scaladsl.Http
import akka.http.scaladsl.model.StatusCodes.OK
import akka.http.scaladsl.server.Directives._

import com.typesafe.config.ConfigFactory

import java.time.LocalDateTime

import scala.io.StdIn

object Server {
  val route = path("now") {
    get { complete(OK -> LocalDateTime.now.toString) }
  }

  def main(args: Array[String]): Unit = {
    val conf = ConfigFactory.load("server.conf")
    val name = conf.getString("server.name")
    val host = conf.getString("server.host")
    val port = conf.getInt("server.port")

    implicit val system = ActorSystem.create(name, conf)
    implicit val executor = system.dispatcher

    val server = Http()
      .newServerAt(host, port)
      .bindFlow(route)

    println(s"*** Server started at http://$host:$port/\nPress RETURN to stop...")

    StdIn.readLine()
    server
      .flatMap(_.unbind())
      .onComplete { _ =>
        system.terminate()
        println("*** Server stopped.")
      }
  }
}