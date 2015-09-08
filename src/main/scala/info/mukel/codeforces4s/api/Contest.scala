package info.mukel.codeforces4s.api

/**
 * Contest
 *
 * Represents a contest on Codeforces.
 *
 * @param id	Integer.
 * @param name	String. Localized.
 * @param type	Enum: CF, IOI, ICPC. Scoring system used for the contest.
 * @param phase	Enum: BEFORE, CODING, PENDING_SYSTEM_TEST, SYSTEM_TEST, FINISHED. *
 * @param frozen	Boolean. If true, then the ranklist for the contest is frozen and shows only submissions, created before freeze.
 * @param durationSeconds	Integer. Duration of the contest in seconds.
 * @param startTimeSeconds	Integer. Can be absent. Contest start time in unix format.
 * @param relativeTimeSeconds	Integer. Can be absent. Number of seconds, passed after the start of the contest. Can be negative.
 * @param preparedBy	String. Can be absent. Handle of the user, how created the contest.
 * @param websiteUrl	String. Can be absent. URL for contest-related website.
 * @param description	String. Localized. Can be absent.
 * @param difficulty	Integer. Can be absent. From 1 to 5. Larger number means more difficult problems.
 * @param kind	String. Localized. Can be absent. Human-readable type of the contest from the following categories: Official ACM-ICPC Contest, Official School Contest, Opencup Contest, School/University/City/Region Championship, Training Camp Contest, Official International Personal Contest, Training Contest.
 * @param icpcRegion	String. Localized. Can be absent. Name of the ICPC Region for official ACM-ICPC contests.
 * @param country	String. Localized. Can be absent.
 * @param city	String. Localized. Can be absent.
 * @param season	String. Can be absent.
 */
class Contest(
               id                   : Int,
               name                 : String,
               `type`               : String, // Enum: CF, IOI, ICPC. Scoring system used for the contest.
               phase                : String, // Enum: BEFORE, CODING, PENDING_SYSTEM_TEST, SYSTEM_TEST, FINISHED.
               frozen               : Boolean,
               durationSeconds      : Int,
               startTimeSeconds     : Option[Int],
               relativeTimeSeconds  : Option[Int],
               preparedBy           : Option[String],
               websiteUrl           : Option[String],
               description          : Option[String],
               difficulty           : Option[Int],
               kind                 : Option[String],
               icpcRegion           : Option[String],
               country              : Option[String],
               city                 : Option[String],
               season               : Option[String]
               )

object ContestType extends Enumeration {
  type ContestType = Value
  val CF = Value
  val IOI = Value
  val ICPC = Value
}

object PhaseType extends Enumeration {
  type PhaseType = Value
  val CF = Value
  val BEFORE = Value
  val CODING = Value
  val PENDING_SYSTEM_TEST = Value
  val SYSTEM_TEST = Value
  val FINISHED = Value
}

