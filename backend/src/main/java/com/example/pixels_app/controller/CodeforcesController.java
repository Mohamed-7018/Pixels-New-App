package com.example.pixels_app.controller;

import com.example.pixels_app.exception.exceptions.CodeforcesApiException;
import com.example.pixels_app.models.codeforces.*;
import com.example.pixels_app.services.codeforces.CodeforcesServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/codeforces")
public class CodeforcesController {

    private final CodeforcesServices codeforcesService;

    public CodeforcesController(CodeforcesServices codeforcesService) {
        this.codeforcesService = codeforcesService;
    }

    // Blog Entry Endpoints
    @GetMapping("/blog/{blogEntryId}/comments")
    public ResponseEntity<List<Comment>> getBlogEntryComments(@PathVariable int blogEntryId) {
        try {
            return ResponseEntity.ok(codeforcesService.getBlogEntryComments(blogEntryId));
        } catch (CodeforcesApiException e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
        }
    }

    @GetMapping("/blog/{blogEntryId}")
    public ResponseEntity<BlogEntry> getBlogEntry(@PathVariable int blogEntryId) {
        try {
            return ResponseEntity.ok(codeforcesService.getBlogEntry(blogEntryId));
        } catch (CodeforcesApiException e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
        }
    }

    // Contest Endpoints
    @GetMapping("/contests/{contestId}/hacks")
    public ResponseEntity<List<Hack>> getContestHacks(@PathVariable int contestId) {
        try {
            return ResponseEntity.ok(codeforcesService.getContestHacks(contestId));
        } catch (CodeforcesApiException e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
        }
    }

    @GetMapping("/contests")
    public ResponseEntity<List<Contest>> getContests(
            @RequestParam(required = false) Boolean gym) {
        try {
            return ResponseEntity.ok(codeforcesService.getContests(gym));
        } catch (CodeforcesApiException e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
        }
    }

    @GetMapping("/contests/{contestId}/rating-changes")
    public ResponseEntity<List<RatingChange>> getContestRatingChanges(@PathVariable int contestId) {
        try {
            return ResponseEntity.ok(codeforcesService.getContestRatingChanges(contestId));
        } catch (CodeforcesApiException e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
        }
    }

    @GetMapping("/contests/{contestId}/standings")
    public ResponseEntity<ContestStandings> getContestStandings(
            @PathVariable int contestId,
            @RequestParam(required = false) Integer from,
            @RequestParam(required = false) Integer count,
            @RequestParam(required = false) List<String> handles,
            @RequestParam(required = false) Integer room,
            @RequestParam(required = false) Boolean showUnofficial) {
        try {
            return ResponseEntity.ok(codeforcesService.getContestStandings(
                    contestId, from, count, handles, room, showUnofficial));
        } catch (CodeforcesApiException e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
        }
    }

    @GetMapping("/contests/{contestId}/submissions")
    public ResponseEntity<List<Submission>> getContestSubmissions(
            @PathVariable int contestId,
            @RequestParam(required = false) String handle,
            @RequestParam(required = false) Integer from,
            @RequestParam(required = false) Integer count) {
        try {
            return ResponseEntity.ok(codeforcesService.getContestSubmissions(
                    contestId, handle, from, count));
        } catch (CodeforcesApiException e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
        }
    }

    // Problemset Endpoints
    @GetMapping("/problemset/problems")
    public ResponseEntity<ProblemSet> getProblemsetProblems(
            @RequestParam(required = false) List<String> tags,
            @RequestParam(required = false) String problemsetName) {
        try {
            return ResponseEntity.ok(codeforcesService.getProblemsetProblems(tags, problemsetName));
        } catch (CodeforcesApiException e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
        }
    }

    @GetMapping("/problemset/recent-submissions")
    public ResponseEntity<List<Submission>> getProblemsetRecentSubmissions(
            @RequestParam int count,
            @RequestParam(required = false) String problemsetName) {
        try {
            return ResponseEntity.ok(codeforcesService.getProblemsetRecentSubmissions(count, problemsetName));
        } catch (CodeforcesApiException e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
        }
    }

    // Recent Actions Endpoint
    @GetMapping("/recent-actions")
    public ResponseEntity<List<RecentAction>> getRecentActions(@RequestParam int maxCount) {
        try {
            return ResponseEntity.ok(codeforcesService.getRecentActions(maxCount));
        } catch (CodeforcesApiException e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
        }
    }

    // User Endpoints
    @GetMapping("/users/{handle}/blog-entries")
    public ResponseEntity<List<BlogEntry>> getUserBlogEntries(@PathVariable String handle) {
        try {
            return ResponseEntity.ok(codeforcesService.getUserBlogEntries(handle));
        } catch (CodeforcesApiException e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
        }
    }

    @GetMapping("/users/friends")
    public ResponseEntity<List<String>> getUserFriends(@RequestParam boolean onlyOnline) {
        try {
            return ResponseEntity.ok(codeforcesService.getUserFriends(onlyOnline));
        } catch (CodeforcesApiException e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
        }
    }

    @GetMapping("/users/info")
    public ResponseEntity<List<User>> getUserInfo(@RequestParam List<String> handles) {
        try {
            return ResponseEntity.ok(codeforcesService.getUserInfo(handles));
        } catch (CodeforcesApiException e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
        }
    }

    @GetMapping("/users/rated-list")
    public ResponseEntity<List<User>> getRatedUsers(@RequestParam boolean activeOnly) {
        try {
            return ResponseEntity.ok(codeforcesService.getRatedUsers(activeOnly));
        } catch (CodeforcesApiException e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
        }
    }

    @GetMapping("/users/{handle}/rating-history")
    public ResponseEntity<List<RatingChange>> getUserRatingHistory(@PathVariable String handle) {
        try {
            return ResponseEntity.ok(codeforcesService.getUserRatingHistory(handle));
        } catch (CodeforcesApiException e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
        }
    }

    @GetMapping("/users/{handle}/submissions")
    public ResponseEntity<List<Submission>> getUserSubmissions(
            @PathVariable String handle,
            @RequestParam(required = false) Integer from,
            @RequestParam(required = false) Integer count) {
        try {
            return ResponseEntity.ok(codeforcesService.getUserSubmissions(handle, from, count));
        } catch (CodeforcesApiException e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
        }
    }

    // Convenience Endpoints
    @GetMapping("/users/{handle}")
    public ResponseEntity<User> getSingleUserInfo(@PathVariable String handle) {
        try {
            return ResponseEntity.ok(codeforcesService.getSingleUserInfo(handle));
        } catch (CodeforcesApiException e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
        }
    }

    @GetMapping("/users/{handle}/recent-submissions")
    public ResponseEntity<List<Submission>> getLatestUserSubmissions(
            @PathVariable String handle,
            @RequestParam(defaultValue = "10") int count) {
        try {
            return ResponseEntity.ok(codeforcesService.getLatestUserSubmissions(handle, count));
        } catch (CodeforcesApiException e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
        }
    }

    // Exception handler for CodeforcesApiException
//    @ExceptionHandler(CodeforcesApiException.class)
//    public ResponseEntity<String> handleCodeforcesApiException(CodeforcesApiException ex) {
//        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
//                .body("Error accessing Codeforces API: " + ex.getMessage());
//    }
}