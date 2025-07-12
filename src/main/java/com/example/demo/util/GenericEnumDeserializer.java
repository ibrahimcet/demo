package com.example.demo.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.apache.coyote.BadRequestException;

import java.io.IOException;
import java.util.Arrays;

public class GenericEnumDeserializer<T extends Enum<T>> extends JsonDeserializer<T> {

    private final Class<T> enumType;

    public GenericEnumDeserializer(Class<T> enumType) {
        this.enumType = enumType;
    }

    @Override
    public T deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        String value = parser.getText();
        try {
            return Enum.valueOf(enumType, value);
        } catch (IllegalArgumentException ex) {
            throw new BadRequestException("Invalid value for enum type " + enumType.getSimpleName() + ": " + value +
                    ". Accepted values are: " + Arrays.toString(enumType.getEnumConstants()));
        }
    }
}
