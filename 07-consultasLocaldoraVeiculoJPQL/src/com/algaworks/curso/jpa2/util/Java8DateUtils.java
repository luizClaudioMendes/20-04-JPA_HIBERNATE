package com.algaworks.curso.jpa2.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/*
 * based on 
 * https://www.mkyong.com/java8/java-8-convert-date-to-localdate-and-localdatetime/
 */
public class Java8DateUtils {
    
	private static ZoneId defaultZoneId = ZoneId.of("America/Sao_Paulo");
	
	private static boolean showLog = false;
    
    public static void main(String[] args) {
		showLog = true;
		System.out.println("System Default TimeZone : " + defaultZoneId);
		
		LocalDate localDate = LocalDate.of(2016, 8, 19);
		convertLocalDateToDate(localDate);
		
		LocalDateTime localDateTime = LocalDateTime.of(2016,8,19,21,46,31);
		convertLocalDateTimeToDate(localDateTime);
		
		ZonedDateTime zonedDateTime = localDateTime.atZone(defaultZoneId);
		convertZonedDateTimeToDate(zonedDateTime);
		//--------------------------------------------
		Date date = new Date();
		
		convertDateToInstant(date);
		
		Instant instantTest = convertDateToInstant(date);
		obtemLocalDateFromInstant(instantTest);
		
		obtemLocalDateTimeFromInstant(instantTest);
		
		obtemZonedDateTimeFromInstant(instantTest);
		
	}
    
    public static ZonedDateTime obtemZonedDateTimeFromInstant(Instant instant) {
    	//4. Instant + system default time zone = ZonedDateTime
        ZonedDateTime zonedDateTime = instant.atZone(defaultZoneId);
        if(showLog)
        	System.out.println("zonedDateTime : " + zonedDateTime);
        return zonedDateTime;
	}

    public static LocalDateTime obtemLocalDateTimeFromInstant(Instant instant) {
		//3. Instant + system default time zone + toLocalDateTime() = LocalDateTime
	    LocalDateTime localDateTime = instant.atZone(defaultZoneId).toLocalDateTime();
	    if(showLog) 
	    	System.out.println("localDateTime : " + localDateTime);
	    
	    return localDateTime;
	}
	
	public static LocalDate obtemLocalDateFromInstant(Instant instant) {
    	//2. Instant + system default time zone + toLocalDate() = LocalDate
        LocalDate localDate = instant.atZone(defaultZoneId).toLocalDate();
        if(showLog)
        	System.out.println("localDate : " + localDate);
		
        return localDate;
	}

    public static Instant convertDateToInstant(Date date) {
        Instant instant = date.toInstant();
        if(showLog) {
        	System.out.println("instant : " + instant); //Zone : UTC+0        	
        }
		return instant;
	}

	public static Date convertZonedDateTimeToDate(ZonedDateTime zonedDateTime) {
    	Date date = Date.from(zonedDateTime.toInstant());
	    if(showLog) {
//	    	System.out.println("\n3. ZonedDateTime -> Date");
	    	System.out.println("zonedDateTime : " + zonedDateTime);
	    	System.out.println("date3 : " + date);	    	
	    }
		return date;
	}

	public static Date convertLocalDateTimeToDate(LocalDateTime ldt) {
    	Date date = Date.from(ldt.atZone(defaultZoneId).toInstant());
    	if(showLog) {
//    		System.out.println("\n2. LocalDateTime -> Date"); // 2. LocalDateTime -> Date
    		System.out.println("localDateTime : " + ldt);
    		System.out.println("date2 : " + date);    		 
    	}
		
    	return date;
	}

	public static Date convertLocalDateToDate(LocalDate ld) {
    	
    	Date date = Date.from(ld.atStartOfDay(defaultZoneId).toInstant());
	    if(showLog) {
//	    	System.out.println("\n1. LocalDate -> Date"); // 1. LocalDate -> Date
	    	System.out.println("localDate : " + ld);
	    	System.out.println("date : " + date);    	
	    }
	    
	    return date;
    }
	
	 public static Integer obterDiasEntreDuasDatasJava7(Date dataInicial, Date dataFinal) {
        DateTime dataComparativa = new DateTime(dataFinal);
        DateTime dateInicial = new DateTime(dataInicial);
        return Days.daysBetween(dateInicial, dataComparativa).getDays();
    }

}