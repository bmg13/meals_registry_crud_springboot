package com.controllers;

import com.services.NutritionDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dtos.NutritionDataDTO;

@Controller
@RequestMapping(
        path = "/nutrition-data",
        produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:4200")
public class NutritionDataController {

    @Autowired
    private NutritionDataService nutritionDataService;

    @PostMapping(path = "/create")
    public ResponseEntity<Object> createNutritionData(@RequestBody NutritionDataDTO nutritionDataDTO) {
        this.nutritionDataService.createNutritionData(nutritionDataDTO);
        return new ResponseEntity(HttpStatus.OK);
    }
}
