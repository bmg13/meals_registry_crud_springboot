package com.mappers;

import com.persistence.valueObjects.IdentificationNumber;
import com.dtos.IdentificationNumberDTO;

public class IdentificationNumberMapper {

    public static IdentificationNumberDTO mapIdentificationNumberToIdentificationNumberDTO(IdentificationNumber identificationNumber) {
        return new IdentificationNumberDTO(identificationNumber.getIdentificationNumber());
    }

    public static IdentificationNumber mapIdentificationNumberDTOToIdentificationNumber(IdentificationNumberDTO identificationNumberDTO) {
        return new IdentificationNumber(identificationNumberDTO.getDescription());
    }
}
