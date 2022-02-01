package com.example.regionhandbook.repository;

import com.example.regionhandbook.model.HandBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HandBookRepository extends JpaRepository<HandBook, Long> {

    HandBook getById(Long id);
}
