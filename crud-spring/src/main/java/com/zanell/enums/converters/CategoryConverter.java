package com.zanell.enums.converters;

import com.zanell.enums.Category;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class CategoryConverter implements AttributeConverter<Category, String> {

    @Override
    public String convertToDatabaseColumn(Category category) {
        if (category == null) {
            return null;
        }
        return category.getValue();
    }

    @Override
    public Category convertToEntityAttribute(String value) {
        if (value == null) {
            return null;
        }
        try {
            return Stream.of(Category.values())
                    .filter(c -> c.getValue().equals(value))
                    .findFirst()
                    .orElseThrow(IllegalAccessException::new);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
