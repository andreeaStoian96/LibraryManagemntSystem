package com.Andreea.LibraryManagementSystem.service;

import com.Andreea.LibraryManagementSystem.operations.Operations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;


import java.util.Scanner;

import static com.Andreea.LibraryManagementSystem.util.Messages.mainOperationsMessage;
import static com.Andreea.LibraryManagementSystem.util.Messages.userApplicationsMessage;

@Configuration
public class Application {
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    private final BasicOperationsImpl basicOperations;
    private final Operations operations;
    private final UserActions userActions;

    public Application(BasicOperationsImpl basicOperations, Operations operations, UserActions userActions) {
        this.basicOperations = basicOperations;
        this.operations = operations;
        this.userActions = userActions;
    }

    public void UserOperations() {
        Scanner input = new Scanner(System.in);
        do {
            LOGGER.info("Welcome user! \n Please insert your password");
            String pass = input.next();
            if (pass == "user") {
                userApplicationsMessage();
                int inp = input.nextInt();
                switch (inp) {
                    case 1:
                        LOGGER.info("Please insert the name of the item");
                        String nameItem= input.nextLine();
                        userActions.searchItemByName(nameItem);
                        break;
                    case 2:
                        LOGGER.info("Please insert the name of the item you want to borrow");
                        String borrowItem= input.nextLine();
                        userActions.borrowItem(borrowItem);
                        break;
                    case 3:
                        LOGGER.info("Please insert the name of the item you want to return");
                        String returnItem= input.nextLine();
                        userActions.returnItem(returnItem);
                        break;
                    default:LOGGER.info("Please choose a valid option!");
                }
            }
        }while (input.nextInt() <=3);
    }

    public void mainOperations() {
        Scanner input = new Scanner(System.in);
        do {
            mainOperationsMessage();
            int inp = input.nextInt();
            switch (inp) {
                case 1:
                    basicOperations.saveItem(operations.addItem());
                    LOGGER.info("Item saved!");
                    break;
                case 2:
                    LOGGER.info("Please insert the name of the item: ");
                    String name = input.next();
                    basicOperations.searchItemByName(name);
                    break;
                case 3:
                    LOGGER.info("Please insert the name of the item you want to delete: ");
                    String deleteName = input.next();
                    basicOperations.deleteItem(deleteName);
                    LOGGER.info("Item deleted!");
                    break;
                case 4:
                    operations.applyFilters();
                    break;
                default:
                    LOGGER.info("Please insert a valid choice from the list!");
            }
        } while (input.nextInt() <= 4);
    }
}
