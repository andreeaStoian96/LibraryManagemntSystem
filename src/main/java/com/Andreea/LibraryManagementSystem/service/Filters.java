package com.Andreea.LibraryManagementSystem.service;

import com.Andreea.LibraryManagementSystem.entity.Item;

import java.util.List;

public interface Filters {
List<Item> getAuthors();
List<Item> getAllTheBorrowedItems();
List<Item> getAllTheAvailableItems();
List<Item> getTheLatestFiveItemsBasedOnDateOfPublishing();
void getAllTheItemsFromOneAuthor(String author);
void getAllItemsFromASpecificYear(int year);
}
