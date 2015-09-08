package info.mukel.codeforces4s.api

/**
 * Submission
 * Represents a submission.
 *
 * @param id                   Integer.
 * @param contestId            Integer.
 * @param creationTimeSeconds  Integer. Time, when submission was created, in unix-format.
 * @param relativeTimeSeconds  Integer. Number of seconds, passed after the start of the contest (or a virtual start for virtual parties), before the submission.
 * @param problem              Problem object.
 * @param author               Party object.
 * @param programmingLanguage  String.
 * @param verdict              Enum: FAILED, OK, PARTIAL, COMPILATION_ERROR, RUNTIME_ERROR, WRONG_ANSWER, PRESENTATION_ERROR, TIME_LIMIT_EXCEEDED, MEMORY_LIMIT_EXCEEDED, IDLENESS_LIMIT_EXCEEDED, SECURITY_VIOLATED, CRASHED, INPUT_PREPARATION_CRASHED, CHALLENGED, SKIPPED, TESTING, REJECTED. Can be absent.
 * @param testset              Enum: SAMPLES, PRETESTS, TESTS, CHALLENGES, TESTS1, ..., TESTS10. Testset used for judging the submission.
 * @param passedTestCount      Integer. Number of passed tests.
 * @param timeConsumedMillis   Integer. Maximum time in milliseconds, consumed by solution for one test.
 * @param memoryConsumedBytes  Integer. Maximum memory in bytes, consumed by solution for one test.
 */
case class Submission(
                       id                  : Int,
                       contestId           : Int,
                       creationTimeSeconds : Int,
                       relativeTimeSeconds : Int,
                       problem             : Problem,
                       author              : Party,
                       programmingLanguage : String,
                       verdict             : Option[String], //	Enum: FAILED, OK, PARTIAL, COMPILATION_ERROR, RUNTIME_ERROR, WRONG_ANSWER, PRESENTATION_ERROR, TIME_LIMIT_EXCEEDED, MEMORY_LIMIT_EXCEEDED, IDLENESS_LIMIT_EXCEEDED, SECURITY_VIOLATED, CRASHED, INPUT_PREPARATION_CRASHED, CHALLENGED, SKIPPED, TESTING, REJECTED. Can be absent.
                       testset             : String, //	Enum: SAMPLES, PRETESTS, TESTS, CHALLENGES, TESTS1, ..., TESTS10. Testset used for judging the submission.
                       passedTestCount     : Int,
                       timeConsumedMillis  : Int,
                       memoryConsumedBytes : Int
                       )


object SubmissionVerdict extends Enumeration {
  type SubmissionVerdict = Value
  val FAILED = Value
  val OK = Value
  val PARTIAL = Value
  val COMPILATION_ERROR = Value
  val RUNTIME_ERROR = Value
  val WRONG_ANSWER = Value
  val PRESENTATION_ERROR = Value
  val TIME_LIMIT_EXCEEDED = Value
  val MEMORY_LIMIT_EXCEEDED = Value
  val IDLENESS_LIMIT_EXCEEDED = Value
  val SECURITY_VIOLATED = Value
  val CRASHED = Value
  val INPUT_PREPARATION_CRASHED = Value
  val CHALLENGED = Value
  val SKIPPED = Value
  val TESTING = Value
  val REJECTED = Value
}

object SubmissionTestset extends Enumeration {
  type SubmissionTestset = Value
  val SAMPLES = Value
  val PRETESTS = Value
  val TESTS = Value
  val CHALLENGES = Value
  val TESTS1 = Value
  val TESTS2 = Value
  val TESTS3 = Value
  val TESTS4 = Value
  val TESTS5 = Value
  val TESTS6 = Value
  val TESTS7 = Value
  val TESTS8 = Value
  val TESTS9 = Value
  val TESTS10 = Value
}