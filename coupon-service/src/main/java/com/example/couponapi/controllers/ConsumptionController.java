package com.example.couponapi.controllers;

import com.example.couponapi.models.ConsumptionDTO;
import com.example.couponapi.services.ConsumptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/consumption_history")
public class ConsumptionController {

    private final ConsumptionService consumptionService;

    @GetMapping("/list")
    public ResponseEntity<List<ConsumptionDTO>> listAllConsumptions() {
        List<ConsumptionDTO> consumptionDTOList = consumptionService.findAllConsumptions();
        return new ResponseEntity<>(consumptionDTOList, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ConsumptionDTO> findConsumptionById(@PathVariable Long id) {
        ConsumptionDTO consumptionDTO = consumptionService.findConsumptionById(id);
        return new ResponseEntity<>(consumptionDTO, HttpStatus.OK);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<ConsumptionDTO>> findConsumptionsByFilters(
            @RequestParam(name = "couponCode", required = false) String couponCode,
            @RequestParam(name = "orderId", required = false) Long orderId,
            @RequestParam(name = "startDate", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(name = "endDate", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        List<ConsumptionDTO> consumptionDTOList = consumptionService
                .findAllConsumptionsByFilters(couponCode, orderId, startDate, endDate);
        return new ResponseEntity<>(consumptionDTOList, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteConsumption(@PathVariable Long id) {
        consumptionService.deleteConsumption(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
