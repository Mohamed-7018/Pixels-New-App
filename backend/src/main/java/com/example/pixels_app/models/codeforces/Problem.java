package com.example.pixels_app.models.codeforces;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a problem.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Problem {

    /**
     * The ID of the contest containing the problem. This field can be absent.
     */
    private Integer contestId;

    /**
     * The short name of the problemset the problem belongs to. This field can be absent.
     */
    private String problemsetName;

    /**
     * The index of the problem in a contest. Usually, a letter or letter with digit(s).
     */
    private String index;

    /**
     * The localized name of the problem.
     */
    private String name;

    /**
     * The type of the problem.
     */
    private ProblemType type;

    /**
     * The maximum amount of points for the problem. This field can be absent.
     */
    private Double points;

    /**
     * The problem rating (difficulty). This field can be absent.
     */
    private Integer rating;

    /**
     * The problem tags.
     */
    private List<String> tags;


    /**
     * Represents the types of a problem.
     */
    public enum ProblemType {
        PROGRAMMING,
        QUESTION
    }
}