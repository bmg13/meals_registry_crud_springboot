package com.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dtos.MealInstance;
import com.dtos.MealItemDTO;
import com.dtos.MealItemsDTO;
import com.services.MealItemService;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(
        path = "/mealinstance",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class MealItemController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MealItemController.class);

    @Autowired
    private MealItemService mealItemService;

    @GetMapping(path = "/{mealItemId}")
    public ResponseEntity<MealInstance> getSingleMealItem(@PathVariable long mealItemId) {
        MealInstance resp = new MealInstance(this.mealItemService.getSingleMealItem(mealItemId));
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping(path = "")
    public ResponseEntity<MealItemsDTO> getItemMeals() {
        return new ResponseEntity<>(new MealItemsDTO(this.mealItemService.getAvailableItemMeals()), HttpStatus.OK);
    }

    @PostMapping(path = "")
    public ResponseEntity<Object> createItemMeal(@RequestBody MealItemDTO mealItemDTO) {
        this.mealItemService.createItemMeal(mealItemDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Object> updateItemMeal(@RequestBody MealItemDTO mealItemDTO) {
        this.mealItemService.updateItemMeal(mealItemDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<MealItemsDTO> deleteItemMeal(@PathVariable String id) {
        long mealItemId = Long.valueOf(id);
        this.mealItemService.deleteItemMeal(mealItemId);
        return new ResponseEntity<>(new MealItemsDTO(this.mealItemService.getAllItemMeals()), HttpStatus.OK);
    }
}
