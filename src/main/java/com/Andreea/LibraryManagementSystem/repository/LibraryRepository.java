package com.Andreea.LibraryManagementSystem.repository;

import com.Andreea.LibraryManagementSystem.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LibraryRepository extends JpaRepository<Item, Integer> {

    Optional<Item> findByTitle(String name);

    List<Item> findByOrderByAuthor();

    List<Item> findByIsBorrowed(boolean isBorrowed);

    List<Item> findByOrderByYearOfPublishingDesc();
}
