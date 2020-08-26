package com.ezypay.task.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author Pravat Kumar Pradhan
 */
public class DateTimeUtil {

 public static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
  return dateToConvert.toInstant()
         .atZone(ZoneId.systemDefault())
         .toLocalDate();
 }
 public  static  Date convertToDateViaInstant(LocalDate dateToConvert) {
  return java.util.Date.from(dateToConvert.atStartOfDay()
         .atZone(ZoneId.systemDefault())
         .toInstant());
 }

}
