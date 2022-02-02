package com.example.regionhandbook.service;

import com.example.regionhandbook.model.HandBook;
import com.example.regionhandbook.repository.HandBookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class HandBookService {

    public final HandBookRepository handBookRepository;

    @CachePut(cacheNames = "handBooks")
    public List<HandBook> getAll() {
        log.info("In HandBookService getAll");
        return handBookRepository.findAll();
    }

    @Cacheable(cacheNames = "handBook_Id")
    public HandBook findById(Long id) {
        log.info("In HandBookService findById {}", id);
        return handBookRepository.findById(id);
    }

    public void save(HandBook handBook) {
        log.info("In HandBookService save {}", handBook);
        handBookRepository.save(handBook);
    }

    public void update(HandBook handBook) {
        log.info("In HandBookService update {}", handBook);
        handBookRepository.update(handBook);
    }

    public void deleteById(Long id) {
        log.info("In HandBookService delete {}", id);
        handBookRepository.deleteById(id);
    }
}
