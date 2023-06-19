package com.Andreea.LibraryManagementSystem;

import com.Andreea.LibraryManagementSystem.service.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Scanner;

import static com.Andreea.LibraryManagementSystem.util.Messages.mainMessages;

@SpringBootApplication
@EnableJpaRepositories("com.Andreea.LibraryManagementSystem.repository")
@EntityScan("com.Andreea.LibraryManagementSystem.entity")
public class LibraryManagementSystemApplication {
    private static Application application;

    @Autowired
    public void LibraryManagementSystemApplication(Application application) {
        this.application = application;
    }

    public static void main(String[] args) {
        final Logger LOGGER = LoggerFactory.getLogger(LibraryManagementSystemApplication.class);

        SpringApplication.run(LibraryManagementSystemApplication.class, args);
        Scanner input = new Scanner(System.in);
        do {
             mainMessages();
            int inp = input.nextInt();
            switch (inp) {
                case 1 -> application.userOperations();

                case 2 -> application.memberOperations();

                case 3 -> application.administratorOperations();

                default -> LOGGER.info("Please chose a valid option");
            }

        } while (input.nextInt() <= 3);
    }
}

