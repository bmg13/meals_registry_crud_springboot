package com.mappers;

import com.persistence.valueObjects.IdentificationNumber;
import com.dtos.IdentificationNumberDTO;

public class IdentificationNumberMapper {

    public static IdentificationNumberDTO mapIdentificationNumberToIdentificationNumberDTO(IdentificationNumber identificationNumber) {
        if (identificationNumber != null) {
            return new IdentificationNumberDTO(identificationNumber.getIdentificationNumber());
        }
        return null;
    }

    public static IdentificationNumber mapIdentificationNumberDTOToIdentificationNumber(IdentificationNumberDTO identificationNumberDTO) {
        if (identificationNumberDTO != null) {
            return new IdentificationNumber(identificationNumberDTO.getDescription());
        }
        return null;
    }
}
