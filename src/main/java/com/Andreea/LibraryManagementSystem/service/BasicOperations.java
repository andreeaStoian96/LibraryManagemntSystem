package com.Andreea.LibraryManagementSystem.service;

import com.Andreea.LibraryManagementSystem.entity.Item;

public interface BasicOperations {

    void borrowItem(String name);

    void returnItem(String name);

    Item searchItemByName(String name);


}
