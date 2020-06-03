package com.controllers;

import com.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dtos.SaleDTO;
import com.dtos.SalesDTO;

@CrossOrigin(maxAge = 3600, origins = "http://localhost:4200")
@Controller
@RequestMapping(
        path = "/sale",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping(path = "/{saleId}")
    public ResponseEntity<SaleDTO> getSingleSale(@PathVariable long saleId) {
        return ResponseEntity.ok(this.saleService.getSingleSale(saleId));
    }

    @GetMapping(path = "")
    public ResponseEntity<SalesDTO> getSales() {
        return new ResponseEntity<>(new SalesDTO(this.saleService.getSales()), HttpStatus.OK);
    }

    @PostMapping(path = "")
    public ResponseEntity<Object> createSale(@RequestBody SaleDTO saleDTO) {
        if (saleDTO.getMealItem() == null) {
            return new ResponseEntity("Meal item is null", HttpStatus.BAD_REQUEST);
        }
        this.saleService.createSale(saleDTO);
        return new ResponseEntity(HttpStatus.OK);
    }
}
