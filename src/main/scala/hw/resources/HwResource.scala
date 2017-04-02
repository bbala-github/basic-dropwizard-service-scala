package hw.resources

import javax.ws.rs.container.{AsyncResponse, Suspended}
import javax.ws.rs.{GET, Path, QueryParam}

import com.codahale.metrics.annotation.Timed

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

@Path("/")
class HwResource extends AsyncResponseHandler {
  @GET
  @Timed
  def foo(@Suspended asyncResponse: AsyncResponse, @QueryParam("q") q: String) {
    handleAsyncResponse(asyncResponse, Future[String](s"Hello World: $q"), 5000)
  }
}