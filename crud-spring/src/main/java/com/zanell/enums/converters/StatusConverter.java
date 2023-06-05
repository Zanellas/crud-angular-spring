package com.zanell.enums.converters;

import com.zanell.enums.Status;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class StatusConverter implements AttributeConverter<Status, String> {

    @Override
    public String convertToDatabaseColumn(Status status) {
        if (status == null) {
            return null;
        }
        return status.getValue();
    }

    @Override
    public Status convertToEntityAttribute(String value) {
        if (value == null) {
            return null;
        }
        try {
            return Stream.of(Status.values())
                    .filter(c -> c.getValue().equals(value))
                    .findFirst()
                    .orElseThrow(IllegalAccessException::new);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
