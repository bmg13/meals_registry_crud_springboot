package com.mappers;

import com.persistence.valueObjects.Allergen;
import com.dtos.AllergenDTO;

import java.util.ArrayList;
import java.util.List;

public class AllergenMapper {

    public static AllergenDTO mapAllegernToAllegernDTO(Allergen allergen) {
        return new AllergenDTO(allergen.getAllergenName(), allergen.getAllergenValue());
    }

    public static Allergen mapAllergenDTOToAllergen(AllergenDTO allergenDTO) {
        return new Allergen(allergenDTO.getAllergenName(), allergenDTO.getAllergenValue());
    }


    public static List<AllergenDTO> mapAllergenListToAllergenDTOList(List<Allergen> allergenList) {
        List<AllergenDTO> allegernResult = new ArrayList<>();
        allergenList.forEach(i -> allegernResult.add(mapAllegernToAllegernDTO(i)));
        return allegernResult;
    }

    public static List<Allergen> mapAllegernListDTOToAllergenList(List<AllergenDTO> allergenList) {
        List<Allergen> allegernResult = new ArrayList<>();
        allergenList.forEach(i -> allegernResult.add(mapAllergenDTOToAllergen(i)));
        return allegernResult;
    }
}
