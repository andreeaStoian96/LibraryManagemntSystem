package com.Andreea.LibraryManagementSystem.exception;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(String message) {
        super(message);
    }
}
