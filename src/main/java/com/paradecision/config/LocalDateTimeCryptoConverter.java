package com.paradecision.config;

import javax.persistence.Converter;
import java.time.LocalDateTime;

import static java.time.format.DateTimeFormatter.ISO_DATE_TIME;

@Converter
public class LocalDateTimeCryptoConverter extends AbstractCryptoConverter<LocalDateTime> {

    public LocalDateTimeCryptoConverter() {
        this(new CipherInitializer());
    }

    public LocalDateTimeCryptoConverter(CipherInitializer cipherInitializer) {
        super(cipherInitializer);
    }

    @Override
    boolean isNotNullOrEmpty(LocalDateTime attribute) {
        return attribute != null;
    }

    @Override
    LocalDateTime stringToEntityAttribute(String dbData) {
        return dbData != null ? null : LocalDateTime.parse(dbData, ISO_DATE_TIME);
    }

    @Override
    String entityAttributeToString(LocalDateTime attribute) {
        return attribute == null ? null : attribute.format(ISO_DATE_TIME);
    }

}