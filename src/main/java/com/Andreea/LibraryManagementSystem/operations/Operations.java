package com.Andreea.LibraryManagementSystem.operations;

import com.Andreea.LibraryManagementSystem.util.Genre;
import com.Andreea.LibraryManagementSystem.entity.Item;
import com.Andreea.LibraryManagementSystem.repository.LibraryRepository;
import com.Andreea.LibraryManagementSystem.service.FiltersImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

import static com.Andreea.LibraryManagementSystem.util.Messages.filtersMessages;

@Component
public class Operations {
    private  final FiltersImpl filtersImpl;
    private final LibraryRepository libraryRepository;


    private static final Logger LOGGER = LoggerFactory.getLogger(Operations.class);

    public Operations(FiltersImpl filtersImpl, LibraryRepository libraryRepository) {
        this.filtersImpl = filtersImpl;
        this.libraryRepository = libraryRepository;
    }


    public Item addItem() {
        Item item = new Item();
        Scanner input = new Scanner(System.in);
        LOGGER.info("Enter the title of the item");
        item.setName(input.nextLine());
        LOGGER.info("Enter the author");
        item.setAuthor(input.nextLine());
        LOGGER.info("Enter the publishing year");
        item.setYearOfPublishing(input.nextInt());
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

        int number = input.nextInt();
        Genre[] values = Genre.values();

        for (Genre value : Genre.values()) {
            if (number == value.ordinal()) {
                item.setGenre(String.valueOf(values[number].name()));
            } else {
                LOGGER.info("Please choose a correct number from the list!");
            }
        }
        return item;
    }

    public void applyFilters() {
        Scanner input = new Scanner(System.in);
        do {
            filtersMessages();
            int filter = input.nextInt();
            switch (filter) {
                case 1 -> {
                    List<Item> authorName = filtersImpl.getAuthors();
                    for (Item author : authorName) {
                        LOGGER.info(String.valueOf(author));
                    }
                }
                case 2 -> {
                    List<Item> borrowStatus = filtersImpl.getAllTheBorrowedItems();
                    for (Item borrow : borrowStatus) {
                        LOGGER.info(String.valueOf(borrow));
                    }
                }
                case 3 -> {
                    List<Item> availableItems = filtersImpl.getAllTheAvailableItems();
                    for (Item available : availableItems) {
                        LOGGER.info(String.valueOf(available));
                    }
                }
                case 4 -> {
                    LOGGER.info("Enter the author name!");
                    String author = input.next();
                    filtersImpl.getAllTheItemsFromOneAuthor(author);
                }
                case 5 -> {
                    LOGGER.info("Enter the year you want to see items from!");
                    int year = input.nextInt();
                    filtersImpl.getAllItemsFromASpecificYear(year);
                }
                default -> LOGGER.info("Please enter a valid choice from above!");
            }
        } while (input.nextInt() <= 6);
    }
}
