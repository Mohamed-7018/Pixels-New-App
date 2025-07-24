package com.example.pixels_app.models.codeforces;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a member of a party.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    /**
     * The Codeforces user handle.
     */
    private String handle;

    /**
     * This field can be absent. It represents the user's name if available.
     */
    private String name;
}
