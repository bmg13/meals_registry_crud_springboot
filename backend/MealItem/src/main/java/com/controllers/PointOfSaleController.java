package com.controllers;


import com.services.PointOfSaleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dtos.PointOfSaleDTO;
import com.dtos.PointsOfSaleDTO;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(
        path = "/pointofsale",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class PointOfSaleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MealItemController.class);

    @Autowired
    private PointOfSaleService pointOfSaleService;

    @GetMapping(path = "/{pointOfSaleId}")
    public ResponseEntity<PointOfSaleDTO> getSinglePointOfSale(@PathVariable long pointOfSaleId) {
        PointOfSaleDTO resp = this.pointOfSaleService.getSinglePointOfSale(pointOfSaleId);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping(path = "")
    public ResponseEntity<PointsOfSaleDTO> getAllPointsOfSale() {
        PointsOfSaleDTO resp = new PointsOfSaleDTO(this.pointOfSaleService.getAllPointsOfSale());
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Object> updatePointOfSale(@RequestBody PointOfSaleDTO pointsOfSaleDTO) {
        this.pointOfSaleService.updatePointOfSale(pointsOfSaleDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

}
