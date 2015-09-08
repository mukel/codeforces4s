package info.mukel.codeforces4s.api

/**
 * RanklistRow
 *
 * Represents a ranklist row.
 *
 * @param party                      Party object. Party that took a corresponding place in the contest.
 * @param rank                       Integer. Party place in the contest.
 * @param points                     Floating point number. Total ammount of points, scored by the party.
 * @param penalty                    Integer. Total penalty (in ICPC meaning) of the party.
 * @param successfulHackCount        Integer.
 * @param unsuccessfulHackCount      Integer.
 * @param problemResults             List of ProblemResult objects. Party results for each problem. Order of the problems is the same as in "problems" field of the returned object.
 * @param lastSubmissionTimeSeconds  Integer. For IOI contests only. Time in seconds from the start of the contest to the last submission that added some points to the total score of the party.
 */
case class RanklistRow(
                        party                     : Party,
                        rank                      : Integer,
                        points                    : Float,
                        penalty                   : Int,
                        successfulHackCount       : Int,
                        unsuccessfulHackCount     : Int,
                        problemResults            : Array[ProblemResult],
                        lastSubmissionTimeSeconds : Option[Integer]

                        )
