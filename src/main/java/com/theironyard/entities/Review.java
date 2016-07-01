package com.theironyard.entities;

import javax.persistence.*;

/**
 * Created by hoseasandstrom on 7/1/16.
 */
@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String author;

    @Column(nullable = false)
    String comment;

    @ManyToOne
    Lecturer lecturer;

    @Column(nullable = false)
    boolean isGood;

    public Review() {
    }

    public Review(String author, String comment, Lecturer lecturer, boolean isGood) {
        this.author = author;
        this.comment = comment;
        this.lecturer = lecturer;
        this.isGood = isGood;
    }

    public Review(String author, String comment, boolean isGood, Lecturer lecturer) {
        this.author = author;
        this.comment = comment;
        this.isGood = isGood;
        this.lecturer = lecturer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public boolean isGood() {
        return isGood;
    }

    public void setGood(boolean good) {
        isGood = good;
    }
}
