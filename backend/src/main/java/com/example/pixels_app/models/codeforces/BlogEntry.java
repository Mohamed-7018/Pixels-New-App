package com.example.pixels_app.models.codeforces;


import java.util.List;

import lombok.*;

/**
 * Represents a Codeforces Blog entry. May be in either short or full version.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class BlogEntry {

    /**
     * The id of the blog entry.
     */
    private Integer id;

    /**
     * The original locale of the blog entry.
     */
    private String originalLocale;

    /**
     * The time when the blog entry was created, in Unix format.
     */
    private Integer creationTimeSeconds;

    /**
     * The author's user handle.
     */
    private String authorHandle;

    /**
     * The localized title of the blog entry.
     */
    private String title;

    /**
     * The localized content of the blog entry. This field is not included in the short version.
     */
    private String content;

    /**
     * The locale of the blog entry.
     */
    private String locale;

    /**
     * The time when the blog entry has been updated, in Unix format.
     */
    private Integer modificationTimeSeconds;

    /**
     * Indicates whether viewing any specific revision of the blog entry is allowed.
     */
    private Boolean allowViewHistory;

    /**
     * The list of tags associated with the blog entry.
     */
    private List<String> tags;


    private Integer rating;
}