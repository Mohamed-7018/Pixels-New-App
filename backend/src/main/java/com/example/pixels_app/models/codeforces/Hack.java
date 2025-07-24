package com.example.pixels_app.models.codeforces;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a hack, made during Codeforces Round.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hack {

    /**
     * The ID of the hack.
     */
    private Integer id;

    /**
     * The hack creation time in Unix format.
     */
    private Integer creationTimeSeconds;

    /**
     * The party (hacker) who made the hack.
     */
    private Party hacker;

    /**
     * The party (defender) who received the hack.
     */
    private Party defender;

    /**
     * The verdict of the hack. This field can be absent.
     */
    private Verdict verdict;

    /**
     * The problem that was hacked.
     */
    private Problem problem;

    /**
     * The test associated with the hack. This field can be absent.
     */
    private String test;

    /**
     * The judge protocol for the hack, including fields "manual", "protocol", and "verdict". Field
     * "manual" can have values "true" and "false". If manual is "true", then the test for the hack
     * was entered manually. Fields "protocol" and "verdict" contain a human-readable description of
     * the judge protocol and hack verdict. This field can be absent.
     */
    private JudgeProtocol judgeProtocol;

    /**
     * Represents the verdicts of a hack.
     */
    public enum Verdict {
        HACK_SUCCESSFUL, HACK_UNSUCCESSFUL, INVALID_INPUT, GENERATOR_INCOMPILABLE,
        GENERATOR_CRASHED, IGNORED, TESTING, OTHER
    }

    /**
     * Represents the judge protocol for a hack.
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JudgeProtocol {

        /**
         * Indicates whether the test for the hack was entered manually.
         */
        private Boolean manual;

        /**
         * The protocol description.
         */
        private String protocol;

        /**
         * The verdict of the hack.
         */
        private String verdict;
    }
}
