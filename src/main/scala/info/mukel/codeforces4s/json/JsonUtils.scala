package info.mukel.codeforces4s.json

import org.json4s.JsonAST.JValue
import org.json4s.NoTypeHints
import org.json4s.native.JsonMethods._
import org.json4s.native.Serialization
import org.json4s.native.Serialization._

/**
 * JsonUtils
 *
 * Provides JSON conversion methods
 */
object JsonUtils {

  def jsonify[T <: AnyRef](value: T): String = {
    implicit val formats = Serialization.formats(NoTypeHints)
    write(value)
  }
  
  def unjsonify[T : Manifest](json: String): T = unjsonify(parse(json))

  def unjsonify[T : Manifest](json: JValue): T = {
    implicit val formats = Serialization.formats(NoTypeHints)
    json.extract[T]
  }
}