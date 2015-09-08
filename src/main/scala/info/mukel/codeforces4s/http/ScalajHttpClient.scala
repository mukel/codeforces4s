package info.mukel.codeforces4s.http


import java.io.File
import java.nio.file.{Files, Paths}


import scalaj.http.{Http, MultiPart}
import scala.util.Try
import scala.concurrent._
import ExecutionContext.Implicits.global

/**
 * Created by mukel on 8/5/15.
 */
trait ScalajHttpClient extends HttpClient {

  def request(requestUrl: String, params : (String, Any)*): String = {
    // TODO: Set appropriate timeout values
    val query = params.foldLeft(Http(requestUrl)) {
      case (q, (id, value)) => value match {
        case Some(s) =>
          q.param(id, s.toString)

        case None => q

        case _ => q.param(id, value.toString)
      }
    }

    val response = query.asString
    if (response.isSuccess)
      response.body
    else
      throw new Exception("HTTP request error " + response.code + ": " + response.statusLine)
  }

  def asyncRequest(requestUrl: String, params : (String, Any)*): Future[String] = {
    val p = Promise[String]()
    Future {
      p.complete(Try(request(requestUrl, params: _*)))
    }
    p.future
  }
}