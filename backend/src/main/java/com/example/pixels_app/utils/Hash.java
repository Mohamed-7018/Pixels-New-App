package com.example.pixels_app.utils;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

public class Hash {

    private Hash() {}

    public static String SHA256(String originalString) {
        return Hashing.sha256().hashString(originalString, StandardCharsets.UTF_8).toString();
    }
}
