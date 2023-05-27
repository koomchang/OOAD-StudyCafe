package model;

import java.util.Date;

public class Review {
    private int reviewId;
    private final User author;
    private final Date createDate;
    private final String content;

    public Review(User author, String content) {
        this.reviewId = reviewId + 1;
        this.author = author;
        this.createDate = new Date();
        this.content = content;
    }

    public int getReviewId() {
        return reviewId;
    }

    public User getAuthor() {
        return author;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public String getContent() {
        return content;
    }
}
