package com.Andreea.LibraryManagementSystem.service;

import com.Andreea.LibraryManagementSystem.entity.Item;
import com.Andreea.LibraryManagementSystem.repository.LibraryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MemberActions extends UserActions {

    private static final Logger LOGGER = LoggerFactory.getLogger(MemberActions.class);

    public MemberActions(LibraryRepository libraryRepository) {
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

    public void reserveItem(String name) {
        Item reservedItem = searchItemByName(name);
        if (reservedItem != null) {
            if (!reservedItem.isReserved() && reservedItem.isBorrowed()) {
                reservedItem.setReserved(true);
                libraryRepository.save(reservedItem);
                LOGGER.info("\nYou reserved: " + reservedItem);
            } else if (!reservedItem.isReserved() && !reservedItem.isBorrowed()) {
                LOGGER.info("\nYou can borrow this item, it is available");
            } else {
                LOGGER.info("\nThis item is already reserved");
            }
        } else {
            LOGGER.info("\nThis item is not in our library!");
        }
    }
}
