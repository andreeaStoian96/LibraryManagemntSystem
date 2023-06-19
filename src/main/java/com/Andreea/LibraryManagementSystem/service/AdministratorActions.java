package com.Andreea.LibraryManagementSystem.service;

import com.Andreea.LibraryManagementSystem.entity.Item;
import com.Andreea.LibraryManagementSystem.exception.AuthorNotFoundException;
import com.Andreea.LibraryManagementSystem.exception.ItemNotFoundException;
import com.Andreea.LibraryManagementSystem.exception.YearNotFoundException;
import com.Andreea.LibraryManagementSystem.repository.LibraryRepository;
import com.Andreea.LibraryManagementSystem.util.Genre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static com.Andreea.LibraryManagementSystem.util.Messages.genreMessage;

@Service
public class AdministratorActions extends MemberActions {
    private static final Logger LOGGER = LoggerFactory.getLogger(AdministratorActions.class);

    public AdministratorActions(LibraryRepository libraryRepository) {
        super(libraryRepository);
    }

    @Override
    public void borrowItem(String name) {
        super.borrowItem(name);
    }

    @Override
    public void returnItem(String name) {
        super.returnItem(name);
    }

    @Override
    public Item searchItemByName(String name) {
        return super.searchItemByName(name);
    }

    @Override
    public void reserveItem(String name) {
        super.reserveItem(name);
    }

    public Item saveItem(Item item) {
        libraryRepository.save(item);
        return item;
    }

    public Item addItem() {
        Item item = new Item();
        Scanner input = new Scanner(System.in);
        LOGGER.info("Enter the title of the item");
        item.setTitle(input.nextLine());
        LOGGER.info("Enter the author");
        item.setAuthor(input.nextLine());
        LOGGER.info("Enter the publishing year");
        item.setYearOfPublishing(input.nextInt());
        genreMessage();
        int number = input.nextInt();
        Genre[] values = Genre.values();

        if (number >= 1 && number <= values.length) {
            item.setGenre(String.valueOf(values[number - 1].name()));
        } else {
            LOGGER.info("Please choose a correct number from the list!");
        }

        return item;
    }

    public void deleteItem(String name) {
        Optional<Item> optionalItem = libraryRepository.findByTitle(name);
        if (optionalItem.isPresent()) {
            libraryRepository.delete(optionalItem.get());
        } else {
            throw new ItemNotFoundException("Item not found: " + name);
        }
    }

    public List<Item> getAllTheAvailableItems() {
        List<Item> availableItems = libraryRepository.findByIsBorrowed(false);
        List<Item> validatedItems = new ArrayList<>();

        for (Item item : availableItems) {
            validatedItems.add(item);
            LOGGER.info(String.valueOf(item));
        }
        return validatedItems;
    }

    public List<Item> getAllTheBorrowedItems() {
        List<Item> availableItems = libraryRepository.findByIsBorrowed(true);
        List<Item> validatedItems = new ArrayList<>();

        for (Item item : availableItems) {
            validatedItems.add(item);
            LOGGER.info(String.valueOf(item));
        }
        return validatedItems;
    }

    public void getAllTheItemsFromOneAuthor(String author) {
        Map<String, List<Item>> authorName = libraryRepository.findByOrderByAuthor().stream()
                .filter(item -> item.getAuthor().equals(author))
                .collect(Collectors.groupingBy(Item::getAuthor));

        List<Item> itemList = authorName.get(author);
        if (itemList == null || itemList.isEmpty()) {
            throw new AuthorNotFoundException("Author not found: " + author);
        }

        LOGGER.info("Author is: {}\nItems written by the author:", author);
        itemList.forEach(item -> LOGGER.info(item.getTitle()));
        LOGGER.info("\n");
    }

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
                item.getTitle(), item.getAuthor(), item.isBorrowed()));
        LOGGER.info("\n");
    }
}
