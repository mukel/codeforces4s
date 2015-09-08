package info.mukel.codeforces4s.api

import info.mukel.codeforces4s.http.HttpClient
import info.mukel.codeforces4s.http.ScalajHttpClient

import info.mukel.codeforces4s.json.JsonUtils


import org.json4s._
import org.json4s.native.JsonMethods._
import org.json4s.native.Serialization
import org.json4s.native.Serialization._

import scala.concurrent._

import org.json4s.DefaultFormats

/**
 * CodeforcesApi
 *
 * Anonymous (non-authenticated) Codeforces API
 */
object CodeforcesApi extends ScalajHttpClient {

  //this : HttpClient =>

  implicit val formats = DefaultFormats

  private val apiBaseURL = "http://codeforces.com/api/"

  private def apiCall(action: String, params: (String, Any)*): JValue = {
    val requestUrl = apiBaseURL + action
    val response = request(requestUrl, params : _*)
    val json = parse(response)
    if((json \ "status").extract[String] == "OK")
      (json \ "result")
    else
      throw new Exception("Invalid reponse:\n" + response)
  }

  private def getAs[T : Manifest](action: String, params: (String, Any)*): T = {
    val json = apiCall(action, params : _*)
    JsonUtils.unjsonify[T](json)
  }

  /**
   * contest.hacks
   *
   * Returns list of hacks in the specified contests. Full information about hacks is available only after some time after the contest end. During the contest user can see only own hacks.
   *
   * @param contestId  (Required)	Id of the contest. It is not the round number. It can be seen in contest URL. For example: /contest/374/status
   * @return  Returns a list of Hack objects.
   *
   * Example: http://codeforces.com/api/contest.hacks?contestId=374
   */
  def contestHacks(contestId: Int): Array[Hack] = {
    getAs[Array[Hack]]("contest.hacks",
      "contestId" -> contestId)
  }

  /**
   * contest.list
   *
   * Returns information about all available contests.
   *
   * @param gym  Boolean. If true — than gym contests are returned. Otherwide, regular contests are returned.
   * @return Returns a list of Contest objects. If this method is called not anonymously, then all available contests for a calling user will be returned too, including mashups and private gyms.
   *
   * Example: http://codeforces.com/api/contest.list?gym=true
   */
  def contestList(gym: Option[Boolean] = None): Array[Contest] = {
    getAs[Array[Contest]]("contest.list",
      "gym" -> gym)
  }

  /**
   * contest.standings
   *
   * Returns the description of the contest and the requested part of the standings.
   *
   * @param contestId       (Required)	Id of the contest. It is not the round number. It can be seen in contest URL. For example: /contest/374/status
   * @param from            1-based index of the standings row to start the ranklist.
   * @param count	          Number of standing rows to return.
   * @param handles	        Semicolon-separated list of handles. No more than 10000 handles is accepted.
   * @param room            If specified, than only participants from this room will be shown in the result. If not — all the participants will be shown.
   * @param showUnofficial	If true than all participants (virtual, out of competition) are shown. Otherwise, only official contestants are shown.
   * @return Returns object with three fields: "contest", "problems" and "rows". Field "contest" contains a Contest object. Field "problems" contains a list of Problem objects. Field "rows" contains a list of RanklistRow objects.
   * Example: http://codeforces.com/api/contest.standings?contestId=374&from=1&count=5&showUnofficial=true
   */
  def contestStandings(contestId      : Int,
                       from           : Int,
                       count          : Int,
                       handles        : Array[String],
                       room           : Option[Int] = None,
                       showUnofficial : Option[Boolean] = None): ContestStandingsResult = {
    getAs[ContestStandingsResult]("contest.standings",
      "contestId"      -> contestId,
      "from"           -> from,
      "count"          -> count,
      "handles"        -> (handles mkString ";"),
      "room"           -> room,
      "showUnofficial" -> showUnofficial
    )
  }

  case class ContestStandingsResult(
                                     contest  : Contest,
                                     problems : Array[Problem],
                                     rows     : List[RanklistRow]
                                     )

  /**
   * contest.status
   *
   * Returns submissions for specified contest. Optionally can return submissions of specified user.
   *
   * @param contestId  (Required)	Id of the contest. It is not the round number. It can be seen in contest URL. For example: /contest/374/status
   * @param handle     Codeforces user handle.
   * @param from       1-based index of the first submission to return.
   * @param count	     Number of returned submissions.
   * @return Returns a list of Submission objects, sorted in decreasing order of submission id.
   *
   * Example: http://codeforces.com/api/contest.status?contestId=374&from=1&count=10
   */
  def contestStatus(contestId : Int,
                    handle    : String,
                    from      : Int,
                    count     : Int): Array[Submission] = {
    getAs[Array[Submission]]("contest.status",
      "contestId" -> contestId,
      "handle"    -> handle,
      "from"      -> from,
      "count"     -> count
    )
  }

  /**
   * problemset.problems
   *
   * Returns all problems from problemset. Problems can be filtered by tags.
   *
   * @param tags  Semicolon-separated list of tags.
   * @return Returns two lists. List of Problem objects and list of ProblemStatistics objects.
   *
   * Example: http://codeforces.com/api/problemset.problems?tags=implementation
   */
  def problemsetProblems(tags : Array[String]): Array[(Problem, ProblemStatistics)] = {
    val result = getAs[ProblemsetProblemsResult]("problemset.problems", "tags" -> (tags mkString ";"))
    result.problems zip result.problemStatistics
  }

  case class ProblemsetProblemsResult(
                                       problems: Array[Problem],
                                       problemStatistics: Array[ProblemStatistics]
                                       )

  /**
   * problemset.recentStatus
   *
   * Returns recent submissions.
   *
   * @param count (Required)	Number of submissions to return. Can be up to 1000.
   * @return Returns a list of Submission objects, sorted in decreasing order of submission id.
   *
   * Example: http://codeforces.com/api/problemset.recentStatus?count=10
   */
  def problemsetRecentStatus(count: Int): Array[Submission] = {
    getAs[Array[Submission]]("problemset.recentStatus",
      "count" -> count
    )
  }

  /**
   * user.info
   *
   * Returns information about one or several users.
   *
   * @param handles (Required)	Semicolon-separated list of handles. No more than 10000 handles is accepted.
   * @return Returns a list of User objects for requested handles.
   *
   * Example: http://codeforces.com/api/user.info?handles=DmitriyH;Fefer_Ivan
   */
  def userInfo(handles: Array[String]): Array[User] = {
    getAs[Array[User]]("user.info",
      "handles" -> (handles mkString ";")
    )
  }

  /**
   * user.ratedList
   *
   * Returns the list of all rated users.
   *
   * @param activeOnly	Boolean. If true then only users, who participated in rated contest during the last month are returned. Otherwise, all users with at least one rated contest are returned.
   * @return Returns a list of User objects, sorted in decreasing order of rating.
   *
   * Example: http://codeforces.com/api/user.ratedList?activeOnly=true
   */
  def userRatedList(activeOnly: Option[Boolean] = None): Array[User] = {
    getAs[Array[User]]("user.ratedList",
      "activeOnly" -> activeOnly
    )
  }

  /**
   * user.rating
   *
   *  Returns rating history of the specified user.
   *
   * @param handle (Required)	Codeforces user handle.
   * @return Returns a list of RatingChange objects for requested user.
   *
   * Example: http://codeforces.com/api/user.rating?handle=Fefer_Ivan
   */
  def  userRating(handle: String): Array[RatingChange] = {
    getAs[Array[RatingChange]]("user.ratedList",
      "handle" -> handle
    )
  }

  /**
   * user.status
   *
   * Returns submissions of specified user.
   *
   * @param handle (Required)	Codeforces user handle.
   * @param from	1-based index of the first submission to return.
   * @param count	Number of returned submissions.
   * @return Returns a list of Submission objects, sorted in decreasing order of submission id.
   *
   * Example: http://codeforces.com/api/user.status?handle=Fefer_Ivan&from=1&count=10
   */
  def userStatus(handle     : String,
                 from       : Int,
                 count      : Int): Array[Submission] = {
    getAs[Array[Submission]]("user.status",
      "handle"    -> handle,
      "from"      -> from,
      "count"     -> count
    )
  }
}
