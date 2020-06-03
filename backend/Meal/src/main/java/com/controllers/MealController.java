package com.controllers;

import com.services.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dtos.MealDTO;
import com.dtos.MealsDTO;
import com.mappers.MealMapper;

@CrossOrigin(maxAge = 3600)
@Controller
@RequestMapping(
        path = "/meal",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class MealController {

    @Autowired
    private MealService mealService;

    @GetMapping(path = "/id/{mealId}")
    public ResponseEntity<MealDTO> getSingleMeal(@PathVariable long mealId) {
        return ResponseEntity.ok(this.mealService.getSingleMeal(mealId));
    }

    @GetMapping(path = "/designation/{designation}")
    public ResponseEntity<MealDTO> getSingleMealByDesignation(@PathVariable String designation) {
        return ResponseEntity.ok(this.mealService.getSingleMealByDesignation(designation));
    }

    @GetMapping(path = "")
    public ResponseEntity<MealsDTO> getMeals() {
        return new ResponseEntity<>(new MealsDTO(this.mealService.getMeals()), HttpStatus.OK);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<Object> createMeal(@RequestBody MealDTO mealDTO) {
        this.mealService.createMeal(mealDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Object> updateMeal(@RequestBody MealDTO mealDTO) {
        this.mealService.updateMeal(MealMapper.mapMealDTOToMeal(mealDTO));
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{mealId}")
    public ResponseEntity<Object> deleteMeal(@PathVariable long mealId) {
        this.mealService.deleteMeal(mealId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping(path = "/quantity/add/designation/{designation}")
    public ResponseEntity<Object> increaseMealQuantityToSell(@PathVariable String designation){
        this.mealService.decreaseMealQuantityToSell(designation);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping(path = "/quantity/remove/designation/{designation}")
    public ResponseEntity<Object> decreaseMealQuantityToSell(@PathVariable String designation){
        this.mealService.decreaseMealQuantityToSell(designation);
        return new ResponseEntity(HttpStatus.OK);
    }
}
