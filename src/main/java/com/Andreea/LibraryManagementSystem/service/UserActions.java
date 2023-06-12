package com.Andreea.LibraryManagementSystem.service;

import com.Andreea.LibraryManagementSystem.entity.Item;
import com.Andreea.LibraryManagementSystem.exception.ItemNotFoundException;
import com.Andreea.LibraryManagementSystem.repository.LibraryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class UserActions implements BasicOperations {

    LibraryRepository libraryRepository;

    public UserActions(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(UserActions.class);

    @Override
    public void borrowItem(String name) {
        Item item = searchItemByName(name);

        if (item != null) {
            if (!item.isBorrowed()) {
                item.setBorrowed(true);
                LOGGER.info("You borrowed the book: " + name);
            } else {
                LOGGER.info("This book is not available!");
            }
        } else {
            LOGGER.info("The item was not found!");
        }
    }

    @Override
    public void returnItem(String name) {
        Item returnItem = searchItemByName(name);
        if (returnItem != null) {
            if (returnItem.isBorrowed()) {
                returnItem.setBorrowed(false);
                LOGGER.info("You returned the book" + name);
            } else {
                LOGGER.info("This item is not from our library!");
            }
        } else {
            LOGGER.info("The item was not found!");
        }

    }

    @Override
    public Item searchItemByName(String name) {
        Optional<Item> optionalItem = libraryRepository.findByName(name);
        optionalItem.
                orElseThrow(() -> new ItemNotFoundException(String.format("No item found for name %s", name)));
        return optionalItem.orElseGet(optionalItem::get);
    }
}
