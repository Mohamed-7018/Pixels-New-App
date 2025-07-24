package com.example.pixels_app.models.codeforces;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    /**
     * Integer.
     */
    private Integer id;

    /**
     * Integer. Time, when comment was created, in unix format.
     */
    private Integer creationTimeSecondsTime;

    /**
     * String.
     */
    private String commentatorHandle;

    /**
     * String.
     */
    private String locale;

    /**
     * String.
     */
    private String text;

    /**
     * Integer. Can be absent.
     */
    private Integer parentCommentId;

    /**
     * Integer.
     */
    private Integer rating;
}