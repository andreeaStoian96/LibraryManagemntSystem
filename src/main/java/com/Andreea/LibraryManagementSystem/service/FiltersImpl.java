package com.Andreea.LibraryManagementSystem.service;

import com.Andreea.LibraryManagementSystem.entity.Item;
import com.Andreea.LibraryManagementSystem.exception.AuthorNotFoundException;
import com.Andreea.LibraryManagementSystem.exception.YearNotFoundException;
import com.Andreea.LibraryManagementSystem.repository.LibraryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Service
public class FiltersImpl implements Filters {
    private static final Logger LOGGER = LoggerFactory.getLogger(FiltersImpl.class);
    @Autowired
    LibraryRepository libraryRepository;

    public FiltersImpl(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    @Override
    public List<Item> getAuthors() {
        return libraryRepository.findByOrderByAuthor().stream().collect(Collectors.toList());

    }

    @Override
    public List<Item> getAllTheBorrowedItems() {
        return libraryRepository.findByIsBorrowed(true);
    }

    @Override
    public List<Item> getAllTheAvailableItems() {
        return libraryRepository.findByIsBorrowed(false);
    }

    @Override
    public List<Item> getTheLatestFiveItemsBasedOnDateOfPublishing() {
        List<Item> getLatestFiveItems = libraryRepository.findByOrderByYearOfPublishingDesc()
                .stream().limit(5).collect(Collectors.toList());
        return getLatestFiveItems;
    }

    @Override
    public void getAllTheItemsFromOneAuthor(String author) {
        Map<String, List<Item>> authorName = libraryRepository.findByOrderByAuthor().stream()
                .filter(item -> item.getAuthor().equals(author))
                .collect(Collectors.groupingBy(Item::getAuthor));

        List<Item> itemList = authorName.get(author);
        if (itemList == null || itemList.isEmpty()) {
            throw new AuthorNotFoundException("Author not found: " + author);
        }

        LOGGER.info("Author is: {}\nItems written by the author:", author);
        itemList.forEach(item -> LOGGER.info(item.getName()));
        LOGGER.info("\n");
    }


    @Override
    public void getAllItemsFromASpecificYear(int year) {
        Map<Integer, List<Item>> yearOfPublishing = libraryRepository.findByOrderByYearOfPublishingDesc()
                .stream().filter(y -> y.getYearOfPublishing() == year)
                .collect(Collectors.groupingBy(Item::getYearOfPublishing));

        List<Item> itemList = yearOfPublishing.get(year);
        if (itemList == null || itemList.isEmpty()) {
            throw new YearNotFoundException("Year not found: " + year);
        }
        LOGGER.info("Year Of Publishing is: {}\nItems from that year:", year);

        itemList.forEach(item -> LOGGER.info("Name: {}, Author: {}, Is item borrow: {}",
                item.getName(), item.getAuthor(), item.isBorrowed()));
        LOGGER.info("\n");
    }
}
