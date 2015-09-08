package info.mukel.codeforces4s.api

/**
 * ProblemStatistics
 *
 * Represents a statistic data about a problem.
 *
 * @param contestId    Integer. Id of the contest, containing the problem.
 * @param index        String. Usually a letter of a letter, followed by a digit, that represent a problem index in a contest.
 * @param solvedCount  Integer. Number of users, who solved the problem.
 */
class ProblemStatistics(
                         contestId   : Int,
                         index       : String,
                         solvedCount :  Int
                         )
