package com.Andreea.LibraryManagementSystem.service;

import com.Andreea.LibraryManagementSystem.entity.Item;

public interface BasicOperations {
    Item getItem(String name);

    void borrowItem(String name);

    void returnItem(String name);

    Item searchItemByName(String name);
}
