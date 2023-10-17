package com.fawry.store.controller;

import com.fawry.store.services.StockHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/histories")
public class StockHistoryController {

    private final StockHistoryService service;

    @GetMapping
    ResponseEntity<?> getAllHistories() {
        return new ResponseEntity<>(service.getAllHistories(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getHistory(@PathVariable("id") long id) {
        return new ResponseEntity<>(service.getHistory(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteHistory(@PathVariable long id) {
        service.removeHistory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/product/{id}")
    ResponseEntity<?> getProductHistory(@PathVariable("id") long id) {
        return new ResponseEntity<>(service.getHistoryOfProduct(id), HttpStatus.OK);
    }

    @GetMapping("/warehouse/{id}")
    ResponseEntity<?> getWarehouseHistory(@PathVariable("id") long id) {
        return new ResponseEntity<>(service.getHistoryOfWarehouse(id), HttpStatus.OK);
    }
}
