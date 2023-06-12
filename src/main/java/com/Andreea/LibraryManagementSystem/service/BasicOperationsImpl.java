package com.Andreea.LibraryManagementSystem.service;

import com.Andreea.LibraryManagementSystem.entity.Item;
import com.Andreea.LibraryManagementSystem.exception.ItemNotFoundException;
import com.Andreea.LibraryManagementSystem.repository.LibraryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BasicOperationsImpl implements BasicOperations {
    @Autowired
    private LibraryRepository libraryRepository;

    public BasicOperationsImpl(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(BasicOperationsImpl.class);


    public Item saveItem(Item item) {
        libraryRepository.save(item);
        return item;
    }

    @Override
    public void borrowItem(String name) {

    }

    @Override
    public void returnItem(String name) {

    }

    @Override
    public Item searchItemByName(String name) {
        Optional<Item> optionalItem = libraryRepository.findByName(name);
        optionalItem.
                orElseThrow(() -> new ItemNotFoundException(String.format("No item found for name %s", name)));
        return optionalItem.orElseGet(optionalItem::get);
    }

    public void deleteItem(String name) {
        Optional<Item> optionalItem = libraryRepository.findByName(name);
        if (optionalItem.isPresent()) {
            Item item = optionalItem.get();
            libraryRepository.delete(item);
        } else {
            throw new ItemNotFoundException("Item not found: " + name);
        }
    }

}
