package info.mukel.codeforces4s.api

/**
 * RatingChange
 *
 * Represents a participation of user in rated contest.
 *
 * @param contestId                Integer.
 * @param contestName              String. Localized.
 * @param rank                     Integer. Place of the user in the contest. This field contains user rank on the moment of rating update. If afterwards rank changes (e.g. someone get disqualified), this field will not be update and will contain old rank.
 * @param ratingUpdateTimeSeconds  Integer. Time, when rating for the contest was update, in unix-format.
 * @param oldRating                Integer. User rating before the contest.
 * @param newRating                Integer. User rating after the contest.
 */
case class RatingChange(
                         contestId                : Int,
                         contestName              : String,
                         rank                     : Int,
                         ratingUpdateTimeSeconds  : Int,
                         oldRating                : Int,
                         newRating                : Int
                         )
