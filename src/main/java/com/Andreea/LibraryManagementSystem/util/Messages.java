package com.Andreea.LibraryManagementSystem.util;

import com.Andreea.LibraryManagementSystem.service.FiltersImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Messages {
    private static final Logger LOGGER = LoggerFactory.getLogger(Messages.class);

    public static void filtersMessages() {
        LOGGER.info("""
                Choose from the filters: 
                1:View all authors
                2:View all borrow items
                3:View all available items
                4:View the newest items
                5:View items by author
                6:View items by year of publishing""");
    }

    public static void mainOperationsMessage() {
        LOGGER.info("""
                Press:
                1. For adding an item
                2. For searching an item 
                3. For deleting an item 
                4. For filters""");
    }

    public static void userApplicationsMessage() {
        LOGGER.info("""
                Welcome user!
                Press:
                1. For searching an item
                2. For borrowing an item
                3. For returning an item 
                """);
    }
}
