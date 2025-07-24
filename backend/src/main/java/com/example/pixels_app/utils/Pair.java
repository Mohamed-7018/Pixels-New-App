package com.example.pixels_app.utils;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Represents a pair of key-value data.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pair {

    private String key;
    private String value;
}