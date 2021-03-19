package com.SAD.Main_Project.helpers;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Date;
import java.time.LocalDate;

@Converter(autoApply=true)
public class LocalDateConverter implements AttributeConverter<LocalDate, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDate attribute) {
        return Date.valueOf(attribute);
    }

    @Override
    public LocalDate convertToEntityAttribute(Date dbData) {
        return dbData.toLocalDate();
    }

    public java.sql.Date convertUtilDateToSqlDate(java.util.Date utilDate) {
        return new java.sql.Date(utilDate.getTime());
    }

}
