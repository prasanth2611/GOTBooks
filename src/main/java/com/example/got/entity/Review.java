package com.example.got.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="REVIEWS",indexes = {@Index(name="EMP_NAME_INDEX", columnList="BOOK_ID")})
public class Review implements Serializable {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name="REVIEW_ID")
    private Integer reviewId;

    @Column(name="BOOK_ID")
    private String bookId;

    @Column(name="CONTENT")
    private  String content;

    public Review(String bookId, String content) {
        this.bookId = bookId;
        this.content = content;
    }

    public Review() {
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public String getBookId() {
        return bookId;
    }

    public String getContent() {
        return content;
    }

}
