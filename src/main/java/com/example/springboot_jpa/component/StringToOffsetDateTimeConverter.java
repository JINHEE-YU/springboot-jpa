package com.example.springboot_jpa.component;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToOffsetDateTimeConverter implements Converter<String, OffsetDateTime> {

  private static final String DATE_PATTERN = "^\\d{4}-\\d{2}-\\d{2}$";
  private static final String DATE_TIME_PATTERN = "^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}$";
  private static final String INIT_TIME = "T00:00:00";
  private static final String INIT_TIMEZONE = "+09:00";

  @Override
  public OffsetDateTime convert(String source) {
    if (source.matches(DATE_PATTERN)) { // 'yyyy-mm-dd'
      source += INIT_TIME + INIT_TIMEZONE;
    } else if (source.matches(DATE_TIME_PATTERN)) { // 'yyyy-mm-dd HH:MM:SS'
      source = source.replace(" ", "T") + INIT_TIMEZONE;
    } else {
      throw new IllegalArgumentException("yyyy-mm-dd 또는 yyyy-mm-dd HH:MM:SS 형태로 전달해야합니다.");
    }
    try {
      return OffsetDateTime.parse(source, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    } catch (DateTimeParseException e) {
      return null;
    }
  }
}
