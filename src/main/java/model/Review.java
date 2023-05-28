package model;

import java.util.Date;

public class Review {
    private final User author;
    private final Date createDate;
    private final String content;

    public Review(User author, String content) {
        this.author = author;
        this.createDate = new Date();
        this.content = content;
    }

    public String getAuthor() {
        return author.getName();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public String getContent() {
        return content;
    }
}

