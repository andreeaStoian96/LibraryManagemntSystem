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
    public void mainOperations(){
        Scanner input = new Scanner(System.in);
        do {
            mainMessages();
            int inp = input.nextInt();
            switch (inp) {
                case 1 -> userOperations();

                case 2 -> memberOperations();

                case 3 -> administratorOperations();

                default -> LOGGER.info("\nPlease chose a valid option");
            }

        } while (input.nextInt() <= 3);
    }

    public void userOperations() {
        Scanner input = new Scanner(System.in);

        LOGGER.info("\nWelcome user! \n Please insert your password");
        String pass = input.next();
        if (pass.equals("user")) {
            do {
                userApplicationsMessage();
                int inp = input.nextInt();
                switch (inp) {
                    case 1 -> {
                        LOGGER.info("\nPlease insert the name of the item");
                        input.nextLine();
                        String nameItem = input.nextLine();
                        Item item = userActions.getItem(nameItem);
                        LOGGER.info(String.valueOf(item));

                    }
                    case 2 -> {
                        LOGGER.info("\nPlease insert the name of the item you want to borrow");
                        input.nextLine();
                        String borrowItem = input.nextLine();
                        userActions.borrowItem(borrowItem);
                    }
                    case 3 -> {
                        LOGGER.info("\nPlease insert the name of the item you want to return");
                        input.nextLine();
                        String returnItem = input.nextLine();
                        userActions.returnItem(returnItem);
                    }
                    case 4 ->{
                        mainOperations();
                    }
                    default -> LOGGER.info("\nPlease choose a valid option!");
                }
            } while (input.nextInt() <= 4);
        } else {
            LOGGER.info("\nIncorrect password!");
        }
    }

    public void memberOperations() {
        Scanner input = new Scanner(System.in);
        LOGGER.info("\nWelcome Member! \n Please insert your password");
        String pass = input.next();
        if (pass.equals("member")) {
            do {
                memberApplicationsMessage();
                int inp = input.nextInt();
                switch (inp) {
                    case 1 -> {
                        LOGGER.info("\nPlease insert the name of the item");
                        input.nextLine();
                        String nameItem = input.nextLine();
                        Item item = memberActions.getItem(nameItem);
                        System.out.println(item);
                    }
                    case 2 -> {
                        LOGGER.info("\nPlease insert the name of the item you want to borrow");
                        String borrowItem = input.next();
                        memberActions.borrowItem(borrowItem);
                    }
                    case 3 -> {
                        LOGGER.info("\nPlease insert the name of the item you want to return");
                        String returnItem = input.next();
                        memberActions.returnItem(returnItem);
                    }
                    case 4 -> {
                        LOGGER.info("\nPlease insert the name of the item you want to reserve");
                        String reserveItem = input.next();
                        memberActions.reserveItem(reserveItem);
                    }
                    case 5 -> {
                        mainOperations();
                    }
                    default -> LOGGER.info("\nPlease choose a valid option!");
                }
            } while (input.nextInt() <= 5);
        } else {
            LOGGER.info("\nIncorrect password!");
        }
    }

    public void administratorOperations() {
        Scanner input = new Scanner(System.in);

        LOGGER.info("\nWelcome Administrator! \n Please insert your password");
        String pass = input.next();
        if (pass.equals("admin")) {
            do {
                adminApplicationsMessage();
                int inp = input.nextInt();
                switch (inp) {
                    case 1 -> {
                        LOGGER.info("\nPlease insert the name of the item");
                        input.nextLine();
                        String nameItem = input.nextLine();
                        Item item = administratorActions.getItem(nameItem);
                        System.out.println(item);
                    }
                    case 2 -> {
                        LOGGER.info("\nPlease insert the name of the item you want to borrow");
                        input.nextLine();
                        String borrowItem = input.nextLine();
                        administratorActions.borrowItem(borrowItem);
                    }
                    case 3 -> {
                        LOGGER.info("\nPlease insert the name of the item you want to return");
                        input.nextLine();
                        String returnItem = input.nextLine();
                        administratorActions.returnItem(returnItem);
                    }
                    case 4 -> {
                        LOGGER.info("\nPlease insert the name of the item you want to reserve");
                        input.nextLine();
                        String reserveItem = input.nextLine();
                        administratorActions.reserveItem(reserveItem);
                    }
                    case 5 -> {
                        administratorActions.saveItem(administratorActions.addItem());
                        LOGGER.info("\nItem saved!");
                    }
                    case 6 -> {
                        LOGGER.info("\nPlease insert the name of the item you want to delete: ");
                        input.nextLine();
                        String deleteName = input.nextLine();
                        administratorActions.deleteItem(deleteName);
                        LOGGER.info("\nItem deleted!");
                    }
                    case 7 -> {
                        administratorActions.getAllTheAvailableItems();
                    }
                    case 8 -> {
                        administratorActions.getAllTheBorrowedItems();
                    }
                    case 9 -> {
                        LOGGER.info("\nInsert name of the author");
                        input.nextLine();
                        String authorName = input.nextLine();
                        administratorActions.getAllTheItemsFromOneAuthor(authorName);
                    }
                    case 10 -> {
                        LOGGER.info("\nInsert year");
                        int year = input.nextInt();
                        administratorActions.getAllItemsFromASpecificYear(year);
                    }
                    case 11 ->{
                        mainOperations();
                    }
                    default -> LOGGER.info("\nPlease choose a valid option!");
                }
            } while (input.nextInt() <= 11);
        } else {
            LOGGER.info("\nIncorrect password!");
        }
    }
}
