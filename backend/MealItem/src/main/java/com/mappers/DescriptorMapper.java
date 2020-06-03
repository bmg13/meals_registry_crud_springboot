package com.mappers;

import com.persistence.valueObjects.Descriptor;
import com.dtos.DescriptorDTO;

import java.util.ArrayList;
import java.util.List;

public class DescriptorMapper {

    public static DescriptorDTO mapDescriptorNumberToDescriptorDTO(Descriptor descriptor) {
        return new DescriptorDTO(descriptor.getName(), descriptor.getValue(), descriptor.getUnit(), descriptor.getMaxValue());
    }

    public static Descriptor mapDescriptorDTOToDescriptor(DescriptorDTO descriptorDTO) {
        return new Descriptor(descriptorDTO.getName(), descriptorDTO.getValue(), descriptorDTO.getUnit(), descriptorDTO.getMaxValue());
    }

    public static List<DescriptorDTO> mapDescriptorListToDescriptorDTOList(List<Descriptor> descriptorList) {
        List<DescriptorDTO> descriptionResult = new ArrayList<>();
        descriptorList.forEach(i -> descriptionResult.add(mapDescriptorNumberToDescriptorDTO(i)));
        return descriptionResult;
    }

    public static List<Descriptor> mapDescriptorListDTOToDescriptorList(List<DescriptorDTO> descriptorList) {
        List<Descriptor> descriptionResult = new ArrayList<>();
        descriptorList.forEach(i -> descriptionResult.add(mapDescriptorDTOToDescriptor(i)));
        return descriptionResult;
    }
}
