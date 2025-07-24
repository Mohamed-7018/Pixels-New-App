package com.example.pixels_app.models.codeforces;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents statistic data about a problem.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProblemStatistics {

    /**
     * The ID of the contest containing the problem. This field can be absent.
     */
    private Integer contestId;

    /**
     * The index of the problem in a contest. Usually, a letter or letter with digit(s).
     */
    private String index;

    /**
     * The number of users who solved the problem.
     */
    private Integer solvedCount;
}