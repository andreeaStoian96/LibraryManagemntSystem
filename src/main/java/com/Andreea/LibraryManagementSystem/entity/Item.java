package com.Andreea.LibraryManagementSystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Item {
    private static final Logger LOGGER = LoggerFactory.getLogger(Item.class);
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    protected String title;
    protected String author;
    protected int yearOfPublishing;
    protected String genre;
    protected boolean isBorrowed;

    protected boolean isReserved;

    public Item(int id, String title, String author, int yearOfPublishing, String genre, boolean isBorrowed, boolean isReserved) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.yearOfPublishing = yearOfPublishing;
        this.genre = genre;
        this.isBorrowed = isBorrowed;
        this.isReserved = isReserved;
    }

    public Item() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    @Override
    public String toString() {
        return String.format("\nItem{id=%d, name='%s', author='%s', yearOfPublishing=%d, isBorrowed=%s, isReserved=%s}",
                id, title, author, yearOfPublishing, isBorrowed(), isReserved());
    }

}
