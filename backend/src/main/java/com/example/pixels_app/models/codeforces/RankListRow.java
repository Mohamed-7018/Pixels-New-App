package com.example.pixels_app.models.codeforces;


import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a ranklist row.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RankListRow {

    /**
     * The party that took a corresponding place in the contest.
     */
    private Party party;

    /**
     * The party's place in the contest.
     */
    private Integer rank;

    /**
     * The total amount of points scored by the party.
     */
    private Double points;

    /**
     * The total penalty (in ICPC meaning) of the party.
     */
    private Integer penalty;

    /**
     * The number of successful hacks made by the party.
     */
    private Integer successfulHackCount;

    /**
     * The number of unsuccessful hacks made by the party.
     */
    private Integer unsuccessfulHackCount;

    /**
     * The party's results for each problem. The order of the problems is the same as in the
     * "problems" field of the returned object.
     */
    private List<ProblemResult> problemResults;

    /**
     * For IOI contests only. The time in seconds from the start of the contest to the last submission
     * that added some points to the total score of the party. This field can be absent.
     */
    private Integer lastSubmissionTimeSeconds;
}
