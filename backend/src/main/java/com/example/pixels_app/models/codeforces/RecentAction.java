package com.example.pixels_app.models.codeforces;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a recent action.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecentAction {

    /**
     * The action time in Unix format.
     */
    private Integer timeSeconds;

    /**
     * The BlogEntry object in short form. This field can be absent.
     */
    private BlogEntry blogEntry;

    /**
     * The Comment object. This field can be absent.
     */
    private Comment comment;
}