package com.example.pixels_app.models.codeforces;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CFResponse<T> {

    private String status;
    private T result;
    private String comment;
}