package com.example.regionhandbook.controller;

import com.example.regionhandbook.model.HandBook;
import com.example.regionhandbook.service.HandBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/handbooks")
@RequiredArgsConstructor
public class HandBookRestController {

    public final HandBookService handBookService;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<HandBook>> getAllHandBooks() {
        List<HandBook> handBooks = handBookService.getAll();

        if (handBooks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(handBooks, HttpStatus.OK);
    }

    @RequestMapping(value = "findById/{id}", method = RequestMethod.GET)
    public ResponseEntity<HandBook> getHandBook(@PathVariable("id") Long id) {
        if(id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        HandBook handBook = handBookService.findById(id);
        if (handBook == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(handBook, HttpStatus.OK);
    }

    @PutMapping("/save")
    public ResponseEntity<HandBook> saveHandBook(@RequestBody @Valid HandBook handBook) {
        HttpHeaders headers = new HttpHeaders();
        if (handBook == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        handBookService.save(handBook);
        return new ResponseEntity<>(handBook, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HandBook> updateHandBook(@RequestBody @Valid HandBook handBook, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();
        if (handBook == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        handBookService.update(handBook);
        return new ResponseEntity<>(handBook, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HandBook> deleteHandBook(@PathVariable("id") Long id) {
        HandBook handBook = handBookService.findById(id);
        if (handBook == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        handBookService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
