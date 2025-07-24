package com.example.pixels_app.models.codeforces;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a ProblemSet.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProblemSet {

    List<Problem> problems;
    List<ProblemStatistics> problemStatistics;
}