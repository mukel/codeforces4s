package info.mukel.codeforces4s.api

/**
 * Party
 * Represents a party, participating in a contest.
 *
 * @param contestId	Integer. Id of the contest, in which party is participating.
 * @param members	List of Member objects. Members of the party.
 * @param participantType	Enum: CONTESTANT, PRACTICE, VIRTUAL, MANAGER, OUT_OF_COMPETITION.
 * @param teamId	Integer. Can be absent. If party is a team, then it is a unique team id. Otherwise, this field is absent.
 * @param teamName	String. Localized. Can be absent. If party is a team or ghost, then it is a localized name of the team. Otherwise, it is absent.
 * @param ghost	Boolean. If true then this party is a ghost. It participated in the contest, but not on Codeforces. For example, Andrew Stankevich Contests in Gym has ghosts of the participants from Petrozavodsk Training Camp.
 * @param room	Integer. Can be absent. Room of the party. If absent, then the party has no room.
 * @param startTimeSeconds	Integer. Can be absent. Time, when this party started a contest.
 */
case class Party(
                  contestId        : Int,
                  members          : Array[Member],
                  participantType  : String, //	Enum: CONTESTANT, PRACTICE, VIRTUAL, MANAGER, OUT_OF_COMPETITION.
                  teamId           : Option[Int],
                  teamName         : Option[String],
                  ghost            : Boolean,
                  room             : Option[Integer],
                  startTimeSeconds : Option[Int]
                  )


object ParticipantType extends Enumeration {
  type ParticipantType = Value
  val CONTESTANT = Value
  val PRACTICE = Value
  val VIRTUAL = Value
  val MANAGER = Value
  val OUT_OF_COMPETITION = Value
}