package com.services;

import com.persistence.entities.PointOfSale;
import com.persistence.repositories.PointOfSaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dtos.PointOfSaleDTO;
import com.mappers.PointOfSaleMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class PointOfSaleService {

    @Autowired
    private PointOfSaleRepository pointOfSaleRepository;

    public PointOfSaleDTO getSinglePointOfSale(long pointOfSaleId) {
        PointOfSale pointOfSale = this.pointOfSaleRepository.findById(pointOfSaleId);
        return PointOfSaleMapper.mapPointOfSaleToPointOfSaleDTO(pointOfSale);
    }

    public List<PointOfSaleDTO> getAllPointsOfSale() {
        List<PointOfSale> pointsOfSale = this.pointOfSaleRepository.findAll();
        List<PointOfSaleDTO> pointsOfSaleDTO = new ArrayList<>();
        pointsOfSale
                .parallelStream()
                .forEach(
                        pointOfSale -> pointsOfSaleDTO.add(PointOfSaleMapper.mapPointOfSaleToPointOfSaleDTO(pointOfSale)));
        return pointsOfSaleDTO;
    }

    public void updatePointOfSale(PointOfSaleDTO pointOfSaleDTO) {
        this.pointOfSaleRepository.saveAndFlush(PointOfSaleMapper.mapPointOfSaleDTOToPointOfSale(pointOfSaleDTO));
    }
}
