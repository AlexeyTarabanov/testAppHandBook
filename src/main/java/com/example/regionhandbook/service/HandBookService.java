package com.example.regionhandbook.service;

import com.example.regionhandbook.model.HandBook;
import com.example.regionhandbook.repository.HandBookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class HandBookService {

    public final HandBookRepository handBookRepository;

    public HandBook findById(Long id) {
        log.info("In HandBookService findById {}", id);
        return handBookRepository.findById(id).orElse(null);
    }

    public List<HandBook> getAll() {
        log.info("In HandBookService getAll");
        return handBookRepository.findAll();
    }

    public HandBook save(HandBook handBook) {
        log.info("In HandBookService save {}", handBook);
        return handBookRepository.save(handBook);
    }

    public void deleteById(Long id) {
        log.info("In HandBookService delete {}", id);
        handBookRepository.deleteById(id);
    }
}
