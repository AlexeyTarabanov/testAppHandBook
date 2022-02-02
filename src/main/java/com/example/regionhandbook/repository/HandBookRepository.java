package com.example.regionhandbook.repository;

import com.example.regionhandbook.model.HandBook;

import java.util.List;

public interface HandBookRepository {

    List<HandBook> findAll();
    HandBook findById(Long id);
    void save(HandBook handBook);
    void update(HandBook handBook);
    void deleteById(Long id);
}
