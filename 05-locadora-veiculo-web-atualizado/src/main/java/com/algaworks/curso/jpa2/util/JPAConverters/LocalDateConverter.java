package com.algaworks.curso.jpa2.util.JPAConverters;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class LocalDateConverter implements AttributeConverter<LocalDate, Date>{
//	AttributeConverter<OBJETO_NO_SISTEMA, OBJETO_NO_BANCO>
	/*
	 * (non-Javadoc)
	 * @see javax.persistence.AttributeConverter#convertToDatabaseColumn(java.lang.Object)
	 * 
	 * este converter serve para o JPA converter o localDate para DAte para persistir no banco e vice versa
	 */

	@Override
	public Date convertToDatabaseColumn(LocalDate atributo) {
		Instant instant = atributo.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
		return Date.from(instant);
	}

	@Override
	public LocalDate convertToEntityAttribute(Date atributo) {
		Instant instant = Instant.ofEpochMilli(atributo.getTime());
		return LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
	}
	

}
