package hw.resources

import java.util.concurrent.TimeUnit
import javax.ws.rs.container.{AsyncResponse, TimeoutHandler}
import javax.ws.rs.core.Response

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

abstract class AsyncResponseHandler {
  protected def handleAsyncResponse[T](ar: AsyncResponse, f: Future[T], timeoutInMs: Long) {
    ar.setTimeout(timeoutInMs, TimeUnit.MILLISECONDS)
    ar.setTimeoutHandler(new TimeoutHandler {
      override def handleTimeout(ar: AsyncResponse) {
        ar.resume(Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("internal timeout").build())
      }
    })

    f.onComplete{
      case Success(s) => ar.resume(s)
      case Failure(e) => ar.resume(e)
    }
  }
}