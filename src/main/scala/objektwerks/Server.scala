package objektwerks

import com.typesafe.config.ConfigFactory

import java.time.LocalDateTime

import org.apache.pekko.actor.ActorSystem
import org.apache.pekko.http.scaladsl.Http
import org.apache.pekko.http.scaladsl.model.StatusCodes.OK
import org.apache.pekko.http.scaladsl.server.Directives.*

import scala.io.StdIn
import scala.concurrent.ExecutionContext

@main def runServer(): Unit =
  val conf = ConfigFactory.load("server.conf")
  val name = conf.getString("server.name")
  val host = conf.getString("server.host")
  val port = conf.getInt("server.port")

  given system: ActorSystem = ActorSystem.create(name, conf)
  given executor: ExecutionContext = system.dispatcher

  val server = Http()
    .newServerAt(host, port)
    .bindFlow(Router.route)

  println(s"*** Server started at http://$host:$port/\nPress RETURN to stop...")

  StdIn.readLine()
  server
    .flatMap(_.unbind())
    .onComplete { _ =>
      system.terminate()
      println("*** Server stopped.")
    }