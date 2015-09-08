package info.mukel.codeforces4s.api

/**
 * Hack
 *
 * Represents a hack, made during Codeforces Round.
 *
 * @param id                   Integer.
 * @param creationTimeSeconds  Integer. Hack creation time in unix format.
 * @param hacker               Party object.
 * @param defender             Party object.
 * @param verdict              Enum: HACK_SUCCESSFUL, HACK_UNSUCCESSFUL, INVALID_INPUT, GENERATOR_INCOMPILABLE, GENERATOR_CRASHED, IGNORED, TESTING, OTHER. Can be absent.
 * @param problem              Problem object. Hacked problem.
 * @param test                 String. Can be absent.
 * @param judgeProtocol        Object with three fields: "manual", "protocol" and "verdict". Field manual can have values "true" and "false". If manual is "true" then test for the hack was entered manually. Fields "protocol" and "verdict" contain human-readable description of judge protocol and hack verdict. Localized. Can be absent.
 */
case class Hack(
                 id                  : Int,
                 creationTimeSeconds : Int,
                 hacker              : Party,
                 defender            : Party,
                 verdict             : Option[String], //	Enum: HACK_SUCCESSFUL, HACK_UNSUCCESSFUL, INVALID_INPUT, GENERATOR_INCOMPILABLE, GENERATOR_CRASHED, IGNORED, TESTING, OTHER. Can be absent.
                 problem             : Problem,
                 test                : Option[String],
                 judgeProtocol       : Option[JudgeProtocol]
                 )

case class JudgeProtocol(manual: String, protocol: String, verdict: String)

object HackVerdict extends Enumeration {
  type HackVerdict = Value
  val HACK_SUCCESSFUL = Value
  val HACK_UNSUCCESSFUL = Value
  val INVALID_INPUT = Value
  val GENERATOR_INCOMPILABLE = Value
  val GENERATOR_CRASHED = Value
  val IGNORED = Value
  val TESTING = Value
  val OTHER = Value
}