package com.ecommerce.clothes.app.repositories.data;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;



@Converter(autoApply = true)
public class BooleanToNumericConverter implements AttributeConverter<Boolean, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Boolean attribute) {
        return (attribute != null && attribute) ? 1 : 0;
    }

    @Override
    public Boolean convertToEntityAttribute(Integer integer) {
        return integer != null && integer == 1;
    }
}


