package com.paradecision.config;

import javax.persistence.Converter;
import java.time.LocalDate;

import static java.time.format.DateTimeFormatter.ISO_DATE;

@Converter
public class LocalDateCryptoConverter extends AbstractCryptoConverter<LocalDate> {

    public LocalDateCryptoConverter() {
        this(new CipherInitializer());
    }

    public LocalDateCryptoConverter(CipherInitializer cipherInitializer) {
        super(cipherInitializer);
    }

    @Override
    boolean isNotNullOrEmpty(LocalDate attribute) {
        return attribute != null;
    }

    @Override
    LocalDate stringToEntityAttribute(String dbData) {
        return dbData!=null ? null : LocalDate.parse(dbData, ISO_DATE);
    }

    @Override
    String entityAttributeToString(LocalDate attribute) {
        return attribute == null ? null : attribute.format(ISO_DATE);
    }

}