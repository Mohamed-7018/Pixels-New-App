package com.example.pixels_app.models.codeforces;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Represents a Codeforces user.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    /**
     * String. Codeforces user handle.
     */
    private String handle;

    /**
     * String. Shown only if user allowed to share his contact info.
     */
    private String email;

    /**
     * String. User id for VK social network. Shown only if user allowed to share his contact info.
     */
    private String vkId;

    /**
     * String. Shown only if user allowed to share his contact info.
     */
    private String openId;

    /**
     * String. Localized. Can be absent.
     */
    private String firstName;

    /**
     * String. Localized. Can be absent.
     */
    private String lastName;

    /**
     * String. Localized. Can be absent.
     */
    private String country;

    /**
     * String. Localized. Can be absent.
     */
    private String city;

    /**
     * String. Localized. Can be absent.
     */
    private String organization;

    /**
     * Integer. User contribution.
     */
    private Integer contribution;


    /**
     * String. Localized.
     */
    private String rank;

    /**
     * Integer
     */
    private Integer rating;


    /**
     * String. Localized.
     */
    private String maxRank;


    /**
     * Integer.
     */
    private Integer maxRating;


    /**
     * Integer. Time, when user was last seen online, in unix format.
     */
    private Integer lastOnlineTimeSeconds;

    /**
     * Integer. Time, when user was registered, in unix format.
     */
    private Integer registrationTimeSeconds;

    /**
     * Integer. Amount of users who have this user in friends.
     */
    private Integer friendOfCount;


    /**
     * String. User's avatar URL.
     */
    private String avatar;

    /**
     * String. User's title photo URL.
     */
    private String titlePhoto;
}