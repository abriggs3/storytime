package aaron.briggs.entity;

import java.time.LocalDate;

/**
 * Created by aaronBriggs on 2/20/17.
 */
public class Story {
    private int storyId;
    private String storyTitle;
    private int storyRating;
    private int storyNumberOfRatings;
    private int storyContentRating;
    private int storyNumberOfContentRatings;
    private int userId;
    private LocalDate storyDatePublished;

    public int getStoryId() { return storyId; }

    public void setStoryId(int storyId) {
        this.storyId = storyId;
    }

    public String getStoryTitle() {
        return storyTitle;
    }

    public void setStoryTitle(String storyTitle) {
        this.storyTitle = storyTitle;
    }

    public int getStoryRating() {
        return storyRating;
    }

    public void setStoryRating(int storyRating) {
        this.storyRating = storyRating;
    }

    public int getStoryNumberOfRatings() {
        return storyNumberOfRatings;
    }

    public void setStoryNumberOfRatings(int storyNumberOfRatings) {
        this.storyNumberOfRatings = storyNumberOfRatings;
    }

    public int getStoryContentRating() {
        return storyContentRating;
    }

    public void setStoryContentRating(int storyContentRating) {
        this.storyContentRating = storyContentRating;
    }

    public int getStoryNumberOfContentRatings() {
        return storyNumberOfContentRatings;
    }

    public void setStoryNumberOfContentRatings(int storyNumberOfContentRatings) {
        this.storyNumberOfContentRatings = storyNumberOfContentRatings;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDate getStoryDatePublished() {
        return storyDatePublished;
    }

    public void setStoryDatePublished(LocalDate storyDatePublished) {
        this.storyDatePublished = storyDatePublished;
    }




}
