package aaron.briggs.entity;

import java.time.LocalDate;

/**
 * Created by aaronBriggs on 2/21/17.
 */
public class Paragraph {
    private int paragraphId;
    private LocalDate paragraphDatePosted;
    private int paragraphTimesFlaggedForContent;
    private int paragraphAuthorId;
    private String paragraphContent;
    private int paragraphStoryId;
    private int paragraphPathId;

    public int getParagraphId() {
        return paragraphId;
    }

    public void setParagraphId(int paragraphId) {
        this.paragraphId = paragraphId;
    }

    public LocalDate getParagraphDatePosted() {
        return paragraphDatePosted;
    }

    public void setParagraphDatePosted(LocalDate paragraphDatePosted) {
        this.paragraphDatePosted = paragraphDatePosted;
    }

    public int getParagraphTimesFlaggedForContent() {
        return paragraphTimesFlaggedForContent;
    }

    public void setParagraphTimesFlaggedForContent(int paragraphTimesFlaggedForContent) {
        this.paragraphTimesFlaggedForContent = paragraphTimesFlaggedForContent;
    }

    public int getParagraphAuthorId() {
        return paragraphAuthorId;
    }

    public void setParagraphAuthorId(int paragraphAuthorId) {
        this.paragraphAuthorId = paragraphAuthorId;
    }

    public String getParagraphContent() {
        return paragraphContent;
    }

    public void setParagraphContent(String paragraphContent) {
        this.paragraphContent = paragraphContent;
    }

    public int getParagraphStoryId() {
        return paragraphStoryId;
    }

    public void setParagraphStoryId(int paragraphStoryId) {
        this.paragraphStoryId = paragraphStoryId;
    }

    public int getParagraphPathId() {
        return paragraphPathId;
    }

    public void setParagraphPathId(int paragraphPathId) {
        this.paragraphPathId = paragraphPathId;
    }
}
