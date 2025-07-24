package com.example.pixels_app.models.codeforces;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a submission.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Submission {

    /**
     * The ID of the submission.
     */
    private Integer id;

    /**
     * The ID of the contest containing the submission. This field can be absent.
     */
    private Integer contestId;

    /**
     * The time when the submission was created, in Unix format.
     */
    private Integer creationTimeSeconds;

    /**
     * The number of seconds passed after the start of the contest (or a virtual start for virtual
     * parties), before the submission.
     */
    private Integer relativeTimeSeconds;

    /**
     * The problem associated with the submission.
     */
    private Problem problem;

    /**
     * The party (author) of the submission.
     */
    private Party author;

    /**
     * The programming language used for the submission.
     */
    private String programmingLanguage;

    /**
     * The verdict of the submission. This field can be absent.
     */
    private Verdict verdict;

    /**
     * The testset used for judging the submission.
     */
    private TestSet testset;

    /**
     * The number of passed tests.
     */
    private Integer passedTestCount;

    /**
     * The maximum time in milliseconds consumed by the solution for one test.
     */
    private Integer timeConsumedMillis;

    /**
     * The maximum memory in bytes consumed by the solution for one test.
     */
    private Integer memoryConsumedBytes;

    /**
     * The number of scored points for IOI-like contests. This field can be absent.
     */
    private Double points;

    /**
     * Represents the verdicts of a submission.
     */
    public enum Verdict {
        FAILED, OK, PARTIAL, COMPILATION_ERROR, RUNTIME_ERROR, WRONG_ANSWER, PRESENTATION_ERROR,
        TIME_LIMIT_EXCEEDED, MEMORY_LIMIT_EXCEEDED, IDLENESS_LIMIT_EXCEEDED, SECURITY_VIOLATED,
        CRASHED, INPUT_PREPARATION_CRASHED, CHALLENGED, SKIPPED, TESTING, REJECTED
    }

    /**
     * Represents the testsets used for judging a submission.
     */
    public enum TestSet {
        SAMPLES, PRETESTS, TESTS, CHALLENGES, TESTS1, TESTS2, TESTS3, TESTS4, TESTS5, TESTS6,
        TESTS7, TESTS8, TESTS9, TESTS10
    }
}