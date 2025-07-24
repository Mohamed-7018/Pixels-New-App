package com.example.pixels_app.models.codeforces;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a party participating in a contest.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Party {

    /**
     * The ID of the contest in which the party is participating. This field can be absent.
     */
    private Integer contestId;

    /**
     * The list of Member objects representing the members of the party.
     */
    private List<Member> members;

    /**
     * The participant type of the party.
     */
    private ParticipantType participantType;

    /**
     * The team ID. This field can be absent. If the party is a team, then it is a unique team ID.
     * Otherwise, this field is absent.
     */
    private Integer teamId;

    /**
     * The localized name of the team. This field can be absent. If the party is a team or ghost, then
     * it is the localized name of the team. Otherwise, it is absent.
     */
    private String teamName;

    /**
     * Indicates whether the party is a ghost. If true, then this party is a ghost. It participated in
     * the contest, but not on Codeforces.
     */
    private Boolean ghost;

    /**
     * The room of the party. This field can be absent. If absent, then the party has no room.
     */
    private Integer room;

    /**
     * The time when this party started a contest. This field can be absent.
     */
    private Integer startTimeSeconds;

    public enum ParticipantType {
        CONTESTANT,
        PRACTICE,
        VIRTUAL,
        MANAGER,
        OUT_OF_COMPETITION
    }
}