package com.example.pixels_app.services.codeforces;

import com.example.pixels_app.exception.exceptions.CodeforcesApiException;
import com.example.pixels_app.infrastructure.CodeforcesApi;
import com.example.pixels_app.models.codeforces.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeforcesServices {

    private final CodeforcesApi codeforcesApi;

    public CodeforcesServices(CodeforcesApi codeforcesApi) {
        this.codeforcesApi = codeforcesApi;
    }

    // Blog Entry related methods
    public List<Comment> getBlogEntryComments(int blogEntryId) throws CodeforcesApiException {
        return codeforcesApi.blogEntryComments(blogEntryId);
    }

    public BlogEntry getBlogEntry(int blogEntryId) throws CodeforcesApiException {
        return codeforcesApi.blogEntryView(blogEntryId);
    }

    // Contest related methods
    public List<Hack> getContestHacks(int contestId) throws CodeforcesApiException {
        return codeforcesApi.contestHacks(contestId);
    }

    public List<Contest> getContests(Boolean gym) throws CodeforcesApiException {
        return codeforcesApi.contestList(gym);
    }

    public List<RatingChange> getContestRatingChanges(int contestId) throws CodeforcesApiException {
        return codeforcesApi.contestRatingChanges(contestId);
    }

    public ContestStandings getContestStandings(int contestId, Integer from, Integer count,
                                                List<String> handles, Integer room, Boolean showUnofficial)
            throws CodeforcesApiException {
        return codeforcesApi.contestStanding(contestId, from, count, handles, room, showUnofficial);
    }

    public List<Submission> getContestSubmissions(int contestId, String handle, Integer from, Integer count)
            throws CodeforcesApiException {
        return codeforcesApi.contestStatus(contestId, handle, from, count);
    }

    // Problemset related methods
    public ProblemSet getProblemsetProblems(List<String> tags, String problemsetName)
            throws CodeforcesApiException {
        return codeforcesApi.problemsetProblems(tags, problemsetName);
    }

    public List<Submission> getProblemsetRecentSubmissions(int count, String problemsetName)
            throws CodeforcesApiException {
        return codeforcesApi.problemsetRecentStatus(count, problemsetName);
    }

    // Recent actions
    public List<RecentAction> getRecentActions(int maxCount) throws CodeforcesApiException {
        return codeforcesApi.recentActions(maxCount);
    }

    // User related methods
    public List<BlogEntry> getUserBlogEntries(String handle) throws CodeforcesApiException {
        return codeforcesApi.userBlogEntries(handle);
    }

    public List<String> getUserFriends(boolean onlyOnline) throws CodeforcesApiException {
        return codeforcesApi.userFriends(onlyOnline);
    }

    public List<User> getUserInfo(List<String> handles) throws CodeforcesApiException {
        return codeforcesApi.userInfo(handles);
    }

    public List<User> getRatedUsers(boolean activeOnly) throws CodeforcesApiException {
        return codeforcesApi.userRatedList(activeOnly);
    }

    public List<RatingChange> getUserRatingHistory(String handle) throws CodeforcesApiException {
        return codeforcesApi.userRating(handle);
    }

    public List<Submission> getUserSubmissions(String handle, Integer from, Integer count)
            throws CodeforcesApiException {
        return codeforcesApi.userStatus(handle, from, count);
    }

    // Additional convenience methods could be added here
    // For example:
    public User getSingleUserInfo(String handle) throws CodeforcesApiException {
        List<User> users = codeforcesApi.userInfo(List.of(handle));
        if (users.isEmpty()) {
            throw new CodeforcesApiException("User not found: " + handle);
        }
        return users.get(0);
    }

    public List<Submission> getLatestUserSubmissions(String handle, int count)
            throws CodeforcesApiException {
        return codeforcesApi.userStatus(handle, 1, count);
    }
}