package objektwerks

import java.time.LocalDateTime

import org.apache.pekko.http.scaladsl.model.StatusCodes.OK
import org.apache.pekko.http.scaladsl.server.Directives.*

object Router:
  val route = path("now") {
    get {
      complete(OK -> s"*** Now: ${LocalDateTime.now.toString}")
    }
  }