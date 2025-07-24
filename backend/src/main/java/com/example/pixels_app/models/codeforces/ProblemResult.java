package com.example.pixels_app.models.codeforces;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents the submission results of a party for a problem.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProblemResult {

    /**
     * The floating-point number representing the points scored by the party for this problem.
     */
    private Double points;

    /**
     * The penalty (in ICPC meaning) of the party for this problem. This field can be absent.
     */
    private Integer penalty;

    /**
     * The number of incorrect submissions made by the party for this problem.
     */
    private Integer rejectedAttemptCount;

    /**
     * The type of the problem result, which can be PRELIMINARY or FINAL. If the type is PRELIMINARY,
     * the points can decrease if, for example, the solution fails during system testing. Otherwise,
     * the party can only increase points for this problem by submitting better solutions.
     */
    private ResultType type;

    /**
     * The number of seconds after the start of the contest before the submission that brought the
     * maximal amount of points for this problem. This field can be absent.
     */
    private Integer bestSubmissionTimeSeconds;

    /**
     * Represents the types of problem results.
     */
    public enum ResultType {
        PRELIMINARY, FINAL
    }
}