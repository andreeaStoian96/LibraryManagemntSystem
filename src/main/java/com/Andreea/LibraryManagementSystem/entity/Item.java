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
    protected String name;
    protected String author;
    protected int yearOfPublishing;
    protected String genre;
    protected boolean isBorrowed;

    public Item(int id, String name, String author, int yearOfPublishing, String genre, boolean isBorrowed) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.yearOfPublishing = yearOfPublishing;
        this.genre = genre;
        this.isBorrowed = isBorrowed;
    }

    public Item() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void borrow() {
        if (isBorrowed) {
            LOGGER.info("This book is borrowed");
        } else {
            LOGGER.info("This book is available");
        }

    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", yearOfPublishing=" + yearOfPublishing +
                ",isBorrowed=" + isBorrowed() +
                '}';
    }
}
