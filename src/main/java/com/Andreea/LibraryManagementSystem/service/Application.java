package com.Andreea.LibraryManagementSystem.service;

import com.Andreea.LibraryManagementSystem.entity.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

import static com.Andreea.LibraryManagementSystem.util.Messages.*;

@Configuration
public class Application {
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
    private final UserActions userActions;
    private final MemberActions memberActions;
    private final AdministratorActions administratorActions;

    public Application(UserActions userActions,
                       MemberActions memberActions, AdministratorActions administratorActions) {
        this.userActions = userActions;
        this.memberActions = memberActions;
        this.administratorActions = administratorActions;
    }

    public void userOperations() {
        Scanner input = new Scanner(System.in);

        LOGGER.info("Welcome user! \n Please insert your password");
        String pass = input.next();
        if (pass.equals("user")) {
            do {
                userApplicationsMessage();
                int inp = input.nextInt();
                switch (inp) {
                    case 1 -> {
                        LOGGER.info("Please insert the name of the item");
                        String nameItem = input.next();
                        Item item = userActions.getItem(nameItem);
                        System.out.println(item);

                    }
                    case 2 -> {
                        LOGGER.info("Please insert the name of the item you want to borrow");
                        String borrowItem = input.next();
                        userActions.borrowItem(borrowItem);
                    }
                    case 3 -> {
                        LOGGER.info("Please insert the name of the item you want to return");
                        String returnItem = input.next();
                        userActions.returnItem(returnItem);
                    }
                    default -> LOGGER.info("Please choose a valid option!");
                }
            } while (input.nextInt() <= 3);
        } else {
            LOGGER.info("Incorrect password!");
        }
    }

    public void memberOperations() {
        Scanner input = new Scanner(System.in);
        do {
            LOGGER.info("Welcome Member! \n Please insert your password");
            String pass = input.next();
            if (pass.equals("member")) {
                memberApplicationsMessage();
                int inp = input.nextInt();
                switch (inp) {
                    case 1 -> {
                        LOGGER.info("Please insert the name of the item");
                        String nameItem = input.next();
                        memberActions.searchItemByName(nameItem);
                    }
                    case 2 -> {
                        LOGGER.info("Please insert the name of the item you want to borrow");
                        String borrowItem = input.next();
                        memberActions.borrowItem(borrowItem);
                    }
                    case 3 -> {
                        LOGGER.info("Please insert the name of the item you want to return");
                        String returnItem = input.next();
                        memberActions.returnItem(returnItem);
                    }
                    case 4 -> {
                        LOGGER.info("Please insert the name of the item you want to reserve");
                        String reserveItem = input.next();
                        memberActions.reserveItem(reserveItem);
                    }
                    default -> LOGGER.info("Please choose a valid option!");
                }
            } else {
                LOGGER.info("Incorrect password!");
            }
        } while (input.nextInt() <= 3);
    }

    public void administratorOperations() {
        Scanner input = new Scanner(System.in);
        do {
            LOGGER.info("Welcome Administrator! \n Please insert your password");
            String pass = input.next();
            if (pass.equals("admin")) {
                adminApplicationsMessage();
                int inp = input.nextInt();
                switch (inp) {
                    case 1 -> {
                        LOGGER.info("Please insert the name of the item");
                        String nameItem = input.next();
                        administratorActions.searchItemByName(nameItem);
                    }
                    case 2 -> {
                        LOGGER.info("Please insert the name of the item you want to borrow");
                        String borrowItem = input.next();
                        administratorActions.borrowItem(borrowItem);
                    }
                    case 3 -> {
                        LOGGER.info("Please insert the name of the item you want to return");
                        String returnItem = input.next();
                        administratorActions.returnItem(returnItem);
                    }
                    case 4 -> {
                        LOGGER.info("Please insert the name of the item you want to reserve");
                        String reserveItem = input.next();
                        administratorActions.reserveItem(reserveItem);
                    }
                    case 5 -> {
                        administratorActions.saveItem(administratorActions.addItem());
                        LOGGER.info("Item saved!");
                    }
                    case 6 -> {
                        LOGGER.info("Please insert the name of the item you want to delete: ");
                        String deleteName = input.next();
                        administratorActions.deleteItem(deleteName);
                        LOGGER.info("Item deleted!");
                    }
                    case 7 -> {
                        administratorActions.getAllTheAvailableItems();
                    }
                    case 8 -> {
                        administratorActions.getAllTheBorrowedItems();
                    }
                    case 9 -> {
                        LOGGER.info("Insert name of the author");
                        String authorName = input.next();
                        administratorActions.getAllTheItemsFromOneAuthor(authorName);
                    }
                    case 10 -> {
                        LOGGER.info("Insert year");
                        int year = input.nextInt();
                        administratorActions.getAllItemsFromASpecificYear(year);
                    }
                    default -> LOGGER.info("Please choose a valid option!");
                }
            } else {
                LOGGER.info("Incorrect password!");
            }
        } while (input.nextInt() <= 6);
    }
}
