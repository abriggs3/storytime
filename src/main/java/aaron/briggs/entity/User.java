package aaron.briggs.entity;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Created by aaronBriggs on 2/20/17.
 */
public class User {
    private int userId;
    private String userName;
    private String password;
    private String email;
    private int numberOfFlagsUsed;
    private int numberOfStoriesAuthored;
    private int numberOfPathsCreated;
    private int numberOfParagraphsWritten;
    private int ratingOfAuthor;
    private int numberOfAuthorRatings;
    private LocalDate dateOfBirth;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumberOfFlagsUsed() {
        return numberOfFlagsUsed;
    }

    public void setNumberOfFlagsUsed(int numberOfFlagsUsed) {
        this.numberOfFlagsUsed = numberOfFlagsUsed;
    }

    public int getNumberOfStoriesAuthored() {
        return numberOfStoriesAuthored;
    }

    public void setNumberOfStoriesAuthored(int numberOfStoriesAuthored) {
        this.numberOfStoriesAuthored = numberOfStoriesAuthored;
    }

    public int getNumberOfPathsCreated() {
        return numberOfPathsCreated;
    }

    public void setNumberOfPathsCreated(int numberOfPathsCreated) {
        this.numberOfPathsCreated = numberOfPathsCreated;
    }

    public int getNumberOfParagraphsWritten() {
        return numberOfParagraphsWritten;
    }

    public void setNumberOfParagraphsWritten(int numberOfParagraphsWritten) {
        this.numberOfParagraphsWritten = numberOfParagraphsWritten;
    }

    public int getRatingOfAuthor() {
        return ratingOfAuthor;
    }

    public void setRatingOfAuthor(int ratingOfAuthor) {
        this.ratingOfAuthor = ratingOfAuthor;
    }

    public int getNumberOfAuthorRatings() {
        return numberOfAuthorRatings;
    }

    public void setNumberOfAuthorRatings(int numberOfAuthorRatings) {
        this.numberOfAuthorRatings = numberOfAuthorRatings;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Calculate age.
     *
     * @return the age
     */
    public int calculateAge() {

        LocalDate now = LocalDate.now();
        long age = ChronoUnit.YEARS.between(dateOfBirth, now);
        return (int)age;
    }

}
