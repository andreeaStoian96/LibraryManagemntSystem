package com.Andreea.LibraryManagementSystem.util;

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
    public static void memberApplicationsMessage() {
        LOGGER.info("""
                Welcome member!
                Press:
                1. For searching an item
                2. For borrowing an item
                3. For returning an item 
                4. For reserving an item
                """);
    }
    public static void mainMessages(){
        LOGGER.info("""
                Welcome to library!
                Please select your role!
                1. User
                2. Member
                3. Admin
                """);
    }
    public static void adminApplicationsMessage() {
        LOGGER.info("""
                Welcome admin!
                Press:
                1. For searching an item
                2. For borrowing an item
                3. For returning an item 
                4. For reserving an item
                5. For adding an item
                6. For deleting an item
                7. Get all the available items
                8. Get all the borrowed items
                9. Search based on author name
                10. Search based on year of publishing
                """);
    }
    public static void genreMessage(){
        LOGGER.info("""
                Please chose the genre from our list:
                0: LITERARY_FICTION,
                1: NON_FICTION,
                2: MYSTERY_SUSPENSE,
                3: SCIENCE_FICTION,
                4: FANTASY,
                5: ROMANCE,
                6: HISTORICAL_FICTION,
                7: PSYCHOLOGICAL_THRILLER,
                8: HORROR,
                9: YOUNG_ADULT,
                10: CHILDREN_BOOKS,
                11: POETRY,
                12: DRAMA,
                13: SELF_HELP,
                14: TRAVEL_BOOKS,
                15: ADVENTURE,
                or if it is a magazine choose from:
                16: CURRENT_AFFAIRS_NEWS,
                17: FASHION_BEAUTY,
                18: TECHNOLOGY_GADGETS,
                19: TRAVEL_ADVENTURE,
                20: HEALTH_FITNESS,
                21: ART_CULTURE,
                22: CUISINE_GASTRONOMY,
                23: SCIENCE_DISCOVERIES,
                24: FINANCE_BUSINESS
                """);


    }
}
