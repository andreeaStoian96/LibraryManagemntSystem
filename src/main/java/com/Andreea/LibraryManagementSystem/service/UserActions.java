package com.Andreea.LibraryManagementSystem.service;

import com.Andreea.LibraryManagementSystem.entity.Item;
import com.Andreea.LibraryManagementSystem.exception.ItemNotFoundException;
import com.Andreea.LibraryManagementSystem.repository.LibraryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class UserActions implements BasicOperations {

    LibraryRepository libraryRepository;

    public UserActions(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(UserActions.class);

    @Override
    public void borrowItem(String name) {
        Item item = getItem(name);
        if (item != null) {
            if (!item.isBorrowed()) {
                item.setBorrowed(true);
                libraryRepository.save(item);
                LOGGER.info("You borrowed the item: " + name);
            } else {
                LOGGER.info("This item is not available!");
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
                libraryRepository.save(returnItem);
                LOGGER.info("You returned the book " + name);
            } else {
                LOGGER.info("This item is not borrowed from our library!");
            }
        } else {
            LOGGER.info("The item was not found!");
        }

    }

    @Override
    public Item getItem(String name) {
        return searchItemByName(name);
    }

    @Override
    public Item searchItemByName(String name) {
        return libraryRepository.findByName(name)
                .orElseThrow(() -> new ItemNotFoundException(String.format("No item found for name %s", name)));
    }
}


