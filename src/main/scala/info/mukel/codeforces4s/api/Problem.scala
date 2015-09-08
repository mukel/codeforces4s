package info.mukel.codeforces4s.api

/**
 * Problem
 *
 * Represents a problem.
 *
 * @param contestId  Integer. Id of the contest, containing the problem.
 * @param index      String. Usually a letter of a letter, followed by a digit, that represent a problem index in a contest.
 * @param name       String. Localized.
 * @param type       Enum: PROGRAMMING, QUESTION.
 * @param points     Floating point number. Can be absent. Maximum ammount of points for the problem.
 * @param tags       String list. Problem tags.
 */
case class Problem(
                    contestId  : Int,
                    index      : String,
                    name       : String,
                    `type`     : String, // Enum: PROGRAMMING, QUESTION.
                    points     : Option[Float],
                    tags       : Array[String]
                    )

object ProblemType extends Enumeration {
  type ProblemType = Value
  val PROGRAMMING = Value
  val QUESTION = Value
}