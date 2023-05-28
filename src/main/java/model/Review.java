package model;

import java.util.Date;

public class Review {
    private final StudyCafe studyCafe;
    private final User author;
    private final Date createDate;
    private final String content;

    public Review(StudyCafe studyCafe, User author, String content) {
        this.studyCafe = studyCafe;
        this.author = author;
        this.createDate = new Date();
        this.content = content;
    }

    public StudyCafe getStudyCafe() { return studyCafe; }

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

