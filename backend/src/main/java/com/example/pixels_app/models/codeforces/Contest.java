package com.example.pixels_app.models.codeforces;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Represents a contest on Codeforces.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contest {
    public  static  String NO_CONTEST_FOUND = "No Contests Found";

    private Integer id;
    private String name;

    /**
     * Enum: CF, IOI, ICPC. Scoring system used for the contest.
     */
    private String type;

    /**
     * Enum: BEFORE, CODING, PENDING_SYSTEM_TEST, SYSTEM_TEST, FINISHED.
     */
    private String phase;

    /**
     * Boolean. If true, then the ranklist for the contest is frozen and shows only submissions,
     * created before freeze.
     */
    private Boolean frozen;


    /**
     * Integer. Duration of the contest in seconds.
     */
    private Integer durationSeconds;

    /**
     * Integer. Can be absent. Contest start time in unix format.
     */
    private Integer startTimeSeconds;

    /**
     * Integer. Can be absent. Number of seconds, passed after the start of the contest. Can be
     * negative..
     */
    private Integer relativeTimeSeconds;


    /**
     * String. Can be absent. Handle of the user, who created the contest.
     */
    private String preparedBy;

    /**
     * String. Can be absent. URL for contest-related website.
     */
    private String websiteUrl;

    /**
     * String. Localized. Can be absent.
     */
    private String description;


    /**
     * Integer. Can be absent. From 1 to 5. Larger number means more difficult problems.
     */
    private Integer difficulty;

    /**
     * String. Localized. Can be absent. Human-readable type of the contest from the following
     * categories: Official ICPC Contest, Official School Contest, Opencup Contest,
     * School/University/City/Region Championship, Training Camp Contest, Official International
     * Personal Contest, Training Contest.
     */
    private String kind;

    /**
     * String. Localized. Can be absent. Name of the Region for official ICPC contests.
     */
    private String icpcRegion;

    /**
     * String. Localized. Can be absent.
     */
    private String country;

    /**
     * String. Localized. Can be absent.
     */
    private String city;

    /**
     * String. Can be absent.
     */
    private String season;
}