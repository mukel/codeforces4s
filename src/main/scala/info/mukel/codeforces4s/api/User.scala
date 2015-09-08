package info.mukel.codeforces4s.api

/**
 * User
 *
 * Represents a Codeforces user.
 *
 * @param handle                   String. Codeforces user handle.
 * @param email                    String. Shown only if user allowed to share his contact info.
 * @param vkId                     String. User id for VK social network. Shown only if user allowed to share his contact info.
 * @param openId                   String. Shown only if user allowed to share his contact info.
 * @param firstName                String. Localized. Can be absent.
 * @param lastName                 String. Localized. Can be absent.
 * @param country                  String. Localized. Can be absent.
 * @param city                     String. Localized. Can be absent.
 * @param organization             String. Localized. Can be absent.
 * @param contribution             Integer. User contribution.
 * @param rank                     String. Localized.
 * @param rating                   Integer.
 * @param maxRank                  String. Localized.
 * @param maxRating	               Integer.
 * @param lastOnlineTimeSeconds    Integer. Time, when user was last seen online, in unix format.
 * @param registrationTimeSeconds  Integer. Time, when user was registered, in unix format.
 */
case class User(
                 handle                  : String,
                 email                   : Option[String],
                 vkId                    : Option[String],
                 openId                  : Option[String],
                 firstName               : Option[String],
                 lastName                : Option[String],
                 country                 : Option[String],
                 city                    : Option[String],
                 organization            : Option[String],
                 contribution            : Int,
                 rank                    : String,
                 rating                  : Int,
                 maxRank                 : String,
                 maxRating               : Int,
                 lastOnlineTimeSeconds   : Int,
                 registrationTimeSeconds : Int
                 )
