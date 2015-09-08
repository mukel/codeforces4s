package info.mukel.codeforces4s.api

/**
 * ProblemResult
 *
 * Represents a submissions results of a party for a problem.
 *
 * @param points                     Floating point number.
 * @param penalty                    Integer. Penalty (in ICPC meaning) of the party for this problem.
 * @param rejectedAttemptCount       Integer. Number of incorrect submissions.
 * @param type                       Enum: PRELIMINARY, FINAL. If type is PRELIMINARY then points can decrease (if, for example, solution will fail during system test). Otherwise, party can only increase points for this problem by submitting better solutions.
 * @param bestSubmissionTimeSeconds  Integer. Number of seconds after the start of the contest before the submission, that brought maximal amount of points for this problem.
 */
class ProblemResult(
                     points                    : Float,
                     penalty                   : Int,
                     rejectedAttemptCount      : Int,
                     `type`                    : String, //	Enum: PRELIMINARY, FINAL. If type is PRELIMINARY then points can decrease (if, for example, solution will fail during system test). Otherwise, party can only increase points for this problem by submitting better solutions.
                     bestSubmissionTimeSeconds : Int
                     )

object ProblemResultType extends Enumeration {
  type ProblemResulType = Value
  val PRELIMINARY = Value
  val FINAL = Value
}