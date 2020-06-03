package com.services;

import com.persistence.entities.Sale;
import com.persistence.repositories.SaleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.dtos.MealDTO;
import com.dtos.MealItemDTO;
import com.dtos.SaleDTO;
import com.mappers.SaleMapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SaleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SaleService.class);

    private static final String MEALS_URI = "http://localhost:3034/api/meal";

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private MealService mealService;

    @Autowired
    private MealItemService mealItemService;

    @Autowired
    private RestTemplate restTemplate;

    public SaleDTO getSingleSale(long saleId) {
        LOGGER.info("About to get the sale with id {} .", saleId);
        Sale sale = this.saleRepository.findById(saleId);
        LOGGER.info("Sale retrieved from db.");
        return SaleMapper.mapSaleToSaleDTO(sale);
    }

    public List<SaleDTO> getSales() {
        LOGGER.info("About to get all sales.");
        List<Sale> allSales = this.saleRepository.findAll();
        LOGGER.info("Sales retrieved from db.");
        final List<SaleDTO> allSalesConverted = new ArrayList<>();
        allSales
                .parallelStream()
                .forEach(
                        sale -> allSalesConverted.add(SaleMapper.mapSaleToSaleDTO(sale)));
        LOGGER.info("Total number of sales is {} ", allSales.size());
        return allSalesConverted;
    }

    public synchronized void createSale(SaleDTO saleDTO) {
        LOGGER.info("About to create a sale.");
        saleDTO.setSoldDate(new Date());
        this.saleRepository.saveAndFlush(SaleMapper.mapSaleDTOToSale(saleDTO));
        LOGGER.info("Sale created.");
        updateMealQuantities(saleDTO);
    }

    private void updateMealQuantities(SaleDTO saleDTO) {
        MealItemDTO updatedMealItem = saleDTO.getMealItem();
        updatedMealItem.setAvailable(false);
        this.mealItemService.updateItemMeal(updatedMealItem);
        String designation = updatedMealItem.getMealId().getDesignation();
        ResponseEntity<MealDTO> mealDTO = this.restTemplate.exchange(MEALS_URI + "/designation/" + designation, HttpMethod.GET, null, MealDTO.class);
        MealDTO updatedMeal = mealDTO.getBody();
        updatedMeal.setQuantitySold(updatedMeal.getQuantitySold() + 1);
        if (updatedMeal.getQuantityToSell() > 0) {
            updatedMeal.setQuantityToSell(updatedMeal.getQuantityToSell() - 1);
        }
        this.mealService.updateMeal(updatedMeal);
    }
}
