package com.example.pixels_app.models.codeforces;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a participation of a user in a rated contest.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RatingChange {

    /**
     * The contest ID.
     */
    private Integer contestId;

    /**
     * The localized contest name.
     */
    private String contestName;

    /**
     * The Codeforces user handle.
     */
    private String handle;

    /**
     * The place of the user in the contest. This field contains the user's rank at the moment of
     * rating update. If the rank changes later (e.g., someone gets disqualified), this field will not
     * be updated and will contain the old rank.
     */
    private Integer rank;

    /**
     * The time when the rating for the contest was updated, in Unix format.
     */
    private Integer ratingUpdateTimeSeconds;

    /**
     * The user's rating before the contest.
     */
    private Integer oldRating;

    /**
     * The user's rating after the contest.
     */
    private Integer newRating;
}